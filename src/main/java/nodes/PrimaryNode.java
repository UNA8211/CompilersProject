package nodes;

public class PrimaryNode extends ASTNode {
    public IDNode id;
    public Integer intLiteral;
    public Float floatLiteral;
    public ExpressionNode expressionNode;

    public PrimaryNode() {

    }

    @Override
    public boolean isNull() {
        if (id == null && intLiteral == null && floatLiteral == null && expressionNode == null) {
            return true;
        }
        return false;
    }
}
