package study.s06.s628;

class Test06 {
    String name = "홍길동";
    int age = 20;

    @Override
    public String toString() {
        return "Test : " + name + ", " + age;
    }
}

public class overriding06 {
    public static void main(String[] args) {
        Test06 t = new Test06();
        System.out.println(t);
        System.out.println(t.toString());
    }
}
