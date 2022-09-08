package automation.selenium.guru;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class calendarexample {

	
	// This is sample class which used to experiment the timezone conversion
	public static void main(String[] args) throws ParseException {
	
		String date_actual = "Thu, Jun 30, 2022";
		String time = "11:30 AM";
		System.out.println(get_account_appointment_time(date_actual,time,"GMT+09:00 Asia/Seoul (GMT+9)"));
		String date_s = ""+date_actual+", "+ ""+time+"";
		SimpleDateFormat dt = new SimpleDateFormat("EEE, MMM d, yyyy, h:mm a");
		TimeZone tzInAmerica = TimeZone.getTimeZone("Asia/Almaty");
		dt.setTimeZone(tzInAmerica);
		Date date_new = dt.parse(date_s);// this will parse the date to current system timezone
		//System.out.println(date_new);
		String output_date = new SimpleDateFormat("MMM d yyyy, h:mm a").format(date_new);
		//System.out.println(output_date);
		
	}
	
	public static String get_local_appointment_time(String user_apt_date, String user_apt_time, String user_timezone) throws ParseException {
		String user_date_s = ""+user_apt_date+", "+ ""+user_apt_time+"";
		user_timezone= user_timezone.split(" ")[1];
		SimpleDateFormat dt = new SimpleDateFormat("EEE, MMM d, yyyy, hh:mm a");
		TimeZone user_tz = TimeZone.getTimeZone(user_timezone);
		dt.setTimeZone(user_tz);
		Date date_new = dt.parse(user_date_s);// this will parse the date to current system timezone
		System.out.println(date_new);
		String output_date = new SimpleDateFormat("MMM d yyyy, hh:mm a").format(date_new);
		System.out.println(output_date);
		return output_date;
		
	}
	
	public static String get_account_appointment_time(String user_apt_date, String user_apt_time, String user_timezone) throws ParseException {
		String acc_timezone = "Asia/Kolkata";
		String user_date_s = ""+user_apt_date+", "+ ""+user_apt_time+"";
		user_timezone= user_timezone.split(" ")[1];
		SimpleDateFormat dt = new SimpleDateFormat("EEE, MMM d, yyyy, hh:mm a");
		TimeZone user_tz = TimeZone.getTimeZone(user_timezone);
		dt.setTimeZone(user_tz);
		Date date_new = dt.parse(user_date_s);// this will parse the date to current system timezone
		
		SimpleDateFormat new_dt = new SimpleDateFormat("MMM d yyyy, hh:mm a");
		TimeZone acc_tz = TimeZone.getTimeZone(acc_timezone);
		new_dt.setTimeZone(acc_tz);
		String output_date = new_dt.format(date_new);
		System.out.println(output_date);
		return output_date;
		
	}

}
