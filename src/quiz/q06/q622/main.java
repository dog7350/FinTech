package quiz.q06.q622;

import static prt.ObjectPrint.*;
import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        func bf = new func();
        int cmd = 0;
        boolean flag = true;

        while (flag) {
            prt("\n1. 입력\n2. 연산\n3. 출력\n4. 등급\n5. 프로그램 종료\n명령어 입력 >> ");
            cmd = sc.nextInt();

            switch (cmd) {
                case 1 :
                    bf.insert();
                    break;
                case 2 :
                    bf.exec();
                    break;
                case 3 :
                    bf.funPrint();
                    break;
                case 4 :
                    bf.grade();
                    break;
                case 5 :
                    flag = false;
                    prt("\n프로그램 종료\n");
                    break;
                default :
                    prt("\n존재하지 않는 명령어입니다.\n");
            }
        }
    }
}
