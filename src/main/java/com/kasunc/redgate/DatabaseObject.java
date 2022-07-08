package com.kasunc.redgate;

public interface DatabaseObject {
    String getName();
    void setName(String name);
    StringBuilder toString(int indent);
    
    
    
}
