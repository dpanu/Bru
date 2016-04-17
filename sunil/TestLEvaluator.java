import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class TestLEvaluator {
    /** Sample "calculator" */
    public static class Evaluator extends LabeledExprBaseListener {
        Stack<Integer> stack = new Stack<Integer>();
		Stack<Boolean> boolstack = new Stack<Boolean>();
		Stack<String> stringstack = new Stack<String>();
		Map<String, Integer> memory = new HashMap<String, Integer>();
		
		public void exitInt(LabeledExprParser.IntContext ctx) { 
			int num = Integer.valueOf(ctx.INT().getText());
			stack.push(num);
		}
		
		public void exitBool(LabeledExprParser.BoolContext ctx) { 
			if(ctx.BOOL().getText().equals("true"))
				boolstack.push(true);
			else if (ctx.BOOL().getText().equals("false"))
				boolstack.push(false);
		}

		
		public void exitAddSub(LabeledExprParser.AddSubContext ctx){
			int right = stack.pop();
            int left = stack.pop();
			if ( ctx.op.getType() == LabeledExprParser.ADD ){
				//System.out.println(left+right);
				stack.push(left + right);
			}
			else{	
			//System.out.println(left-right);
				stack.push(left - right);
			}
		}

		public void exitMulDivMod(LabeledExprParser.MulDivModContext ctx){
			int right = stack.pop();
            int left = stack.pop();
			if ( ctx.op.getType() == LabeledExprParser.MUL ){
				//System.out.println(left*right);
				stack.push(left * right);
			}
			else if ( ctx.op.getType() == LabeledExprParser.DIV ) {
				//System.out.println(left / right);
				stack.push(left / right);
			}
			else{
				//System.out.println(left % right);
				stack.push(left % right);
			}
		}
		
		public void exitRelational(LabeledExprParser.RelationalContext ctx) { 
			int right = stack.pop();
            int left = stack.pop();
			if ( ctx.op.getType() == LabeledExprParser.LESS )
				System.out.println(left < right);
			else if ( ctx.op.getType() == LabeledExprParser.GRT ) 
				System.out.println(left > right);
			else if ( ctx.op.getType() == LabeledExprParser.LE ) 
				System.out.println(left <= right);
			else if ( ctx.op.getType() == LabeledExprParser.ME )
				System.out.println(left >= right);
				
		}
		
		public void exitEquality(LabeledExprParser.EqualityContext ctx) { 
			int right = stack.pop();
            int left = stack.pop();
			if ( ctx.op.getType() == LabeledExprParser.EQ )
				System.out.println(left == right);
			else if ( ctx.op.getType() == LabeledExprParser.NEQ ) 
				System.out.println(left != right);
			
		}
		
		
		public void exitLogicalAND(LabeledExprParser.LogicalANDContext ctx) {
			boolean right = boolstack.pop();
            boolean left = boolstack.pop();
				System.out.println(left && right);
		}
		
		
		public void exitLogicalOR(LabeledExprParser.LogicalORContext ctx) { 
			boolean right = boolstack.pop();
            boolean left = boolstack.pop();
				System.out.println(left || right);
		}
		
		
		
		public void exitAssign(LabeledExprParser.AssignContext ctx) { 
			memory.put(ctx.ID().getText(), stack.pop());
		}
		
		public void exitPrintline(LabeledExprParser.PrintlineContext ctx) { 
			if(memory.containsKey(ctx.expr().getText()))
				System.out.println(memory.get(ctx.expr().getText()));
			else
				System.out.println("Undefined Variable "+ ctx.expr().getText() +" define it before use");
		}
		
		public void exitPrintString(LabeledExprParser.PrintStringContext ctx) { 
			System.out.println(ctx.ID());
		}
		
    }

		
    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if ( args.length>0 ) inputFile = args[0];
        InputStream is = System.in;
        if ( inputFile!=null ) {
            is = new FileInputStream(inputFile);
        }
        ANTLRInputStream input = new ANTLRInputStream(is);
        LabeledExprLexer lexer = new LabeledExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LabeledExprParser parser = new LabeledExprParser(tokens);
        parser.setBuildParseTree(true);      // tell ANTLR to build a parse tree
        ParseTree tree = parser.prog(); // parse
        // show tree in text form
        System.out.println(tree.toStringTree(parser));

        ParseTreeWalker walker = new ParseTreeWalker();
        Evaluator eval = new Evaluator();
        walker.walk(eval, tree);
		while(!eval.stack.empty())
			System.out.println("Stack result = "+eval.stack.pop());
    }
}
