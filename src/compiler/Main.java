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
 * Created by Abhinav on 16-04-2016.
 */
public class Main {


    public static  String filename;
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
