package quiz.q06.q627;

/*
회사 (회사명, 부서명, 직급[사장, 부장, 차장, 과장, 사원])
사원 (사원 번호, 사원명, 급여, 출근 시간, 퇴근 시간, 근무 시간)

1. 정보 입력
2. 정보 수정
3. 정보 삭제
4. 출력 (일반 출력, 회사별 정렬, 직급별 정렬, 급여별 정렬)
5. 직급 상승 or 급여 상승 이벤트
6. 출근 시간 입력 (사원 번호)
7. 퇴근 시간 입력 (사원 번호) > 근무 시간 출력
  > 8시간 근무량을 채우지 못 할 경우 급여 삭감
6. 프로그램 종료

클래스 종류 : Main, Service(Single), Employee, Company

회사 사원 정보 관리 프로그램을 작성합니다.
사원 클래스는 회사 클래스를 상속 받으며, 서비스 클래스는 싱글톤 모델로 구성합니다.
모든 기능은 각 함수로 별도 구현하며, 4번 출력의 경우 사용자의 요청을 받아 출력 형태를 결정합니다.
  > 직급별 정렬과 급여별 정렬은 회사별 정렬을 우선 적용 후 출력합니다.
  > 어려운 경우 정렬 기능 패스
5번 이벤트 항목의 경우 직급 상승 이벤트 또는 급여 상승 이벤트가 랜덤적으로 작동하며, 모든 사원을 대상으로 한 명을 선정하여 적용합니다.
  > 사장 이상의 직급은 존재할 수 없습니다.
출퇴근 시간의 입력은 사원 번호를 입력받아 개인별로 적용합니다.
근무 시간 미달로 인한 급여 삭감이 적용될 경우 급여는 0보다 작을 수 없습니다.
*/

import java.util.*;

public class lcMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        lcService service = new lcService();

        int cmd;
        boolean flag = true;

        while (flag) {
            System.out.print("\n명령어 입력 >> ");
            cmd = sc.nextInt();

            service.test();
            /*
            switch (cmd) {

            }
            */
        }
    }
}
