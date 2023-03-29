package Parcial2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Lector {

	public void ejecutar(int ID) {
			FileWriter escribir = null;
			PrintWriter imprimir = null;
			FileReader leer = null;
			
			String path = "D:\\Users\\174720\\eclipse-workspace\\Parcial2\\src\\Parcial2\\emails.csv";
			//File file = new File(path);
			
	        List<String> lista = null;
	        
	        int[] sumatoria = new int[3000];
	        String[] email = new String[3000];
	        
	        
	        
	        //-------------------------------------------
	        String cadena= String.valueOf(ID);
	        int largo = cadena.length();
	        String subID = cadena.substring(largo-3,largo);
	        int lastID = Integer.parseInt(subID);
	        
	        int primerCorreo = lastID;
	        int lastCorreo = lastID + 49;
	        
	        //-------------------------------------------
	          
	        try {
	        	
	        	lista = Files.readAllLines(Paths.get(path));
	        	
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        

	        
	        for (int i = primerCorreo; i <= lastCorreo; i++) {
	        	email = lista.get(i).split(",");
	     
	            for (int j = 1; j < email.length - 1; j++) {
	                sumatoria[j-1] += Integer.parseInt(email[j]);
	            }
	        }
	        String[] titulos = lista.get(0).split(",");


	        try {
	        	
	        	//file.createNewFile();
	            FileWriter escritura = new FileWriter("D:\\Users\\174720\\eclipse-workspace\\Parcial2\\src\\Parcial2\\"+ ID +".txt");
	            for (int i = 0; i < sumatoria.length; i++) {
	            	escritura.write((titulos[i+1]) + ",");
	                escritura.write(Integer.toString(sumatoria[i]) + "\n");
	            }
	            escritura.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	      
	    }
	}
