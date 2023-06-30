package study.s630;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class fileio03 {
    public static void main(String[] args) throws Exception  {
        Scanner sc = new Scanner(System.in);

        File path = new File("D:/Work/Coding/IntelliJ IDEA/FinTech/src/data/test.txt");
        FileOutputStream fos = new FileOutputStream(path, true);

        fos.write("test".getBytes(StandardCharsets.UTF_8));

        fos.close();

        FileInputStream fis = new FileInputStream(path);
        /*
        System.out.println(fis.read());
        System.out.println((char)fis.read());
        */
        while ( true ) {
            int res = fis.read();
            if (res <= 0) {
                System.out.println("내용이 없습니다 : " + res);
                break;
            }
            System.out.println((char) res);
        }
    }
}
