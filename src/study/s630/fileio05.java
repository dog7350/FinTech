package study.s630;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class fileio05 {
    public static void main(String[] args) throws Exception  {
        Scanner sc = new Scanner(System.in);

        File path = new File("D:/Work/Coding/IntelliJ IDEA/FinTech/src/data/test.txt");
        FileOutputStream fos = new FileOutputStream(path);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        DataOutputStream dos = new DataOutputStream(bos);

        dos.writeUTF("안녕하세요.");
        dos.writeInt(12345);
        dos.writeDouble(1.12345);

        dos.close();
        bos.close();
        fos.close();

        FileInputStream fis = new FileInputStream(path);
        BufferedInputStream bis = new BufferedInputStream(fis);
        DataInputStream dis = new DataInputStream(bis);

        String msg = dis.readUTF();
        int num = dis.readInt();
        double dou = dis.readDouble();

        System.out.println(msg);
        System.out.println(num);
        System.out.println(dou);

        dis.close();
        bis.close();
        fis.close();
    }
}
