package quest.q623;

import java.util.*;

         /*
            사용자에게 명령어를 입력받아 처리하는 프로그램을 작성하세요.
            "count" 명령어는 입력할 학생의 수를 입력받습니다.
                > 학생 수를 입력 받지 않고 insert 명령어를 입력하는 경우 "먼저 학생 수를 입력하세요"를 출력한 후 메인 메뉴로 돌아옵니다.
            "insert" 명령어는 입력 사용자의 수 만큼 학생의 이름(String), 주소(String), ID(String), PW(String), 국어(int), 영어(int), 수학(int)을 차례대로 입력합니다.
            "print" 명령어는 입력 받은 정보를 아래와 같이 출력한 후 메인 메뉴로 돌아옵니다.
                만약, 학생 정보가 하나도 존재하지 않을 경우 "입력된 학생 정보가 없습니다." 메시지를 출력합니다.
                    ★ ㅇㅇㅇ 학생(ID)의 정보 ★
                     이름 : ㅇㅇㅇ
                     주소 : ㅇㅇㅇ
                     ID : ㅇㅇㅇ
                     PW : ㅇㅇㅇ
                     국어 : ㅇㅇㅇ
                     영어 : ㅇㅇㅇ
                     수학 : ㅇㅇㅇ
                     총점 : ㅇㅇㅇ
                     평균 : ㅇㅇㅇ \n
            "search" 명령어는 학생의 ID를 입력받아 특정 학생을 검색하여 위와같이 출력합니다.
            "modify" 명령어는 학생의 ID를 입력받아 정보를 수정한 후 "ㅇㅇㅇ 정보가 수정되었습니다." 메시지를 출력하고, 학생이 존재하지 않을 경우 "존재하지 않는 학생입니다"를 출력합니다.
            "remove" 명령어는 학생의 ID를 입력받아 정보를 삭제한 후 "ㅇㅇㅇ 학생은 퇴학 처리되었습니다." 메시지를 출력하고, 학생이 존재하지 않을 경우 "존재하지 않는 학생입니다"를 출력합니다.
            "event" 명령어는 무작위의 번호를 뽑아 이벤트 학생 한 명을 선정하여 정보를 출력하고, 모든 성적을 10점씩 상향시킨 후 반영합니다. 그리고 반영된 정보를 출력하고 "경축! 이벤트에 당첨되셨습니다" 메시지를 출력 후 메인 메뉴로 돌아갑니다.
                > 단, 각 과목의 점수는 100점을 넘어갈 수 없습니다.
                > 입력된 학생 정보가 없을 경우 "입력된 학생 정보가 없습니다." 메시지를 출력하고 메인 메뉴로 돌아갑니다.
            "exit" 명령어를 입력할 경우 프로그램을 종료합니다.

            파일은 Main.Class, Student.Class, Module.Class를 필요로 합니다.
        */

public class lcMain {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        lcModule module = new lcModule();

        boolean flag = true;
        String cmd;

        while (flag) {
            System.out.print("\n명령어 가이드\ncount : 입력할 학생 수\ninsert : 학생 정보 입력\nprint : 모든 학생 정보 출력\nsearch : 특정 학생 검색\nmodify : 학생 정보 수정\ndelete : 퇴학\nevent : 이벤트 학생 추첨\nexit : 프로그램 종료\n");
            System.out.print("\n명령어름 입력하세요.\n>> ");
            cmd = sc.next();

            switch (cmd) {
                case "count" :
                    System.out.print("\n입력할 학생의 수\n>> ");
                    module.setCnt(sc.nextInt());
                    break;
                case "insert" :
                    module.insert();
                    break;
                case "modify" :
                    System.out.print("\n수정할 학생 ID : ");
                    module.modify(sc.next());
                    break;
                case "delete" :
                    System.out.print("\n삭제할 학생 ID : ");
                    module.delete(sc.next());
                    break;
                case "search" :
                    System.out.print("\n검색할 학생 ID : ");
                    module.search(sc.next());
                    break;
                case "event" :
                    module.event();
                    break;
                case "print" :
                    module.print();
                    break;
                case "exit" :
                    System.out.print("\n프로그램을 종료합니다.\n");
                    flag = false;
                    break;
            }
        }
    }
}