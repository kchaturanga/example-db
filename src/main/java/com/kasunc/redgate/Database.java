package com.kasunc.redgate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class Database implements DatabaseObject {

	private Collection<DatabaseObject> objects = new ArrayList<>();
	private String name;

	public Collection<DatabaseObject> getObjects() {
		return objects;
	}

	public void setObjects(Collection<DatabaseObject> objects) {
		this.objects = objects;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public StringBuilder toString(int indent) {
		

		StringBuilder sb = new StringBuilder();
		sb.append(Collections.nCopies(indent, "\t").stream().collect(Collectors.joining()))
		.append("Stored Procedure: ")
		.append(name)
		.append(System.lineSeparator())
		.append(objects.stream().map(c -> c.toString(indent + 1)).collect(Collectors.joining()));
		
		
		return sb;
		
 
	}
	
	@Override
	public String toString() {
		return toString(0).toString();
	}

}
