package quiz.q06.q626;

import java.util.*;

public class lcMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        lcService service = lcService.getInstance();

        int cmd;
        boolean flag = true;

        while (flag) {
            if (service.login.getId() == null) System.out.print("\n등록된 아이디가 없습니다.\n");
            System.out.print("\n1. 로그인\n2. 회원가입\n3. 탈퇴\n4. 프로그램 종료\n명령어 입력 >> ");
            cmd = sc.nextInt();

            switch(cmd) {
                case 1 :
                    if (service.startLogin() == 1) {
                        service.startTime();
                        service.startStatus();
                    }
                    break;
                case 2 :
                    service.join();
                    break;
                case 3 :
                    service.exit();
                    break;
                case 4 :
                    flag = false;
                    service.endTime();
                    service.endStatus();
                    service.totalTime();
                    System.out.print("\n프로그램을 종료합니다.\n");
                    break;
            }
        }
    }
}
