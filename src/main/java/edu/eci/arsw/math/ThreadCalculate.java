package edu.eci.arsw.math;

//Class that determines the life cycle of a thread that calculates a portion of the required digits.
/**
 * @autor Johan Sebastian Garcia
 */

public class ThreadCalculate extends Thread{
	
	private final int start;
	private final int last;
	private String thread;
	private String result;
	
	public ThreadCalculate(String NameOfThread ,int a, int b) {
		this.start = a;
		this.last = b;
		this.thread = NameOfThread;
	}
	
	@Override
	public void run() {
//		Iniciamos un nuevo grupo de digitos vacío
		byte[] digits;
//		invocamos la función que obtiene los digitos dado un rango y el resultado lo guardamos en el array creado antes
		digits = PiDigits.getDigits(start, last);
//		En la variable result guardamos el resultado de cambiar este valor de digitos a hexadecimal
		this.result = PiDigits.bytesToHex(digits);
	}
	
//	Función que retorna el valor en hexadecimal del grupo de datos correspondiente al hilo
	public String getResult() {
		return this.result;
	}
	
//	Función que retorna el nombre del hilo 
	public String getNameOfThread() {
		return this.thread;
	}
}