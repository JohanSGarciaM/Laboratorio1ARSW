package edu.eci.arsw.math;

//Class that determines the life cycle of a thread that calculates a portion of the required digits.
/**
 * @autor Johan Sebastian Garcia
 */

public class ThreadCalculate extends Thread{
	
	private final int start;
	private final int last;
	private final int threads;
	
	public ThreadCalculate(int a, int b, int N) {
		this.start = a;
		this.last = b;
		this.threads = N;
	}
	
	@Override
	public void run() {
		byte[] digits;
		digits = PiDigits.getDigits(start, last, threads );
		
	}
	
}