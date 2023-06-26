package quest.q623;

import java.util.*;

public class lcModule {
    Scanner sc = new Scanner(System.in);

    ArrayList<lcStudent> students = new ArrayList<>();

    private int cnt = -1;
    public void setCnt(int cnt) { this.cnt = cnt; }

    public void insert() {
        if (cnt == -1) {
            System.out.print("\n학생의 수를 입력하세요!\n");
            return;
        }
        for (int i = 0; i < cnt; i++) {
            lcStudent stu = new lcStudent();
            ist(stu);
            students.add(stu);
            System.out.print(stu.getName() + " 학생의 정보가 입력되었습니다.\n");
        }
        cnt = -1;
    }

    public void modify(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                ist(students.get(i));
                System.out.print(students.get(i).getName() + " 학생의 정보가 수정되었습니다.");
                return;
            }
        }
        System.out.print("\n" + id + " 학생은 존재하지 않습니다.\n");
    }

    public void delete(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                System.out.print(students.get(i).getName() + " 학생이 퇴학 처리되었습니다.");
                students.remove(i);
                return;
            }
        }
        System.out.print("\n" + id + " 학생은 존재하지 않습니다.\n");
    }

    public void search(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                System.out.print("\n검색된 " + id + " 학생의 정보\n");
                prt(students.get(i));
                return;
            }
        }
        System.out.print("\n" + id + " 학생은 존재하지 않습니다.\n");
    }

    public void event() {
        System.out.print("\n이벤트 추첨을 진행합니다.\n");
        int num = new Random().nextInt(students.size());

        System.out.print("\n경축! " + students.get(num).getName() + " 학생께서 이벤트에 당첨되셨습니다!\n");
        int kor = (students.get(num).getKor() + 10) > 100 ? 100 : students.get(num).getKor() + 10;
        int math = (students.get(num).getMath() + 10) > 100 ? 100 : students.get(num).getMath() + 10;
        int eng = (students.get(num).getEng() + 10) > 100 ? 100 : students.get(num).getEng() + 10;
        int sum = kor + math + eng;
        float avg = sum / 3;
        students.get(num).setKor(kor);
        students.get(num).setMath(math);
        students.get(num).setEng(eng);
        students.get(num).setSum(sum);
        students.get(num).setAvg(avg);
        System.out.print("\n★ 반영된 " + students.get(num).getName() + "학생(" + students.get(num).getId() + ")의 정보 ★\n");
        prt(students.get(num));
    }

    public void print() {
        if (students.size() <= 0) {
            System.out.print("\n입력된 학생 정보가 없습니다.\n");
            return;
        }
        for (int i = 0; i < students.size(); i++) {
            System.out.println("\n★★★ " + students.get(i).getName() + " 학생의 정보 ★★★\n");
            prt(students.get(i));
        }
    }

    private void ist(lcStudent s) {
        System.out.print("\n학생 이름 : ");
        s.setName(sc.next());
        System.out.print("\n학생 주소 : ");
        s.setAddr(sc.next());
        System.out.print("\n학생 ID : ");
        s.setId(sc.next());
        System.out.print("\n학생 PW : ");
        s.setPw(sc.next());
        System.out.print("\n국어 점수 : ");
        s.setKor(sc.nextInt());
        System.out.print("\n수학 점수 : ");
        s.setMath(sc.nextInt());
        System.out.print("\n영어 점수 : ");
        s.setEng(sc.nextInt());
        s.setSum(s.getKor() + s.getMath() + s.getEng());
        s.setAvg(s.getSum() / 3);
    }

    private void prt(lcStudent s) {
        System.out.println("\n학생 이름 : " + s.getName());
        System.out.println("\n학생 주소 : " + s.getAddr());
        System.out.println("\n학생 ID : " + s.getId());
        System.out.println("\n학생 PW : " + s.getPw());
        System.out.println("\n국어 점수 : " + s.getKor());
        System.out.println("\n수학 점수 : " + s.getMath());
        System.out.println("\n영어 점수 : " + s.getEng());
        System.out.println("\n총점 : " + s.getSum());
        System.out.println("\n평균 : " + s.getAvg());
    }
}
