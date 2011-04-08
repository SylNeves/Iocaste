package org.iocaste.components.login;

import org.iocaste.protocol.AbstractFunction;
import org.iocaste.protocol.Message;

public class Login extends AbstractFunction {

    public Login() { }
    
    @Override
    public Object run(Message message) {
        User user = (User)load(User.class, message.getString("user"));;
        String secret = message.getString("secret");
        
        if (user == null)
            return false;
        
        user.setSecret(user.getSecret().trim());
        
        if (!user.getSecret().equals(secret))
            return false;
        
        return true;
    }

}
