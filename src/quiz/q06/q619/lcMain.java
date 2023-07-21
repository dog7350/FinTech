package quiz.q06.q619;

import java.util.*;

public class lcMain {
    public void lc619() {
        /*
            사용자에게 명령어를 입력받아 처리하는 프로그램을 작성하세요.
            "count" 명령어는 입력할 학생의 수를 입력받습니다.
                     > 학생 수를 입력 받지 않고 member나 grade 명령어를 입력하는 경우 "입력할 학생 수를 입력하세요"를 출력한 후 메인 메뉴로 돌아옵니다.
                     > 학생의 정보를 입력 중이라면 "이미 입력된 학생 수가 있습니다. 학생 정보를 전부 입력해주세요." 메시지를 출력합니다.
            "member" 명령어는 입력 사용자의 수 만큼 사용자의 이름과 주소를 입력받은 후 ArrayList memberDB에 저장 후 메인 메뉴로 돌아옵니다.
            "grade" 명령어는 입력 사용자의 수 만큼 사용자의 국어, 수학, 영어 성적을 차례대로 입력 받은 후 ArrayList gradeDB에 저장 후 메인 메뉴로 돌아옵니다.
            "print" 명령어는 입력 받은 정보를 아래와 같이 출력한 후 메인 메뉴로 돌아옵니다.
                만약, 학생 정보가 하나도 존재하지 않을 경우 "입력된 학생 정보가 없습니다." 메시지를 출력합니다. 학생의 정보를 입력 중이라면 "학생 정보를 전부 입력하세요" 메시지를 출력합니다.
                    ★ ㅇㅇㅇ 학생의 정보 ★
                     이름 : ㅇㅇㅇ
                     주소 : ㅇㅇㅇ
                     국어 : ㅇㅇㅇ
                     수학 : ㅇㅇㅇ
                     영어 : ㅇㅇㅇ
                     총점 : ㅇㅇㅇ
                     평균 : ㅇㅇㅇ \n
            "modify" 명령어는 학생의 이름을 입력받아 memberDB와 gradeDB의 정보를 수정하며, 학생이 존재하지 않을 경우 "존재하지 않는 학생입니다"를 출력합니다.
                    만약, 학생의 정보를 입력 중이라면 "학생 정보를 전부 입력하세요" 메시지를 출력합니다. 중복된 이름의 학생은 존재하지 않습니다.
            "remove" 명령어는 학생의 이름을 입력받아 memberDB와 gradeDB의 정보를 삭제한 후 "ㅇㅇㅇ 학생이 삭제되었습니다." 메시지를 출력하고, 학생이 존재하지 않을 경우 "존재하지 않는 학생입니다"를 출력합니다.
                    만약, 학생의 정보를 입력 중이라면 "학생 정보를 전부 입력하세요" 메시지를 출력합니다. 중복된 이름의 학생은 존재하지 않습니다.
            "exit" 명령어를 입력할 경우 프로그램을 종료합니다.
        */

        Scanner sc = new Scanner(System.in);
        String name = "";
        String cmd = "";
        int cnt = -1;
        boolean[] state = null;
        String[][] student = {};
        int[][] grade = {};
        boolean flag = true;
        ArrayList<String[]> memberDB = new ArrayList<>();
        ArrayList<int[]> gradeDB = new ArrayList<>();

        while (flag) {
            if (state != null && state[0] == true && state[1] == true) {
                state = null;
                cnt = 0;
            }

            System.out.print("\n명령어를 입력하세요 > ");
            cmd = sc.next();

            switch (cmd) {
                case "count" :
                    if (state != null) {
                        System.out.println("이미 입력된 학생 수가 있습니다.\n학생 정보를 전부 입력해주세요.");
                        break;
                    }
                    System.out.print("학생 수를 입력하세요 > ");
                    cnt = sc.nextInt();
                    student = new String[cnt][2];
                    grade = new int[cnt][3];
                    state = new boolean[] {false, false};
                    break;
                case "member" :
                    if (cnt == -1) {
                        System.out.println("학생 수를 입력하세요!");
                        break;
                    }
                    for (int i = 0; i < cnt; i++) {
                        System.out.println("\n" + (i + 1) + " 번째 학생");
                        System.out.print("학생 이름 : ");
                        student[i][0] = sc.next();
                        System.out.print("학생 주소 : ");
                        student[i][1] = sc.next();
                        memberDB.add(student[i]);
                    }
                    state[0] = true;
                    break;
                case "grade" :
                    if (cnt == -1) {
                        System.out.println("학생 수를 입력하세요!");
                        break;
                    }
                    for (int i = 0; i < cnt; i++) {
                        System.out.println("\n" + (i + 1) + " 번째 학생");
                        System.out.print("국어 점수 : ");
                        grade[i][0] = sc.nextInt();
                        System.out.print("수학 점수 : ");
                        grade[i][1] = sc.nextInt();
                        System.out.print("영어 점수 : ");
                        grade[i][2] = sc.nextInt();
                        gradeDB.add(grade[i]);
                    }
                    state[1] = true;
                    break;
                case "print" :
                    if (state != null && (state[0] == false || state[1] == false)) {
                        System.out.println("학생 정보를 전부 입력하세요.");
                        break;
                    } else if (memberDB.size() < 1) {
                        System.out.println("입력된 학생 정보가 없습니다.");
                        break;
                    }
                    for (int i = 0; i < memberDB.size(); i++) {
                        System.out.println("★ " + memberDB.get(i)[0] + " 학생의 정보 ★");
                        System.out.println("이름 : " + memberDB.get(i)[0]);
                        System.out.println("주소 : " + memberDB.get(i)[1]);
                        System.out.println("국어 : " + gradeDB.get(i)[0]);
                        System.out.println("수학 : " + gradeDB.get(i)[1]);
                        System.out.println("영어 : " + gradeDB.get(i)[2]);
                        System.out.println("총점 : " + (gradeDB.get(i)[0] + gradeDB.get(i)[1] + gradeDB.get(i)[2]));
                        System.out.println("평균 : " + (gradeDB.get(i)[0] + gradeDB.get(i)[1] + gradeDB.get(i)[2]) / 3 + "\n");
                    }
                    cnt = -1;
                    break;
                case "modify" :
                    if (state != null && (state[0] == false || state[1] == false)) {
                        System.out.println("학생 정보를 전부 입력하세요.");
                        break;
                    }
                    System.out.print("학생 이름 입력 > ");
                    name = sc.next();
                    for (int i = 0; i < memberDB.size(); i++)
                        if (memberDB.get(i)[0].contains(name)) {
                            System.out.print("주소 입력 > ");
                            String addr = sc.next();
                            System.out.print("국어 점수 : ");
                            int[] grd = new int[3];
                            grd[0] = sc.nextInt();
                            System.out.print("수학 점수 : ");
                            grd[1] = sc.nextInt();
                            System.out.print("영어 점수 : ");
                            grd[2] = sc.nextInt();
                            memberDB.set(i, new String[]{name, addr});
                            gradeDB.set(i, grd);
                        } else if (i >= memberDB.size() - 1) {
                            System.out.println("존재하지 않는 학생입니다.");
                        }
                    break;
                case "remove" :
                    if (state != null && (state[0] == false || state[1] == false)) {
                        System.out.println("학생 정보를 전부 입력하세요.");
                        break;
                    }
                    System.out.print("학생 이름 입력 > ");
                    name = sc.next();
                    for (int i = 0; i < memberDB.size(); i++)
                        if (memberDB.get(i)[0].contains(name)) {
                            memberDB.remove(i);
                            gradeDB.remove(i);
                            System.out.println(name + " 학생이 삭제되었습니다.");
                        } else if (i >= memberDB.size() - 1) {
                            System.out.println("존재하지 않는 학생입니다.");
                        }
                    break;
                case "exit" : flag = false; break;
            }
        }
    }
}
