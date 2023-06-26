package quest.q620;

import static prt.ObjectPrint.*;
import java.util.*;

public class bfMain {
    public void bf620() {
        Scanner sc = new Scanner(System.in);

        boolean flag = true;
        Map<String, String> menu = new HashMap<>();
        String name;
        String price;
        while (flag) {
            prt("\n1. 메뉴 등록");
            prt("2. 메뉴별 가격 보기");
            prt("3. 종료");
            System.out.print(">>> ");
            int cmd = sc.nextInt();

            switch (cmd) {
                case 1 :
                    System.out.print("메뉴 명 : ");
                    name = sc.next();
                    System.out.print("가격 : ");
                    price = sc.next();
                    prt("등록되었습니다.");
                    menu.put(name, price);
                    break;
                case 2 :
                    int i = 1;
                    Iterator<String> it = menu.keySet().iterator();
                    while (it.hasNext()) {
                        String key = it.next();
                        prt("\n" + (i++) + ". " + key + " : " + menu.get(key));
                    }
                    prt("\n1. 수정 / 2. 삭제 / 3. 나가기");
                    System.out.print(">>> ");
                    cmd = sc.nextInt();
                    switch (cmd) {
                        case 1 :
                            prt("가격을 수정할 메뉴명 입력");
                            System.out.print(">>> ");
                            name = sc.next();
                            if (!menu.containsKey(name)) {
                                prt("존재하지 않는 메뉴입니다.");
                                break;
                            }
                            prt("가격 입력");
                            System.out.print(">>> ");
                            price = sc.next();
                            menu.put(name, price);
                            prt("삭제되었습니다.");
                            break;
                        case 2 :
                            prt("삭제할 메뉴명 입력");
                            System.out.print(">>> ");
                            name = sc.next();
                            if (!menu.containsKey(name)) {
                                prt("존재하지 않는 메뉴입니다.");
                                break;
                            }
                            menu.remove(name);
                            prt("삭제되었습니다.");
                            break;
                        case 3 :
                            break;
                    }
                    break;
                case 3 :
                    flag = false;
                    break;
            }
        }
    }
}
