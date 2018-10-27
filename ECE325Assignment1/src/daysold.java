/**
 *Nicholas Serrano
 * Assignment 1: Using standard libraries <br />
 * Calculate age in days
 */
import java.util.*; 
import java.text.*;
import java.time.temporal.ChronoUnit;  //used to find days between
public class daysold {

    /**
     * Calculate how many days between today and the date, and them out
     * @param birthday      {@code String} The start date
     * @throws ParseException 
     */
    public static void days(String birthday) throws ParseException {
        // TODO: Assignment 1 -- write your code here.
    	
    	Calendar newcal = Calendar.getInstance(); //This gives us todays date
        
    	//birthday = birthday.replaceAll("[^-?0-9]+", " "); 
        //birthcal.set(Calendar.MONTH, 0);
    	//int curryear = newcal.get(Calendar.YEAR);
    	//int currday = newcal.get(Calendar.DATE);
    	
    	//**These commented out lines are for me for future reference*
    	
    	String pattern = "yyyy-MM-dd";
    	SimpleDateFormat inputFormat = new SimpleDateFormat(pattern);
    	Date date = inputFormat.parse(birthday);  //use SimpleDateFormat to get date from input
    	
    	Calendar birthcal = inputFormat.getCalendar();  //getCalendar will make a calendar from a date/time formatter
    	
		String outputpattern = "yyyy-MMMMM-dd";
		SimpleDateFormat outputFormat = new SimpleDateFormat(outputpattern);
		String outdate = outputFormat.format(date);  //getting the output to look like the format in the example

		//System.out.println(newcal.getTime());
		
    	if(birthcal.after(newcal)) { //the after is a method that checks if calendar is after a specific date
    		System.out.println("Birthday: " + outdate + ";" + " Today: " + outputFormat.format(new Date()) + "; -- Wrong Birthday!");
    	}
    	else {
    		long daysBetween = ChronoUnit.DAYS.between(birthcal.toInstant(), newcal.toInstant()); //ChronoUnit has a convenient method for finding the days
    		System.out.println("Birthday: " + outdate + ";" + " Today: " + outputFormat.format(new Date()) +"; You are " + daysBetween + " days old.");
    	}
    	//System.out.println("Your Birthday is: " + birthcal.getTime());
    	//System.out.println("The current year is: " + newcal.getTime());
      
    } // public static void days(String birthday)

    /**
     * Main entry
     * @param args          {@code String[]} Command line arguments
     * @throws ParseException 
     */
    
    public static void main(String[] args) throws ParseException {
        days("2000-1-1");
        days("3000-1-1");           // This is a wrong birthday
    } // public static void main(String[] args)
}