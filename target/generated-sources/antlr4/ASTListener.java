import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Stack;

public class ASTListener implements LittleListener {

    ASTNode current;
    ASTNode prev;
    Stack<ASTNode> tree = new Stack<ASTNode>();

    public void enterProgram(LittleParser.ProgramContext ctx) {

    }

    public void exitProgram(LittleParser.ProgramContext ctx) {

    }

    public void enterId(LittleParser.IdContext ctx) {
    }

    public void exitId(LittleParser.IdContext ctx) {
        if (current instanceof ASTNode.IDListNode) {
            ((ASTNode.IDListNode) current).identifier = new ASTNode.IDNode(ctx.IDENTIFIER().getText());
        } else if (current instanceof ASTNode.IDTailNode) {
            ((ASTNode.IDTailNode) current).identifier = new ASTNode.IDNode(ctx.IDENTIFIER().getText());
        } else if (current instanceof ASTNode.FuncDeclNode) {
            ((ASTNode.FuncDeclNode) current).id = new ASTNode.IDNode(ctx.IDENTIFIER().getText());
        } else if (current instanceof ASTNode.PrimaryNode) {
            ((ASTNode.PrimaryNode) current).id = new ASTNode.IDNode(ctx.IDENTIFIER().getText());
        } else if (current instanceof ASTNode.AssignmentExprNode) {
            ((ASTNode.AssignmentExprNode) current).identifier = new ASTNode.IDNode(ctx.IDENTIFIER().getText());
        } else if (current instanceof ASTNode.StringDeclNode) {
            ((ASTNode.StringDeclNode) current).identifier = new ASTNode.IDNode(ctx.IDENTIFIER().getText());
        }
    }

    public void enterPgm_body(LittleParser.Pgm_bodyContext ctx) {
        tree.push(new ASTNode.ProgramBodyNode());
        current = tree.peek();
    }

    public void exitPgm_body(LittleParser.Pgm_bodyContext ctx) {
        prev = tree.pop();
    }

    public void enterDecl(LittleParser.DeclContext ctx) {
        tree.push(new ASTNode.DeclNode());
        current = tree.peek();
    }

    public void exitDecl(LittleParser.DeclContext ctx) {
        prev = tree.pop();
        if (!tree.empty()) {
            current = tree.peek();
        }
        if (((ASTNode.DeclNode) prev).isNull()) {
            return;
        }
        if (current instanceof ASTNode.ProgramBodyNode) {
            ((ASTNode.ProgramBodyNode) current).decl = (ASTNode.DeclNode) prev;
        } else if (current instanceof ASTNode.DeclNode) {
            ((ASTNode.DeclNode) current).decl = (ASTNode.DeclNode) prev;
        } else if (current instanceof ASTNode.FuncBodyNode) {
            ((ASTNode.FuncBodyNode) current).decl = (ASTNode.DeclNode) prev;
        }

    }

    public void enterString_decl(LittleParser.String_declContext ctx) {
        tree.push(new ASTNode.StringDeclNode());
        current = tree.peek();
    }

    public void exitString_decl(LittleParser.String_declContext ctx) {
        upOneLevel();
        if (((ASTNode.StringDeclNode) prev).isNull()) {
            return;
        }

        if (current instanceof ASTNode.DeclNode) {
            ((ASTNode.StringDeclNode) prev).value = ctx.str().STRINGLITERAL().getText();
            ((ASTNode.DeclNode) current).stringDecl = (ASTNode.StringDeclNode) prev;
        }
    }

    public void enterStr(LittleParser.StrContext ctx) {

    }

    public void exitStr(LittleParser.StrContext ctx) {

    }

    public void enterVar_decl(LittleParser.Var_declContext ctx) {
        tree.push(new ASTNode.VarDeclNode());
        current = tree.peek();
    }

    public void exitVar_decl(LittleParser.Var_declContext ctx) {
        upOneLevel();
        if (((ASTNode.VarDeclNode) prev).isNull()) {
            return;
        }
        if (current instanceof ASTNode.DeclNode) {
            ((ASTNode.DeclNode) current).varDecl = (ASTNode.VarDeclNode) prev;
        }
    }

    public void enterVar_type(LittleParser.Var_typeContext ctx) {
    }

    public void exitVar_type(LittleParser.Var_typeContext ctx) {
        if (current instanceof ASTNode.VarDeclNode) {
            ((ASTNode.VarDeclNode) current).type = new ASTNode.VarTypeNode(ctx.FLOAT() == null ? ctx.INT().getText() : ctx.FLOAT().getText());
        }
    }

    public void enterAny_type(LittleParser.Any_typeContext ctx) {

    }

    public void exitAny_type(LittleParser.Any_typeContext ctx) {

    }

    public void enterId_list(LittleParser.Id_listContext ctx) {
        tree.push(new ASTNode.IDListNode());
        current = tree.peek();
    }

    public void exitId_list(LittleParser.Id_listContext ctx) {
        upOneLevel();
        if (((ASTNode.IDListNode) prev).isNull()) {
            return;
        }
        if (current instanceof ASTNode.VarDeclNode) {
            ((ASTNode.VarDeclNode) current).idList = (ASTNode.IDListNode) prev;
        }

        if (current instanceof ASTNode.ReadNode) {
            ((ASTNode.ReadNode) current).idList = (ASTNode.IDListNode) prev;
        }

        if (current instanceof ASTNode.WriteNode) {
            ((ASTNode.WriteNode) current).idList = (ASTNode.IDListNode) prev;
        }
    }

    public void enterId_tail(LittleParser.Id_tailContext ctx) {
        tree.push(new ASTNode.IDTailNode());
        current = tree.peek();
    }

    public void exitId_tail(LittleParser.Id_tailContext ctx) {
        upOneLevel();
        if (((ASTNode.IDTailNode) prev).isNull()) {
            return;
        }
        if (current instanceof ASTNode.IDTailNode) {
            ((ASTNode.IDTailNode) current).tail = (ASTNode.IDTailNode) prev;
        } else if (current instanceof ASTNode.IDListNode) {
            ((ASTNode.IDListNode) current).tail = (ASTNode.IDTailNode) prev;
        }
    }

    public void enterParam_decl_list(LittleParser.Param_decl_listContext ctx) {
    }

    public void exitParam_decl_list(LittleParser.Param_decl_listContext ctx) {
    }

    public void enterParam_decl(LittleParser.Param_declContext ctx) {
    }

    public void exitParam_decl(LittleParser.Param_declContext ctx) {
    }

    public void enterParam_decl_tail(LittleParser.Param_decl_tailContext ctx) {
    }

    public void exitParam_decl_tail(LittleParser.Param_decl_tailContext ctx) {
    }

    public void enterFunc_declarations(LittleParser.Func_declarationsContext ctx) {
        tree.push(new ASTNode.FuncDecl());
        current= tree.peek();
    }

    public void exitFunc_declarations(LittleParser.Func_declarationsContext ctx) {
        upOneLevel();
        if (((ASTNode.FuncDecl) prev).isNull()) {
            return;
        }
        if (current instanceof ASTNode.FuncDecl) {
            ((ASTNode.FuncDecl) current).funcDeclaration = (ASTNode.FuncDecl) prev;
        } else if (current instanceof ASTNode.ProgramBodyNode) {
            ((ASTNode.ProgramBodyNode) current).funcDecl = (ASTNode.FuncDecl) prev;
        }
    }

    public void enterFunc_decl(LittleParser.Func_declContext ctx) {
        tree.push(new ASTNode.FuncDeclNode());
        current = tree.peek();
    }

    public void exitFunc_decl(LittleParser.Func_declContext ctx) {
        upOneLevel();
        if (((ASTNode.FuncDeclNode) prev).isNull()) {
            return;
        }
        ((ASTNode.FuncDecl) current).funcDecl = (ASTNode.FuncDeclNode) prev;
    }

    public void enterFunc_body(LittleParser.Func_bodyContext ctx) {
        tree.push(new ASTNode.FuncBodyNode());
        current = tree.peek();
    }

    public void exitFunc_body(LittleParser.Func_bodyContext ctx) {
        upOneLevel();
        if (((ASTNode.FuncBodyNode) prev).isNull()) {
            return;
        }
        ((ASTNode.FuncDeclNode) current).funcBody = (ASTNode.FuncBodyNode) prev;
    }

    public void enterStmt_list(LittleParser.Stmt_listContext ctx) {
        tree.push(new ASTNode.StatementListNode());
        current = tree.peek();
    }

    public void exitStmt_list(LittleParser.Stmt_listContext ctx) {
        upOneLevel();
        if (((ASTNode.StatementListNode) prev).isNull()) {
            return;
        }
        if (current instanceof ASTNode.FuncBodyNode) {
            ((ASTNode.FuncBodyNode) current).stmtList = (ASTNode.StatementListNode) prev;
        } else if (current instanceof ASTNode. StatementListNode) {
            ((ASTNode.StatementListNode) current).statementList = (ASTNode.StatementListNode) prev;
        }
    }

    public void enterStmt(LittleParser.StmtContext ctx) {
        tree.push(new ASTNode.StatementNode());
        current = tree.peek();
    }

    public void exitStmt(LittleParser.StmtContext ctx) {
        upOneLevel();
        if (((ASTNode.StatementNode) prev).isNull()) {
            return;
        }
        ((ASTNode.StatementListNode) current).stmt = (ASTNode.StatementNode) prev;

    }

    public void enterBase_stmt(LittleParser.Base_stmtContext ctx) {
        tree.push(new ASTNode.BaseStatements());
        current = tree.peek();
    }

    public void exitBase_stmt(LittleParser.Base_stmtContext ctx) {
        upOneLevel();
        if (((ASTNode.BaseStatements) prev).isNull()) {
            return;
        }

        ((ASTNode.StatementNode) current).baseStmt = (ASTNode.BaseStatements) prev;
    }

    public void enterAssign_stmt(LittleParser.Assign_stmtContext ctx) {
        tree.push(new ASTNode.AssignStatementNode());
        current = tree.peek();
    }

    public void exitAssign_stmt(LittleParser.Assign_stmtContext ctx) {
        upOneLevel();
        if (((ASTNode.AssignStatementNode) prev).isNull()) {
            return;
        }
        ((ASTNode.BaseStatements) current).assignment = (ASTNode.AssignStatementNode) prev;
    }

    public void enterAssign_expr(LittleParser.Assign_exprContext ctx) {
        tree.push(new ASTNode.AssignmentExprNode());
        current = tree.peek();
    }

    public void exitAssign_expr(LittleParser.Assign_exprContext ctx) {
        upOneLevel();
        if (((ASTNode.AssignmentExprNode) prev).isNull()) {
            return;
        }
        ((ASTNode.AssignStatementNode) current).assignmentExpr = (ASTNode.AssignmentExprNode) prev;
    }

    public void enterRead_stmt(LittleParser.Read_stmtContext ctx) {
        tree.push(new ASTNode.ReadNode());
        current = tree.peek();
    }

    public void exitRead_stmt(LittleParser.Read_stmtContext ctx) {
        upOneLevel();
        if (((ASTNode.ReadNode) prev).isNull()) {
            return;
        }
        ((ASTNode.BaseStatements) current).read = (ASTNode.ReadNode) prev;
    }

    public void enterWrite_stmt(LittleParser.Write_stmtContext ctx) {
        tree.push(new ASTNode.WriteNode());
        current = tree.peek();
    }

    public void exitWrite_stmt(LittleParser.Write_stmtContext ctx) {
        upOneLevel();
        if (((ASTNode.WriteNode) prev).isNull()) {
            return;
        }

        ((ASTNode.BaseStatements) current).write = (ASTNode.WriteNode) prev;

    }

    public void enterReturn_stmt(LittleParser.Return_stmtContext ctx) {

    }

    public void exitReturn_stmt(LittleParser.Return_stmtContext ctx) {

    }

    public void enterExpr(LittleParser.ExprContext ctx) {
        tree.push(new ASTNode.ExpressionNode());
        current = tree.peek();
    }

    public void exitExpr(LittleParser.ExprContext ctx) {
        upOneLevel();
        if (((ASTNode.ExpressionNode) prev).isNull()) {
            return;
        }
        if (current instanceof ASTNode.AssignmentExprNode) {
            ((ASTNode.AssignmentExprNode) current).expr = (ASTNode.ExpressionNode) prev;
        } else if (current instanceof ASTNode.ExpressionList) {
            ((ASTNode.ExpressionList) current).expr = (ASTNode.ExpressionNode) prev;
        } else if (current instanceof ASTNode.ExpressionListTail) {
            ((ASTNode.ExpressionListTail) current).expr = (ASTNode.ExpressionNode) prev;
        } else if (current instanceof ASTNode.PrimaryNode) {
            ((ASTNode.PrimaryNode) current).expressionNode = (ASTNode.ExpressionNode) prev;
        }
    }

    public void enterExpr_prefix(LittleParser.Expr_prefixContext ctx) {
        tree.push(new ASTNode.ExpressionPrefix());
        current = tree.peek();
    }

    public void exitExpr_prefix(LittleParser.Expr_prefixContext ctx) {
        upOneLevel();
        if (((ASTNode.ExpressionPrefix) prev).isNull()) {
            return;
        }
        if (current instanceof ASTNode.ExpressionNode) {
            ((ASTNode.ExpressionNode) current).prefix = (ASTNode.ExpressionPrefix) prev;
        } else if (current instanceof ASTNode.ExpressionPrefix) {
            ((ASTNode.ExpressionPrefix) current).prefix = (ASTNode.ExpressionPrefix) prev;
        }
    }

    public void enterFactor(LittleParser.FactorContext ctx) {
        tree.push(new ASTNode.FactorNode());
        current = tree.peek();
    }

    public void exitFactor(LittleParser.FactorContext ctx) {
        upOneLevel();
        if (((ASTNode.FactorNode) prev).isNull()) {
            return;
        }
        if (current instanceof ASTNode.ExpressionNode) {
            ((ASTNode.ExpressionNode) current).factor = (ASTNode.FactorNode) prev;
        } else if (current instanceof ASTNode.ExpressionPrefix) {
            ((ASTNode.ExpressionPrefix) current).factor = (ASTNode.FactorNode) prev;
        }
    }

    public void enterFactor_prefix(LittleParser.Factor_prefixContext ctx) {
        tree.push(new ASTNode.FactorPrefixNode());
        current = tree.peek();
    }

    public void exitFactor_prefix(LittleParser.Factor_prefixContext ctx) {
        upOneLevel();
        if (((ASTNode.FactorPrefixNode) prev).isNull()) {
            return;
        }
        if (current instanceof ASTNode.FactorNode) {
            ((ASTNode.FactorNode) current).prefix = (ASTNode.FactorPrefixNode) prev;
        } else if (current instanceof ASTNode.FactorPrefixNode) {
            ((ASTNode.FactorPrefixNode) current).prefix = (ASTNode.FactorPrefixNode) prev;
        }
    }

    public void enterPostfix_expr(LittleParser.Postfix_exprContext ctx) {
        tree.push(new ASTNode.PostfixNode());
        current = tree.peek();
    }

    public void exitPostfix_expr(LittleParser.Postfix_exprContext ctx) {
        upOneLevel();
        if (((ASTNode.PostfixNode) prev).isNull()) {
            return;
        }
        if (current instanceof ASTNode.FactorNode) {
            ((ASTNode.FactorNode) current).postfix = (ASTNode.PostfixNode) prev;
        } else if (current instanceof ASTNode.FactorPrefixNode) {
            ((ASTNode.FactorPrefixNode) current).postfix = (ASTNode.PostfixNode) prev;
        }
    }

    public void enterCall_expr(LittleParser.Call_exprContext ctx) {

    }

    public void exitCall_expr(LittleParser.Call_exprContext ctx) {

    }

    public void enterExpr_list(LittleParser.Expr_listContext ctx) {

    }

    public void exitExpr_list(LittleParser.Expr_listContext ctx) {

    }

    public void enterExpr_list_tail(LittleParser.Expr_list_tailContext ctx) {

    }

    public void exitExpr_list_tail(LittleParser.Expr_list_tailContext ctx) {

    }

    public void enterPrimary(LittleParser.PrimaryContext ctx) {
        tree.push(new ASTNode.PrimaryNode());
        current = tree.peek();
    }

    public void exitPrimary(LittleParser.PrimaryContext ctx) {
        upOneLevel();
        if (ctx.INTLITERAL() != null) {
            ((ASTNode.PrimaryNode) prev).intLiteral = Integer.parseInt(ctx.INTLITERAL().getText());
        } else if (ctx.FLOATLITERAL() != null) {
            ((ASTNode.PrimaryNode) prev).floatLiteral = Float.parseFloat(ctx.FLOATLITERAL().getText());
        }
        ((ASTNode.PostfixNode) current).primary = (ASTNode.PrimaryNode) prev;
    }

    public void enterAddop(LittleParser.AddopContext ctx) {

    }

    public void exitAddop(LittleParser.AddopContext ctx) {
        ((ASTNode.ExpressionPrefix) current).addOp = new ASTNode.AddOperator(ctx.PLUS() == null ? 1 : 0);
    }

    public void enterMulop(LittleParser.MulopContext ctx) {

    }

    public void exitMulop(LittleParser.MulopContext ctx) {
        ((ASTNode.FactorPrefixNode) current).mulOp = new ASTNode.MulopNode(ctx.MULTIPLY() == null ? 1 : 0);
    }

    public void enterIf_stmt(LittleParser.If_stmtContext ctx) {

    }

    public void exitIf_stmt(LittleParser.If_stmtContext ctx) {

    }

    public void enterElse_part(LittleParser.Else_partContext ctx) {

    }

    public void exitElse_part(LittleParser.Else_partContext ctx) {

    }

    public void enterCond(LittleParser.CondContext ctx) {

    }

    public void exitCond(LittleParser.CondContext ctx) {

    }

    public void enterCompop(LittleParser.CompopContext ctx) {

    }

    public void exitCompop(LittleParser.CompopContext ctx) {

    }

    public void enterWhile_stmt(LittleParser.While_stmtContext ctx) {

    }

    public void exitWhile_stmt(LittleParser.While_stmtContext ctx) {

    }

    public void visitTerminal(TerminalNode terminalNode) {

    }

    public void visitErrorNode(ErrorNode errorNode) {

    }

    public void enterEveryRule(ParserRuleContext parserRuleContext) {

    }

    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }

    private void upOneLevel() {
        prev = tree.pop();
        current = tree.peek();
    }
}
