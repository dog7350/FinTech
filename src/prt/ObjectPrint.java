package prt;

public class ObjectPrint {
    public static void prt(Object o) {
        System.out.print(o);
    }

    public static void arrPrt(Object[] o) {
        for (int i = 0; i < o.length; i++) System.out.println(o[i]);
    }
}
