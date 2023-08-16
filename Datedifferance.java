import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Datedifferance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter date and time (DD-MM-YYYY hh:mm): ");
        String inputDate = scanner.nextLine();
        scanner.close();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        try {
            Date enteredDate = dateFormat.parse(inputDate);
            Date currentDate = new Date();

            long differenceMillis = enteredDate.getTime() - currentDate.getTime();

            if (differenceMillis < 0) {
                System.out.println("Invalid date.");
            } else {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(enteredDate);
                int enteredYear = calendar.get(Calendar.YEAR);
                int enteredMonth = calendar.get(Calendar.MONTH);
                int enteredWeek = calendar.get(Calendar.WEEK_OF_YEAR);
                int enteredDay = calendar.get(Calendar.DAY_OF_YEAR);

                calendar.setTime(currentDate);
                int currentYear = calendar.get(Calendar.YEAR);
                int currentMonth = calendar.get(Calendar.MONTH);
                int currentWeek = calendar.get(Calendar.WEEK_OF_YEAR);
                int currentDay = calendar.get(Calendar.DAY_OF_YEAR);

                long years = currentYear - enteredYear;
                long months = currentMonth - enteredMonth + years * 12;
                long weeks = currentWeek - enteredWeek + years * 52;
                long days = currentDay - enteredDay + years * 365;

                if (months == 0) {
                    System.out.println("Difference in weeks: " + weeks);
                } else if (weeks == 0) {
                    System.out.println("Difference in days: " + days);
                } else if (days == 0) {
                    long minutes = TimeUnit.MILLISECONDS.toMinutes(differenceMillis);
                    System.out.println("Difference in minutes: " + minutes);
                } else {
                    System.out.println("Difference in years: " + years);
                }
            }
        } catch (ParseException e) {
            System.out.println("Invalid date.");
        }
    }
}

