package org.iocaste.protocol;

import org.hibernate.SessionFactory;

public interface Function {

    public abstract Object run(Message message) throws Exception;
    
    public abstract void setSessionFactory(SessionFactory sessionFactory);
}
