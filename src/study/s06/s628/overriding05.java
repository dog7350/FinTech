package study.s06.s628;

class test05 {
    public void test1() {}
}

class testClass05 extends test05 {

}

public class overriding05 {
    public static void main(String[] args) {
        test05 t = new test05();
        System.out.println( t.getClass() );
        System.out.println( t.toString() );
    }
}
