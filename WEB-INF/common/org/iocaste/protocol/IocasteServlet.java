package org.iocaste.protocol;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class IocasteServlet extends HttpServlet {
    private static final long serialVersionUID = 6054291682722402756L;
    private HttpServletRequest req;
    private HttpServletResponse resp;
    
    /*
     * Getters
     */
    
    protected final String getValue(String name) {
        return req.getParameter(name);
    }
    
    /*
     * Setters
     */
    
    protected final void setValue(String name, String value) {
        req.getSession().setAttribute(name, value);
    }
    
    /*
     * Others
     */
    
    @Override
    protected final void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected final void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.req = req;
        this.resp = resp;
        
        try {
            entry();
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
    
    protected abstract void entry() throws Exception;
    
    protected final void redirect(String url) throws IOException {
        resp.sendRedirect(url);
    }
    
    protected final Service serviceInstance(String url) throws IOException {
        Service service = new Service(req.getSession().getId(), url);
        
        service.setInputStream(req.getInputStream());
        service.setOutputStream(resp.getOutputStream());
        
        return service;
    }
    
}
