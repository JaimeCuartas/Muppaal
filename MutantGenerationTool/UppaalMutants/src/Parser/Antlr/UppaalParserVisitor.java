// Generated from C:/Users/Jaime/OneDrive - correounivalle.edu.co/Documentos/Github/mutantes/UppaalMutants/src/Parser/Antlr\UppaalParser.g4 by ANTLR 4.9.1
package Parser.Antlr;

    import java.util.HashMap;
    import java.util.HashSet;
    import Parser.Mutation.*;
    import Parser.Graph.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link UppaalParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface UppaalParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link UppaalParser#model}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModel(UppaalParser.ModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#prolog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProlog(UppaalParser.PrologContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(UppaalParser.ContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(UppaalParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(UppaalParser.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(UppaalParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#chardata}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChardata(UppaalParser.ChardataContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#misc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMisc(UppaalParser.MiscContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#nta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNta(UppaalParser.NtaContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(UppaalParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#declContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclContent(UppaalParser.DeclContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableDeclaration}
	 * labeled alternative in {@link UppaalParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(UppaalParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeDeclaration}
	 * labeled alternative in {@link UppaalParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDeclaration(UppaalParser.TypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionDeclaration}
	 * labeled alternative in {@link UppaalParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(UppaalParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ChanDeclaration}
	 * labeled alternative in {@link UppaalParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChanDeclaration(UppaalParser.ChanDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IncrementExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncrementExpr(UppaalParser.IncrementExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExpr(UppaalParser.IfExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesisExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisExpr(UppaalParser.ParenthesisExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TrueExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueExpr(UppaalParser.TrueExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpr(UppaalParser.ComparisonExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpr(UppaalParser.BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprIncrement}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIncrement(UppaalParser.ExprIncrementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DotExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotExpr(UppaalParser.DotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForallExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForallExpr(UppaalParser.ForallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(UppaalParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SumExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSumExpr(UppaalParser.SumExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FuncExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncExpr(UppaalParser.FuncExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprDecrement}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDecrement(UppaalParser.ExprDecrementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FalseExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseExpr(UppaalParser.FalseExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpr(UppaalParser.AssignExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoubleExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleExpr(UppaalParser.DoubleExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(UppaalParser.ArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StopWatchExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStopWatchExpr(UppaalParser.StopWatchExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentifierExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpr(UppaalParser.IdentifierExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NatExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNatExpr(UppaalParser.NatExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExistsExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistsExpr(UppaalParser.ExistsExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DecrementExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecrementExpr(UppaalParser.DecrementExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(UppaalParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#variableDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDecl(UppaalParser.VariableDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(UppaalParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UrgentPrefix}
	 * labeled alternative in {@link UppaalParser#prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUrgentPrefix(UppaalParser.UrgentPrefixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BroadcastPrefix}
	 * labeled alternative in {@link UppaalParser#prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBroadcastPrefix(UppaalParser.BroadcastPrefixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MetaPrefix}
	 * labeled alternative in {@link UppaalParser#prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetaPrefix(UppaalParser.MetaPrefixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstPrefix}
	 * labeled alternative in {@link UppaalParser#prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstPrefix(UppaalParser.ConstPrefixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentifierType}
	 * labeled alternative in {@link UppaalParser#typeId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierType(UppaalParser.IdentifierTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link UppaalParser#typeId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(UppaalParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoubleType}
	 * labeled alternative in {@link UppaalParser#typeId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleType(UppaalParser.DoubleTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ClockType}
	 * labeled alternative in {@link UppaalParser#typeId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClockType(UppaalParser.ClockTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ChanType}
	 * labeled alternative in {@link UppaalParser#typeId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChanType(UppaalParser.ChanTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link UppaalParser#typeId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(UppaalParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntDomainType}
	 * labeled alternative in {@link UppaalParser#typeId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntDomainType(UppaalParser.IntDomainTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ScalarType}
	 * labeled alternative in {@link UppaalParser#typeId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScalarType(UppaalParser.ScalarTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructType}
	 * labeled alternative in {@link UppaalParser#typeId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructType(UppaalParser.StructTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#fieldDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDecl(UppaalParser.FieldDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#varFieldDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarFieldDecl(UppaalParser.VarFieldDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayDeclExpr}
	 * labeled alternative in {@link UppaalParser#arrayDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDeclExpr(UppaalParser.ArrayDeclExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayDeclType}
	 * labeled alternative in {@link UppaalParser#arrayDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDeclType(UppaalParser.ArrayDeclTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#variableID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableID(UppaalParser.VariableIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InitialiserExpr}
	 * labeled alternative in {@link UppaalParser#initialiser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitialiserExpr(UppaalParser.InitialiserExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InitialiserArray}
	 * labeled alternative in {@link UppaalParser#initialiser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitialiserArray(UppaalParser.InitialiserArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#typeDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDecl(UppaalParser.TypeDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(UppaalParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#funcParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncParameters(UppaalParser.FuncParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#funcParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncParameter(UppaalParser.FuncParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(UppaalParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementBlock}
	 * labeled alternative in {@link UppaalParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementBlock(UppaalParser.StatementBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementSemicolon}
	 * labeled alternative in {@link UppaalParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementSemicolon(UppaalParser.StatementSemicolonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementExpr}
	 * labeled alternative in {@link UppaalParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpr(UppaalParser.StatementExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementFor}
	 * labeled alternative in {@link UppaalParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementFor(UppaalParser.StatementForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementIteration}
	 * labeled alternative in {@link UppaalParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementIteration(UppaalParser.StatementIterationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementWhile}
	 * labeled alternative in {@link UppaalParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWhile(UppaalParser.StatementWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementDoWhile}
	 * labeled alternative in {@link UppaalParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementDoWhile(UppaalParser.StatementDoWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementIf}
	 * labeled alternative in {@link UppaalParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementIf(UppaalParser.StatementIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementReturn}
	 * labeled alternative in {@link UppaalParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementReturn(UppaalParser.StatementReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#forLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(UppaalParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#iteration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIteration(UppaalParser.IterationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#whileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(UppaalParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#doWhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhile(UppaalParser.DoWhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(UppaalParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(UppaalParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#chanPriority}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChanPriority(UppaalParser.ChanPriorityContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#chanOrDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChanOrDef(UppaalParser.ChanOrDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#chanSeparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChanSeparator(UppaalParser.ChanSeparatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ChanArray}
	 * labeled alternative in {@link UppaalParser#chanExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChanArray(UppaalParser.ChanArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ChanIdentifier}
	 * labeled alternative in {@link UppaalParser#chanExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChanIdentifier(UppaalParser.ChanIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#anything}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnything(UppaalParser.AnythingContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#template}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplate(UppaalParser.TemplateContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#tempContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTempContent(UppaalParser.TempContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(UppaalParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#coordinate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoordinate(UppaalParser.CoordinateContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#initLoc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitLoc(UppaalParser.InitLocContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#branchpoint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranchpoint(UppaalParser.BranchpointContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocation(UppaalParser.LocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#labelLoc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelLoc(UppaalParser.LabelLocContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(UppaalParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#color}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColor(UppaalParser.ColorContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#transition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransition(UppaalParser.TransitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#labelTransGuard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelTransGuard(UppaalParser.LabelTransGuardContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#labelTransSyncInput}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelTransSyncInput(UppaalParser.LabelTransSyncInputContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#labelTransSyncOutput}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelTransSyncOutput(UppaalParser.LabelTransSyncOutputContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#labelTrans}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelTrans(UppaalParser.LabelTransContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SumGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSumGuard(UppaalParser.SumGuardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesisGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisGuard(UppaalParser.ParenthesisGuardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FalseGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseGuard(UppaalParser.FalseGuardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignGuard(UppaalParser.AssignGuardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DotGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotGuard(UppaalParser.DotGuardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DecrementGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecrementGuard(UppaalParser.DecrementGuardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryGuard(UppaalParser.UnaryGuardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonGuard(UppaalParser.ComparisonGuardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentifierGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierGuard(UppaalParser.IdentifierGuardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryGuard(UppaalParser.BinaryGuardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NatGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNatGuard(UppaalParser.NatGuardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExistsGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistsGuard(UppaalParser.ExistsGuardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StopWatchGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStopWatchGuard(UppaalParser.StopWatchGuardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayGuard(UppaalParser.ArrayGuardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForallGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForallGuard(UppaalParser.ForallGuardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GuardDecrement}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardDecrement(UppaalParser.GuardDecrementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TrueGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueGuard(UppaalParser.TrueGuardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfGuard(UppaalParser.IfGuardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FuncGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncGuard(UppaalParser.FuncGuardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IncrementGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncrementGuard(UppaalParser.IncrementGuardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoubleGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleGuard(UppaalParser.DoubleGuardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GuardIncrement}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardIncrement(UppaalParser.GuardIncrementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#guardArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardArguments(UppaalParser.GuardArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#guardType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardType(UppaalParser.GuardTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GuardTypeInt}
	 * labeled alternative in {@link UppaalParser#guardTypeId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardTypeInt(UppaalParser.GuardTypeIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GuardTypeIntDomain}
	 * labeled alternative in {@link UppaalParser#guardTypeId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardTypeIntDomain(UppaalParser.GuardTypeIntDomainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GuardTypeScalar}
	 * labeled alternative in {@link UppaalParser#guardTypeId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardTypeScalar(UppaalParser.GuardTypeScalarContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#source}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSource(UppaalParser.SourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTarget(UppaalParser.TargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#nail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNail(UppaalParser.NailContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#system}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystem(UppaalParser.SystemContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#queries}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueries(UppaalParser.QueriesContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(UppaalParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormula(UppaalParser.FormulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link UppaalParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(UppaalParser.CommentContext ctx);
}