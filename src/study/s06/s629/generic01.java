package study.s06.s629;

class genericClass01< T > {
    public void sumFunc(T n1, T n2) {
        System.out.println(n1 + ", " + n2);
    }
}

public class generic01 {
    public static void main(String[] args) {
        genericClass01<Integer> g1 = new genericClass01();
        g1.sumFunc(10, 20);
        genericClass01<String> g2 = new genericClass01();
        g2.sumFunc("aaa", "bbb");
    }
}
