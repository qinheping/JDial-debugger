package sketchobj.stmts;

import java.util.Collections;
import java.util.List;

public class StmtBlock extends Statement{

    protected List<Statement> stmts;
    public StmtBlock(List<? extends Statement> stmts)
    {
        this.stmts = Collections.unmodifiableList(stmts);
    }
}
