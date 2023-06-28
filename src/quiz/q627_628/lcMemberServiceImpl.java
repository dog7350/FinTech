package quiz.q627_628;

import java.util.Scanner;

public class lcMemberServiceImpl implements lcMemberService {
    private static lcMemberServiceImpl instance = null;
    private lcMemberServiceImpl() {}
    public static lcMemberServiceImpl getInstance() {
        if (instance == null) instance = new lcMemberServiceImpl();
        return instance;
    }

    lcMemberDTO dto = new lcMemberDTO();
    Scanner sc = new Scanner(System.in);

    public void memberAdmin() {
        boolean flag = true;

        while (flag) {
            System.out.print("\n1. 회원 정보 등록\n2. 회원 정보 출력\n3. 회원 정보 수정\n4. 회원 정보 삭제\n5. 회원 관리 종료\n" +
                    "명령어 입력\n>> ");
            switch (sc.nextInt()) {
                case 1 :
                    craeteMember();
                    break;
                case 2 :
                    viewMember();
                    break;
                case 3 :
                    modifyMember();
                    break;
                case 4 :
                    deleteMember();
                    break;
                case 5 :
                    System.out.println("\n회원 관리 종료\n");
                    flag = false;
                    break;
            }
        }
    }

    @Override
    public void craeteMember() {
        System.out.print("\n회원 이름 입력\n>> ");
        dto.setName(sc.next());
        System.out.print("\n회원 주소 입력\n>> ");
        dto.setAddr(sc.next());
        System.out.print("\n회원 나이 입력\n>> ");
        dto.setAge(sc.nextInt());
        System.out.print("\n회원 정보 입력 완료\n");
    }

    @Override
    public void viewMember() {
        System.out.println("\n회원 명 : " + dto.getName());
        System.out.println("\n회원 주소 : " + dto.getAddr());
        System.out.println("\n회원 나이 : " + dto.getAge());
    }

    @Override
    public void modifyMember() {
        System.out.print("\n회원 이름 입력\n>> ");
        dto.setName(sc.next());
        System.out.print("\n회원 주소 입력\n>> ");
        dto.setAddr(sc.next());
        System.out.print("\n회원 나이 입력\n>> ");
        dto.setAge(sc.nextInt());
        System.out.print("\n회원 정보 수정 완료\n");
    }

    @Override
    public void deleteMember() {
        dto.setAge(0);
        dto.setName("");
        dto.setAddr("");
        System.out.print("\n회원 정보 삭제 완료\n");
    }
}
