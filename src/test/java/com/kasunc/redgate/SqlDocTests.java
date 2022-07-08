package com.kasunc.redgate;

import org.junit.Assert;
import org.junit.Test;

import com.kasunc.redgate.builder.StoredProcedureBuilder;
import com.kasunc.redgate.builder.TableBuilder;

public class SqlDocTests {
	
    @Test 
    public void rendering_a_table_works_correctly() {
    	
    	String tableString  =  TableBuilder.init()
    	.name("Foo")
		.addColumn()
			.name("Bar")
			.type("int")
		.build().toString();
       
    	String expecting = "Table: Foo" + System.lineSeparator() + "\tBar of type int" ;
    	
     
        // Assert
        Assert.assertEquals(expecting, tableString);
    }
    
    @Test
    public void rendering_a_stored_procedure_works_correctly() {
    	
    	// Building StoredProcedure
    	String actual =   StoredProcedureBuilder.init()
    	.name("Foo")
    	.addTable()
    		.name("Baz")
    		.addColumn()
   			.name("Bosh")
    			.type("int")
     	.addView()
     		.name("Banana")
     		.addTable()
    			.name("Salary")
    			.addColumn()
  					.name("Bosh")
   					.type("int")
    		.build()
    			.toString();
    				
    	String expected = "Stored Procedure: Foo" + System.lineSeparator() + "\tTable: Baz" + System.lineSeparator() + "\t\tBosh of type int" + System.lineSeparator() + "\tView: Banana" + System.lineSeparator() + "\t\tTable: Salary" + System.lineSeparator() + "\t\t\tBosh of type int";
    	// Assert
    	System.out.println(String.format( "expected  :%s%s ",System.lineSeparator(), expected ));
    	System.out.println(String.format( "actual :%s%s ",System.lineSeparator(), actual ));
		Assert.assertEquals(expected, actual );
    }
    
}
