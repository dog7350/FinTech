package study.s06.s627;

class MyThread {
    public void start() {
        run();
    }
    public void run() {
        System.out.print("\n부모 run\n");
    }
}

class A02 extends MyThread {
    public void run() {
        System.out.print("\n자식 run 실행\n");
    }
}

public class thread02 {
    public static void main (String[] args) {
        A02 a = new A02();
        a.start();
    }
}
