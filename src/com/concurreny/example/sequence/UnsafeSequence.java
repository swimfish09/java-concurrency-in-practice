package com.concurreny.example.sequence;

public class UnsafeSequence {
	private int value;

	public int getValue() {
		return value++;
	}
}
