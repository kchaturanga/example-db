package com.kasunc.redgate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class Table implements DatabaseObject {
	
    private String name = "";
    private Collection<Column> columns = new ArrayList<>();

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Collection<Column> getColumns() {
        return columns;
    }

    public void setColumns(Collection<Column> columns) {
        this.columns = columns;
    }

    public StringBuilder toString(int indent) {
		
			StringBuilder sb = new StringBuilder();
			sb.append(Collections.nCopies(indent, "\t").stream().collect(Collectors.joining()))
			.append("Table: ")
			.append(name)
			.append(System.lineSeparator())
			.append(columns.stream().map(c -> c.toString(indent + 1)).collect(Collectors.joining(System.lineSeparator())));
			
			return sb;
			
		 
	}

	@Override
	public String toString() {

		return toString(0).toString();
	}
}
