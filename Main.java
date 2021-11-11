import expr.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;



class Main {
	
	public static void printTree(String prefix, ParseTree tree) {
		if (tree instanceof TerminalNode) {
			System.out.println(prefix +"'"+ tree.getText()+"'");
			return;
		}
		String className = tree.getClass().getSimpleName().replace("Context","");
		System.out.println(prefix + className + "[" + tree.getText() + "]");

		for (int c=0;c<tree.getChildCount();c++) {
			printTree(prefix + "|  ", tree.getChild(c));
		}

	}


  public static void main(String[] args) {
    System.out.println("Executando o reconhecedor.");
	//CharStream src = CharStreams.fromFileName("teste.expr");
	CharStream src = CharStreams.fromString("(1 + 3) / 2 ");
	
	ExprLexer lexer = new ExprLexer(src);
	TokenStream tokens = new CommonTokenStream(lexer);
	ExprParser parser = new ExprParser(tokens);

	ParseTree tree = parser.start();

	if (parser.getNumberOfSyntaxErrors()>0) {
	   System.out.println("entrada errada");
	   return;
	}
	System.out.println("entrada valida");
    printTree("", tree);
  }
}