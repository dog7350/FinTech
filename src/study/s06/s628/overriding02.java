package study.s06.s628;

import java.util.*;

class Test02 extends ArrayList<String> {
    public void test() {
        System.out.println("추가 기능");
    }

    @Override
    public boolean add(String s) {
        System.out.println("내용을 추가해주는 기능 실행");
        System.out.println("잘 동작 되나요??");
        return super.add(s);
    }
}

public class overriding02 {
    public static void main(String[] args) {
        Test02 t = new Test02();
        t.add("안녕하세요");
        System.out.println( t.get(0) );
        t.test();
    }
}
