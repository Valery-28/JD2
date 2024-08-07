package org.example.old;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/print_all_name_2")
public class PrintOnlyName2Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        Enumeration<String> params  = req.getParameterNames();

        while (params.hasMoreElements()){
            String paramName = params.nextElement();
            if(paramName.contains("_name")){
                String[] names = req.getParameterValues(paramName);

                for (String name : names) {
                    writer.write("<p>" + req.getParameter(name) + "</p>");
                }
            }
        }
    }
}