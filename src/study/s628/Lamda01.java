package study.s628;

interface interfaceLamda01 {
    public void test();
}

class LamdaTest01 implements interfaceLamda01 {
    public void test() {
        System.out.println("Test 실행");
    }
}

public class Lamda01 {
    public static void main(String[] args) {
        LamdaTest01 t01 = new LamdaTest01();
        t01.test();
        System.out.println("====================================");

        interfaceLamda01 t02 = new interfaceLamda01() {
            public void test() {
                System.out.println("인터페이스");
            }
        };
        t02.test();
        System.out.println("====================================");

        interfaceLamda01 t03 = () -> System.out.println("람다 실행");
        t03.test();
    }
}
