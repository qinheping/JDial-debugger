package sketchobj.stmts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import constraintfactory.ConstData;
import constraintfactory.ExternalFunction;
import sketchobj.core.Context;
import sketchobj.core.SketchNode;
import sketchobj.core.SketchObject;
import sketchobj.core.Type;

public abstract class Statement extends SketchNode {

	private int lineNumber;
	private boolean sorceCode;
	private Context postctx;
	private Context prectx;

	public abstract boolean isBasic();

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public boolean isSorce() {
		return this.sorceCode;
	}

	public abstract ConstData replaceConst(int index);

	@Override
	public abstract ConstData replaceLinearCombination(int index);

	public Context getPostctx() {
		return postctx;
	}

	public void setPostctx(Context ctx) {
		this.postctx = ctx;
	}

	public abstract Context buildContext(Context prectx);

	public abstract Map<String, Type> addRecordStmt(StmtBlock parent, int index, Map<String, Type> m);

	public Context getPrectx() {
		return prectx;
	}

	public void setPrectx(Context prectx) {
		this.prectx = prectx;
	}

	@Override
	public ConstData replaceLinearCombination(int index,List<Integer> allowRange) {
		if (allowRange.contains(this.getLineNumber()))
			return this.replaceLinearCombination(index);
		return new ConstData(null, new ArrayList(), index, 0, null,this.lineNumber);
	}

	@Override
	public ConstData replaceConst(int index, List<Integer> repair_range) {
		if (repair_range.contains(this.lineNumber)){
			return this.replaceConst(index);

			}
		else
			return this.replaceConst_Exclude_This(index, repair_range);
	}

	public abstract ConstData replaceConst_Exclude_This(int index,List<Integer> repair_range);

	public abstract List<ExternalFunction> extractExternalFuncs(List<ExternalFunction> externalFuncNames);

	public abstract Map<Integer,String> ConstructLineToString(Map<Integer, String> line_to_string);
	
	public abstract Statement clone();
	
	public String toString_Context(){
		return this.toString()+": "+this.postctx.toString();
	};
}
