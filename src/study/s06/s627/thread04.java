package study.s06.s627;


import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

class A04 extends Thread {
    public void run() {
        Scanner sc = new Scanner(System.in);
        String str;
        while (true) {
            System.out.print("입력 : ");
            str = sc.next();
            System.out.println("값 : " + str);
        }
    }
}

public class thread04 {
    public static void main(String[] args) {
        A04 a = new A04();
        a.start();

        JFrame frame = new JFrame("제목");

        Container c = frame.getContentPane();
        JLabel label = new JLabel("test gui");

        c.add(label);
        label.setFont(new Font(null, 0, 32));
        label.setHorizontalAlignment(JLabel.CENTER);

        frame.setLocation(1000, 200);
        frame.setPreferredSize(new Dimension(500, 200));
        frame.pack();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0;; i++) label.setText("" + i);
    }
}
