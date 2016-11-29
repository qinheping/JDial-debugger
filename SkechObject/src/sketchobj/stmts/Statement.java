package sketchobj.stmts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import constraintfactory.ConstData;
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

	public abstract void replaceLinearCombination();

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

	public void replaceLinearCombination(List<Integer> allowRange) {
		if (allowRange.contains(this.getLineNumber()))
			this.replaceLinearCombination();
	}

	@Override
	public ConstData replaceConst(int index, List<Integer> repair_range) {
		System.out.println(this.lineNumber + "  " + this );
		if (repair_range.contains(this.lineNumber)){
			return this.replaceConst(index);

			}
		else
			return this.replaceConst_Exclude_This(index, repair_range);
	}

	public abstract ConstData replaceConst_Exclude_This(int index,List<Integer> repair_range);
}
