package com.kasunc.redgate.builder;

import com.kasunc.redgate.DatabaseObject;
import com.kasunc.redgate.StoredProcedure;
import com.kasunc.redgate.Table;
import com.kasunc.redgate.View;

public class TableBuilder extends ViewBuilder{
	
	protected Table table;
	
	protected TableBuilder() { }
	public static TableBuilder init() {
		TableBuilder i = new TableBuilder();
		i.table = new Table();
		return i ; 
	}
	public static TableBuilder init(StoredProcedure procedure) {
		TableBuilder i = new TableBuilder();
		i.table = new Table();
		i.procedure = procedure;
		i.procedure.getTables().add(i.table); 
		return i ; 
	}
	
	public static TableBuilder init(View view, StoredProcedure procedure) {
		TableBuilder i = new TableBuilder();
		i.table = new Table();
		i.procedure = procedure;
		i.view = view;
		i.view.getTables().add(i.table);
		return i ; 
	}
	
	@Override
	 public TableBuilder name(String name ) {
		 this.table.setName(name);
		 return this;
	 }

	public ColumnBuilder addColumn() {
		return    ColumnBuilder.init(table , procedure);
		
	}
	
	@Override
	public DatabaseObject build() {
		return super.build() == null? table : super.build();
	}
	 
	 

}
