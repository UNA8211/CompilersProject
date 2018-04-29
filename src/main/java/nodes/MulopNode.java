package nodes;

public class MulopNode extends ASTNode {
    public Integer op;

    public MulopNode(int op) {
        this.op = op;
    }

    @Override
    public boolean isNull() {
        if (op == null) {
            return true;
        }
        return false;
    }
}
