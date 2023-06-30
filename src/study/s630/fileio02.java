package study.s630;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class fileio02 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String path = "D:/Work/Coding/IntelliJ IDEA/FinTech/src/data/";
        // File path = new File("D:/Work/Coding/IntelliJ IDEA/FinTech/src/data/test.txt");
        /*
        path.mkdir();
        path.delete();
        String [] list = path.list();
        System.out.println(list[0]);
        System.out.println(path.exists());
        */

        System.out.println("파일명 입력");
        String name = sc.next();
        path += name + ".txt";
        File filePath = new File(path);

        if ( filePath.exists() ) {
            System.out.println("파일이 존재합니다.");
        } else {
            FileOutputStream fos = new FileOutputStream(path);
            System.out.println("파일에 출력할 내용 입력");
            String msg = sc.next();
            fos.write( msg.getBytes(StandardCharsets.UTF_8) );
            System.out.println("저장되었습니다.");
        }
    }
}
