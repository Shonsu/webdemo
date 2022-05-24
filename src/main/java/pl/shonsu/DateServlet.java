package pl.shonsu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DateServlet")
public class DateServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //DateTime now = DateTime.now();
        PrintWriter responseOutput = response.getWriter();
        responseOutput.append("<html><body>" + "TEST" + "</body></html>");
    }
    
}
