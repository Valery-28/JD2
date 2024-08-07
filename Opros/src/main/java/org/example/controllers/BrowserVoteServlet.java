package org.example.controllers;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


@WebServlet(urlPatterns = "/vote")
public class BrowserVoteServlet extends HttpServlet{

    Map<String, Integer> singerMap = new HashMap<>();

    Map<String, Integer> styleMap = new HashMap<>();

    List<String> textCommentList = new ArrayList<>();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter writer = resp.getWriter();

        writer.write("<p>Best singer - " + singerMap + "</p>" );
        writer.write("<p>Best style - " + styleMap + "</p>");
        writer.write("<p>Last comment:  "+ textCommentList  + "</p>");

        writer.write("<t1>" + "GET" + "/t1");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
// SINGER
        String singerVal = req.getParameter("singer");

        if (singerVal != null) {
            if (singerMap.containsKey(singerVal)) {
                int repeatNumber = singerMap.get(singerVal);
                repeatNumber += 1;
                singerMap.put(singerVal, repeatNumber);
            } else singerMap.put(singerVal, 1);
        }

        String singerMaxKey = null;
        for (String key : singerMap.keySet()) {
            if (singerMaxKey == null || singerMap.get(key) >= singerMap.get(singerMaxKey)) {
                singerMaxKey = String.valueOf(key);
            }
        }
//SINGER
// STYLE
        String[] styleArr = req.getParameterValues("style");

        for (String styleRepeat: styleArr) {
            if (styleArr.length < 2 || styleArr.length > 4) {
                writer.write("Error, minimum 3 choice, maximum 5");
                break;
            }
            if (styleMap.containsKey(styleRepeat)) {
                int repeatNumber = styleMap.get(styleRepeat); //
                repeatNumber += 1;
                styleMap.put(styleRepeat, repeatNumber);
            } else styleMap.put(styleRepeat, 1);

        }
        String styleMaxKey = null;
        for(String key : styleMap.keySet()){
            if(styleMaxKey == null || styleMap.get(key) >= styleMap.get(styleMaxKey)){
                styleMaxKey = String.valueOf(key);
            }
        }

//STYLE
        String textComment = req.getParameter("message");

        if (!Objects.equals(textComment,(null))) {
            textCommentList.add(textComment);
        }
        writer.println("<html>");
        writer.write("<head>");
        writer.write("<title>info</title>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("<h1>VOTE</h1>");
        writer.write("<p>Best singer - " + singerMaxKey + "</p>");
        writer.write("<p>Best genres - " + styleMaxKey + "</p>");
        writer.write("<p>Last comment:  "+ textCommentList.get(textCommentList.size() - 1) + "</p>");
        writer.write("</body>");
    }
}
