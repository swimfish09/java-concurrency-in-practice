package com.concurreny.example.sequence;

public class Sequence {
	private int value;

	public synchronized int getValue() {
		return value++;
	}
}
