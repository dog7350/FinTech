package quiz.q06.q626;

import java.text.*;
import java.util.*;

public class bfService {
    bfDto dTime = bfDto.getInstance();
    SimpleDateFormat form = new SimpleDateFormat("yyyy년 M월 d일 / h시 m분 s초");

    public void startTime() {
        dTime.setStart(new Date().getTime());
    }

    public void startStatus() {
        System.out.println(form.format(dTime.getStart()));
    }

    public void endTime() {
        dTime.setEnd(new Date().getTime());
    }

    public void endStatus() {
        System.out.println(form.format(dTime.getEnd()));
    }

    public void totalTime() {
        dTime.setTotal(dTime.getEnd() - dTime.getStart());
        System.out.println(new SimpleDateFormat("h시간 m분 s초 사용함!!").format(dTime.getTotal()));
    }
}
