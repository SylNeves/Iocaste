package org.iocaste.protocol;

import java.io.IOException;

public final class Iocaste extends AbstractServiceInterface {
    
    public Iocaste() throws IOException {
        initService("/iocaste-server/index.html");
    }
    
    public final boolean login(String user, String secret) throws IOException, ClassNotFoundException {
        Message message = new Message();
        
        message.setId("login");
        message.add("user", user);
        message.add("secret", secret);
        
        return (Boolean)call(message);
    }
    
    public final boolean isConnected() throws IOException, ClassNotFoundException {
        Message message = new Message();
        
        message.setId("is_connected");
        
        return (Boolean)call(message);
    }
}
