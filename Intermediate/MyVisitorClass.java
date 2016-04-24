import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class MyVisitorClass extends LabeledExprBaseVisitor<String> {


    BufferedWriter out = null;

    FileWriter fstream;
    String fileName = Main.filename;
    String[] parts = fileName.split("\\.");
    String parts1 = parts[0];

    String outFile = parts1.concat(".bruclass");
    File file = new File(outFile);
    int labelcounter = 0;
    
    MyVisitorClass(){
        if(file.exists()){
            //System.out.println("Deleting file");
            file.delete();
        }
    }
    
    public String createlabel(){
        labelcounter++;
        return ("label"+labelcounter);
    }
    
    @Override
    public String visitAddSub(LabeledExprParser.AddSubContext ctx) {
        visitChildren(ctx);

        if (ctx.op.getType() == LabeledExprParser.ADD) {
            //System.out.println(left+right);
            try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				){
                
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
            }
            
        } else {
            //System.out.println(left-right);
            try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
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
            try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
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
            }
            //    stack.push(left * right);
        } else if (ctx.op.getType() == LabeledExprParser.DIV) {
            //System.out.println(left / right);
            try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
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
            }
        } else {

            try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
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
            try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
                out.write("PUSH "+ctx.getChild(2).getText() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(ctx.getChild(2) instanceof LabeledExprParser.IdContext){
            try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
                out.write("LOAD "+ctx.getChild(2).getText() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
            out.write("STORE "+ctx.ID().getText() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    return null;
    }

    @Override
    public String visitRelational(LabeledExprParser.RelationalContext ctx) {
        //visitChildren(ctx);
        if ( ctx.op.getType() == LabeledExprParser.LESS ){
            try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
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
            }
        }
        else if ( ctx.op.getType() == LabeledExprParser.GRT ){
            try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
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
            }
        }
        else if ( ctx.op.getType() == LabeledExprParser.LE ){
            try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
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
            }
        }
        else if ( ctx.op.getType() == LabeledExprParser.ME ){
            try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				){
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
            }
        }
        return null;
    }

    @Override
    public String visitEquality(LabeledExprParser.EqualityContext ctx) {
        //visitChildren(ctx);
        if ( ctx.op.getType() == LabeledExprParser.EQ ){
            try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
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
            }
        }
        else if ( ctx.op.getType() == LabeledExprParser.NEQ ){
            try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
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
            }
        }

    return null;
    }

    @Override
    public String visitPrintline(LabeledExprParser.PrintlineContext ctx) {
        visitChildren(ctx);
        try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
            out.write("PRINT " + ctx.expr().getText() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return null;
    }

    @Override
    public String visitIf(LabeledExprParser.IfContext ctx) {
        visit(ctx.exp);
        //System.out.println("if true");
        try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
            out.write("IFtrue" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } 

        visit(ctx.ifstmt);

        try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
            out.write("Go-Endifelse" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return null;
    }

    @Override
    public String visitElse(LabeledExprParser.ElseContext ctx) {

        try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
            out.write("IFfalse" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        visit(ctx.elstmt);

        try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
            out.write("EndIfelse" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return null;
    }

    @Override
    public String visitLoopcond(LabeledExprParser.LoopcondContext ctx) {
        try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
            String label = createlabel();
            out.write("\nWStart " + label + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        visit(ctx.exps);

        try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
            out.write("Whiletrue" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } 
		
        visit(ctx.whlstmt);
        try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
            out.write("Go-WStart" + "\n");
            out.write("WEnd" + "\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String visitFuncdecl(LabeledExprParser.FuncdeclContext ctx) {

        //System.out.println("Function Declaration starts");
        //System.out.println(ctx.getChild(1).getText());
        System.out.println(ctx.getChildCount());
        try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
            out.write("\nFuncDef " + ctx.getChild(1).getText() + "\n");
            //out.write("WEnd" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } 
        visit(ctx.args);

        try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
            out.write("\n.func body start" + "\n");

            //out.write("WEnd" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        visit(ctx.stmt);
        visit(ctx.ret);

        try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
            out.write(".func body ends" + "\n\n");
            out.write("FuncDef Ends" + "\n");
            //out.write("WEnd" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } 
		
        return null;
    }


    @Override
    public String visitReturnStmt(LabeledExprParser.ReturnStmtContext ctx) {

        System.out.println("in return statement");

        if(ctx.getChildCount() > 0){
        //    System.out.println("chile are " + ctx.getChildCount());
            try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
                out.write("PUSH " + ctx.getChild(1).getText() + "\n");
                out.write(ctx.getChild(0).getText().toUpperCase() + "\n");
                //out.write("WEnd" + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }
        return null;
    }

    @Override
    public String visitExprsList(LabeledExprParser.ExprsListContext ctx) {

        //System.out.println("Sie is " + ctx.exprsn.size());
        try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
            for(int i = ctx.exprsn.size()-1; i >=0 ;i--){
                out.write("STORE " + ctx.exprsn.get(i).getText() + "\n");
            }
            //out.write("WEnd" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return null;
    }

    @Override
    public String visitFunccall(LabeledExprParser.FunccallContext ctx) {
        try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
            out.write("FuncCall " + ctx.ID() + "\n");
            //out.write("WEnd" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } 
        visit(ctx.args);

        return null;
    }

    @Override
    public String visitArguments(LabeledExprParser.ArgumentsContext ctx) {
        //System.out.println("In here");
        //visit(ctx.expr);
        System.out.println(ctx.exprsn.size());
        try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
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
        }
        //System.out.println(ctx.exprsn.get(0).getText());
        return null;
    }

    @Override
    public String visitStackdec(LabeledExprParser.StackdecContext ctx) {

        try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
            out.write("STKDEC " + ctx.getChild(1).getText() + "\n");
            //out.write("WEnd" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return null;
    }

    @Override
    public String visitStkpush(LabeledExprParser.StkpushContext ctx) {
        //System.out.println("child count from stk psh " + ctx.getChildCount());
        try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
            out.write("PUSH " + ctx.getChild(4).getText() + "\n");
            out.write("STORESTK " + ctx.getChild(0).getText() + "\n");
            //out.write("WEnd" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return null;
    }


    @Override
    public String visitStkpeek(LabeledExprParser.StkpeekContext ctx) {
        try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
            out.write("STKPEEK " + ctx.getChild(0).getText() + "\n");
            //out.write("WEnd" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return null;
    }

    @Override
    public String visitStkempty(LabeledExprParser.StkemptyContext ctx) {
        try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				) {
            out.write("STKEMPTY " + ctx.getChild(0).getText() + "\n");
            //out.write("WEnd" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    public String visitStkpop(LabeledExprParser.StkpopContext ctx) {

        try (
				FileWriter fstream = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(fstream);
				)  {
            out.write("STKPOP " + ctx.getChild(0).getText() + "\n");
            //out.write("WEnd" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return null;
    }
}
