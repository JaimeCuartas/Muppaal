// Generated from C:/Users/Jaime/OneDrive - correounivalle.edu.co/Documentos/Github/mutantes/UppaalMutants/src/Parser/Antlr\UppaalParser.g4 by ANTLR 4.9.1
package Parser.Antlr;

    import java.util.HashMap;
    import java.util.HashSet;
    import Parser.Mutation.*;
    import Parser.Graph.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link UppaalParser}.
 */
public interface UppaalParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link UppaalParser#model}.
	 * @param ctx the parse tree
	 */
	void enterModel(UppaalParser.ModelContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#model}.
	 * @param ctx the parse tree
	 */
	void exitModel(UppaalParser.ModelContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#prolog}.
	 * @param ctx the parse tree
	 */
	void enterProlog(UppaalParser.PrologContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#prolog}.
	 * @param ctx the parse tree
	 */
	void exitProlog(UppaalParser.PrologContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(UppaalParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(UppaalParser.ContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(UppaalParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(UppaalParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(UppaalParser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(UppaalParser.ReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(UppaalParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(UppaalParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#chardata}.
	 * @param ctx the parse tree
	 */
	void enterChardata(UppaalParser.ChardataContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#chardata}.
	 * @param ctx the parse tree
	 */
	void exitChardata(UppaalParser.ChardataContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#misc}.
	 * @param ctx the parse tree
	 */
	void enterMisc(UppaalParser.MiscContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#misc}.
	 * @param ctx the parse tree
	 */
	void exitMisc(UppaalParser.MiscContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#nta}.
	 * @param ctx the parse tree
	 */
	void enterNta(UppaalParser.NtaContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#nta}.
	 * @param ctx the parse tree
	 */
	void exitNta(UppaalParser.NtaContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(UppaalParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(UppaalParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#declContent}.
	 * @param ctx the parse tree
	 */
	void enterDeclContent(UppaalParser.DeclContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#declContent}.
	 * @param ctx the parse tree
	 */
	void exitDeclContent(UppaalParser.DeclContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableDeclaration}
	 * labeled alternative in {@link UppaalParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(UppaalParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableDeclaration}
	 * labeled alternative in {@link UppaalParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(UppaalParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeDeclaration}
	 * labeled alternative in {@link UppaalParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(UppaalParser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeDeclaration}
	 * labeled alternative in {@link UppaalParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(UppaalParser.TypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionDeclaration}
	 * labeled alternative in {@link UppaalParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(UppaalParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionDeclaration}
	 * labeled alternative in {@link UppaalParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(UppaalParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChanDeclaration}
	 * labeled alternative in {@link UppaalParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterChanDeclaration(UppaalParser.ChanDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChanDeclaration}
	 * labeled alternative in {@link UppaalParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitChanDeclaration(UppaalParser.ChanDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IncrementExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIncrementExpr(UppaalParser.IncrementExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IncrementExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIncrementExpr(UppaalParser.IncrementExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIfExpr(UppaalParser.IfExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIfExpr(UppaalParser.IfExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesisExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisExpr(UppaalParser.ParenthesisExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesisExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisExpr(UppaalParser.ParenthesisExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TrueExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTrueExpr(UppaalParser.TrueExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrueExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTrueExpr(UppaalParser.TrueExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpr(UppaalParser.ComparisonExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpr(UppaalParser.ComparisonExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(UppaalParser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(UppaalParser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprIncrement}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprIncrement(UppaalParser.ExprIncrementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprIncrement}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprIncrement(UppaalParser.ExprIncrementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DotExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDotExpr(UppaalParser.DotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DotExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDotExpr(UppaalParser.DotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForallExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterForallExpr(UppaalParser.ForallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForallExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitForallExpr(UppaalParser.ForallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(UppaalParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(UppaalParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SumExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSumExpr(UppaalParser.SumExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SumExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSumExpr(UppaalParser.SumExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFuncExpr(UppaalParser.FuncExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFuncExpr(UppaalParser.FuncExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprDecrement}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprDecrement(UppaalParser.ExprDecrementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprDecrement}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprDecrement(UppaalParser.ExprDecrementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FalseExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFalseExpr(UppaalParser.FalseExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FalseExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFalseExpr(UppaalParser.FalseExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpr(UppaalParser.AssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpr(UppaalParser.AssignExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDoubleExpr(UppaalParser.DoubleExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDoubleExpr(UppaalParser.DoubleExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpr(UppaalParser.ArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpr(UppaalParser.ArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StopWatchExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStopWatchExpr(UppaalParser.StopWatchExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StopWatchExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStopWatchExpr(UppaalParser.StopWatchExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentifierExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpr(UppaalParser.IdentifierExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentifierExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpr(UppaalParser.IdentifierExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NatExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNatExpr(UppaalParser.NatExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NatExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNatExpr(UppaalParser.NatExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExistsExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExistsExpr(UppaalParser.ExistsExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExistsExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExistsExpr(UppaalParser.ExistsExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DecrementExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDecrementExpr(UppaalParser.DecrementExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DecrementExpr}
	 * labeled alternative in {@link UppaalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDecrementExpr(UppaalParser.DecrementExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(UppaalParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(UppaalParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void enterVariableDecl(UppaalParser.VariableDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void exitVariableDecl(UppaalParser.VariableDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(UppaalParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(UppaalParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UrgentPrefix}
	 * labeled alternative in {@link UppaalParser#prefix}.
	 * @param ctx the parse tree
	 */
	void enterUrgentPrefix(UppaalParser.UrgentPrefixContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UrgentPrefix}
	 * labeled alternative in {@link UppaalParser#prefix}.
	 * @param ctx the parse tree
	 */
	void exitUrgentPrefix(UppaalParser.UrgentPrefixContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BroadcastPrefix}
	 * labeled alternative in {@link UppaalParser#prefix}.
	 * @param ctx the parse tree
	 */
	void enterBroadcastPrefix(UppaalParser.BroadcastPrefixContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BroadcastPrefix}
	 * labeled alternative in {@link UppaalParser#prefix}.
	 * @param ctx the parse tree
	 */
	void exitBroadcastPrefix(UppaalParser.BroadcastPrefixContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MetaPrefix}
	 * labeled alternative in {@link UppaalParser#prefix}.
	 * @param ctx the parse tree
	 */
	void enterMetaPrefix(UppaalParser.MetaPrefixContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MetaPrefix}
	 * labeled alternative in {@link UppaalParser#prefix}.
	 * @param ctx the parse tree
	 */
	void exitMetaPrefix(UppaalParser.MetaPrefixContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstPrefix}
	 * labeled alternative in {@link UppaalParser#prefix}.
	 * @param ctx the parse tree
	 */
	void enterConstPrefix(UppaalParser.ConstPrefixContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstPrefix}
	 * labeled alternative in {@link UppaalParser#prefix}.
	 * @param ctx the parse tree
	 */
	void exitConstPrefix(UppaalParser.ConstPrefixContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentifierType}
	 * labeled alternative in {@link UppaalParser#typeId}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierType(UppaalParser.IdentifierTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentifierType}
	 * labeled alternative in {@link UppaalParser#typeId}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierType(UppaalParser.IdentifierTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link UppaalParser#typeId}.
	 * @param ctx the parse tree
	 */
	void enterIntType(UppaalParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link UppaalParser#typeId}.
	 * @param ctx the parse tree
	 */
	void exitIntType(UppaalParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleType}
	 * labeled alternative in {@link UppaalParser#typeId}.
	 * @param ctx the parse tree
	 */
	void enterDoubleType(UppaalParser.DoubleTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleType}
	 * labeled alternative in {@link UppaalParser#typeId}.
	 * @param ctx the parse tree
	 */
	void exitDoubleType(UppaalParser.DoubleTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClockType}
	 * labeled alternative in {@link UppaalParser#typeId}.
	 * @param ctx the parse tree
	 */
	void enterClockType(UppaalParser.ClockTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClockType}
	 * labeled alternative in {@link UppaalParser#typeId}.
	 * @param ctx the parse tree
	 */
	void exitClockType(UppaalParser.ClockTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChanType}
	 * labeled alternative in {@link UppaalParser#typeId}.
	 * @param ctx the parse tree
	 */
	void enterChanType(UppaalParser.ChanTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChanType}
	 * labeled alternative in {@link UppaalParser#typeId}.
	 * @param ctx the parse tree
	 */
	void exitChanType(UppaalParser.ChanTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link UppaalParser#typeId}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(UppaalParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link UppaalParser#typeId}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(UppaalParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntDomainType}
	 * labeled alternative in {@link UppaalParser#typeId}.
	 * @param ctx the parse tree
	 */
	void enterIntDomainType(UppaalParser.IntDomainTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntDomainType}
	 * labeled alternative in {@link UppaalParser#typeId}.
	 * @param ctx the parse tree
	 */
	void exitIntDomainType(UppaalParser.IntDomainTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ScalarType}
	 * labeled alternative in {@link UppaalParser#typeId}.
	 * @param ctx the parse tree
	 */
	void enterScalarType(UppaalParser.ScalarTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ScalarType}
	 * labeled alternative in {@link UppaalParser#typeId}.
	 * @param ctx the parse tree
	 */
	void exitScalarType(UppaalParser.ScalarTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructType}
	 * labeled alternative in {@link UppaalParser#typeId}.
	 * @param ctx the parse tree
	 */
	void enterStructType(UppaalParser.StructTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructType}
	 * labeled alternative in {@link UppaalParser#typeId}.
	 * @param ctx the parse tree
	 */
	void exitStructType(UppaalParser.StructTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void enterFieldDecl(UppaalParser.FieldDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void exitFieldDecl(UppaalParser.FieldDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#varFieldDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarFieldDecl(UppaalParser.VarFieldDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#varFieldDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarFieldDecl(UppaalParser.VarFieldDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayDeclExpr}
	 * labeled alternative in {@link UppaalParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void enterArrayDeclExpr(UppaalParser.ArrayDeclExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayDeclExpr}
	 * labeled alternative in {@link UppaalParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void exitArrayDeclExpr(UppaalParser.ArrayDeclExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayDeclType}
	 * labeled alternative in {@link UppaalParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void enterArrayDeclType(UppaalParser.ArrayDeclTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayDeclType}
	 * labeled alternative in {@link UppaalParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void exitArrayDeclType(UppaalParser.ArrayDeclTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#variableID}.
	 * @param ctx the parse tree
	 */
	void enterVariableID(UppaalParser.VariableIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#variableID}.
	 * @param ctx the parse tree
	 */
	void exitVariableID(UppaalParser.VariableIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InitialiserExpr}
	 * labeled alternative in {@link UppaalParser#initialiser}.
	 * @param ctx the parse tree
	 */
	void enterInitialiserExpr(UppaalParser.InitialiserExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InitialiserExpr}
	 * labeled alternative in {@link UppaalParser#initialiser}.
	 * @param ctx the parse tree
	 */
	void exitInitialiserExpr(UppaalParser.InitialiserExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InitialiserArray}
	 * labeled alternative in {@link UppaalParser#initialiser}.
	 * @param ctx the parse tree
	 */
	void enterInitialiserArray(UppaalParser.InitialiserArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InitialiserArray}
	 * labeled alternative in {@link UppaalParser#initialiser}.
	 * @param ctx the parse tree
	 */
	void exitInitialiserArray(UppaalParser.InitialiserArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#typeDecl}.
	 * @param ctx the parse tree
	 */
	void enterTypeDecl(UppaalParser.TypeDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#typeDecl}.
	 * @param ctx the parse tree
	 */
	void exitTypeDecl(UppaalParser.TypeDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(UppaalParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(UppaalParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#funcParameters}.
	 * @param ctx the parse tree
	 */
	void enterFuncParameters(UppaalParser.FuncParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#funcParameters}.
	 * @param ctx the parse tree
	 */
	void exitFuncParameters(UppaalParser.FuncParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#funcParameter}.
	 * @param ctx the parse tree
	 */
	void enterFuncParameter(UppaalParser.FuncParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#funcParameter}.
	 * @param ctx the parse tree
	 */
	void exitFuncParameter(UppaalParser.FuncParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(UppaalParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(UppaalParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementBlock}
	 * labeled alternative in {@link UppaalParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementBlock(UppaalParser.StatementBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementBlock}
	 * labeled alternative in {@link UppaalParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementBlock(UppaalParser.StatementBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementSemicolon}
	 * labeled alternative in {@link UppaalParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementSemicolon(UppaalParser.StatementSemicolonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementSemicolon}
	 * labeled alternative in {@link UppaalParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementSemicolon(UppaalParser.StatementSemicolonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementExpr}
	 * labeled alternative in {@link UppaalParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpr(UppaalParser.StatementExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementExpr}
	 * labeled alternative in {@link UppaalParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpr(UppaalParser.StatementExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementFor}
	 * labeled alternative in {@link UppaalParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementFor(UppaalParser.StatementForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementFor}
	 * labeled alternative in {@link UppaalParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementFor(UppaalParser.StatementForContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementIteration}
	 * labeled alternative in {@link UppaalParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementIteration(UppaalParser.StatementIterationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementIteration}
	 * labeled alternative in {@link UppaalParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementIteration(UppaalParser.StatementIterationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementWhile}
	 * labeled alternative in {@link UppaalParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementWhile(UppaalParser.StatementWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementWhile}
	 * labeled alternative in {@link UppaalParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementWhile(UppaalParser.StatementWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementDoWhile}
	 * labeled alternative in {@link UppaalParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementDoWhile(UppaalParser.StatementDoWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementDoWhile}
	 * labeled alternative in {@link UppaalParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementDoWhile(UppaalParser.StatementDoWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementIf}
	 * labeled alternative in {@link UppaalParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementIf(UppaalParser.StatementIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementIf}
	 * labeled alternative in {@link UppaalParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementIf(UppaalParser.StatementIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementReturn}
	 * labeled alternative in {@link UppaalParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementReturn(UppaalParser.StatementReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementReturn}
	 * labeled alternative in {@link UppaalParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementReturn(UppaalParser.StatementReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(UppaalParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(UppaalParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#iteration}.
	 * @param ctx the parse tree
	 */
	void enterIteration(UppaalParser.IterationContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#iteration}.
	 * @param ctx the parse tree
	 */
	void exitIteration(UppaalParser.IterationContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(UppaalParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(UppaalParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#doWhile}.
	 * @param ctx the parse tree
	 */
	void enterDoWhile(UppaalParser.DoWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#doWhile}.
	 * @param ctx the parse tree
	 */
	void exitDoWhile(UppaalParser.DoWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(UppaalParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(UppaalParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(UppaalParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(UppaalParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#chanPriority}.
	 * @param ctx the parse tree
	 */
	void enterChanPriority(UppaalParser.ChanPriorityContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#chanPriority}.
	 * @param ctx the parse tree
	 */
	void exitChanPriority(UppaalParser.ChanPriorityContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#chanOrDef}.
	 * @param ctx the parse tree
	 */
	void enterChanOrDef(UppaalParser.ChanOrDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#chanOrDef}.
	 * @param ctx the parse tree
	 */
	void exitChanOrDef(UppaalParser.ChanOrDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#chanSeparator}.
	 * @param ctx the parse tree
	 */
	void enterChanSeparator(UppaalParser.ChanSeparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#chanSeparator}.
	 * @param ctx the parse tree
	 */
	void exitChanSeparator(UppaalParser.ChanSeparatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChanArray}
	 * labeled alternative in {@link UppaalParser#chanExpr}.
	 * @param ctx the parse tree
	 */
	void enterChanArray(UppaalParser.ChanArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChanArray}
	 * labeled alternative in {@link UppaalParser#chanExpr}.
	 * @param ctx the parse tree
	 */
	void exitChanArray(UppaalParser.ChanArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChanIdentifier}
	 * labeled alternative in {@link UppaalParser#chanExpr}.
	 * @param ctx the parse tree
	 */
	void enterChanIdentifier(UppaalParser.ChanIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChanIdentifier}
	 * labeled alternative in {@link UppaalParser#chanExpr}.
	 * @param ctx the parse tree
	 */
	void exitChanIdentifier(UppaalParser.ChanIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#anything}.
	 * @param ctx the parse tree
	 */
	void enterAnything(UppaalParser.AnythingContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#anything}.
	 * @param ctx the parse tree
	 */
	void exitAnything(UppaalParser.AnythingContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#template}.
	 * @param ctx the parse tree
	 */
	void enterTemplate(UppaalParser.TemplateContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#template}.
	 * @param ctx the parse tree
	 */
	void exitTemplate(UppaalParser.TemplateContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#tempContent}.
	 * @param ctx the parse tree
	 */
	void enterTempContent(UppaalParser.TempContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#tempContent}.
	 * @param ctx the parse tree
	 */
	void exitTempContent(UppaalParser.TempContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(UppaalParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(UppaalParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#coordinate}.
	 * @param ctx the parse tree
	 */
	void enterCoordinate(UppaalParser.CoordinateContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#coordinate}.
	 * @param ctx the parse tree
	 */
	void exitCoordinate(UppaalParser.CoordinateContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#initLoc}.
	 * @param ctx the parse tree
	 */
	void enterInitLoc(UppaalParser.InitLocContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#initLoc}.
	 * @param ctx the parse tree
	 */
	void exitInitLoc(UppaalParser.InitLocContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#branchpoint}.
	 * @param ctx the parse tree
	 */
	void enterBranchpoint(UppaalParser.BranchpointContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#branchpoint}.
	 * @param ctx the parse tree
	 */
	void exitBranchpoint(UppaalParser.BranchpointContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#location}.
	 * @param ctx the parse tree
	 */
	void enterLocation(UppaalParser.LocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#location}.
	 * @param ctx the parse tree
	 */
	void exitLocation(UppaalParser.LocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#labelLoc}.
	 * @param ctx the parse tree
	 */
	void enterLabelLoc(UppaalParser.LabelLocContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#labelLoc}.
	 * @param ctx the parse tree
	 */
	void exitLabelLoc(UppaalParser.LabelLocContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(UppaalParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(UppaalParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#color}.
	 * @param ctx the parse tree
	 */
	void enterColor(UppaalParser.ColorContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#color}.
	 * @param ctx the parse tree
	 */
	void exitColor(UppaalParser.ColorContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#transition}.
	 * @param ctx the parse tree
	 */
	void enterTransition(UppaalParser.TransitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#transition}.
	 * @param ctx the parse tree
	 */
	void exitTransition(UppaalParser.TransitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#labelTransGuard}.
	 * @param ctx the parse tree
	 */
	void enterLabelTransGuard(UppaalParser.LabelTransGuardContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#labelTransGuard}.
	 * @param ctx the parse tree
	 */
	void exitLabelTransGuard(UppaalParser.LabelTransGuardContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#labelTransSyncInput}.
	 * @param ctx the parse tree
	 */
	void enterLabelTransSyncInput(UppaalParser.LabelTransSyncInputContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#labelTransSyncInput}.
	 * @param ctx the parse tree
	 */
	void exitLabelTransSyncInput(UppaalParser.LabelTransSyncInputContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#labelTransSyncOutput}.
	 * @param ctx the parse tree
	 */
	void enterLabelTransSyncOutput(UppaalParser.LabelTransSyncOutputContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#labelTransSyncOutput}.
	 * @param ctx the parse tree
	 */
	void exitLabelTransSyncOutput(UppaalParser.LabelTransSyncOutputContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#labelTrans}.
	 * @param ctx the parse tree
	 */
	void enterLabelTrans(UppaalParser.LabelTransContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#labelTrans}.
	 * @param ctx the parse tree
	 */
	void exitLabelTrans(UppaalParser.LabelTransContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SumGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void enterSumGuard(UppaalParser.SumGuardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SumGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void exitSumGuard(UppaalParser.SumGuardContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesisGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisGuard(UppaalParser.ParenthesisGuardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesisGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisGuard(UppaalParser.ParenthesisGuardContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FalseGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void enterFalseGuard(UppaalParser.FalseGuardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FalseGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void exitFalseGuard(UppaalParser.FalseGuardContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void enterAssignGuard(UppaalParser.AssignGuardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void exitAssignGuard(UppaalParser.AssignGuardContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DotGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void enterDotGuard(UppaalParser.DotGuardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DotGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void exitDotGuard(UppaalParser.DotGuardContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DecrementGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void enterDecrementGuard(UppaalParser.DecrementGuardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DecrementGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void exitDecrementGuard(UppaalParser.DecrementGuardContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryGuard(UppaalParser.UnaryGuardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryGuard(UppaalParser.UnaryGuardContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void enterComparisonGuard(UppaalParser.ComparisonGuardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void exitComparisonGuard(UppaalParser.ComparisonGuardContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentifierGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierGuard(UppaalParser.IdentifierGuardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentifierGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierGuard(UppaalParser.IdentifierGuardContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryGuard(UppaalParser.BinaryGuardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryGuard(UppaalParser.BinaryGuardContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NatGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void enterNatGuard(UppaalParser.NatGuardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NatGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void exitNatGuard(UppaalParser.NatGuardContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExistsGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void enterExistsGuard(UppaalParser.ExistsGuardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExistsGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void exitExistsGuard(UppaalParser.ExistsGuardContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StopWatchGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void enterStopWatchGuard(UppaalParser.StopWatchGuardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StopWatchGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void exitStopWatchGuard(UppaalParser.StopWatchGuardContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void enterArrayGuard(UppaalParser.ArrayGuardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void exitArrayGuard(UppaalParser.ArrayGuardContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForallGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void enterForallGuard(UppaalParser.ForallGuardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForallGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void exitForallGuard(UppaalParser.ForallGuardContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GuardDecrement}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void enterGuardDecrement(UppaalParser.GuardDecrementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GuardDecrement}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void exitGuardDecrement(UppaalParser.GuardDecrementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TrueGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void enterTrueGuard(UppaalParser.TrueGuardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrueGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void exitTrueGuard(UppaalParser.TrueGuardContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void enterIfGuard(UppaalParser.IfGuardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void exitIfGuard(UppaalParser.IfGuardContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void enterFuncGuard(UppaalParser.FuncGuardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void exitFuncGuard(UppaalParser.FuncGuardContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IncrementGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void enterIncrementGuard(UppaalParser.IncrementGuardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IncrementGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void exitIncrementGuard(UppaalParser.IncrementGuardContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void enterDoubleGuard(UppaalParser.DoubleGuardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleGuard}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void exitDoubleGuard(UppaalParser.DoubleGuardContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GuardIncrement}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void enterGuardIncrement(UppaalParser.GuardIncrementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GuardIncrement}
	 * labeled alternative in {@link UppaalParser#guardExpr}.
	 * @param ctx the parse tree
	 */
	void exitGuardIncrement(UppaalParser.GuardIncrementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#guardArguments}.
	 * @param ctx the parse tree
	 */
	void enterGuardArguments(UppaalParser.GuardArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#guardArguments}.
	 * @param ctx the parse tree
	 */
	void exitGuardArguments(UppaalParser.GuardArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#guardType}.
	 * @param ctx the parse tree
	 */
	void enterGuardType(UppaalParser.GuardTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#guardType}.
	 * @param ctx the parse tree
	 */
	void exitGuardType(UppaalParser.GuardTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GuardTypeInt}
	 * labeled alternative in {@link UppaalParser#guardTypeId}.
	 * @param ctx the parse tree
	 */
	void enterGuardTypeInt(UppaalParser.GuardTypeIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GuardTypeInt}
	 * labeled alternative in {@link UppaalParser#guardTypeId}.
	 * @param ctx the parse tree
	 */
	void exitGuardTypeInt(UppaalParser.GuardTypeIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GuardTypeIntDomain}
	 * labeled alternative in {@link UppaalParser#guardTypeId}.
	 * @param ctx the parse tree
	 */
	void enterGuardTypeIntDomain(UppaalParser.GuardTypeIntDomainContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GuardTypeIntDomain}
	 * labeled alternative in {@link UppaalParser#guardTypeId}.
	 * @param ctx the parse tree
	 */
	void exitGuardTypeIntDomain(UppaalParser.GuardTypeIntDomainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GuardTypeScalar}
	 * labeled alternative in {@link UppaalParser#guardTypeId}.
	 * @param ctx the parse tree
	 */
	void enterGuardTypeScalar(UppaalParser.GuardTypeScalarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GuardTypeScalar}
	 * labeled alternative in {@link UppaalParser#guardTypeId}.
	 * @param ctx the parse tree
	 */
	void exitGuardTypeScalar(UppaalParser.GuardTypeScalarContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#source}.
	 * @param ctx the parse tree
	 */
	void enterSource(UppaalParser.SourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#source}.
	 * @param ctx the parse tree
	 */
	void exitSource(UppaalParser.SourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#target}.
	 * @param ctx the parse tree
	 */
	void enterTarget(UppaalParser.TargetContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#target}.
	 * @param ctx the parse tree
	 */
	void exitTarget(UppaalParser.TargetContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#nail}.
	 * @param ctx the parse tree
	 */
	void enterNail(UppaalParser.NailContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#nail}.
	 * @param ctx the parse tree
	 */
	void exitNail(UppaalParser.NailContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#system}.
	 * @param ctx the parse tree
	 */
	void enterSystem(UppaalParser.SystemContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#system}.
	 * @param ctx the parse tree
	 */
	void exitSystem(UppaalParser.SystemContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#queries}.
	 * @param ctx the parse tree
	 */
	void enterQueries(UppaalParser.QueriesContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#queries}.
	 * @param ctx the parse tree
	 */
	void exitQueries(UppaalParser.QueriesContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(UppaalParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(UppaalParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterFormula(UppaalParser.FormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitFormula(UppaalParser.FormulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link UppaalParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(UppaalParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link UppaalParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(UppaalParser.CommentContext ctx);
}