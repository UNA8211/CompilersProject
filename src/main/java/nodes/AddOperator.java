package nodes;

public class AddOperator extends ASTNode {
    Integer sign;

    public AddOperator(int sign) {
        this.sign = sign;
    }

    @Override
    public boolean isNull() {
        if (sign == null) {
            return true;
        }
        return false;
    }
}
