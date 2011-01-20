package org.iocaste.server;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iocaste.protocol.Message;


public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 7408336035974886402L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(resp.getOutputStream());
        Message message = new Message();
        
        message.add("teste", "chamado de server");
        out.writeObject(message);
        System.out.println("chamado.");
    }

}
