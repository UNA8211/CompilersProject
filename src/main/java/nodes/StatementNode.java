package nodes;

public class StatementNode extends ASTNode {
    public BaseStatements baseStmt;

    public StatementNode() {

    }

    @Override
    public boolean isNull() {
        if (baseStmt == null) {
            return true;
        }
        return false;
    }
}
