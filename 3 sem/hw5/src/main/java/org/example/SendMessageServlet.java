package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
public class SendMessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String name = (String) httpSession.getAttribute("name");
        if (name == null){
            resp.sendRedirect("http://localhost:8080/servlets1/name");
        }
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Sign Up</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form action=\"/servlets1/send\" method=\"post\">\n" +
                "    <input name=\"name\" type=\"text\" placeholder=\"name\">\n" +
                "    <input name=\"message\" type=\"text\" placeholder=\"message\">\n" +
                "    <input type=\"submit\">\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String message = req.getParameter("message");
//        BufferedReader reader = req.getReader();
//        String message = reader.readLine().split("=")[1];
//        message = message.replace('+',' ');
        String sender = (String) req.getSession().getAttribute("name");
        Message message1 = Message.builder().sender(sender).receiver(name).text(message).build();
        MessageContainer.messages.add(message1);
    }

}
