package study.s628;

class Ferrari {
    private int ye;
    public Ferrari(int ye) { this.ye = ye; }
    public int getYe() { return ye; }
    public void speed() {
        System.out.println(ye + "년식 페라리 속도 : 300km");
    }
}

class NewFerrari extends Ferrari {
    public void speed() {
        System.out.println(getYe() + "년식 페라리 속도 : 5000km");
    }

    public NewFerrari(int ye) {
        super(ye);
    }

    public void autoSystem() {
        System.out.println("자동 운전 모드로 전환합니다!!");
    }
}

public class overriding01 {
    public static void main(String[] args) {
        // Ferrari fe = new Ferrari(2023);
        // fe.speed();
        NewFerrari nFe = new NewFerrari(2024);
        nFe.speed();
        nFe.autoSystem();
    }
}
