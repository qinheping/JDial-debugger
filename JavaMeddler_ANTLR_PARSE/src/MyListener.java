
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class MyListener extends Java8BaseListener {

	@Override public void exitLiteral(Java8Parser.LiteralContext ctx) 
	{ 
		System.out.println( "LITERAL ("+ctx.getStart().getLine() + "," + ctx.getStart().getCharPositionInLine()+"):" + ctx.getText() );
	}

}