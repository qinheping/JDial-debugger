package sketchobj.stmts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class StmtBlock extends Statement {

	protected List<Statement> stmts;

	public StmtBlock(List<? extends Statement> stmts) {
		this.stmts = Collections.unmodifiableList(stmts);
	}

	/** Create a new StmtBlock for a pair of statements. */
	public StmtBlock(Statement stmt1, Statement stmt2) {
		List<Statement> lst = new ArrayList<Statement>(2);
		lst.add(stmt1);
		lst.add(stmt2);
		this.stmts = Collections.unmodifiableList(lst);
	}

	public String toString() {
		String result = "";
		Iterator<Statement> it = stmts.iterator();
		while (it.hasNext()) {
			result += it.next().toString() + "\n";
		}
		return result;
	}

	public boolean isBlock() {
		return true;
	}

	/** Returns the list of statements of this. */
	public List<Statement> getStmts() {
		return stmts;
	}

	@Override
	public int size() {
		int sz = 0;
		if (stmts != null) {
			for (Statement s : stmts) {
				sz += s.size();
			}
		}
		return sz;
	}
}
