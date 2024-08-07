package org.example.old;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/print_all_name_3")
public class PrintOnlyName3Servlet extends HttpServlet {

    private final static String PARAM_NAME_HEADER = "param_name";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        String headerValue = req.getHeader(PARAM_NAME_HEADER);

        String[] names = req.getParameterValues(headerValue);

        for (String name : names) {
            writer.write("<p>" + req.getParameter(name) + "</p>");
        }
    }
}