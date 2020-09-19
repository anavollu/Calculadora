/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.calculator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalculatorServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalculatorServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("calculator.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
