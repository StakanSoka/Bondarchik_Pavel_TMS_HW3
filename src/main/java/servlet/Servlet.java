package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Servlet extends HttpServlet {
    public static final String parameterDateName = "d";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String unformattedDate = req.getParameter(parameterDateName);
        Calendar calendar = new GregorianCalendar();
        Date date;
        DateFormat formatter = new SimpleDateFormat("dd-MM-y");
        PrintWriter writer = resp.getWriter();

        if (unformattedDate != null) {
            try {
                date = formatter.parse(unformattedDate);
                calendar.setTime(date);
                int numberDayWeek = calendar.get(Calendar.DAY_OF_WEEK);
                writer.println("the day of the week: " +
                        calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH));
            } catch (ParseException e) {
                System.out.println(e.getMessage());
                writer.println("the date has been written incorrectly");
            }
        } else {
            writer.println("you have not written the date");
        }


    }
}
