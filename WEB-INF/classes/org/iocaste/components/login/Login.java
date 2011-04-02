package org.iocaste.components.login;

import java.util.List;

import org.iocaste.protocol.AbstractFunction;
import org.iocaste.protocol.Message;

public class Login extends AbstractFunction {

    public Login() {
        addQuery("users", "from User where name = ?");
    }
    
    @Override
    public Object run(Message message) {
        User user;
        List<?> users;
        String username = (String)message.get("user");
        String secret = (String)message.get("secret");
        
        if (message.getId().equals("login")) {
            users = select("users", new Object[] {username});
            
            if (users == null)
                return false;
            
            for (Object object : users) {
                user = (User)object;
                
                if (user.getName().equals(username) &&
                        user.getSecret().equals(secret))
                    return true;
            }
        }
        System.out.println("teste");
        return false;
    }

}
