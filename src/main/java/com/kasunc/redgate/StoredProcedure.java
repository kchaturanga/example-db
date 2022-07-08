package com.kasunc.redgate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class StoredProcedure implements DatabaseObject{
	
	private String name; 
	private Collection<Table> tables = new ArrayList<>();
	private Collection<View> views = new ArrayList<>();
	
	public StoredProcedure() { }
	public StoredProcedure(String name ) {
		this.name = name ; 
	}
	 
	public Collection<Table> getTables() {
		return tables;
	}
	public void setTables(Collection<Table> tables) {
		this.tables = tables;
	}
	public Collection<View> getViews() {
		return views;
	}
	public void setViews(Collection<View> views) {
		this.views = views;
	}
	@Override
	public String getName() { 
		return name;
	}

	@Override
	public void setName(String name) {
		 this.name = name ; 
		
	}
	
	@Override
	public String toString() {
		return toString(0).toString();
		
	}
	
	public StringBuilder toString(int indent) {
		

		StringBuilder sb = new StringBuilder();
		sb.append(Collections.nCopies(indent, "\t").stream().collect(Collectors.joining()))
		.append("Stored Procedure: ")
		.append(name)
		.append(System.lineSeparator())
		.append(tables.stream().map(c -> c.toString(indent + 1)).collect(Collectors.joining()))
		.append(!tables.isEmpty()? System.lineSeparator():"")
		.append(views.stream().map(c -> c.toString(indent + 1)).collect(Collectors.joining()));
		
		return sb;
		
 
	}

}
