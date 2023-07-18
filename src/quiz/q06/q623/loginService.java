package quiz.q06.q623;

import java.util.*;

public class loginService {
    Scanner sc = new Scanner(System.in);

    loginDTO dto = new loginDTO();
    int cmd = 0;
    String id, pw;
    boolean flag = true;

    public void display() {
        while (flag) {
            if (dto.getId() == null) { System.out.println("\n등록된 아이디가 없습니다."); }
            System.out.println("\n1. 로그인\n2. 회원가입\n3. 탈퇴\n4. 프로그램 종료");

            cmd = sc.nextInt();
            switch (cmd) {
                case 1 :
                    if (dto.getId() == null) {
                        System.out.println("\n아이디를 저장하세요.");
                        break;
                    } else {
                        System.out.print("\n아이디 입력\n>> ");
                        id = sc.next();
                        if (dto.getId().equals(id)) {
                            System.out.print("\n비밀번호 입력\n>> ");
                            pw = sc.next();
                            if (dto.getPwd().equals(pw)) System.out.println("\n인증 통과");
                            else System.out.println("\n비번 틀림");
                        } else System.out.println("\n존재하지 않는 ID입니다.");
                    }
                    break;
                case 2 :
                    if (dto.getId() == null) {
                        System.out.print("\n사용자 등록\n아이디 입력\n>> ");
                        id = sc.next();
                        System.out.print("\n비밀번호 입력\n>> ");
                        pw = sc.next();
                        dto.setId(id);
                        dto.setPwd(pw);
                        System.out.println("\n등록되었습니다.");
                    } else System.out.print("\n사용자가 이미 존재합니다.\n");
                    break;
                case 3 :
                    if (dto.getId() == null) System.out.println("\n등록된 값 없음");
                    else {
                        dto.setId(null);
                        dto.setPwd(null);
                        System.out.println("\n탈퇴 되었습니다.");
                    }
                    break;
                case 4 :
                    System.out.println("\n프로그램을 종료합니다.");
                    flag = false;
                    break;
            }
        }
    }
}
