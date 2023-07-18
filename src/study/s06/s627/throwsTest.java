package study.s06.s627;

class TestClass {
    public void test1() throws Exception {
        System.out.print("\nTest1");
        test2();
    }

    public void test2() throws Exception {
        System.out.print("\nTest2");

        /*
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
        */
        Thread.sleep(2000);
    }
}

public class throwsTest {
    public static void main(String[] args) throws Exception {
        TestClass t = new TestClass();
        t.test1();
    }
}
