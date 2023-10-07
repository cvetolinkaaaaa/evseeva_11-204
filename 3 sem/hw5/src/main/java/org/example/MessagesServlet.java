package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class MessagesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>");
        for (int i = 0; i < MessageContainer.messages.size(); i++) {
            if (MessageContainer.messages.get(i).getReceiver().equals( httpSession.getAttribute("name"))) {
                printWriter.println("<p>" + MessageContainer.messages.get(i).getSender()
                        + ":" + MessageContainer.messages.get(i).getText() +"</p>");
            }
        }
        printWriter.println("</body>\n" +
                "</html>");
    }
}
