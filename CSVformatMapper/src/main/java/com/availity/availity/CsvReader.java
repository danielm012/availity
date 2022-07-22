package com.availity.availity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import tech.tablesaw.api.*;

public class CsvReader {

    public static void main(String... args) {
    	
        // importing file for modification
        File fileLoc = new File("enrollmentTest.csv");     
        System.out.println(fileLoc.getAbsolutePath());
        
        Table dataTable = Table.read().csv(fileLoc);
        
        // Analyzing structure of the imported CSV 
        System.out.println(dataTable.structure());
        System.out.println(dataTable.first(10));
        
        // cleaning file and organizing in ascending order
        Table ascending = dataTable.sortAscendingOn("Insurance", "Last", "First", "version");
        
        System.out.println(ascending.first(10));        
        
        // Getting all insurance companies to unique name
        Set<?> insuranceNames = dataTable.column("Insurance").asSet();

        System.out.println(insuranceNames);
        
        // remove duplicate data by checking field against next value      
        int rowSize = dataTable.rowCount();       
        ArrayList<Integer> toDropDuplicatesIndex = new ArrayList<>();       
        List<String> columnsNames = dataTable.columnNames();
        
        for(int index = 0; index < rowSize - 1; index++)
        {
        	Boolean isSame = true;
        	
        	// Use iterator to stop at will and add row immediately, avoid O(N) columns
        	// Find records with the same version and add the row to be removed for cleaning
            for(String columnName :  columnsNames)
            {    	
            	if(!columnName.equals("Version")  && !columnName.equals("Id") && ascending.column(columnName).get(index) !=  ascending.column(columnName).get(index+1))
            	{
            		isSame = false;
            	}
            }
            if(isSame == true)
            	toDropDuplicatesIndex.add(index);
        }
        
        int[] dropValues = toDropDuplicatesIndex.stream().mapToInt(i->i).toArray();
        
        // Clean the record of column with same version, leaving LATEST
        ascending = ascending.dropRows(dropValues);
        

        // export the files to the individualize insurance companies. 
        for(Object InsuranceName : (Object[]) insuranceNames.toArray())
        {
        	String name = (String) InsuranceName;
        	
        	// Filtering columns by company 
        	Table insuranceDataFilter = ascending.where(ascending.stringColumn("Insurance").isEqualTo(name));
        	
        	// People with no insurance companies
        	if(name.equals(""))
        		name = "BlankInsurance";
        	
        	// exporting new file
        	insuranceDataFilter.write().csv(new File(name + ".csv"));
            
        	// Show the data being filter
            System.out.println(insuranceDataFilter.first(10));
        }     
   }

}