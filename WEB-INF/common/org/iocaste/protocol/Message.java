package org.iocaste.protocol;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Message implements Serializable {
    private static final long serialVersionUID = 4538161172762638611L;
    private Map<String, Object> values;
    private String id;
    private String sessionid;
    private Exception ex;
    
    public Message() {
        values = new HashMap<String, Object>();
    }
    
    public final Object get(String name) {
        return values.get(name);
    }
    
    public final byte getByte(String name) {
        return (Byte)values.get(name);
    }
    
    public final double getDouble(String name) {
        return (Double)values.get(name);
    }
    
    public final Exception getException() {
        return ex;
    }
    
    public final float getFloat(String name) {
        return (Float)values.get(name);
    }
    
    public final String getId() {
        return id;
    }
    
    public final int getInt(String name) {
        return (Integer)values.get(name);
    }
    
    public final long getLong(String name) {
        return (Long)values.get(name);
    }
    
    public final String getSessionid() {
        return sessionid;
    }
    
    public final short getShort(String name) {
        return (Short)values.get(name);
    }
    
    public final String getString(String name) {
        return (String)values.get(name);
    }
    
    /*
     * Setters
     */
    
    public final void setException(Exception ex) {
        this.ex = ex;
    }
    
    public final void setId(String id) {
        this.id = id;
    }
    
    public final void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }
    
    /*
     * Others
     */
    
    public final void add(String name, Object value) {
        values.put(name, value);
    }
    
    public final void add(String name, int value) {
        values.put(name, value);
    }
    
    public final void clear() {
        values.clear();
    }
}
