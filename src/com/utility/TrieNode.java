package com.utility;

public class TrieNode {
	private final int ALPHABET_SIZE = 26;
	public TrieNode[] characters = new TrieNode[ALPHABET_SIZE];
	private char alphabet;

	public TrieNode() {
		for (int i = 0; i < ALPHABET_SIZE; i++) {
			characters[i] = null;
		}
	}

	public void setCharacter(char c) {
		this.alphabet = c;
	}

	public char getCharacter() {
		return this.alphabet;
	}
}