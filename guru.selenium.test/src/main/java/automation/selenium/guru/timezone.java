package automation.selenium.guru;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class timezone {
		
			public static void main(String[] args) throws ParseException {
				String input = "Mon, Jun 27, 2022 [ 08:30 PM - 09:00 PM ]";
				String[] timesplit = input.split("\\[");
				String[] times = timesplit[1].split("-")[0].trim().split(" ");
				String time = times[0];
				String[] hours = time.split(":");
				String hour ="";
				if ( "PM".equals(times[1])) {
					hour = String.valueOf(Integer.parseInt(hours[0])+12);			
				} else {
					hour = hours[0];
				}
				
				String min = hours[1];
				String timeStr = hour+":"+min+":00 MST";
				String dateInString = timesplit[0]+timeStr;
				System.out.println(dateInString);
				
				String tmp = "Mon, 27 Jun 2022 20:30:00 MST";
				
				String DATE_FORMAT = "E, dd MMM yyyy HH:mm:ss z";
				
				SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);

		        Date date = formatter.parse(tmp);       

		        // To TimeZone America/New_York
		        SimpleDateFormat outputFormat = new SimpleDateFormat(DATE_FORMAT);
		        TimeZone outputTimeZone = TimeZone.getTimeZone("Asia/Kolkata");
		        outputFormat.setTimeZone(outputTimeZone);
		        
		        String outputDateString = outputFormat.format(date); // Convert to String first
		        Date output = formatter.parse(outputDateString); // Create a new Date object

		        System.out.println( output);

			}

		
	}


