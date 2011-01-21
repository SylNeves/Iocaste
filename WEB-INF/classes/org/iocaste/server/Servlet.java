package org.iocaste.server;
import java.io.IOException;

import org.iocaste.protocol.Iocaste;
import org.iocaste.protocol.Message;
import org.iocaste.protocol.ServerServlet;
import org.iocaste.protocol.Service;

public class Servlet extends ServerServlet {
    private static final long serialVersionUID = -8569034003940826582L;

    public Servlet() {
        System.out.println("construtor.server");
    }
    
    /*
     * (non-Javadoc)
     * @see org.iocaste.protocol.ServerServlet#init(org.iocaste.protocol.Service, org.iocaste.protocol.Message)
     */
    @Override
    protected void init(Service service, Message message) {
        switch(message.getId()) {
        case Iocaste.LOGIN:
            System.out.println("tentativa de login");
            try {
                service.messageReturn(message, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            break;
        }
    }

}
