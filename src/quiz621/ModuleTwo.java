package quiz621;

import static prt.ObjectPrint.*;
import java.util.*;

public class ModuleTwo {
    Scanner sc = new Scanner(System.in);

    public void bigger() {
        prt("\n첫 번째 수 입력\n>> ");
        int num1 = sc.nextInt();
        prt("\n두 번째 수 입력\n>> ");
        int num2 = sc.nextInt();

        prt("\n가장 큰 수 : " + ((num1 > num2) ? num1 : num2));
    }

    public void evod() {
        prt("\n정수 입력\n>> ");
        int num = sc.nextInt();
        prt("\n입력한 숫자는 " + ((num % 2 == 0) ? "짝수" : "홀수") + "입니다.");
    }

    public void three() {
        prt("\n정수 입력\n>> ");
        int num = sc.nextInt();
        prt("\n3의 배수\n");
        for (int i = 1; i <= num; i++)
            if (i % 3 == 0) prt(i + " ");
    }

    public void prime() {
        prt("\n정수 입력\n>> ");
        int num = sc.nextInt();
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                prt("\n소수 아님\n");
                return;
            }
        }
        prt("\n소수 맞음\n");
    }

    public int abs(int num) {
        return Math.abs(num);
    }
}
