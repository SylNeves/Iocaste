package org.iocaste.protocol;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ClientServlet extends HttpServlet {
    private static final long serialVersionUID = 3823216617015765316L;
    Iocaste iocaste;
    Exception ex;
    
    public ClientServlet() {
        try {
            iocaste = new Iocaste();
        } catch (IOException e) {
            ex = e;
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (ex != null)
            throw new IOException(ex);
        
        init(iocaste);
    }
    
    protected abstract void init(Iocaste iocaste);

}
