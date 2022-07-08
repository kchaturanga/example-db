package com.kasunc.redgate.builder;

import com.kasunc.redgate.Column;
import com.kasunc.redgate.DatabaseObject;
import com.kasunc.redgate.StoredProcedure;
import com.kasunc.redgate.Table;

public class ColumnBuilder extends TableBuilder {
	protected Column column;
	private ColumnBuilder() { }
	
	public static ColumnBuilder init(Table table, StoredProcedure procedure) {
		ColumnBuilder i = new ColumnBuilder();
		i.column = new Column();
		i.procedure = procedure;
		i.table = table;
		i.table.getColumns().add(i.column);
		return i ; 
	}

	@Override
	public ColumnBuilder name(String name) {
		this.column.setName(name);
		return this;
	}

	public ColumnBuilder type(String type) {
		this.column.setType(type);
		return this;
	}

	@Override
	public DatabaseObject build() {
		return super.build() == null ? column : super.build();
	}

}
