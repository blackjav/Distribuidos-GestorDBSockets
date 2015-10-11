/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author javier
 */
public class Calculadora {
    
    public static final int PUERTO = 5000;
    
    
    public static double suma (int a, int b)
    {
        return a + b ;
    }
    public static double resta (int a, int b)
    {
        return a - b ;
    }
    public static double multiplicacion (int a, int b)
    {
        return a * b ;
    }
    public static  double division (int a, int b)
    {
        return a / b ;
    }
    public static double modulo (int a, int b)
    {
        return a % b ;
    }
    public static double potencia (int a,int potencia)
    {
        return Math.pow(a, potencia) ;
    }
    
    
    public static void main (String args[]) throws IOException
	{
                BufferedReader entrada;
                PrintWriter pw;
		@SuppressWarnings("resource")
		ServerSocket ss = new ServerSocket(PUERTO);
                InputStream is ;
		while(true)
		{
			Socket sc = ss.accept();
                        System.err.println("Cliente conectado..."+sc.getInetAddress().getHostName() );
                        
                        is= sc.getInputStream();
                        entrada = new BufferedReader(new InputStreamReader(is));
                        pw = new PrintWriter(sc.getOutputStream());
                        
                        String tipo = entrada.readLine();
                        String a = entrada.readLine();
                        String b = entrada.readLine();
                        
                        System.out.println("Se recibio operador "+tipo);
                        System.out.println("Se recibio "+a);
                        System.out.println("Se recibio "+b);
                        
                        switch (tipo) {
 
                                case "Suma":
                                    System.err.println("Se esta enviando");
                                    pw.println(suma(Integer.parseInt(a), Integer.parseInt(b)));
                                break;

                                case "Resta":
                                        System.err.println("");
                                        pw.println(resta(Integer.parseInt(a), Integer.parseInt(b)));
                                break;
                                    
                                case "Multiplicacion":
                                        System.err.println("");
                                        pw.println(multiplicacion(Integer.parseInt(a), Integer.parseInt(b)));
                                break;
                                    
                                    
                                case "Division":
                                        System.err.println("");
                                        pw.println(division(Integer.parseInt(a), Integer.parseInt(b)));
                                break;
                                    
                                    
                                case "Modulo":
                                        System.err.println("");
                                        pw.println(modulo(Integer.parseInt(a), Integer.parseInt(b)));
                                break;
                                    
                                    
                                case "Potencia":
                                        System.err.println("");
                                        pw.println(potencia(Integer.parseInt(a), Integer.parseInt(b)));
                                break;
                                
                                default:
                                    System.err.println("ni mayes");
                                break;

                         }
                        
			pw.close();
			sc.close();
		}
        }
}