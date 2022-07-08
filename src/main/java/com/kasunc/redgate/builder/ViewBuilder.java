package com.kasunc.redgate.builder;

import com.kasunc.redgate.DatabaseObject;
import com.kasunc.redgate.StoredProcedure;
import com.kasunc.redgate.Table;
import com.kasunc.redgate.View;

public class ViewBuilder extends StoredProcedureBuilder{
	
	protected View view ;
	protected ViewBuilder() { }
	public static ViewBuilder init(StoredProcedure procedure) {
		ViewBuilder i = new ViewBuilder();
		 i.view = new View();
		i.procedure = procedure;
		i.procedure.getViews() .add(i.view); 
		return i ;
	}

	@Override
	 public ViewBuilder name(String name ) {
		 this.view.setName(name);
		 return this;
	 }
	
	@Override
	public TableBuilder addTable() {
		return   TableBuilder.init(view , procedure);
	}
	
	@Override
	public DatabaseObject build() {
		 return super.build() == null ? view : super.build() ;
	}
	 
 

}
