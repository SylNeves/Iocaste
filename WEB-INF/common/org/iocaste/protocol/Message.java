package org.iocaste.protocol;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Message implements Serializable {
    private static final long serialVersionUID = 4538161172762638611L;
    private Map<String, Object> values;
    private int id;
    
    public Message() {
        values = new HashMap<String, Object>();
    }
    
    public final void setId(int id) {
        this.id = id;
    }
    
    public final void add(String name, Object value) {
        values.put(name, value);
    }
    
    public final void add(String name, int value) {
        values.put(name, value);
    }
    
    public final int getId() {
        return id;
    }
    
    public final void clear() {
        values.clear();
    }
    
    public final Object get(String name) {
        return values.get(name);
    }
}
