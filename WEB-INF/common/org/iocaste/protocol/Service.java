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
    private URLConnection urlcon;
    private InputStream is;
    private OutputStream os;
    
    public Service() { }
    
    public Service(String urlname) throws IOException {
      url = new URL(urlname);
      urlcon = url.openConnection();
      
      urlcon.setDoInput(true);
      urlcon.setDoOutput(true);
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
    
    public final Message call(Message message) throws IOException, ClassNotFoundException {
        Message response;
        ObjectOutputStream oos;
        ObjectInputStream ois;
        
        if (urlcon == null)
            return null;
  
        oos = new ObjectOutputStream(urlcon.getOutputStream());
        oos.writeObject(message);
        oos.close();
        
        ois = new ObjectInputStream(urlcon.getInputStream());
        response = (Message)ois.readObject();
        ois.close();
        
        return response;
    }
    
    public final void messageReturn(Message message) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(os);
        
        oos.writeObject(message);
        oos.close();
    }
}
