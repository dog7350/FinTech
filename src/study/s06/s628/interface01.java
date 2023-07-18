package study.s06.s628;

interface A01 {}
interface B01 {
    public void test();
}

class C01 {
    public void test1() {

    }
}

class interfaceTest01 extends C01 implements A01, B01 {
    @Override
    public void test() {

    }
}

public class interface01 {
}
