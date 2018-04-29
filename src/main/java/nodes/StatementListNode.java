package nodes;

public class StatementListNode extends ASTNode {
    public StatementNode stmt;
    public StatementListNode statementList;

    public StatementListNode() {

    }

    @Override
    public boolean isNull() {
        if (stmt == null && statementList == null) {
            return true;
        }
        return false;
    }
}
