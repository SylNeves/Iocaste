package org.iocaste.protocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class Service {
    private URL url;
    private InputStream is;
    private OutputStream os;
    
    public Service() { }
    
    public Service(String urlname) throws IOException {
      url = new URL(urlname);
    }
    
    public final void setInputStream(InputStream is) {
        this.is = is;
    }
    
    public final void setOutputStream(OutputStream os) {
        this.os = os;
    }
    
    public final Message getMessage() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(is);
        Message message = (Message)ois.readObject();
        
        ois.close();
        
        return message;
    }
    
    public final Object call(Message message) throws IOException, ClassNotFoundException {
        Message response;
        ObjectOutputStream oos;
        ObjectInputStream ois;
        URLConnection urlcon = url.openConnection();
        
        urlcon.setDoInput(true);
        urlcon.setDoOutput(true);
  
        oos = new ObjectOutputStream(urlcon.getOutputStream());
        oos.writeObject(message);
        oos.close();
        
        ois = new ObjectInputStream(urlcon.getInputStream());
        response = (Message)ois.readObject();
        ois.close();
        
        return response.get("return");
    }
    
    public final void messageReturn(Message message, Object object) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(os);
        
        message.clear();
        message.setId(null);
        message.add("return", object);
        
        oos.writeObject(message);
        oos.close();
    }
}
