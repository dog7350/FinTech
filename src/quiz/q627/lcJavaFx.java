package quiz.q627;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class lcJavaFx extends Thread {
    private boolean flag = true;
    public void run() {
        lcService service = lcService.getInstance();
        JFrame frame = null;
        JLabel label = null;
        Container c = null;

        while (flag) {
            frame = new JFrame("Time");

            c = frame.getContentPane();
            label = new JLabel("Quiz");

            c.add(label);
            label.setFont(new Font(null, 0, 32));
            label.setHorizontalAlignment(JLabel.CENTER);

            frame.setLocation(1000, 200);
            frame.setPreferredSize(new Dimension(500, 200));
            frame.pack();

            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            while (flag) label.setText(service.form.format(new Date().getTime()));
        }

        label.setText(new SimpleDateFormat("m분 s초 사용함!!").format(service.login.getTotal()));
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
