// Generated from LabeledExpr.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LabeledExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LabeledExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code assignvalue}
	 * labeled alternative in {@link LabeledExprParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignvalue(@NotNull LabeledExprParser.AssignvalueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link LabeledExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(@NotNull LabeledExprParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link LabeledExprParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlank(@NotNull LabeledExprParser.BlankContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link LabeledExprParser#conditionalexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(@NotNull LabeledExprParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intval}
	 * labeled alternative in {@link LabeledExprParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntval(@NotNull LabeledExprParser.IntvalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string}
	 * labeled alternative in {@link LabeledExprParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(@NotNull LabeledExprParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link LabeledExprParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(@NotNull LabeledExprParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link LabeledExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(@NotNull LabeledExprParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link LabeledExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(@NotNull LabeledExprParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionalANDOR}
	 * labeled alternative in {@link LabeledExprParser#conditionalexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalANDOR(@NotNull LabeledExprParser.ConditionalANDORContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifcondition}
	 * labeled alternative in {@link LabeledExprParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfcondition(@NotNull LabeledExprParser.IfconditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code loops}
	 * labeled alternative in {@link LabeledExprParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoops(@NotNull LabeledExprParser.LoopsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(@NotNull LabeledExprParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link LabeledExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(@NotNull LabeledExprParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifelse}
	 * labeled alternative in {@link LabeledExprParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfelse(@NotNull LabeledExprParser.IfelseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idval}
	 * labeled alternative in {@link LabeledExprParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdval(@NotNull LabeledExprParser.IdvalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code loopcond}
	 * labeled alternative in {@link LabeledExprParser#looping}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopcond(@NotNull LabeledExprParser.LoopcondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link LabeledExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(@NotNull LabeledExprParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equality}
	 * labeled alternative in {@link LabeledExprParser#conditionalexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(@NotNull LabeledExprParser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link LabeledExprParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(@NotNull LabeledExprParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link LabeledExprParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintExpr(@NotNull LabeledExprParser.PrintExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link LabeledExprParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(@NotNull LabeledExprParser.AssignContext ctx);
}