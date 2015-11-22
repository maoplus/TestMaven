package IO;

import java.io.File;
import java.io.IOException;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class TestMethodLineNumber {
    public static void method1() {
        int i = 1;
        System.out.println(i);
    }
    
    public static void method2() {
        String s = "hello";
        System.out.println(s);
    }
    
    public static void main(String[] args) throws ParseException, IOException {
        // File f = new File(".").getAbsoluteFile();
        // File srcRoot = new File(f, "src/main/java");
        // String srcFilename = TestMethodLineNumber.class.getName()
        // .replaceAll("\\.", "/") + ".java";
        File src = new File("c:/x/a.java");
        getMethodLineNumbers(src);
    }
    
    private static void getMethodLineNumbers(File src)
            throws ParseException, IOException {
        CompilationUnit cu = JavaParser.parse(src);
        new MethodVisitor().visit(cu, null);
    }
    
    /**
     * Simple visitor implementation for visiting MethodDeclaration nodes.
     */
    private static class MethodVisitor extends VoidVisitorAdapter {
        @Override
        public void visit(MethodDeclaration m, Object arg) {
            System.out.println("From [" + m.getBeginLine() + ","
                    + m.getBeginColumn() + "] to [" + m.getEndLine() + ","
                    + m.getEndColumn() + "] is method:");
            System.out.println(m);
        }
    }
}