package com.kasunc.redgate.builder;

import com.kasunc.redgate.Database;
import com.kasunc.redgate.DatabaseObject;

public class DatabaseBuilder implements DatabaseObjectBuilder {
	
	protected Database databse;

	protected DatabaseBuilder() { }
	static DatabaseObjectBuilder init() {
		DatabaseBuilder i = new DatabaseBuilder();
		i.databse = new Database();
		return i ; 
	}

	public DatabaseBuilder name(String name) {
		this.databse.setName(name);
		return this;
	}

	public StoredProcedureBuilder addProcedure() {
		return   (StoredProcedureBuilder) StoredProcedureBuilder.init(databse);
	}

	@Override
	public DatabaseObject build() {
		return databse;
	}

}
