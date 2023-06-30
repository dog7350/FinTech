package study.s630;

import java.io.*;
import java.util.*;

public class FileService {
    Scanner sc = new Scanner(System.in);

    public final String path = "D:/Work/Coding/IntelliJ IDEA/FinTech/src/data/member/";

    public FileService() {}

    public void writeMember() {
        String name, addr;
        int age;

        System.out.print("\n이름 입력 : ");
        name = sc.next();
        System.out.print("\n주소 입력 : ");
        addr = sc.next();
        System.out.print("\n나이 입력 : ");
        age = sc.nextInt();

        FileDTO dto = new FileDTO();
        dto.setName(name);
        dto.setAddr(addr);
        dto.setAge(age);

        File filePath = new File(path + name + ".txt");
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(filePath);
            bos = new BufferedOutputStream(fos);
            oos = new ObjectOutputStream(bos);

            oos.writeObject(dto);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) oos.close();
                if (bos != null) bos.close();
                if (fos != null) fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void readMember() {
        System.out.println("1. 파일 목록");
        System.out.println("2. 특정 사용자 검색");
        System.out.println("3. 모든 사용자 보기");
        String msg;

        switch(sc.nextInt()) {
            case 1 :
                list();
                break;
            case 2 :
                System.out.print("파일명 입력 : ");
                msg = sc.next();
                memberView(msg + ".txt");
                break;
            case 3 :
                System.out.print("파일명 입력 : ");
                msg = sc.next();
                allMemberView(msg);
                break;
        }
    }

    private void allMemberView(String msg) {
        String[] fileNames = list();

        for (String name : fileNames) {
            memberView(name);
        }
    }

    private void memberView(String msg) {
        File file = new File(path + msg);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            ois = new ObjectInputStream(bis);

            FileDTO dto = (FileDTO) ois.readObject();
            ois.close(); bis.close(); fis.close();

            System.out.println("이름 : " + dto.getName());
            System.out.println("주소 : " + dto.getAddr());
            System.out.println("나이 : " + dto.getAge());
        } catch (Exception e) {
            System.out.println("해당 사용자는 존재하지 않습니다.");
        }
    }

    private String[] list() {
        File file = new File(path);
        String[] fileNames = file.list();
        for(String f : fileNames) {
            System.out.println(f);
        }

        return fileNames;
    }
}
