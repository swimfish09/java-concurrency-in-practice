package com.concurreny.example.sequence;

public class Test implements Runnable {
	private Sequence sequence;
	// private UnsafeSequence sequence;

	public Test(Sequence sequence) {
		super();
		this.sequence = sequence;
	}

	@Override
	public void run() {
		System.out.print(sequence.getValue() + " ");
	}

	public static void main(String[] args) throws InterruptedException {
		Sequence sequence = new Sequence();
		// UnsafeSequence sequence = new UnsafeSequence();
		for (int i = 0; i < 20; i++) {
			Thread thread = new Thread(new Test(sequence));
			thread.start();
		}
	}
}
