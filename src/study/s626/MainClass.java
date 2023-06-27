package time;

import java.util.Scanner;

public class MainClass {
/*
	1.시작시간설정
	2.시작시간 확인(년월일시분초)
	3.종료시간설정
	4.종료시간 확인(년월일시분초)
	5.사용시간 가져오기
	 - ?시간 ?분 ?초 사용함
*/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num;
		TimeService time = new TimeService();
		while(true) {
			System.out.println("1.시작 시간 설정");
			System.out.println("2.시작 시간 확인");
			System.out.println("3.종료 시간 설정");
			System.out.println("4.종료 시간 확인");
			System.out.println("5.사용 시간 가져오기");
			System.out.print(">>> : ");
			num = input.nextInt();
			switch(num) {
			case 1:
				time.setStartTime();
				break;
			case 2:
				String sTime = time.getStartTime();
				System.out.println( sTime );
				break;
			case 3:
				time.setEndTime();
				break;
			case 4:
				String eTime = time.getEndTime();
				System.out.println( eTime );
				break;
			case 5:
				System.out.println( time.getResultTime() ); 
				break;
			}
		}
	}
}


















