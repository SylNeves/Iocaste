package org.iocaste.protocol;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;

public abstract class ServerServlet extends IocasteServlet {
    private static final long serialVersionUID = 7408336035974886402L;
    private SessionFactory sessionFactory;
    private Map<String, Function> functions;
    private String url;
    
    public ServerServlet() {
        functions = new HashMap<String, Function>();
        sessionFactory = HibernateListener.getSessionFactory();
        config();
    }

    @Override
    protected final void entry() throws Exception {
        Message message;
        Function function;
        Service service = serviceInstance(url);
        
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
    
    protected final void setUrl(String url) {
        this.url = url;
    }
    
    protected abstract void config();
}
