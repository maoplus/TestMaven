package IO;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class GetFileList {
    @Test
    public void fileList() {
        Path path = Paths.get("c:/x");
        try {
            Files.walk(path, FileVisitOption.FOLLOW_LINKS)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void getfileList() {
        Path path = Paths.get("C:\\code\\project");
        
        try {
            Files.walk(path).filter(folder -> !Files.isDirectory(folder))
                    .map(f -> {
                        String fileName = f.getFileName().toString();
                        return fileName
                                .substring(fileName.lastIndexOf('.') + 1);
                    }).distinct().sorted().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
