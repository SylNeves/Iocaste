package org.iocaste.components.login;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -6415620415288973044L;
    private String name;
    private String secret;
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return the secret
     */
    public String getSecret() {
        return secret;
    }
    
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @param secret the secret to set
     */
    public void setSecret(String secret) {
        this.secret = secret;
    }
}
