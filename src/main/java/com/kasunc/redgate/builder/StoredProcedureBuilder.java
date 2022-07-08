package com.kasunc.redgate.builder;

import com.kasunc.redgate.Database;
import com.kasunc.redgate.DatabaseObject;
import com.kasunc.redgate.StoredProcedure;

public class StoredProcedureBuilder extends DatabaseBuilder {
	protected StoredProcedureBuilder() { }
	protected StoredProcedure procedure;
 
	public static StoredProcedureBuilder init() {
		StoredProcedureBuilder i = new StoredProcedureBuilder();
		i.procedure = new StoredProcedure();
		return i ; 
	}

	public static StoredProcedureBuilder init(Database database) {
		StoredProcedureBuilder i = new StoredProcedureBuilder();
		i.databse = database;
		i.procedure = new StoredProcedure();
		i.databse.getObjects().add(i.procedure);
		return i ;
	}

	@Override
	public StoredProcedureBuilder name(String name) {
		this.procedure.setName(name);
		return this;
	}

	public TableBuilder addTable() {
		return   TableBuilder.init(procedure);
	}

	public ViewBuilder addView() {
		return ViewBuilder.init(procedure);
	}

	@Override
	public DatabaseObject build() {
		return super.build() == null ? procedure : super.build();
	}

}
