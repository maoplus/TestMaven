package IO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RTest {
    
    final String  methodName = "LoansFailureReason";
    StringBuilder result     = new StringBuilder("");
    String        newLine    = "\n";
    
    public static void main(String[] args) {
        RTest t = new RTest();
        try {
            t.getMethod();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void getMethod() throws IOException {
        String path = "c:/x/b.txt";
        Files.lines(Paths.get(path)).map(line -> {
            return line.substring(0,
                    line.lastIndexOf("java") + "java".length());
        }).forEach(line -> {
            try {
                ParseMethod(line.replaceAll("\\\\", "/"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        writeToTxt();
    }
    
    public void writeToTxt() {
        try {
            Files.write(Paths.get("c:/x/myresult.txt"),
                    result.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void appendLog(String content) {
        result.append(content + newLine);
    }
    
    public void ParseMethod(String path) throws IOException {
        
        List<String> lineList = Files.readAllLines(Paths.get(path));
        int len = lineList.size();
        int tempLineNumber = 0;
        int lineNumberCount = 0;
        // System.out.println(path);
        for (int linenumber = 0; linenumber < len; linenumber++) {
            String value = lineList.get(linenumber).trim();
            StringBuilder b = new StringBuilder("");
            tempLineNumber = linenumber;
            if (value.contains(methodName)) {
                lineNumberCount = linenumber;
                appendLog(
                        "----------------------------------------------------------------------------");
                appendLog(path);
                for (int i = 0; i < value.length(); i++) {
                    b.append(value.charAt(i));
                    if (';' == value.charAt(i)) {
                        break;
                    }
                    
                    if (i + 1 == value.length()) {
                        ++tempLineNumber;
                        if (tempLineNumber < len) {
                            value = lineList.get(tempLineNumber).trim();
                            linenumber = tempLineNumber;
                            i = -1;
                        }
                    }
                }
                // System.out.println("original method = " + b.toString());
                getIndex2(b.toString());
                // System.out.println("linenumber : " + (lineNumberCount + 1));
                // System.out.println(
                // "----------------------------------------------------------------------------");
                appendLog("original method = " + b.toString());
                appendLog("linenumber :  " + (lineNumberCount + 1));
                appendLog(
                        "----------------------------------------------------------------------------");
            }
        }
    }
    
    public void getIndex2(String v) throws IOException {
        int errorCodeStart = 0;
        int errorCodeEnd = 0;
        int errorCodeCount = 0;
        int leftCount = 0;
        int rightCount = 0;
        int leftStart = 0;
        int rightEnd = 0;
        for (int x = v.indexOf(methodName) + methodName.length(); x < v
                .length(); x++) {
            if ('"' == v.charAt(x)) {
                errorCodeCount++;
                if (1 == errorCodeCount) {
                    errorCodeStart = x;
                }
                else if (2 == errorCodeCount) {
                    errorCodeEnd = x;
                }
            }
            else if ('(' == v.charAt(x)) {
                leftCount++;
                if (1 == leftCount) {
                    leftStart = x;
                }
                if (leftCount == rightCount) {
                    rightEnd = x;
                    break;
                }
            }
            else if (')' == v.charAt(x)) {
                rightCount++;
                if (leftCount == rightCount) {
                    rightEnd = x;
                    break;
                }
            }
        }
        if (errorCodeEnd > errorCodeStart) {
            // does not contain error code or "()"
            // System.out.println(v + " leftStart = " + leftStart
            // + " rightEnd = " + rightEnd);
            if (rightEnd > leftStart) {
                String parameters = v.substring(leftStart + 1, rightEnd)
                        .replaceAll("\\(.*?\\)", "");
                // System.out.println("parameters = " + parameters);
                appendLog("parameters = " + parameters);
                // System.out.println("the number of parameters = "
                // + parameters.split(",").length);
                appendLog("the number of parameters = "
                        + parameters.split(",").length);
            }
            // System.out.println("errorcode = "
            // + v.substring(errorCodeStart + 1, errorCodeEnd));
            appendLog("errorcode = "
                    + v.substring(errorCodeStart + 1, errorCodeEnd));
        }
        else {
            // System.out.println("hava no error code");
            appendLog("hava no error code");
        }
    }
    
    @Test
    public void getMethod2() throws IOException {
        
        String x = new String(Files.readAllBytes(Paths.get("c:/x/a.java")));
        String reg = "LoansFailureReason\\(.*?\\)?;";
        Pattern pattern = Pattern.compile(reg, Pattern.DOTALL);
        Matcher m = pattern.matcher(x);
        boolean result = m.find();
        while (result) {
            String value = m.group();
            System.out.println(
                    "------------------------------------------------------");
            System.out.println(value);
            System.out.println(
                    "------------------------------------------------------");
            result = m.find();
        }
    }
}
