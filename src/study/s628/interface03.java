package study.s628;

import java.util.*;

interface interfaceTest03 {
    public int num = 0;
    public static final String name = "홍길동";
    public static String name1 = "홍길동";
    public final String name2 = "홍길동";
}

class A지상군 implements Army {
    public void attack() { System.out.println("지상군 공격"); }
    public void defense() { System.out.println("지상군 방어"); }
}

class B공군 implements Army {
    public void attack() { System.out.println("비행기 공격"); }
    public void defense() { System.out.println("비행기 방어"); }
}

public class interface03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        Scanner sc = new Scanner(System.in);

        Army a;
        System.out.println("적이 쳐들어왔습니다.");

        System.out.println("1. 지상군 / 2. 공군");
        if (sc.nextInt() == 1) a = new A지상군();
        else  a = new B공군();

        System.out.println("1. 공격 / 2. 방어");
        if (sc.nextInt() == 1) a.attack();
        else a.defense();
    }
}
