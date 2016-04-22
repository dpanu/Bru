import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by Abhinav on 16-04-2016.
 */
public class Main {

    public static void main(String[] args) throws Exception{


        ANTLRInputStream input = new ANTLRFileStream("t.expr");
        LabeledExprLexer lexer = new LabeledExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LabeledExprParser parser = new LabeledExprParser(tokens);

        ParseTree tree = parser.prog();
        new MyVisitorClass().visit(tree);


/*
        String inputFile = "t.expr";
        //if ( args.length>0 ) inputFile = args[0];
        //InputStream is = System.in;
        InputStream is = new FileInputStream(inputFile);

        ANTLRInputStream input = new ANTLRInputStream(is);
        LabeledExprLexer lexer = new LabeledExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
      System.out.println(tokens.getTokens());
        LabeledExprParser parser = new LabeledExprParser(tokens);

        parser.setBuildParseTree(true);      // tell ANTLR to build a parse tree
        ParseTree tree = parser.prog(); // parse
        // show tree in text form
        System.out.println(tree.toStringTree(parser));

        ParseTreeWalker walker = new ParseTreeWalker();
        //MyListener eval = new MyListener();
        MyListenerClass eval = new MyListenerClass();
        walker.walk(eval, tree);

        //while(!eval.stack.empty())
          //  System.out.println("Stack result = "+eval.stack.pop());


*/
    }
}
