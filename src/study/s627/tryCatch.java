package study.s627;

/*
예외 종류
- 강제 예외 : throw new 예외클래스(문자열)
- 예외 전가 : throws > 부모 클래스에 예외 전가
- 예외 처리 : try, catch > 자신의 메서드 안에서 처리
- 실행 : finally
*/

import java.util.*;

public class tryCatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x, y, result = 0;

        while (true) {
            System.out.println("수 입력");
            try {
                x = sc.nextInt();
                y = sc.nextInt();
                result = x / y;
            } catch (Exception e) {
                System.out.print("\n에러 코드 : " + e);
                System.out.print("\n0 이상의 정수 입력\n");
            } finally {
                System.out.print("\n처리 완료\n");
            }
            System.out.println("결과 : " + result);
        }
    }
}
