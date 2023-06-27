package quest.q627;

import java.util.*;

public class lcService {
    ArrayList<lcEmployee> emps = new ArrayList<>();

    public void test() {
        lcEmployee emp = new lcEmployee();
        emp.setDeptPosition("C");
        emps.add(emp);
        emp = new lcEmployee();
        emp.setDeptPosition("A");
        emps.add(emp);

        System.out.print(emps.get(0).getDeptPosition());
    }
}
