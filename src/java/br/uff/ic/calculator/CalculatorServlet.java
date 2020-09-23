package br.uff.ic.calculator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("calculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String arg1 = request.getParameter("arg1");
        String arg2 = request.getParameter("arg2");
        String op = request.getParameter("operation-select");
        Double v1 = Double.parseDouble(arg1);
        Double v2 = Double.parseDouble(arg2);
        Double result;
        if (op.equals("sum")) {
            result = v1 + v2;
            request.setAttribute("op", "+");
        } else if (op.equals("subtract")) {
            result = v1 - v2;
            request.setAttribute("op", "-");
        } else if (op.equals("multiply")) {
            result = v1 * v2;
            request.setAttribute("op", "x");
        } else {
            result = v1 / v2;
            request.setAttribute("op", "/");
        }
        request.setAttribute("result", result);
        request.setAttribute("arg1", arg1);
        request.setAttribute("arg2", arg2);

        Cookie[] cookies = request.getCookies();
        String accessNumberValue = "1";
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                String cookieName = cookie.getName();
                if (cookieName.equals("accessNumber")) {
                    int accessNumber = Integer.parseInt(cookie.getValue());
                    accessNumber += 1;
                    accessNumberValue = accessNumber + "";
                }
            }
        }
        Cookie cookie = new Cookie("accessNumber", accessNumberValue);
        response.addCookie(cookie);
        request.setAttribute("accessNumber", accessNumberValue);

        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
