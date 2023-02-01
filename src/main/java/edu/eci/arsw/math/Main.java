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

    public static void main(String a[]){
    	//La cantidad de digitos a evaluar es 10 y el número de hilos es 3
    	PiDigits Example1 = new PiDigits(10,3);
    	try {
			Example1.Orchestor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//La cantidad de digitos a evaluar es 1000000 y el numero de hilos es 500
    	//PiDigits Example2 = new PiDigits(1000000,500);
    	//Example2.Orchestor();
    }


	

}
