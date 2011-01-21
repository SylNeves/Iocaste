package org.iocaste.protocol;

import java.io.IOException;

public final class Iocaste {
    private Service service;
    
    public Iocaste() throws IOException {
        this("http://localhost:8080/iocaste-server/index.html");
    }
    
    public Iocaste(String urlname) throws IOException {
        service = new Service(urlname);
    }
    
    public final boolean login(String user, String secret) throws IOException, ClassNotFoundException {
        Message message = new Message();
        
        message.setId("login");
        message.add("user", user);
        message.add("secret", secret);
        
        return (Boolean)service.call(message);
    }
}
