package quiz621;

import static prt.ObjectPrint.*;
import java.util.*;

public class ModuleOne {
    Scanner sc = new Scanner(System.in);

    public void names(int num) {
        String[] names = new String[num];
        for (int i = 0; i < num; i++) {
            prt("\n이름 입력\n>> ");
            names[i] = sc.next();
        }
        arrPrt(names);
    }
}
