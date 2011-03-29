package org.iocaste.protocol;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ClientServlet extends HttpServlet {
    private static final long serialVersionUID = 3823216617015765316L;
    private Iocaste iocaste;
    private Exception ex;
    private HttpServletRequest req;
    private HttpServletResponse resp;
    
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
        
        this.req = req;
        this.resp = resp;
        
        try {
            init(iocaste);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
    
    protected final String getValue(String name) {
        return req.getParameter(name);
    }
    
    protected final void setValue(String name, String value) {
        req.getSession().setAttribute(name, value);
    }
    
    protected final void redirect(String url) throws IOException {
        resp.sendRedirect(url);
    }
    
    protected abstract void init(Iocaste iocaste) throws Exception;

}
