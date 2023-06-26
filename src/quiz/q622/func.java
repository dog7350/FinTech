package quiz.q622;

import static prt.ObjectPrint.*;
import java.util.*;

public class func {
    public String name, grade;
    public int kor, eng, math, sum;
    public double avg;

    Scanner sc = new Scanner(System.in);

    public void insert() {
        prt("\n이름 입력 : ");
        name = sc.next();
        prt("\n국어 성적 : ");
        kor = sc.nextInt();
        prt("\n영어 성적 : ");
        eng = sc.nextInt();
        prt("\n수학 성적 : ");
        math = sc.nextInt();
    }

    public void exec() {
        sum = kor + eng + math;
        avg = (double) sum / 3;
        prt("\n연산 완료");
    }

    public void funPrint() {
        prt("\n이름 : " + name);
        prt("\n국어 : " + kor);
        prt("\n영어 : " + eng);
        prt("\n수학 : " + math);
        prt("\n총합 : " + sum);
        prt("\n평균 : " + avg);
        prt("\n성적 : " + grade);
    }

    public void grade() {
        grade = ((eng >= 90) ? "A" : (eng >= 80) ? "B" : "C");
        prt("\n등급 완료");
    }
}
