/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.math;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Johan Sebastian Garcia Martinez
 */
public class PiCalcTest {

    public PiCalcTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void piGenTest() throws Exception {

        byte[] expected = new byte[]{
            0x2, 0x4, 0x3, 0xF, 0x6, 0xA, 0x8, 0x8,
            0x8, 0x5, 0xA, 0x3, 0x0, 0x8, 0xD, 0x3,
            0x1, 0x3, 0x1, 0x9, 0x8, 0xA, 0x2, 0xE,
            0x0, 0x3, 0x7, 0x0, 0x7, 0x3, 0x4, 0x4,
            0xA, 0x4, 0x0, 0x9, 0x3, 0x8, 0x2, 0x2,
            0x2, 0x9, 0x9, 0xF, 0x3, 0x1, 0xD, 0x0,
            0x0, 0x8, 0x2, 0xE, 0xF, 0xA, 0x9, 0x8,
            0xE, 0xC, 0x4, 0xE, 0x6, 0xC, 0x8, 0x9,
            0x4, 0x5, 0x2, 0x8, 0x2, 0x1, 0xE, 0x6,
            0x3, 0x8, 0xD, 0x0, 0x1, 0x3, 0x7, 0x7,};

        for (int start = 0; start < expected.length; start++) {
            for (int count = 0; count < expected.length - start; count++) {
                byte[] digits = PiDigits.getDigits(start, count);
                assertEquals(count, digits.length);

                for (int i = 0; i < digits.length; i++) {
                    assertEquals(expected[start + i], digits[i]);
                }
            }
        }
    }
    
    @Test
//  Prueba si el número de hilos es correcto, para este caso es 3 y el programa debe ser exitoso
    public void Case1() {
    	System.out.println("Test Case 1");
    	int threads = 3;
    	PiDigits CaseNumber1 = new PiDigits(10,3);
    	try {
			CaseNumber1.Orchestor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	assertEquals(CaseNumber1.ThreadsAmount(),threads);
    	
    }
    
    @Test
//    Prueba que el resultado de la ejecución del programa arroja el valor correcto en hexadecimal del numero digitado, con 1 solo hilo
    public void Case2() {
    	System.out.println("Test Case 2");
//    	100 primero dígitos en formato hexadecimal de los decimales de pi obtenidos de internet
    	String expected = "243F6A8885A308D313198A2E03707344A4093822299F31D0082EFA98EC4E6C89452821E638D01377BE5466CF34E90C6CC0AC";
    	PiDigits CaseNumber2 = new PiDigits(100,1);
    	String result = "";
		try {
			result = CaseNumber2.Orchestor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	assertEquals(expected,result);
    }
    @Test
//    Prueba que el resultado de la ejecución del programa arroja el valor correcto en hexadecimal del número digitado, con 2 hilos
    public void Case3() {
    	System.out.println("Test Case 3");
//    	50 primeros dígitos en formato hexadecimal de los decimales de pi obtenidos por internet 
    	String expected = "243F6A8885A308D313198A2E03707344A4093822299F31D008";
    	PiDigits CaseNumber3 = new PiDigits(50,2);
    	String result = "";
    	try {
			result = CaseNumber3.Orchestor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	assertEquals(expected,result);
    }
    
    @Test
//    Prueba que el resultado de la ejecución del programa arroja el valor correcto en hexadecimal del número digitado, con 3 hilos
    public void Case4() {
    	System.out.println("Test Case 4");
//    	100 primeros dígitos en formato hexadecimal de los decimales de pi obtenidos por internet
    	String expected = "243F6A8885A308D313198A2E03707344A4093822299F31D0082EFA98EC4E6C89452821E638D01377BE5466CF34E90C6CC0AC";
    	PiDigits CaseNumber4 = new PiDigits(100,3);
    	String result = "";
    	try {
			result = CaseNumber4.Orchestor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	assertEquals(expected,result);
    }
    
//    Cálculo de tiempos para el punto 3
    
    @Test
//    Para este experimento vamos a utilizar un solo hilo para el calculo de 1 millón de dígitos
//    Vamos a hacer un caso por default exitoso y el fin es solo imprimir el tiempo 
    public void time1() {
	    System.out.println("Test 1 Thread");
	    int value = 1;
	    long start = System.nanoTime();
	    PiDigits timeTest1 = new PiDigits(1000000,1);
	    try {
			timeTest1.Orchestor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    long end = System.nanoTime();
	    long totalTime = end - start;
	    System.out.println("The total time of the process is " + Long.toString(totalTime));
	    assertEquals(1,value);
	    
    }
    
    @Test
//  Para este experimento vamos a utilizar la cantidad de procesadores disponibles para el cálculo de 1 millón de dígitos
//  Vamos a hacer un caso por default exitoso y el fin es solo imprimir el tiempo 
  public void time2() {
	    System.out.println("Test 2 Thread");
	    int value = 1;
	    long start = System.nanoTime();
	    Runtime runtime = Runtime.getRuntime();
	    int processors = runtime.availableProcessors();
	    PiDigits timeTest2 = new PiDigits(1000000,processors);
	    try {
			timeTest2.Orchestor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    long end = System.nanoTime();
	    long totalTime = end - start;
	    System.out.println("The total time of the process is " + Long.toString(totalTime));
	    assertEquals(1,value);
	    
  }
    
    @Test
//  Para este experimento vamos a utilizar el doble de la cantidad de procesadores disponibles para el cálculo de 1 millón de dígitos
//  Vamos a hacer un caso por default exitoso y el fin es solo imprimir el tiempo 
  public void time3() {
	    System.out.println("Test 3 Thread");
	    int value = 1;
	    long start = System.nanoTime();
	    Runtime runtime = Runtime.getRuntime();
	    int processors = runtime.availableProcessors();
	    PiDigits timeTest3 = new PiDigits(1000000,processors*2);
	    try {
			timeTest3.Orchestor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    long end = System.nanoTime();
	    long totalTime = end - start;
	    System.out.println("The total time of the process is " + Long.toString(totalTime));
	    assertEquals(1,value);
	    
  }
    
    @Test
//  Para este experimento vamos a utilizar 200 hilos para el cálculo de 1 millón de dígitos
//  Vamos a hacer un caso por default exitoso y el fin es solo imprimir el tiempo 
  public void time4() {
	    System.out.println("Test 4 Thread");
	    int value = 1;
	    long start = System.nanoTime();
	    PiDigits timeTest4 = new PiDigits(1000000,200);
	    try {
			timeTest4.Orchestor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    long end = System.nanoTime();
	    long totalTime = end - start;
	    System.out.println("The total time of the process is " + Long.toString(totalTime));
	    assertEquals(1,value);
	    
  }
    
    
}
