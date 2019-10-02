package ch.heigvd.amt.mvcsimple.presentation;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CounterServlet", urlPatterns = "/counter")
public class CounterServlet extends HttpServlet {

    private int counter = 0;

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
        String command = request.getParameter("command");
        if ("reset".equals(command)){
            counter = 0;
        } else {
            synchronized (this){
                counter = counter + 1;
            }
        }
        response.getWriter().println("This page has been accessed " + counter + " time(s).");
    }

}
