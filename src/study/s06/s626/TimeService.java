package time;

import java.text.SimpleDateFormat;

public class TimeService {
	/*
	 서비스에서는 시간설정 및 가져오는 기능
	 시간 출력하는 내용은 return을 사용하여 main에서 출력
	 */
	
	private TimeDTO dto;
	public TimeService() {
		dto = new TimeDTO();
	}
	
	public void setStartTime() {
		System.out.println("서비스 시간설정");
		long start = System.currentTimeMillis();
		dto.setStart( start );
	}
	public String getStartTime() {
		//System.out.println( dto.getStart() );
		SimpleDateFormat s = 
				new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		//System.out.println( s.format(dto.getStart() ) );
		String sTime = s.format(dto.getStart() );
		return sTime;
	}
	public void setEndTime() {
		long end = System.currentTimeMillis();
		dto.setEnd( end );
		
		dto.setTotal( (end - dto.getStart()) / 1000 );
	}
	public String getEndTime() {
		SimpleDateFormat s = 
				new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		String eTime = s.format(dto.getEnd() );
		
		return eTime;
	}
	public String getResultTime() {
		//System.out.println( dto.getTotal() + "초 사용");
		
		long total = dto.getTotal();
		int m = (int)total / 60;
		int s = (int)total % 60;
		//System.out.println(m+"분 "+s+"초 사용");
		return m+"분 "+s+"초 사용";
	}
}















