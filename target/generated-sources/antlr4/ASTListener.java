import nodes.*;
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
        System.out.println(";Entering identifier");
    }

    public void exitId(LittleParser.IdContext ctx) {
        if (current instanceof IDListNode) {
            ((IDListNode) current).identifier = new IDNode(ctx.IDENTIFIER().getText());
        } else if (current instanceof IDTailNode) {
            ((IDTailNode) current).identifier = new IDNode(ctx.IDENTIFIER().getText());
        } else if (current instanceof FuncDeclNode) {
            ((FuncDeclNode) current).id = new IDNode(ctx.IDENTIFIER().getText());
        } else if (current instanceof PrimaryNode) {
            ((PrimaryNode) current).id = new IDNode(ctx.IDENTIFIER().getText());
        } else if (current instanceof AssignmentExprNode) {
            ((AssignmentExprNode) current).identifier = new IDNode(ctx.IDENTIFIER().getText());
        }
        System.out.println(";Exiting identifier");
    }

    public void enterPgm_body(LittleParser.Pgm_bodyContext ctx) {
        System.out.println(";Entering program body");
        tree.push(new ProgramBodyNode());
        current = tree.peek();
    }

    public void exitPgm_body(LittleParser.Pgm_bodyContext ctx) {
        System.out.println(";Exiting program body");
        prev = tree.pop();
    }

    public void enterDecl(LittleParser.DeclContext ctx) {
        System.out.println(";Entering decl");
        tree.push(new DeclNode());
        current = tree.peek();
    }

    public void exitDecl(LittleParser.DeclContext ctx) {
        System.out.println(";Exiting decl");
        prev = tree.pop();
        if (!tree.empty()) {
            current = tree.peek();
        }
        if (((DeclNode) prev).varDecl == null) {
            return;
        }
        if (current instanceof ProgramBodyNode) {
            ((ProgramBodyNode) current).decl = (DeclNode) prev;
        } else if (current instanceof DeclNode) {
            ((DeclNode) current).decl = (DeclNode) prev;
        } else if (current instanceof FuncBodyNode) {
            ((FuncBodyNode) current).decl = (DeclNode) prev;
        }

    }

    public void enterString_decl(LittleParser.String_declContext ctx) {

    }

    public void exitString_decl(LittleParser.String_declContext ctx) {

    }

    public void enterStr(LittleParser.StrContext ctx) {

    }

    public void exitStr(LittleParser.StrContext ctx) {

    }

    public void enterVar_decl(LittleParser.Var_declContext ctx) {
        System.out.println(";Entering var decl");
        tree.push(new VarDeclNode());
        current = tree.peek();
    }

    public void exitVar_decl(LittleParser.Var_declContext ctx) {
        System.out.println(";Exiting var decl");
        upOneLevel();
        if (((VarDeclNode) prev).type == null) {
            return;
        }
        if (current instanceof DeclNode) {
            ((DeclNode) current).varDecl = (VarDeclNode) prev;
        }
    }

    public void enterVar_type(LittleParser.Var_typeContext ctx) {
        System.out.println(";Entering var type");
    }

    public void exitVar_type(LittleParser.Var_typeContext ctx) {
        if (current instanceof VarDeclNode) {
            ((VarDeclNode) current).type = new VarTypeNode(ctx.FLOAT() == null ? ctx.INT().getText() : ctx.FLOAT().getText());
        }
        System.out.println(";Exiting var type");
    }

    public void enterAny_type(LittleParser.Any_typeContext ctx) {

    }

    public void exitAny_type(LittleParser.Any_typeContext ctx) {

    }

    public void enterId_list(LittleParser.Id_listContext ctx) {
        System.out.println(";Entering id list");
        tree.push(new IDListNode());
        current = tree.peek();
    }

    public void exitId_list(LittleParser.Id_listContext ctx) {
        System.out.println(";Exiting id list");
        upOneLevel();
        if (current instanceof VarDeclNode) {
            ((VarDeclNode) current).idList = (IDListNode) prev;
        }
    }

    public void enterId_tail(LittleParser.Id_tailContext ctx) {
        System.out.println(";Entered id tail");
        tree.push(new IDTailNode());
        current = tree.peek();
    }

    public void exitId_tail(LittleParser.Id_tailContext ctx) {
        System.out.println(";Exited id tail");
        upOneLevel();
        if (current instanceof IDTailNode) {
            ((IDTailNode) current).tail = (IDTailNode) prev;
        } else if (current instanceof IDListNode) {
            ((IDListNode) current).tail = (IDTailNode) prev;
        }
    }

    public void enterParam_decl_list(LittleParser.Param_decl_listContext ctx) {
        System.out.println(";Entering param declaration list");
    }

    public void exitParam_decl_list(LittleParser.Param_decl_listContext ctx) {
        System.out.println(";Exiting param declaration list");
    }

    public void enterParam_decl(LittleParser.Param_declContext ctx) {
        System.out.println(";Entering param declaration");
    }

    public void exitParam_decl(LittleParser.Param_declContext ctx) {
        System.out.println(";Exiting param declaration");
    }

    public void enterParam_decl_tail(LittleParser.Param_decl_tailContext ctx) {
        System.out.println(";Entering param declaration tail");
    }

    public void exitParam_decl_tail(LittleParser.Param_decl_tailContext ctx) {
        System.out.println(";Entering param declaration tail");
    }

    public void enterFunc_declarations(LittleParser.Func_declarationsContext ctx) {
        System.out.println(";Entering function decl");
        tree.push(new FuncDecl());
        current= tree.peek();
    }

    public void exitFunc_declarations(LittleParser.Func_declarationsContext ctx) {
        System.out.println(";Exiting function decl");
        upOneLevel();
        if (current instanceof FuncDecl) {
            ((FuncDecl) current).funcDeclaration = (FuncDecl) prev;
        } else if (current instanceof ProgramBodyNode) {
            ((ProgramBodyNode) current).funcDecl = (FuncDecl) prev;
        }
    }

    public void enterFunc_decl(LittleParser.Func_declContext ctx) {
        System.out.println(";Entering func decl");
        tree.push(new FuncDeclNode());
        current = tree.peek();
    }

    public void exitFunc_decl(LittleParser.Func_declContext ctx) {
        System.out.println(";Exiting func decl");
        upOneLevel();
        ((FuncDecl) current).funcDecl = (FuncDeclNode) prev;
    }

    public void enterFunc_body(LittleParser.Func_bodyContext ctx) {
        System.out.println("Entering func body");
        tree.push(new FuncBodyNode());
        current = tree.peek();
    }

    public void exitFunc_body(LittleParser.Func_bodyContext ctx) {
        System.out.println("Exiting func body");
        upOneLevel();
        ((FuncDeclNode) current).funcBody = (FuncBodyNode) prev;
    }

    public void enterStmt_list(LittleParser.Stmt_listContext ctx) {
        System.out.println(";Entering statement list");
        tree.push(new StatementListNode());
        current = tree.peek();
    }

    public void exitStmt_list(LittleParser.Stmt_listContext ctx) {
        System.out.println(";Exiting statement list");
        upOneLevel();
        if (current instanceof FuncBodyNode) {
            ((FuncBodyNode) current).stmtList = (StatementListNode) prev;
        } else if (current instanceof  StatementListNode) {
            ((StatementListNode) current).statementList = (StatementListNode) prev;
        }
    }

    public void enterStmt(LittleParser.StmtContext ctx) {
        System.out.println(";Entering statement");
        tree.push(new StatementNode());
        current = tree.peek();
    }

    public void exitStmt(LittleParser.StmtContext ctx) {
        System.out.println(";Exiting statement");
        upOneLevel();
        if (((StatementNode) prev).baseStmt == null) {
            return;
        }
        ((StatementListNode) current).stmt = (StatementNode) prev;

    }

    public void enterBase_stmt(LittleParser.Base_stmtContext ctx) {
        System.out.println(";Entered base statement");
        tree.push(new BaseStatements());
        current = tree.peek();
    }

    public void exitBase_stmt(LittleParser.Base_stmtContext ctx) {
        System.out.println(";Exited base statement");
        upOneLevel();
        if (((BaseStatements) prev).assignment == null) {
            return;
        }
        ((StatementNode) current).baseStmt = (BaseStatements) prev;
    }

    public void enterAssign_stmt(LittleParser.Assign_stmtContext ctx) {
        System.out.println(";Entered assignment");
        tree.push(new AssignStatementNode());
        current = tree.peek();
    }

    public void exitAssign_stmt(LittleParser.Assign_stmtContext ctx) {
        System.out.println(";Exited assignment");
        upOneLevel();
        ((BaseStatements) current).assignment = (AssignStatementNode) prev;
    }

    public void enterAssign_expr(LittleParser.Assign_exprContext ctx) {
        System.out.println(";Entered assignment expression");
        tree.push(new AssignmentExprNode());
        current = tree.peek();
    }

    public void exitAssign_expr(LittleParser.Assign_exprContext ctx) {
        System.out.println(";Exited assignment expression");
        upOneLevel();
        ((AssignStatementNode) current).assignmentExpr = (AssignmentExprNode) prev;
    }

    public void enterRead_stmt(LittleParser.Read_stmtContext ctx) {

    }

    public void exitRead_stmt(LittleParser.Read_stmtContext ctx) {

    }

    public void enterWrite_stmt(LittleParser.Write_stmtContext ctx) {

    }

    public void exitWrite_stmt(LittleParser.Write_stmtContext ctx) {

    }

    public void enterReturn_stmt(LittleParser.Return_stmtContext ctx) {

    }

    public void exitReturn_stmt(LittleParser.Return_stmtContext ctx) {

    }

    public void enterExpr(LittleParser.ExprContext ctx) {
        System.out.println(";Entered Expression");
        tree.push(new ExpressionNode());
        current = tree.peek();
    }

    public void exitExpr(LittleParser.ExprContext ctx) {
        System.out.println(";Exited expression");
        upOneLevel();
        if (current instanceof AssignmentExprNode) {
            ((AssignmentExprNode) current).expr = (ExpressionNode) prev;
        } else if (current instanceof ExpressionList) {
            ((ExpressionList) current).expr = (ExpressionNode) prev;
        } else if (current instanceof ExpressionListTail) {
            ((ExpressionListTail) current).expr = (ExpressionNode) prev;
        } else if (current instanceof PrimaryNode) {
            ((PrimaryNode) current).expressionNode = (ExpressionNode) prev;
        }
    }

    public void enterExpr_prefix(LittleParser.Expr_prefixContext ctx) {
        System.out.println(";Entered Expr prefix");
        tree.push(new ExpressionPrefix());
        current = tree.peek();
    }

    public void exitExpr_prefix(LittleParser.Expr_prefixContext ctx) {
        System.out.println(";Exiting expression prefix");
        upOneLevel();
        if (((ExpressionPrefix) prev).factor == null && ((ExpressionPrefix) prev).prefix == null) {
            return;
        }
        if (current instanceof ExpressionNode) {
            ((ExpressionNode) current).prefix = (ExpressionPrefix) prev;
        } else if (current instanceof ExpressionPrefix) {
            ((ExpressionPrefix) current).prefix = (ExpressionPrefix) prev;
        }
    }

    public void enterFactor(LittleParser.FactorContext ctx) {
        System.out.println(";Entering factor");
        tree.push(new FactorNode());
        current = tree.peek();
    }

    public void exitFactor(LittleParser.FactorContext ctx) {
        System.out.println(";Exiting factor");
        upOneLevel();
        if (current instanceof ExpressionNode) {
            ((ExpressionNode) current).factor = (FactorNode) prev;
        } else if (current instanceof ExpressionPrefix) {
            ((ExpressionPrefix) current).factor = (FactorNode) prev;
        }
    }

    public void enterFactor_prefix(LittleParser.Factor_prefixContext ctx) {
        System.out.println(";Entering factor prefix");
        tree.push(new FactorPrefixNode());
        current = tree.peek();
    }

    public void exitFactor_prefix(LittleParser.Factor_prefixContext ctx) {
        System.out.println(";Exiting factor prefix");
        upOneLevel();
        if (current instanceof FactorNode) {
            ((FactorNode) current).prefix = (FactorPrefixNode) prev;
        } else if (current instanceof FactorPrefixNode) {
            ((FactorPrefixNode) current).prefix = (FactorPrefixNode) prev;
        }
    }

    public void enterPostfix_expr(LittleParser.Postfix_exprContext ctx) {
        System.out.println(";Entering postfix");
        tree.push(new PostfixNode());
        current = tree.peek();
    }

    public void exitPostfix_expr(LittleParser.Postfix_exprContext ctx) {
        System.out.println(";Exiting postfix");
        upOneLevel();
        if (current instanceof FactorNode) {
            ((FactorNode) current).postfix = (PostfixNode) prev;
        } else if (current instanceof FactorPrefixNode) {
            ((FactorPrefixNode) current).postfix = (PostfixNode) prev;
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
        System.out.println(";Entering primary");
        tree.push(new PrimaryNode());
        current = tree.peek();
    }

    public void exitPrimary(LittleParser.PrimaryContext ctx) {
        System.out.println(";Exiting primary");
        upOneLevel();
        if (ctx.INTLITERAL() != null) {
            ((PrimaryNode) prev).intLiteral = Integer.parseInt(ctx.INTLITERAL().getText());
        } else if (ctx.FLOATLITERAL() != null) {
            ((PrimaryNode) prev).floatLiteral = Float.parseFloat(ctx.FLOATLITERAL().getText());
        }
        ((PostfixNode) current).primary = (PrimaryNode) prev;
    }

    public void enterAddop(LittleParser.AddopContext ctx) {

    }

    public void exitAddop(LittleParser.AddopContext ctx) {
        ((ExpressionPrefix) current).addOp = new AddOperator(ctx.PLUS() == null ? 1 : 0);
    }

    public void enterMulop(LittleParser.MulopContext ctx) {

    }

    public void exitMulop(LittleParser.MulopContext ctx) {
        ((FactorPrefixNode) current).mulOp = new MulopNode(ctx.MULTIPLY() == null ? 1 : 0);
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
