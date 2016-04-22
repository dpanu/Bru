import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Abhinav on 16-04-2016.
 */
public class MyVisitorClass extends LabeledExprBaseVisitor<String> {


    BufferedWriter out = null;

    FileWriter fstream;


    @Override
    public String visitAddSub(LabeledExprParser.AddSubContext ctx) {
        visitChildren(ctx);
        if (ctx.op.getType() == LabeledExprParser.ADD) {
            //System.out.println(left+right);
            try {
                fstream = new FileWriter("out.bruclass", true);
                out = new BufferedWriter(fstream);
                if (ctx.getChild(2) instanceof LabeledExprParser.IntContext) {
                    out.write("PUSH " + ctx.getChild(2).getText() + "\n");
                }
                if (ctx.getChild(2) instanceof LabeledExprParser.IdContext) {
                    out.write("LOAD " + ctx.getChild(2).getText() + "\n");
                }
                if (ctx.getChild(0) instanceof LabeledExprParser.IntContext) {
                    out.write("PUSH " + ctx.getChild(0).getText() + "\n");
                }
                if (ctx.getChild(0) instanceof LabeledExprParser.IdContext) {
                    out.write("LOAD " + ctx.getChild(0).getText() + "\n");
                }

                out.write("ADD" + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            // stack.push(left + right);
        } else {
            //System.out.println(left-right);
            try {
                fstream = new FileWriter("out.bruclass", true);

                out = new BufferedWriter(fstream);
                if (ctx.getChild(2) instanceof LabeledExprParser.IntContext) {
                    out.write("PUSH " + ctx.getChild(2).getText() + "\n");
                }
                if (ctx.getChild(2) instanceof LabeledExprParser.IdContext) {
                    out.write("LOAD " + ctx.getChild(2).getText() + "\n");
                }
                if (ctx.getChild(0) instanceof LabeledExprParser.IntContext) {
                    out.write("PUSH " + ctx.getChild(0).getText() + "\n");
                }
                if (ctx.getChild(0) instanceof LabeledExprParser.IdContext) {
                    out.write("LOAD " + ctx.getChild(0).getText() + "\n");
                }

                out.write("SUB" + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            //stack.push(left - right);
        }
        return null;
    }

    @Override
    public String visitMulDivMod(LabeledExprParser.MulDivModContext ctx) {
       visitChildren(ctx);
        if (ctx.op.getType() == LabeledExprParser.MUL) {
            //System.out.println(left*right);
            try {
                fstream = new FileWriter("out.bruclass", true);
                out = new BufferedWriter(fstream);
                if (ctx.getChild(2) instanceof LabeledExprParser.IntContext) {
                    out.write("PUSH " + ctx.getChild(2).getText() + "\n");
                }
                if (ctx.getChild(2) instanceof LabeledExprParser.IdContext) {
                    out.write("LOAD " + ctx.getChild(2).getText() + "\n");
                }
                if (ctx.getChild(0) instanceof LabeledExprParser.IntContext) {
                    out.write("PUSH " + ctx.getChild(0).getText() + "\n");
                }
                if (ctx.getChild(0) instanceof LabeledExprParser.IdContext) {
                    out.write("LOAD " + ctx.getChild(0).getText() + "\n");
                }

                out.write("MULT" + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            //    stack.push(left * right);
        } else if (ctx.op.getType() == LabeledExprParser.DIV) {
            //System.out.println(left / right);
            try {
                fstream = new FileWriter("out.bruclass", true);
                out = new BufferedWriter(fstream);
                if (ctx.getChild(2) instanceof LabeledExprParser.IntContext) {
                    out.write("PUSH " + ctx.getChild(2).getText() + "\n");
                }
                if (ctx.getChild(2) instanceof LabeledExprParser.IdContext) {
                    out.write("LOAD " + ctx.getChild(2).getText() + "\n");
                }
                if (ctx.getChild(0) instanceof LabeledExprParser.IntContext) {
                    out.write("PUSH " + ctx.getChild(0).getText() + "\n");
                }
                if (ctx.getChild(0) instanceof LabeledExprParser.IdContext) {
                    out.write("LOAD " + ctx.getChild(0).getText() + "\n");
                }

                out.write("DIV" + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        } else {

            try {
                fstream = new FileWriter("out.bruclass", true);
                out = new BufferedWriter(fstream);
                if (ctx.getChild(2) instanceof LabeledExprParser.IntContext) {
                    out.write("PUSH " + ctx.getChild(2).getText() + "\n");
                }
                if (ctx.getChild(2) instanceof LabeledExprParser.IdContext) {
                    out.write("LOAD " + ctx.getChild(2).getText() + "\n");
                }
                if (ctx.getChild(0) instanceof LabeledExprParser.IntContext) {
                    out.write("PUSH " + ctx.getChild(0).getText() + "\n");
                }
                if (ctx.getChild(0) instanceof LabeledExprParser.IdContext) {
                    out.write("LOAD " + ctx.getChild(0).getText() + "\n");
                }

                out.write("MOD" + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    return null;
    }

    @Override
    public String visitInt(LabeledExprParser.IntContext ctx) {
        visitChildren(ctx);
        return  null;
    }

    @Override
    public String visitAssign(LabeledExprParser.AssignContext ctx) {

        visitChildren(ctx);

        if(ctx.getChild(2) instanceof LabeledExprParser.IntContext){
            try {
                fstream = new FileWriter("out.bruclass", true);
                out = new BufferedWriter(fstream);
                out.write("PUSH "+ctx.getChild(2).getText() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(out!=null){
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if(ctx.getChild(2) instanceof LabeledExprParser.IdContext){
            try {
                fstream = new FileWriter("out.bruclass", true);
                out = new BufferedWriter(fstream);
                out.write("LOAD "+ctx.getChild(2).getText() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(out!=null){
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        try {
            //visitAddSub((LabeledExprParser.AddSubContext) ctx.expr());
            //visit(ctx.expr());
            fstream = new FileWriter("out.bruclass", true);
            out = new BufferedWriter(fstream);
            out.write("STORE "+ctx.ID().getText() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    return null;
    }

    @Override
    public String visitRelational(LabeledExprParser.RelationalContext ctx) {
        //visitChildren(ctx);
        if ( ctx.op.getType() == LabeledExprParser.LESS ){
            try {
                fstream = new FileWriter("out.bruclass", true);
                out = new BufferedWriter(fstream);
                if(ctx.getChild(2) instanceof LabeledExprParser.IntContext){
                    out.write("PUSH "+ ctx.getChild(2).getText() + "\n");
                }
                if(ctx.getChild(2) instanceof LabeledExprParser.IdContext){
                    out.write("LOAD "+ ctx.getChild(2).getText() + "\n");
                }
                if(ctx.getChild(0) instanceof LabeledExprParser.IntContext){
                    out.write("PUSH "+ ctx.getChild(0).getText() + "\n");
                }
                if(ctx.getChild(0) instanceof LabeledExprParser.IdContext){
                    out.write("LOAD "+ ctx.getChild(0).getText() + "\n");
                }

                out.write("LESS" + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(out!=null){
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else if ( ctx.op.getType() == LabeledExprParser.GRT ){
            try {
                fstream = new FileWriter("out.bruclass", true);
                out = new BufferedWriter(fstream);
                if(ctx.getChild(2) instanceof LabeledExprParser.IntContext){
                    out.write("PUSH "+ ctx.getChild(2).getText() + "\n");
                }
                if(ctx.getChild(2) instanceof LabeledExprParser.IdContext){
                    out.write("LOAD "+ ctx.getChild(2).getText() + "\n");
                }
                if(ctx.getChild(0) instanceof LabeledExprParser.IntContext){
                    out.write("PUSH "+ ctx.getChild(0).getText() + "\n");
                }
                if(ctx.getChild(0) instanceof LabeledExprParser.IdContext){
                    out.write("LOAD "+ ctx.getChild(0).getText() + "\n");
                }

                out.write("GRT" + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(out!=null){
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else if ( ctx.op.getType() == LabeledExprParser.LE ){
            try {
                fstream = new FileWriter("out.bruclass", true);
                out = new BufferedWriter(fstream);
                if(ctx.getChild(2) instanceof LabeledExprParser.IntContext){
                    out.write("PUSH "+ ctx.getChild(2).getText() + "\n");
                }
                if(ctx.getChild(2) instanceof LabeledExprParser.IdContext){
                    out.write("LOAD "+ ctx.getChild(2).getText() + "\n");
                }
                if(ctx.getChild(0) instanceof LabeledExprParser.IntContext){
                    out.write("PUSH "+ ctx.getChild(0).getText() + "\n");
                }
                if(ctx.getChild(0) instanceof LabeledExprParser.IdContext){
                    out.write("LOAD "+ ctx.getChild(0).getText() + "\n");
                }

                out.write("LE" + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(out!=null){
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else if ( ctx.op.getType() == LabeledExprParser.ME ){
            try {
                fstream = new FileWriter("out.bruclass", true);
                out = new BufferedWriter(fstream);
                if(ctx.getChild(2) instanceof LabeledExprParser.IntContext){
                    out.write("PUSH "+ ctx.getChild(2).getText() + "\n");
                }
                if(ctx.getChild(2) instanceof LabeledExprParser.IdContext){
                    out.write("LOAD "+ ctx.getChild(2).getText() + "\n");
                }
                if(ctx.getChild(0) instanceof LabeledExprParser.IntContext){
                    out.write("PUSH "+ ctx.getChild(0).getText() + "\n");
                }
                if(ctx.getChild(0) instanceof LabeledExprParser.IdContext){
                    out.write("LOAD "+ ctx.getChild(0).getText() + "\n");
                }

                out.write("ME" + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(out!=null){
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String visitEquality(LabeledExprParser.EqualityContext ctx) {
        //visitChildren(ctx);
        if ( ctx.op.getType() == LabeledExprParser.EQ ){
            try {
                fstream = new FileWriter("out.bruclass", true);
                out = new BufferedWriter(fstream);
                if(ctx.getChild(2) instanceof LabeledExprParser.IntContext){
                    out.write("PUSH "+ ctx.getChild(2).getText() + "\n");
                }
                if(ctx.getChild(2) instanceof LabeledExprParser.IdContext){
                    out.write("LOAD "+ ctx.getChild(2).getText() + "\n");
                }
                if(ctx.getChild(0) instanceof LabeledExprParser.IntContext){
                    out.write("PUSH "+ ctx.getChild(0).getText() + "\n");
                }
                if(ctx.getChild(0) instanceof LabeledExprParser.IdContext){
                    out.write("LOAD "+ ctx.getChild(0).getText() + "\n");
                }

                out.write("EQ" + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(out!=null){
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else if ( ctx.op.getType() == LabeledExprParser.NEQ ){
            try {
                fstream = new FileWriter("out.bruclass", true);
                out = new BufferedWriter(fstream);
                if(ctx.getChild(2) instanceof LabeledExprParser.IntContext){
                    out.write("PUSH "+ ctx.getChild(2).getText() + "\n");
                }
                if(ctx.getChild(2) instanceof LabeledExprParser.IdContext){
                    out.write("LOAD "+ ctx.getChild(2).getText() + "\n");
                }
                if(ctx.getChild(0) instanceof LabeledExprParser.IntContext){
                    out.write("PUSH "+ ctx.getChild(0).getText() + "\n");
                }
                if(ctx.getChild(0) instanceof LabeledExprParser.IdContext){
                    out.write("LOAD "+ ctx.getChild(0).getText() + "\n");
                }

                out.write("NEQ" + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(out!=null){
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    return null;
    }

    @Override
    public String visitPrintline(LabeledExprParser.PrintlineContext ctx) {
        visitChildren(ctx);
        try {
            fstream = new FileWriter("out.bruclass", true);
            out = new BufferedWriter(fstream);
            //out.write("");
            out.write("PRINT " + ctx.expr().getText() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public String visitIf(LabeledExprParser.IfContext ctx) {
        //visitChildren(ctx);
        //System.out.println("Childs are : " + ctx.getChildCount());
        //System.out.println("Print if");
        visit(ctx.exp);
        //System.out.println("if true");
        try {
            fstream = new FileWriter("out.bruclass", true);
            out = new BufferedWriter(fstream);
            out.write("IFtrue" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        visit(ctx.ifstmt);

        try {
            fstream = new FileWriter("out.bruclass", true);
            out = new BufferedWriter(fstream);
            out.write("Go-Endifelse" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public String visitElse(LabeledExprParser.ElseContext ctx) {

        try {
            fstream = new FileWriter("out.bruclass", true);
            out = new BufferedWriter(fstream);
            out.write("IFfalse" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        visit(ctx.elstmt);

        try {
            fstream = new FileWriter("out.bruclass", true);
            out = new BufferedWriter(fstream);
            out.write("EndIfelse" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    @Override
    public String visitLoopcond(LabeledExprParser.LoopcondContext ctx) {
        try {
            fstream = new FileWriter("out.bruclass", true);
            out = new BufferedWriter(fstream);
            out.write("\nWStart" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        visit(ctx.exps);

        try {
            fstream = new FileWriter("out.bruclass", true);
            out = new BufferedWriter(fstream);
            out.write("Whiletrue" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        visit(ctx.whlstmt);
        try {
            fstream = new FileWriter("out.bruclass", true);
            out = new BufferedWriter(fstream);
            out.write("Go WStart" + "\n");
            out.write("WEnd" + "\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    @Override
    public String visitFuncdecl(LabeledExprParser.FuncdeclContext ctx) {

        System.out.println("Function Declaration starts");
        //System.out.println(ctx.getChild(1).getText());
        try {
            fstream = new FileWriter("out.bruclass", true);
            out = new BufferedWriter(fstream);
            out.write("\nFuncDef " + ctx.getChild(1).getText() + "\n");
            //out.write("WEnd" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        visit(ctx.args);
        try {
            fstream = new FileWriter("out.bruclass", true);
            out = new BufferedWriter(fstream);
            out.write("\n.func body start" + "\n");

            //out.write("WEnd" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        visit(ctx.stmt);
        try {
            fstream = new FileWriter("out.bruclass", true);
            out = new BufferedWriter(fstream);
            out.write(".func body ends" + "\n\n");
            out.write("FuncDef Ends" + "\n");
            //out.write("WEnd" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return null;
    }


    @Override
    public String visitExprsList(LabeledExprParser.ExprsListContext ctx) {

        System.out.println("Sie is " + ctx.exprsn.size());
        try {
            fstream = new FileWriter("out.bruclass", true);
            out = new BufferedWriter(fstream);
            for(int i = ctx.exprsn.size()-1; i >=0 ;i--){
                out.write("STORE " + ctx.exprsn.get(i).getText() + "\n");
            }
            //out.write("WEnd" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    @Override
    public String visitFunccall(LabeledExprParser.FunccallContext ctx) {
        try {
            fstream = new FileWriter("out.bruclass", true);
            out = new BufferedWriter(fstream);
            out.write("FuncCall " + ctx.ID() + "\n");
            //out.write("WEnd" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        visit(ctx.args);

        return null;
    }

    @Override
    public String visitArguments(LabeledExprParser.ArgumentsContext ctx) {
        System.out.println("In here");
        //visit(ctx.expr);
        System.out.println(ctx.exprsn.size());
        try {
            fstream = new FileWriter("out.bruclass", true);
            out = new BufferedWriter(fstream);
            for(int i=0;i<ctx.exprsn.size();i++){
                if(ctx.exprsn.get(i) instanceof LabeledExprParser.IdContext){
                    out.write("LOAD " + ctx.exprsn.get(i).getText() + "\n");
                }else if(ctx.exprsn.get(i) instanceof LabeledExprParser.IntContext){
                    out.write("PUSH " + ctx.exprsn.get(i).getText() + "\n");
                }

            }
            out.write("FuncCall Ends" + "\n");

            //out.write("WEnd" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //System.out.println(ctx.exprsn.get(0).getText());
        return null;
    }


}
