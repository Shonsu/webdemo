package pl.shonsu;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Date", urlPatterns = { "/date" })
public class DateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date now = new Date();
            Date birthDate = sdf.parse("1982/02/09");
            long diffInMillies = Math.abs(now.getTime() - birthDate.getTime());
            long diffInSeconds = TimeUnit.SECONDS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            PrintWriter responseOutput = response.getWriter();

            // second way with ChronoUnits;

            LocalDate nowChU = LocalDate.now();
            LocalDate birthDateChU = LocalDate.parse("1982-02-09");
            // long diffChUinMiliseconds = ChronoUnit.MILLIS.between(birthDateChU,nowChU);
            // long diffChUInSeconds = ChronoUnit.SECONDS.between(birthDateChU, nowChU);
            long diffChUinDays = ChronoUnit.DAYS.between(birthDateChU, nowChU);
            long diffChUiNMonths = ChronoUnit.MONTHS.between(birthDateChU, nowChU);
            long diffChUiNYears = ChronoUnit.YEARS.between(birthDateChU, nowChU);

            responseOutput.append("<html><body>");
            responseOutput.append(
                    "</br>Birth date: "
                            + sdf.format(birthDate)
                            + "</br> Time now: " + sdf.format(now)
                            + "</br>Difference in miliseconds: " + diffInMillies
                            + "</br>Difference in seconds: " + diffInSeconds
                            + "</br>Difference in days: " + diffInDays
                            + "</br>");

            responseOutput.append(
                    "With ChronoUnits:</br>Birth date: "
                            + birthDateChU
                            + "</br> Time now: " + nowChU
                            + "</br>Difference in years: " + diffChUiNYears
                            + "</br>Difference in months: " + diffChUiNMonths
                            + "</br>Difference in days: " + diffChUinDays);
            responseOutput.append("</body></html>");
        } catch (ParseException | DateTimeParseException exception) {
            exception.printStackTrace();
        }

    }

}
