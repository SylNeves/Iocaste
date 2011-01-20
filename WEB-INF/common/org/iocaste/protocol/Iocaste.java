package org.iocaste.protocol;

import java.io.IOException;

public final class Iocaste {
    public static final int RETURN = 0;
    public static final int LOGIN = 1;
    private Service service;
    
    public Iocaste() throws IOException {
        this("http://localhost:8080/iocaste-server/index.html");
    }
    
    public Iocaste(String urlname) throws IOException {
        service = new Service(urlname);
    }
    
    public final boolean login(String user, String secret) {
        Message message = new Message();
        
        message.setId(Iocaste.LOGIN);
        message.add("user", user);
        message.add("secret", secret);
        
        try {
            return (Boolean)service.call(message);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return false;
    }
}
