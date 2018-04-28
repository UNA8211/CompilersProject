// Generated from Little.g4 by ANTLR 4.7

import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * This class provides an empty implementation of {@link LittleListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class LittleBaseListener implements LittleListener {
	private LinkedHashMap<String, LinkedHashMap<String, Pair<String, String>>> scope = new LinkedHashMap<String, LinkedHashMap<String, Pair<String, String>>>();
	private LinkedList<String> scopeStack = new LinkedList<String>();
	private int blockNum = 1;
	private ArrayList<String> scopeErrors = new ArrayList<String>();

	public LinkedHashMap<String, LinkedHashMap<String, Pair<String, String>>> getScope() {
		return scope;
	}
	public ArrayList<String> getScopeErrors() {
		return scopeErrors;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterProgram(LittleParser.ProgramContext ctx) {
		scopeStack.add("GLOBAL");
		scope.put(scopeStack.getFirst(), new LinkedHashMap<String, Pair<String, String>>());
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitProgram(LittleParser.ProgramContext ctx) {
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterId(LittleParser.IdContext ctx) {
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitId(LittleParser.IdContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterPgm_body(LittleParser.Pgm_bodyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitPgm_body(LittleParser.Pgm_bodyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterDecl(LittleParser.DeclContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitDecl(LittleParser.DeclContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterString_decl(LittleParser.String_declContext ctx) {
		 scope.get(scopeStack.getFirst()).put(ctx.id().IDENTIFIER().getSymbol().getText(), new Pair<String, String>(ctx.STRING().toString(), ctx.str().STRINGLITERAL().toString()));
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitString_decl(LittleParser.String_declContext ctx) {

	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterStr(LittleParser.StrContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitStr(LittleParser.StrContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	public void enterVar_decl(LittleParser.Var_declContext ctx) {
		String firstIdent = ctx.id_list().id().IDENTIFIER().getText();
		if (checkError(firstIdent)) {
			scopeErrors.add(firstIdent);
		}
		String varType = ctx.var_type().FLOAT() == null ? ctx.var_type().INT().toString() : ctx.var_type().FLOAT().toString();
		scope.get(scopeStack.getFirst()).put(ctx.id_list().id().IDENTIFIER().getText(), new Pair<String, String>(varType, null));
		LittleParser.Id_tailContext currId = ctx.id_list().id_tail();
		while (currId.COMMA() != null) {
			String currValue = currId.id().IDENTIFIER().getText();
			if (checkError(currValue)) {
				scopeErrors.add(currValue);
				return;
			}
			scope.get(scopeStack.getFirst()).put(currValue, new Pair<String, String>(varType, null));
			currId = currId.id_tail();
		}
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitVar_decl(LittleParser.Var_declContext ctx) {

	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterVar_type(LittleParser.Var_typeContext ctx) {

	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitVar_type(LittleParser.Var_typeContext ctx) {

	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterAny_type(LittleParser.Any_typeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitAny_type(LittleParser.Any_typeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterId_list(LittleParser.Id_listContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitId_list(LittleParser.Id_listContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterId_tail(LittleParser.Id_tailContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitId_tail(LittleParser.Id_tailContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterParam_decl_list(LittleParser.Param_decl_listContext ctx) {

	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitParam_decl_list(LittleParser.Param_decl_listContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterParam_decl(LittleParser.Param_declContext ctx) {
		 String id = ctx.id().IDENTIFIER().getText();
		 if (checkError(id)) {
			 scopeErrors.add(id);
			 return;
		 }
		 String varType = ctx.var_type().FLOAT() == null ? ctx.var_type().INT().toString() : ctx.var_type().FLOAT().toString();
		 scope.get(scopeStack.getFirst()).put(id, new Pair<String, String>(varType, null));
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitParam_decl(LittleParser.Param_declContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterParam_decl_tail(LittleParser.Param_decl_tailContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitParam_decl_tail(LittleParser.Param_decl_tailContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterFunc_declarations(LittleParser.Func_declarationsContext ctx) {

	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitFunc_declarations(LittleParser.Func_declarationsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterFunc_decl(LittleParser.Func_declContext ctx) {
		 scopeStack.addFirst(ctx.id().IDENTIFIER().toString());
		 scope.put(scopeStack.getFirst(), new LinkedHashMap<String, Pair<String, String>>());
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitFunc_decl(LittleParser.Func_declContext ctx) {
		scopeStack.removeFirst();
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterFunc_body(LittleParser.Func_bodyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitFunc_body(LittleParser.Func_bodyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterStmt_list(LittleParser.Stmt_listContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitStmt_list(LittleParser.Stmt_listContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterStmt(LittleParser.StmtContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitStmt(LittleParser.StmtContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterBase_stmt(LittleParser.Base_stmtContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitBase_stmt(LittleParser.Base_stmtContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterAssign_stmt(LittleParser.Assign_stmtContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitAssign_stmt(LittleParser.Assign_stmtContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterAssign_expr(LittleParser.Assign_exprContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitAssign_expr(LittleParser.Assign_exprContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterRead_stmt(LittleParser.Read_stmtContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitRead_stmt(LittleParser.Read_stmtContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterWrite_stmt(LittleParser.Write_stmtContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitWrite_stmt(LittleParser.Write_stmtContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterReturn_stmt(LittleParser.Return_stmtContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitReturn_stmt(LittleParser.Return_stmtContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterExpr(LittleParser.ExprContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitExpr(LittleParser.ExprContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterExpr_prefix(LittleParser.Expr_prefixContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitExpr_prefix(LittleParser.Expr_prefixContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterFactor(LittleParser.FactorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitFactor(LittleParser.FactorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterFactor_prefix(LittleParser.Factor_prefixContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitFactor_prefix(LittleParser.Factor_prefixContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterPostfix_expr(LittleParser.Postfix_exprContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitPostfix_expr(LittleParser.Postfix_exprContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterCall_expr(LittleParser.Call_exprContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitCall_expr(LittleParser.Call_exprContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterExpr_list(LittleParser.Expr_listContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitExpr_list(LittleParser.Expr_listContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterExpr_list_tail(LittleParser.Expr_list_tailContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitExpr_list_tail(LittleParser.Expr_list_tailContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterPrimary(LittleParser.PrimaryContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitPrimary(LittleParser.PrimaryContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterAddop(LittleParser.AddopContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitAddop(LittleParser.AddopContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterMulop(LittleParser.MulopContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitMulop(LittleParser.MulopContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterIf_stmt(LittleParser.If_stmtContext ctx) {
		scopeStack.addFirst("BLOCK " + (blockNum++));
		scope.put(scopeStack.getFirst(), new LinkedHashMap<String, Pair<String, String>>());
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitIf_stmt(LittleParser.If_stmtContext ctx) {
	 	scopeStack.removeFirst();
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterElse_part(LittleParser.Else_partContext ctx) {
	 	 if (ctx.ELSE() != null) {
			 scopeStack.addFirst("BLOCK " + (blockNum++));
			 scope.put(scopeStack.getFirst(), new LinkedHashMap<String, Pair<String, String>>());
		 }
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitElse_part(LittleParser.Else_partContext ctx) {
	 	if (ctx.ELSE() != null) {
			scopeStack.removeFirst();
		}
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterCond(LittleParser.CondContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitCond(LittleParser.CondContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterCompop(LittleParser.CompopContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitCompop(LittleParser.CompopContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterWhile_stmt(LittleParser.While_stmtContext ctx) {
	 	scopeStack.addFirst("BLOCK " + (blockNum++));
	 	scope.put(scopeStack.getFirst(), new LinkedHashMap<String, Pair<String, String>>());
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitWhile_stmt(LittleParser.While_stmtContext ctx) {
	 	scopeStack.removeFirst();
	 }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void enterEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void exitEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void visitTerminal(TerminalNode node) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	 public void visitErrorNode(ErrorNode node) { }

	 private boolean checkError(String id) {
		return scope.get(scopeStack.getFirst()).get(id) != null;
	 }
}