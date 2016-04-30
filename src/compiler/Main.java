import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 *  This executes on BRU program and generated intermediate code
 *  And produces intermediate code through MyVisitorClass
 */
public class Main {
    /**
     * File Name of input
     */
    public static  String filename;

    /**
     *
     * @param args Pass the input BRU program file
     * @throws Exception  Throw Exception if any while handling file
     */
    public static void main(String[] args) throws Exception{

        if ( args.length>0 )
            filename = args[0];
        else
            System.out.println("Argument Missing : Pass filename as argument");;


        //filename = "math.bru";
        ANTLRInputStream input = new ANTLRFileStream(filename);
        LabeledExprLexer lexer = new LabeledExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LabeledExprParser parser = new LabeledExprParser(tokens);

        ParseTree tree = parser.prog();
        MyVisitorClass vclass = new MyVisitorClass();
        vclass.visit(tree);

    }
}
