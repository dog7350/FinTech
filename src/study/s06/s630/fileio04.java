package study.s06.s630;

import java.io.*;
import java.util.*;

public class fileio04 {
    public static void main(String[] args) throws Exception  {
        Scanner sc = new Scanner(System.in);

        File path = new File("D:/Work/Coding/IntelliJ IDEA/FinTech/src/data/test.txt");
        FileOutputStream fos = new FileOutputStream(path);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        for (char ch = '0'; ch <= '9'; ch++) {
            Thread.sleep(2000);
            // fos.write(ch);
            bos.write(ch);
        }

        bos.flush();
        bos.write('B');
        bos.close();
    }
}
