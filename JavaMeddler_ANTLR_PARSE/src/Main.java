import java.io.File;
import java.io.PrintWriter;

import org.antlr.v4.Tool;
import org.antlr.v4.gui.TestRig;
import org.antlr.v4.runtime.*;

public class Main
{
	public static void main(String[] args)
	{
		// generate lexer and parser from Java8 grammer
		//Tool.main(new String[] {"-o", "src", "Java8.g4"});
		
		String code = "";
		try {
			// read in code from a single file file
			java.util.Scanner fin = new java.util.Scanner(new File("src/Test.java"));
			while(fin.hasNextLine()) code += fin.nextLine() + "\n"; 

			// create parse tree for the code in that file
			Java8Lexer lexer = new Java8Lexer( new ANTLRInputStream( code ) );
			Java8Parser parser = new Java8Parser( new CommonTokenStream(lexer) );
			parser.addParseListener( new MyListener() );
			parser.compilationUnit();

		} catch(java.io.FileNotFoundException e) { System.out.println("WARNING: File not found."); }
		System.out.println("DONE.");		
		
		// visualizer
		try { TestRig.main(new String[] {"Java8", "compilationUnit", "-gui", "src/Test.java"}); 
		} catch (Exception e) { e.printStackTrace(); }
	}
}
