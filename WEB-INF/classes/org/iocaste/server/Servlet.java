package org.iocaste.server;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.iocaste.components.login.Login;

import org.iocaste.protocol.Function;
import org.iocaste.protocol.Message;
import org.iocaste.protocol.ServerServlet;
import org.iocaste.protocol.Service;

public class Servlet extends ServerServlet {
    private static final long serialVersionUID = -8569034003940826582L;
    private Map<String, Function> functions;
    
    public Servlet() {
        functions = new HashMap<String, Function>();
        functions.put("login", new Login());
    }
    
    /*
     * (non-Javadoc)
     * @see org.iocaste.protocol.ServerServlet#init(org.iocaste.protocol.Service, org.iocaste.protocol.Message)
     */
    @Override
    protected void init(Service service, Message message) {
        Function function = functions.get(message.getId());
        try {
            service.messageReturn(message, function.run(message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
