package com.kasunc.redgate;

import java.util.Collections;
import java.util.stream.Collectors;

public class Column implements DatabaseObject {
	
    private String name = "";
    private String type = "";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

	public StringBuilder toString(int indent ) {
		return new StringBuilder().append(  
				String.format(
						"%s%s of type %s", 
						Collections.nCopies((indent), "\t").stream().collect(Collectors.joining()),
						this.getName() , 
						this.getType()
				));
	}
 
}
