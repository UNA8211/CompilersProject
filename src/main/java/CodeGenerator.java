import nodes.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CodeGenerator {

    private ASTNode root;
    HashMap<String, String> vars;

    public CodeGenerator(ASTNode root) {
        this.root = root;
        vars = new HashMap<String, String>();
    }

    public void begin() {
        if (root instanceof ProgramBodyNode) {
            walkThroughProgramBody((ProgramBodyNode) root);
        }
    }

    public void walkThroughProgramBody(ProgramBodyNode node) {
        if (node.decl != null) {
            walkThroughDecl(node.decl);
        }

        if (node.funcDecl != null) {
            walkThroughFuncDeclarations(node.funcDecl);
        }
    }

    public void walkThroughFuncDeclarations(FuncDecl funcDecl) {
        if (funcDecl.funcDecl != null) {
            walkThroughFuncDecl(funcDecl.funcDecl);
        }
    }

    public void walkThroughFuncDecl(FuncDeclNode funcDeclNode) {
        System.out.println("label " + funcDeclNode.id.toString());
    }

    public void walkThroughDecl(DeclNode declNode) {
        walkThroughVarDecl(declNode.varDecl);
        if (declNode.decl != null) {
            walkThroughDecl(declNode.decl);
        }
    }

    public void walkThroughVarDecl(VarDeclNode varDeclNode) {
        String type = varDeclNode.type.toString();
        List<String> ids = walkThroughIDList(varDeclNode.idList);
        for (String id : ids) {
            System.out.println("var " + id);
            vars.put(id, type);
        }
    }

    public List<String> walkThroughIDList(IDListNode idListNode) {
        List<String> ids = new ArrayList<String>();
        ids.add(idListNode.identifier.toString());
        if (idListNode.tail != null) {
            ids.addAll(walkThroughTail(idListNode.tail));
        }
        return ids;
    }

    public List<String> walkThroughTail (IDTailNode tail) {
        List<String> ids = new ArrayList<String>();
        ids.add(tail.identifier.toString());
        if (tail.tail != null && tail.tail.identifier != null) {
            ids.addAll(walkThroughTail(tail.tail));
        }
        return ids;
    }
}
