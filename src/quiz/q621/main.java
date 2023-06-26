package quiz.q621;

import static prt.ObjectPrint.*;
import java.util.*;

public class main {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        ModuleOne mo = new ModuleOne();
        ModuleTwo mt = new ModuleTwo();

        boolean flag = true;
        int cmd, num, result;

        while (flag) {
            prt("\n★ 명령어 입력 ★\n1. 이름 출력\n2. 세 이름을 입력받아 출력\n3. 이해 못 함\n4. 이해 못 함\n5. 이해 못 함\n" +
                    "6. 두 수를 입력받아 큰 수 출력\n7. 정수 입력 후 짝수&홀수 출력\n8. 정수를 입력받아 해당 정수까지 3의 배수 출력\n" +
                    "9. 수를 입력받아 소수 판별\n10. 절대값을 구하는 함수\n99. 프로그램 종료\n>> ");
            cmd = sc.nextInt();

            switch(cmd) {
                case 1 :
                    mo.names(1);
                    break;
                case 2 :
                    mo.names(3);
                    break;
                case 3 :
                    prt("문제 이해 못함");
                    break;
                case 4 :
                    prt("문제 이해 못함");
                    break;
                case 5 :
                    prt("문제 이해 못함");
                    break;
                case 6 :
                    mt.bigger();
                    break;
                case 7 :
                    mt.evod();
                    break;
                case 8 :
                    mt.three();
                    break;
                case 9 :
                    mt.prime();
                    break;
                case 10 :
                    prt("\n임의의 수 입력\n>> ");
                    num = sc.nextInt();
                    result = mt.abs(num);
                    prt("\n반환받은 수 : " + result);
                case 99:
                    prt("\n프로그램 종료\n");
                    flag = false;
                    break;
            }
        }

    }
}
