package org.iocaste.protocol;

import java.io.IOException;

public abstract class AbstractServiceInterface {
    private Service service;
    
    public AbstractServiceInterface() { }
    
    protected final void initService(String urlname) throws IOException {
        service = new Service(urlname);
    }

    protected final Object call(Message message)
        throws IOException, ClassNotFoundException {
        
        return service.call(message);
    }
    
    
}
