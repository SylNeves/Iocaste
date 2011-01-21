package org.iocaste.components.login;

import org.iocaste.protocol.AbstractFunction;
import org.iocaste.protocol.Message;

public class Login extends AbstractFunction {

    @Override
    public Object run(Message message) {
        System.out.println("tentativa de login");
        return true;
    }

}
