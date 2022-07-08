package com.kasunc.redgate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class View implements DatabaseObject {
	
    private String name = "";
    private Collection<Column> columns = new ArrayList<>();
    private Collection<Table> tables = new ArrayList<>();

    public View(String name) {
		this.name = name ;
	}
    public View() { }
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

    public Collection<Table> getTables() {
        return tables;
    }

    public void setTables(Collection<Table> tables) {
        this.tables = tables;
    }
    
  
	public StringBuilder toString(int indent) {
    	
    	StringBuilder sb = new StringBuilder();
		sb.append(Collections.nCopies(indent, "\t").stream().collect(Collectors.joining()))
		.append("View: ")
		.append(this.name)
		.append(System.lineSeparator())
		.append(tables.stream().map(t -> t.toString(indent + 1)).collect(Collectors.joining()));
		
		return sb;
//		
//		StringBuilder builder = new StringBuilder();
//		builder.append(indents+"View: ");
//		builder.append(this.getName());
//		
//		for (DatabaseObject databaseObject : tables) {
//			builder.append(System.lineSeparator() );
//			builder.append(databaseObject.toString(indents+"\t") );
//		}
//		 
//    	return builder.toString();
	}
}
