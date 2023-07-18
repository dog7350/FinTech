package study.s06.s630;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class fileio01 {
    public static void main(String[] args) throws Exception {
        File path = new File("D:\\Work\\Coding\\IntelliJ IDEA\\FinTech\\src\\data\\test.txt");
        FileOutputStream fos = new FileOutputStream(path);
        fos.write(97);
        fos.write('A');
        fos.write("test".getBytes(StandardCharsets.UTF_8));
    }
}
