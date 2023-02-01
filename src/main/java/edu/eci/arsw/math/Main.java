/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.math;

import java.util.Arrays;

/**
 *
 * @author hcadavid
 */
public class Main {

    public static void main(String a[]) {
    	//La cantidad de digitos a evaluar es 10 y el número de hilos es 3
    	//PiDigits Example1 = new PiDigits(10,3);
    	//Example1.Orchestor();
    	//La cantidad de digitos a evaluar es 1000000 y el numero de hilos es 500
    	PiDigits Example2 = new PiDigits(1000000,500);
    	Example2.Orchestor();
    }


	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
    
    //En Proceso
    //
    //
    //Necesito conocer en main el numero de digitos a averiguar y el numero de hilos
    //Luego dividir la cantidad de digitos entre los hilos
    //Luego orquestar todos los hilos con estos valores incluyendo join(), el join va aqui
    
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<hexChars.length;i=i+2){
            //sb.append(hexChars[i]);
            sb.append(hexChars[i+1]);            
        }
        return sb.toString();
    }

}
