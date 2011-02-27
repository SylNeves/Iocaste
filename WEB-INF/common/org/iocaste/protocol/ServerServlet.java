package org.iocaste.protocol;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class ServerServlet extends HttpServlet {
    private static final long serialVersionUID = 7408336035974886402L;
    private Service service;
    private SessionFactory sessionFactory;
    private Map<String, Function> functions;
    
    public ServerServlet() {
        service = new Service();
        functions = new HashMap<String, Function>();
        sessionFactory = new Configuration().configure().buildSessionFactory();
        config();
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
        Function function;
        
        service.setInputStream(req.getInputStream());
        service.setOutputStream(resp.getOutputStream());
        
        try {
            message = service.getMessage();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        function = functions.get(message.getId());
        
        try {
            service.messageReturn(message, function.run(message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    protected final void addFunction(String name, Function function) {
        functions.put(name, function);
        function.setSessionFactory(sessionFactory);
    }
    
    protected abstract void config();
}
