package study.s06.s628;

final class Test03 {
    public void test() {
        System.out.println("부모의 기능");
    }
}
class TestClass03 {
    public void test() {
        Test03 t = new Test03();
        System.out.println("자식의 기능 실행");
    }
}

public class overriding03 {
    public static void main(String[] args) {

    }
}
