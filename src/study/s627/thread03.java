package study.s627;

import java.util.Scanner;

class A03 extends Thread {
    public void run() {
        for (int i = 0;;i++) {
            System.out.print("\n내용 출력 " + i + "\n");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class thread03 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str;
        A03 a = new A03();
        a.setDaemon(true); // 현재 종속된 메서드(main)가 종료 시 스레드도 같이 종료
        a.start();

        while (true) {
            System.out.print("\n문자열 입력 : ");
            str = sc.next();
            System.out.println("입력한 값 : " + str);

            if (str.equals("end")) {
                System.out.print("\n프로그램 종료\n");
                break;
            }
        }

        System.out.print("\nMain End\n");
    }
}
