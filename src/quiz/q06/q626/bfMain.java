package quiz.q06.q626;

import java.util.Scanner;

public class bfMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        bfService service = new bfService();

        int cmd;
        boolean flag = true;

        while (flag) {
            System.out.print("\n1. 시작 시간 설정\n2. 시작 시간 확인\n3. 종료 시간 설정\n4. 종료 시간 확인\n5. 사용 시간 확인\n" +
                    "6. 프로그램 종료\n명령어 입력\n>> ");
            cmd = sc.nextInt();

            switch (cmd) {
                case 1:
                    System.out.print("\n시작 시간 설정 중...\n");
                    service.startTime();
                    break;
                case 2:
                    System.out.print("\n시작 시간 확인\n");
                    service.startStatus();
                    break;
                case 3:
                    System.out.print("\n종료 시간 설정 중...\n");
                    service.endTime();
                    break;
                case 4:
                    System.out.print("\n종료 시간 확인\n");
                    service.endStatus();
                    break;
                case 5:
                    System.out.print("\n사용 시간 확인\n");
                    service.totalTime();
                    break;
                case 6:
                    System.out.print("\n프로그램 종료\n");
                    flag = false;
                    break;
            }
        }
    }
}
