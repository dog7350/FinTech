package quiz.q06.q627_628;

import java.util.*;

public class bfMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("\n인증 프로그램 입니다.\n90년생 이상은 '가입불가'\n89년생 이하는 '가입가능'\nA, ㅁ, ㅋ 등의 문자는 잘못 입력\n" +
                    "주민번호 입력(앞6자리) : ");
            String age = "";

            try {
                age = sc.next();
                int num = Integer.parseInt(age);

                if (age.toCharArray().length != 6) System.out.print("\n길이가 틀렸습니다.\n");
                else if (num / 900000 >= 1) System.out.print("\n가입 불가\n");
                else if (num / 900000 == 0) System.out.print("\n가입 가능\n");
            } catch (Exception e) {
                System.out.print("\n숫자를 입력하세요!!\n");
            }
        }
    }
}
