package com.richard;

/**
 * This class models a playing card which has a suit and a value.
 */
public class Card {
 
	/** The card suit. */
	private CardSuit cardSuit;

	/** The card value. */
	private CardValue cardValue;
	
	/**
	 * Instantiates a new card with a suit and value.
	 *
	 * @param suit the suit of a card from CardSuit enum
	 * @param value the value of a card from CardValue enum
	 */
	public Card(final CardSuit suit, final CardValue value) {
		this.cardSuit = suit;
		this.cardValue = value;
	}
	
	/**
	 * Gets the suit of the playing card.
	 *
	 * @return the suit
	 */
	public final CardSuit getSuit() {
		return this.cardSuit;
	}

	/**
	 * Gets the value of the playing card.
	 *
	 * @return the value
	 */
	public final CardValue getValue() {
		return this.cardValue;
	}

}
