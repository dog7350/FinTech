package quest;

import java.util.*;

public class quest620LC {
    public void lc620() {
         /*
            사용자에게 명령어를 입력받아 처리하는 프로그램을 작성하세요.
            "count" 명령어는 입력할 학생의 수를 입력받습니다.
                > 학생 수를 입력 받지 않고 insert 명령어를 입력하는 경우 "먼저 학생 수를 입력하세요"를 출력한 후 메인 메뉴로 돌아옵니다.
            "insert" 명령어는 입력 사용자의 수 만큼 학생의 이름(String), 주소(String), 국어(int), 영어(int), 수학(int)을 차례대로 입력합니다.
                > 학번(int)은 1부터 1씩 증가하며, Map의 Key로 사용하고, 주소는 개인정보이기 때문에 비트 연산을 사용하여 암호화합니다. (2 만큼 증가)
                > Object 자료형(최상위)은 모든 자료형을 포함할 수 있으며, 배열 생성은 다른 배열과 같은 방법으로 생성합니다.
                > 어렵다면 암호화는 패스
            "print" 명령어는 입력 받은 정보를 아래와 같이 출력한 후 메인 메뉴로 돌아옵니다.
                만약, 학생 정보가 하나도 존재하지 않을 경우 "입력된 학생 정보가 없습니다." 메시지를 출력합니다.
                > 주소는 복호화를 진행하여 출력합니다. (암호화를 하지 않았다면 패스)
                    ★ ㅇㅇㅇ 학생(학번)의 정보 ★
                     이름 : ㅇㅇㅇ
                     주소 : ㅇㅇㅇ
                     국어 : ㅇㅇㅇ
                     영어 : ㅇㅇㅇ
                     수학 : ㅇㅇㅇ
                     총점 : ㅇㅇㅇ
                     평균 : ㅇㅇㅇ \n
            "search" 명령어는 학생의 학번을 입력받아 특정 학생을 검색합니다.
            "modify" 명령어는 학생의 이름을 입력받아 정보를 수정한 후 "ㅇㅇㅇ 정보가 수정되었습니다." 메시지를 출력하고, 학생이 존재하지 않을 경우 "존재하지 않는 학생입니다"를 출력합니다.
            "remove" 명령어는 학생의 이름을 입력받아 정보를 삭제한 후 "ㅇㅇㅇ 학생은 퇴학처리 되었습니다." 메시지를 출력하고, 학생이 존재하지 않을 경우 "존재하지 않는 학생입니다"를 출력합니다.
            "event" 명령어는 무작위의 번호를 뽑아 이벤트 학생 한 명을 선정하여 정보를 출력하고, 모든 성적을 10점씩 상향시킨 후 반영합니다. 그리고 반영된 정보를 출력하고 "경축! 이벤트에 당첨되셨습니다" 메시지를 출력 후 메인 메뉴로 돌아갑니다.
                > 단, 각 과목의 점수는 100점을 넘어갈 수 없습니다.
                > 추첨 진행 전 추첨을 할지 다시 한 번 (Y/N)을 입력받으며, 입력된 학생 정보가 없을 경우 "입력된 학생 정보가 없습니다." 메시지를 출력하고 메인 메뉴로 돌아갑니다.
            "exit" 명령어를 입력할 경우 프로그램을 종료합니다.
        */

        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        String cmd, str;
        int cnt = -1, stuCnt = 1, id;
        Map<Integer, Object[]> student = new HashMap<>();
        Iterator<Integer> stuTmp;

        while (flag) {
            System.out.print("\n명령어 가이드\ncount : 입력할 학생 수\ninsert : 학생 정보 입력\nprint : 모든 학생 정보 출력\nsearch : 특정 학생 검색\nmodify : 학생 정보 수정\nremove : 퇴학\nevent : 이벤트 학생 추첨\nexit : 프로그램 종료\n");
            System.out.print("\n명령어름 입력하세요.\n>> ");
            cmd = sc.next();

            switch (cmd) {
                case "count" :
                    System.out.print("\n학생 수 입력\n>> ");
                    cnt = sc.nextInt();
                    break;
                case "insert" :
                    if (cnt == -1) {
                        System.out.print("먼저 학생 수를 입력하세요!\n");
                        break;
                    }
                    for (int i = 0; i < cnt; i++) {
                        Object[] tmp = new Object[5];
                        System.out.print("\n학생 이름 : ");
                        tmp[0] = sc.next();
                        System.out.print("\n주소 : ");
                        tmp[1] = sc.next();
                        str = "";
                        for (int j = 0; j < tmp[1].toString().length(); j++) str += (char) (tmp[1].toString().charAt(j) << 2);
                        tmp[1] = str;
                        System.out.print("\n국어 : ");
                        tmp[2] = sc.nextInt();
                        System.out.print("\n영어 : ");
                        tmp[3] = sc.nextInt();
                        System.out.print("\n수학 : ");
                        tmp[4] = sc.nextInt();
                        student.put(stuCnt++, tmp);
                    }
                    cnt = -1;
                    break;
                case "print" :
                    if (student.size() <= 0) {
                        System.out.print("입력된 학생 정보가 없습니다.");
                        break;
                    }
                    stuTmp = student.keySet().iterator();
                    while (stuTmp.hasNext()) {
                        id = stuTmp.next();
                        System.out.print("\n★ " + student.get(id)[0] + "학생(" + id + ")의 정보 ★\n");
                        System.out.print("이름 : " + student.get(id)[0]);
                        str = "";
                        for (int j = 0; j < student.get(id)[1].toString().length(); j++) str += (char) (student.get(id)[1].toString().charAt(j) >> 2);
                        System.out.print("\n주소 : " + str);
                        System.out.print("\n국어 : " + student.get(id)[2]);
                        System.out.print("\n영어 : " + student.get(id)[3]);
                        System.out.print("\n수학 : " + student.get(id)[4]);
                        int sum = (int) student.get(id)[2] + (int) student.get(id)[3] + (int) student.get(id)[4];
                        System.out.print("\n총점 : " + sum);
                        System.out.print("\n평균 : " + (sum / 3) + "\n");
                    }
                    break;
                case "search" :
                    System.out.print("\n학생의 학번을 입력하세요.\n>> ");
                    id = sc.nextInt();
                    if (student.get(id) == null) {
                        System.out.print("\n존재하지 않는 학생입니다.\n");
                        break;
                    }
                    System.out.print("\n★ " + student.get(id)[0] + "학생(" + id + ")의 정보 ★\n");
                    System.out.print("이름 : " + student.get(id)[0]);
                    str = "";
                    for (int j = 0; j < student.get(id)[1].toString().length(); j++) str += (char) (student.get(id)[1].toString().charAt(j) >> 2);
                    System.out.print("\n주소 : " + str);
                    System.out.print("\n국어 : " + student.get(id)[2]);
                    System.out.print("\n영어 : " + student.get(id)[3]);
                    System.out.print("\n수학 : " + student.get(id)[4]);
                    int sum = (int) student.get(id)[2] + (int) student.get(id)[3] + (int) student.get(id)[4];
                    System.out.print("\n총점 : " + sum);
                    System.out.print("\n평균 : " + (sum / 3) + "\n");
                    break;
                case "modify" :
                    System.out.print("\n학생의 학번을 입력하세요.\n>> ");
                    id = sc.nextInt();
                    if (student.get(id) == null) {
                        System.out.print("\n존재하지 않는 학생입니다.\n");
                        break;
                    }
                    Object[] tmp = new Object[5];
                    System.out.print("\n학생 이름 : ");
                    tmp[0] = sc.next();
                    System.out.print("\n주소 : ");
                    tmp[1] = sc.next();
                    str = "";
                    for (int j = 0; j < tmp[1].toString().length(); j++) str += (char) (tmp[1].toString().charAt(j) << 2);
                    tmp[1] = str;
                    System.out.print("\n국어 : ");
                    tmp[2] = sc.nextInt();
                    System.out.print("\n영어 : ");
                    tmp[3] = sc.nextInt();
                    System.out.print("\n수학 : ");
                    tmp[4] = sc.nextInt();
                    student.put(id, tmp);
                    System.out.print("\n" + tmp[0] + " 정보가 수정되었습니다.\n");
                    break;
                case "remove" :
                    System.out.print("\n학생의 학번을 입력하세요.\n>> ");
                    id = sc.nextInt();
                    if (student.get(id) == null) {
                        System.out.print("\n존재하지 않는 학생입니다.\n");
                        break;
                    }
                    System.out.print("\n" + student.get(id)[0] + " 학생은 퇴학처리 되었습니다.\n");
                    student.remove(id);
                    break;
                case "event" :
                    System.out.print("\n이벤트 추첨을 진행하시겠습니까? (Y/N)\n>> ");
                    cmd = sc.next();
                    if (!cmd.toUpperCase().equals("Y")) {
                        System.out.print("\n추첨을 종료합니다.\n");
                        break;
                    }
                    if (student.size() <= 0) {
                        System.out.print("\n입력된 학생 정보가 없습니다.\n");
                        break;
                    }
                    id = new Random().nextInt(student.size()) + 1;
                    tmp = new Object[5];
                    tmp[0] = student.get(id)[0];
                    tmp[1] = student.get(id)[1];
                    tmp[2] = ((int)student.get(id)[2] + 10 > 100) ? 100 : (int)student.get(id)[2] + 10;
                    tmp[3] = ((int)student.get(id)[3] + 10 > 100) ? 100 : (int)student.get(id)[3] + 10;
                    tmp[4] = ((int)student.get(id)[4] + 10 > 100) ? 100 : (int)student.get(id)[4] + 10;
                    student.put(id, tmp);
                    System.out.print("\n경축! 이벤트에 당첨되셨습니다!\n");
                    System.out.print("\n★ 반영된 " + student.get(id)[0] + "학생(" + id + ")의 정보 ★\n");
                    System.out.print("이름 : " + student.get(id)[0]);
                    str = "";
                    for (int j = 0; j < student.get(id)[1].toString().length(); j++) str += (char) (student.get(id)[1].toString().charAt(j) >> 2);
                    System.out.print("\n주소 : " + str);
                    System.out.print("\n국어 : " + student.get(id)[2]);
                    System.out.print("\n영어 : " + student.get(id)[3]);
                    System.out.print("\n수학 : " + student.get(id)[4]);
                    sum = (int) student.get(id)[2] + (int) student.get(id)[3] + (int) student.get(id)[4];
                    System.out.print("\n총점 : " + sum);
                    System.out.print("\n평균 : " + (sum / 3) + "\n");
                    break;
                case "exit" :
                    System.out.print("\n프로그램을 종료합니다.");
                    flag = false;
                    break;
            }
        }
    }
}
