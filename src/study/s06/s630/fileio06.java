package study.s06.s630;

import java.util.*;

public class fileio06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        FileService fs = new FileService();

        int num;
        while (true) {
            System.out.print("\n1. 파일 저장\n2. 파일 확인\n>> ");
            num = sc.nextInt();

            if (num == 1) {
                fs.writeMember();
            } else if (num == 2) {
                fs.readMember();
            }
        }
    }
}
