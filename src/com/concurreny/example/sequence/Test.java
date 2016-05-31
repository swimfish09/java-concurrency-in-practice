package com.concurreny.example.sequence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test implements Runnable {
	//private Sequence sequence;
	private UnsafeSequence sequence;

	public Test(UnsafeSequence sequence) {
		super();
		this.sequence = sequence;
	}

	@Override
	public void run() {
		// UnsafeSequence sequence = new UnsafeSequence();
		System.out.print(sequence.getValue() + " ");
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(10);
		//Sequence sequence = new Sequence();
		UnsafeSequence sequence = new UnsafeSequence();
		for (int i = 0; i < 20; i++) {
			service.submit(new Test(sequence));
		}
		service.shutdown();
		service.awaitTermination(Long.MAX_VALUE, TimeUnit.HOURS);
		System.out.println("over...");
	}
}
