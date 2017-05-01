package sketchobj.stmts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import constraintfactory.ConstData;
import constraintfactory.ConstraintFactory;
import constraintfactory.ExternalFunction;
import sketchobj.core.*;
import sketchobj.expr.ExprBinary;
import sketchobj.expr.ExprConstant;
import sketchobj.expr.ExprFunCall;
import sketchobj.expr.Expression;

public class StmtFor extends Statement {
	private Expression cond;
	private Statement init, incr, body;

	public StmtFor(Statement init, Expression cond, Statement incr, Statement body, boolean isCanonical, int i) {
		this.init = init;
		init.setParent(this);
		this.cond = cond;
		cond.setParent(this);
		this.incr = incr;
		incr.setParent(this);
		this.body = body;
		body.setParent(this);
		this.setLineNumber(i);
	}

	@Override
	public StmtFor clone() {
		
		return new StmtFor(init.clone(), cond.clone(), incr.clone(), body.clone(), false, this.getLineNumber());
	}
	public String toString() {
		String result = null;
		if (incr.toString().endsWith(";"))
			result = "for(" + init.toString() + " " + cond.toString() + "; "
					+ incr.toString().substring(0, incr.toString().length() - 1) + "){\n";
		else
			result = "for(" + init.toString() + " " + cond.toString() + "; "
					+ incr.toString().substring(0, incr.toString().length() - 2) + "){\n";

		result += this.body + "}\n";
		return result;
	}

	@Override
	public ConstData replaceConst(int index) {
		List<SketchObject> toAdd = new ArrayList<SketchObject>();
		toAdd.add(init);
		toAdd.add(incr);
		toAdd.add(body);
		toAdd.add(cond);
		if (cond instanceof ExprConstant) {
			int value = ((ExprConstant) cond).getVal();
			Type t = ((ExprConstant) cond).getType();
			cond = new ExprFunCall("Const" + index, new ArrayList<Expression>());
			return new ConstData(t, toAdd, index + 1, value, null, this.getLineNumber());
		}else
			toAdd.add(cond);
		return new ConstData(null, toAdd, index, 0, null,this.getLineNumber());
	}
	

	@Override
	public ConstData replaceConst_Exclude_This(int index, List<Integer> repair_range) {
		List<SketchObject> toAdd = new ArrayList<SketchObject>();
		toAdd.add(init);
		toAdd.add(incr);
		toAdd.add(body);
		return new ConstData(null, toAdd, index, 0, null,this.getLineNumber());
	}

	@Override
	public Context buildContext(Context prectx) {
		prectx = new Context(prectx);
		prectx.setLinenumber(this.getLineNumber());
		this.setPrectx(prectx);
		this.setPostctx(new Context(prectx));
		Context postctx = new Context(prectx);
		
		postctx.pushNewVars();
		int temp = postctx.getLinenumber();
		postctx.setLinenumber(temp);
		postctx = init.buildContext(postctx);
		cond.setCtx(postctx);
		postctx = incr.buildContext(postctx);
		postctx = body.buildContext(postctx);
		postctx.popVars();
		return postctx;

	}

	@Override
	public Map<String, Type> addRecordStmt(StmtBlock parent, int index, Map<String, Type> m) {
		m.putAll(body.getPostctx().getAllVars());
		StmtBlock sb = new StmtBlock(ConstraintFactory.recordState(this.getPrectx().getLinenumber(), this.getPrectx().getAllVars()),this);
		sb = new StmtBlock(sb, ConstraintFactory.recordState(this.getPostctx().getLinenumber(), this.getPostctx().getAllVars()));
		parent.stmts.set(index, sb
				);
		body = new StmtBlock(ConstraintFactory.recordState(this.getPostctx().getLinenumber(),
				new ArrayList<String>(init.getPostctx().getAllVars().keySet())), body);
		body =  new StmtBlock(body,ConstraintFactory.recordState(this.getPostctx().getLinenumber(),
				new ArrayList<String>(init.getPostctx().getAllVars().keySet())));
		return ((StmtBlock)((StmtBlock) body).stmts.get(0)).stmts.get(((StmtBlock)((StmtBlock) body).stmts.get(0)).stmts.size()-1).addRecordStmt((StmtBlock) body, 1, m);
	}



	@Override
	public boolean isBasic() {
		return true;
	}

	@Override
	public List<ExternalFunction> extractExternalFuncs(List<ExternalFunction> externalFuncNames) {
		externalFuncNames = cond.extractExternalFuncs(externalFuncNames);
		externalFuncNames = init.extractExternalFuncs(externalFuncNames);
		externalFuncNames = incr.extractExternalFuncs(externalFuncNames);
		externalFuncNames = body.extractExternalFuncs(externalFuncNames);
		return externalFuncNames ;
	}

	@Override
	public ConstData replaceLinearCombination(int index) {
		this.cond.setBoolean(true);
		List<SketchObject> toAdd = new ArrayList<SketchObject>();
		toAdd.add(init);
		toAdd.add(incr);
		toAdd.add(body);
		toAdd.add(cond);
		//toAdd.add(cond);
		return new ConstData(null, toAdd, index, 0, null,this.getLineNumber());
	}

	@Override
	public Map<Integer, String> ConstructLineToString(Map<Integer, String> line_to_string) {
		String result = null;
		if (incr.toString().endsWith(";"))
			result = "for(" + init.toString() + " " + cond.toString() + "; "
					+ incr.toString().substring(0, incr.toString().length() - 1) + "){";
		else
			result = "for(" + init.toString() + " " + cond.toString() + "; "
					+ incr.toString().substring(0, incr.toString().length() - 2) + ")";
		line_to_string.put(this.getLineNumber(), result);
		line_to_string = body.ConstructLineToString(line_to_string);
		return line_to_string;
	}
	
	@Override
	public String toString_Context(){
		String result = null;
		if (incr.toString().endsWith(";"))
			result = "for(" + init.toString_Context() + " " + cond.toString() + "; "
					+ incr.toString_Context() + "){\n";
		else
			result = "for(" + init.toString_Context() + " " + cond.toString() + "; "
					+ incr.toString_Context()+ "){\n";

		result += this.body.toString_Context() + "}\n";
		return result + ": "+this.getPostctx().toString();
	}


}