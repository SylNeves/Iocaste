package org.iocaste.server;

import org.iocaste.components.login.Login;

import org.iocaste.protocol.ServerServlet;

public class Servlet extends ServerServlet {
    private static final long serialVersionUID = -8569034003940826582L;
    
    @Override
    public void config() {
        addFunction("login", new Login());
    }
}
