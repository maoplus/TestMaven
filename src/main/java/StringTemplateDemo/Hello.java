package StringTemplateDemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.stringtemplate.v4.ST;

public class Hello {
    public static void main(String[] args) throws IOException {
        final String stringTemplate = readByLines("c:/x/a.txt");
        ST hello = new ST(stringTemplate);
        List<String> tradestatus = new ArrayList<String>();
        tradestatus.add("Live");
        tradestatus.add("OPen");
        hello.add("tradeStatusList", tradestatus);
        System.out.println(hello.render());
    }
    
    private static String readByLines(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}