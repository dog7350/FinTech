package study.s628;

interface A02 {
    public void test1();
    public int test2();
}

class test02 implements A02 {
    @Override
    public void test1() {
        System.out.println("test1 실행");
    }

    @Override
    public int test2() {
        System.out.println("test2 실행");
        return 0;
    }
}

public class interface02 {
    public static void main(String[] args) {
        test02 t = new test02();
        t.test1();
        t.test2();
    }
}
