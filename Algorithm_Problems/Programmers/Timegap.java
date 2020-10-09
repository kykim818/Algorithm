import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class time_gap {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String  time = "10/01 23:20:25 30";
		String[] arr = time.split(" ");
		String date = arr[0]+" "+arr[1];
		SimpleDateFormat f = new SimpleDateFormat("MM/dd HH:mm:ss");
		int minute = Integer.parseInt(arr[2]);
		Date tempDate = f.parse(date);
		String start = null;
		start = f.format(tempDate);
		System.out.println(start);
		Calendar cal = Calendar.getInstance();
		cal.setTime(tempDate);
		System.out.println("경과시간 :" + minute );
		cal.add(Calendar.MINUTE, minute);
		String endTime = null;
		endTime = f.format(cal.getTime());
		System.out.println(endTime);
	}

}