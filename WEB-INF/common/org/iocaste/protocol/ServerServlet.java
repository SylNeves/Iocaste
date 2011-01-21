package org.iocaste.protocol;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ServerServlet extends HttpServlet {
    private static final long serialVersionUID = 7408336035974886402L;
    private Service service;

    public ServerServlet() {
        service = new Service();
    }
    
    @Override
    protected final void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected final void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Message message;
        
        service.setInputStream(req.getInputStream());
        service.setOutputStream(resp.getOutputStream());
        
        try {
            message = service.getMessage();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        
        init(service, message);
    }
    
    /**
     * Ponto de entrada do servidor
     * @param service
     * @param message
     */
    protected abstract void init(Service service, Message message);
}
