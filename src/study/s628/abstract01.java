package study.s628;

abstract class Test01 {
    public abstract void func();
    public void test() { System.out.println("test 기능"); }
}

class TestClass01 extends Test01 {
    public void test01() { System.out.println("새로운 기능"); }
    public void func() {
        System.out.println("aaa");
    }
}

public class abstract01 {
    public static void main(String[] args) {
        TestClass01 t = new TestClass01();
    }
}
