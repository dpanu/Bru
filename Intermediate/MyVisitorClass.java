import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Abhinav on 16-04-2016.
 */
public class MyVisitorClass extends LabeledExprBaseVisitor<String> {


    BufferedWriter out = null;

    FileWriter fstream;
    String filekanaam = Main.filename;
    String[] parts = filekanaam.split("\\.");
    String parts1 = parts[0];

    String outFile = parts1.concat(".bruclass");
    File file = new File(outFile);
    int labelcounter = 0;

    MyVisitorClass() {
        if (file.exists()) {
            //System.out.println("Deleting file");
            file.delete();
        }
    }

    public String createlabel() {
        labelcounter++;
        return ("label#" + labelcounter);
    }

    @Override
    public String visitAddSub(LabeledExprParser.AddSubContext ctx) {
        visitChildren(ctx);

        if (ctx.op.getType() == LabeledExprParser.ADD) {
            //System.out.println(left+right);
            try {
                fstream = new FileWriter(file, true);
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
                fstream = new FileWriter(file, true);

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
                fstream = new FileWriter(file, true);
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

                out.write("MUL" + "\n");
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
                fstream = new FileWriter(file, true);
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
                fstream = new FileWriter(file, true);
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
        return null;
    }

    @Override
    public String visitAssign(LabeledExprParser.AssignContext ctx) {

        visitChildren(ctx);

        if (ctx.getChild(2) instanceof LabeledExprParser.BoolContext) {
            try {
                fstream = new FileWriter(file, true);
                out = new BufferedWriter(fstream);
                out.write("PUSH " + ctx.getChild(2).getText() + "\n");
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


        if (ctx.getChild(2) instanceof LabeledExprParser.IntContext) {
            try {
                fstream = new FileWriter(file, true);
                out = new BufferedWriter(fstream);
                out.write("PUSH " + ctx.getChild(2).getText() + "\n");
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
        if (ctx.getChild(2) instanceof LabeledExprParser.IdContext) {
            try {
                fstream = new FileWriter(file, true);
                out = new BufferedWriter(fstream);
                out.write("LOAD " + ctx.getChild(2).getText() + "\n");
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
        try {
            //visitAddSub((LabeledExprParser.AddSubContext) ctx.expr());
            //visit(ctx.expr());
            fstream = new FileWriter(file, true);
            out = new BufferedWriter(fstream);
            out.write("STORE " + ctx.ID().getText() + "\n");
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
    public String visitRelational(LabeledExprParser.RelationalContext ctx) {
        //visitChildren(ctx);
        if (ctx.op.getType() == LabeledExprParser.LESS) {
            try {
                fstream = new FileWriter(file, true);
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

                out.write("LESS" + "\n");
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
        } else if (ctx.op.getType() == LabeledExprParser.GRT) {
            try {
                fstream = new FileWriter(file, true);
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

                out.write("GRT" + "\n");
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
        } else if (ctx.op.getType() == LabeledExprParser.LE) {
            try {
                fstream = new FileWriter(file, true);
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

                out.write("LE" + "\n");
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
        } else if (ctx.op.getType() == LabeledExprParser.ME) {
            try {
                fstream = new FileWriter(file, true);
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

                out.write("ME" + "\n");
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
    public String visitLogicalANDOR(LabeledExprParser.LogicalANDORContext ctx) {


        if (ctx.op.getType() == LabeledExprParser.LAND) {
            try {
                fstream = new FileWriter(file, true);
                out = new BufferedWriter(fstream);
                out.write("PUSH " + ctx.getChild(2).getText() + "\n");
                out.write("PUSH " + ctx.getChild(0).getText() + "\n");
                out.write("AND" + "\n");
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
        }else if(ctx.op.getType() == LabeledExprParser.LOR){
            try {
                fstream = new FileWriter(file, true);
                out = new BufferedWriter(fstream);
                out.write("PUSH " + ctx.getChild(2).getText() + "\n");
                out.write("PUSH " + ctx.getChild(0).getText() + "\n");
                out.write("OR" + "\n");
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
    public String visitEquality(LabeledExprParser.EqualityContext ctx) {
        //visitChildren(ctx);
        if ( ctx.op.getType() == LabeledExprParser.EQ ){
            try {
                fstream = new FileWriter(file, true);
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
                fstream = new FileWriter(file, true);
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
        System.out.println("Print Line");
        visitChildren(ctx);
        try {
            fstream = new FileWriter(file, true);
            out = new BufferedWriter(fstream);
            //out.write("");

            out.write("PRINT " + ctx.expr().getText() + "\n");

           /* if(ctx.getChild(2) instanceof LabeledExprParser.StringContext){
                out.write("PRINT " + "\n");
            }else{
                out.write("PRINT " + ctx.expr().getText() + "\n");
            }*/

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

        visit(ctx.exp);
        //System.out.println("if true");
        try {
            fstream = new FileWriter(file, true);
            out = new BufferedWriter(fstream);
            out.write("\nIFtrue " + "\n");
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
            fstream = new FileWriter(file, true);
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
            fstream = new FileWriter(file, true);
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
            fstream = new FileWriter(file, true);
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
            fstream = new FileWriter(file, true);
            out = new BufferedWriter(fstream);
            String label = createlabel();
            out.write("\nWStart " + label + "\n");
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
            fstream = new FileWriter(file, true);
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
            fstream = new FileWriter(file, true);
            out = new BufferedWriter(fstream);
            out.write("Go-WStart" + "\n");
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


        // if main function then don't visit the argms
        if(ctx.getChild(1).getText().equals("main")){

            try {
                fstream = new FileWriter(file, true);
                out = new BufferedWriter(fstream);
                out.write("\n.MainMethodStarts\n");
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

            try {
                fstream = new FileWriter(file, true);
                out = new BufferedWriter(fstream);
                if(!(ctx.getChild(1).getText().equals("main"))){
                    out.write("\n.funcBodyStarts " + ctx.getChild(1).getText() + "\n");
                    //out.write("\n.main method starts\n");
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
            visit(ctx.stmt);
            visit(ctx.ret);
            try {
                fstream = new FileWriter(file, true);
                out = new BufferedWriter(fstream);
                if(ctx.getChild(1).getText().equals("main")){
                    out.write("\n.MainMethodEnds\n");
                }else{
                    out.write(".funcbodyends" + "\n\n");
                    out.write("funcends" + "\n");
                    //out.write("\nFuncDef " + ctx.getChild(1).getText() + "\n");
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

        }else{

            try {
                fstream = new FileWriter(file, true);
                out = new BufferedWriter(fstream);
                out.write("FuncDef " + ctx.getChild(1).getText() + "\n");
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
                fstream = new FileWriter(file, true);
                out = new BufferedWriter(fstream);
                //out.write("\n.func body start" + "\n");
                if(ctx.getChild(1).getText().equals("main")){
                    //out.write("\n.main method starts\n");
                }else{
                    out.write("\n.funcBodyStarts " + ctx.getChild(1).getText() + "\n");
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

            visit(ctx.stmt);
            visit(ctx.ret);
            //visit(ctx.ret);

            try {
                fstream = new FileWriter(file, true);
                out = new BufferedWriter(fstream);
                if(ctx.getChild(1).getText().equals("main")){
                    out.write("\n.mainMethodEnds\n");
                }else{
                    out.write(".funcbodyends" + "\n");
                    out.write("funcends" + "\n\n");
                    //out.write("\nFuncDef " + ctx.getChild(1).getText() + "\n");
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
        }
        return null;

    }



    @Override
    public String visitReturnStmt(LabeledExprParser.ReturnStmtContext ctx) {

        //System.out.println("in return statement");

        if(ctx.getChildCount() > 0){
              //System.out.println("chile are " + ctx.getChildCount());
            try {
                fstream = new FileWriter(file, true);
                out = new BufferedWriter(fstream);
                if(ctx.getChild(1) instanceof LabeledExprParser.IntContext){
                    out.write("PUSH " + ctx.getChild(1).getText() + "\n");
                }else{
                    out.write("LOAD " + ctx.getChild(1).getText() + "\n");
                }

                out.write(ctx.getChild(0).getText().toUpperCase() + "\n");
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

        }
        return null;
    }

    @Override
    public String visitExprsList(LabeledExprParser.ExprsListContext ctx) {


       // System.out.println("Size is " + ctx.exprsn.size());
        if(!ctx.getChild(0).getText().equals("void")){
            try {
                fstream = new FileWriter(file, true);
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

        }


        return null;
    }

    @Override
    public String visitFunccall(LabeledExprParser.FunccallContext ctx) {
        try {
            fstream = new FileWriter(file, true);
            out = new BufferedWriter(fstream);
            out.write("\nFuncCall " + ctx.ID() + "\n");
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
        //System.out.println("In here");
        //visit(ctx.expr);
        System.out.println(ctx.exprsn.size());
        try {
            fstream = new FileWriter(file, true);
            out = new BufferedWriter(fstream);
            for(int i=0;i<ctx.exprsn.size();i++){
                if(ctx.exprsn.get(i) instanceof LabeledExprParser.IdContext){
                    out.write("LOAD " + ctx.exprsn.get(i).getText() + "\n");
                }else if(ctx.exprsn.get(i) instanceof LabeledExprParser.IntContext){
                    out.write("PUSH " + ctx.exprsn.get(i).getText() + "\n");
                }

            }
            out.write("FuncCall Ends" + "\n\n");

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
    /*
    @Override
    public String visitStackdec(LabeledExprParser.StackdecContext ctx) {
           try {
            fstream = new FileWriter(file, true);
            out = new BufferedWriter(fstream);
            out.write("STKDEC " + ctx.getChild(1).getText() + "\n");
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
    */

    @Override
    public String visitStackdec(LabeledExprParser.StackdecContext ctx) {
        //System.out.println("Total Child are " + ctx.getChildCount());
        try {
            fstream = new FileWriter(file, true);
            out = new BufferedWriter(fstream);
            out.write("\nSTKDEC " + ctx.getChild(1).getText() + "\n");
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
    public String visitStkpush(LabeledExprParser.StkpushContext ctx) {
        //System.out.println("child count from stk psh " + ctx.getChildCount());
        try {
            fstream = new FileWriter(file, true);
            out = new BufferedWriter(fstream);
            out.write("PUSH " + ctx.getChild(4).getText() + "\n");
            out.write("STORESTK " + ctx.getChild(0).getText() + "\n");
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
    public String visitStkpeek(LabeledExprParser.StkpeekContext ctx) {
        try {
            fstream = new FileWriter(file, true);
            out = new BufferedWriter(fstream);
            out.write("STKPEEK " + ctx.getChild(0).getText() + "\n");
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
    public String visitStkempty(LabeledExprParser.StkemptyContext ctx) {

        try {
            fstream = new FileWriter(file, true);
            out = new BufferedWriter(fstream);
            out.write("STKEMPTY " + ctx.getChild(0).getText() + "\n");
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
        return  null;
    }

    @Override
    public String visitStkpop(LabeledExprParser.StkpopContext ctx) {

        try {
            fstream = new FileWriter(file, true);
            out = new BufferedWriter(fstream);
            out.write("STKPOP " + ctx.getChild(0).getText() + "\n");
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
}
