package edu.eci.arsw.math;

//Class that determines the life cycle of a thread that calculates a portion of the required digits.
/**
 * @autor Johan Sebastian Garcia
 */

public class ThreadCalculate extends Thread{
	
	private final int start;
	private final int last;
	private final String threads;
	
	public ThreadCalculate(String NameOfThread ,int a, int b) {
		this.start = a;
		this.last = b;
		this.threads = NameOfThread;
	}
	
	@Override
	public void run() {
		byte[] digits;
		digits = PiDigits.getDigits(start, last);
		System.out.println(digits.length+"Longitud");
		for (int i = 0; i<digits.length;i++) {
			System.out.println(String.valueOf(digits[i])+getName());
		}
		
		
	}
	
}