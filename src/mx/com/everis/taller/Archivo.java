package mx.com.everis.taller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Archivo {
	//crar el archivo llamado hola.txt
	//cerrar la ruta /develop/project/tallerJava
	//guardar el archivo holamundo.txt en la ruta anterior
	//verificar si el archivo existe y sino  existe crarlo
	//leer una cadena desde consol y guardarla  en el  holamundo.txt
	//leer el archivo e imprimir en consola

	

	public static void main(String []args) throws IOException
	{
		String ruta="/home/juank-charly/Documentos/Archivos/holamundo.txt";
		Archivo.crearRuta();
		Archivo.guardarCadena(ruta);
		Archivo.leerArchivo(ruta);
    }

	public static void crearRuta() throws IOException
	{
		String ruta="/home/juank-charly/Documentos/Archivos/";
		String nombre="holamundo.txt";
		File folder = new File(ruta);
		folder.mkdirs();
		Archivo.crearArchivo(ruta, nombre);
		
		
	}
	private static void crearArchivo(String ruta,String nombre) throws IOException
	{
		String rutas =ruta+""+nombre; 
        File archivo = new File(rutas);
        BufferedWriter bw;
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            System.out.println("El fichero de texto ya estaba creado.");
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            System.out.println("Acabo de crear el fichero de texto.");
        }
        
        bw.close();
		
	}
	
	public static void guardarCadena(String ruta) throws IOException
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		FileWriter fichero = new FileWriter(ruta);
		PrintWriter pw = new PrintWriter(fichero);
		System.out.println("Ingrese la ocurrencia en el archivo holamundo.txt");
		String dato=in.readLine();
		pw.println(dato);
		System.out.println("Ocurrencia Ingresada");
	    fichero.close();
	}
	
	public static void leerArchivo(String ruta) throws IOException
	{
		File archivo = new File (ruta);
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);

        // Lectura del fichero
        String linea;
        while((linea=br.readLine())!=null){
           System.out.println("la palabra en el archivo es:"+linea);
        }
	}
}

