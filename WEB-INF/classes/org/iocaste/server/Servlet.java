package org.iocaste.server;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iocaste.protocol.Iocaste;
import org.iocaste.protocol.Message;
import org.iocaste.protocol.Service;


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
        Service service = new Service();
        Message message = new Message();
        
        service.setInputStream(req.getInputStream());
        service.setOutputStream(resp.getOutputStream());
        
        try {
            message = service.getMessage();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        switch(message.getId()) {
        case Iocaste.LOGIN:
            System.out.println("tentativa de login");
            message.clear();
            message.add("return", true);
            
            service.messageReturn(message);
            break;
        }
    }

}
