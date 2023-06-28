package quiz.q627_628;

import java.text.*;
import java.util.*;

public class lcService {
    private lcService() {
        login = new lcLogin();
    }
    private static lcService instance = null;
    public lcLogin login = null;
    public SimpleDateFormat form = new SimpleDateFormat("yyyy년 M월 d일 / h시 m분 s초");

    public static lcService getInstance() {
        if (instance == null) instance = new lcService();
        return instance;
    }

    Scanner sc = new Scanner(System.in);

    public void startTime() { login.setStart(new Date().getTime()); }
    public void startStatus() {
        System.out.println(form.format(login.getStart()));
    }
    public void endTime() {
        login.setEnd(new Date().getTime());
    }
    public void endStatus() {
        System.out.println(form.format(login.getEnd()));
    }
    public void totalTime() {
        login.setTotal(login.getEnd() - login.getStart());
        System.out.println(new SimpleDateFormat("m분 s초 사용함!!").format(login.getTotal()));
    }

    public int startLogin() {
        if (login.getId() == null) {
            System.out.println("\n아이디를 저장하세요.");
            return 0;
        } else {
            System.out.print("\n아이디 입력\n>> ");
            String id = sc.next();
            if (login.getId().equals(id)) {
                System.out.print("\n비밀번호 입력\n>> ");
                String pw = sc.next();
                if (login.getPwd().equals(pw)) {
                    System.out.println("\n인증 통과");
                    return 1;
                }
                else System.out.println("\n비번 틀림");
            } else System.out.println("\n존재하지 않는 ID입니다.");
        }
        return 0;
    }

    public void join() {
        if (login.getId() == null) {
            System.out.print("\n사용자 등록\n아이디 입력\n>> ");
            String id = sc.next();
            System.out.print("\n비밀번호 입력\n>> ");
            String pw = sc.next();
            login.setId(id);
            login.setPwd(pw);
            System.out.println("\n등록되었습니다.");
        } else System.out.print("\n사용자가 이미 존재합니다.\n");
    }

    public void exit() {
        if (login.getId() == null) System.out.println("\n등록된 값 없음");
        else {
            login.setId(null);
            login.setPwd(null);
            System.out.println("\n탈퇴 되었습니다.");
        }
    }
}
