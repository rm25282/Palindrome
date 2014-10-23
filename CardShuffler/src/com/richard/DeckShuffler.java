/*
 * This is an interface to a deck of cards.
 */
package com.richard;

/**
 * The deck shuffler interface provides methods to 
 * shuffle, reshuffle, retrieve the top card and counts
 * the number of cards still in the deck.
 */
public interface DeckShuffler {

	/**
	 * Number of currently in the deck.
	 * 
	 * Calling giveMeTheTopCard removes a card 
	 * from the deck and decreases the number by 1
	 *
	 * @return the int
	 */
	int numberOfCardsinDeck();

	/**
	 * Give me the top card in the deck.
	 * 
	 * This will also reduce the number of cards in the 
	 * deck by 1
	 *
	 * @return the card
	 */
	Card giveMeTheTopCard();

	/**
	 * Shuffle the cards in the deck. This attempts to 
	 * imitate the "riffle" shuffle of splitting the cards
	 * into two piles and then selecting the top card from 
	 * each pile and put it back into the main deck. Ideally
	 * this should be called 7 times for a perfectly randomised 
	 * shuffle
	 */
	void shuffle();

	/**
	 * Re-shuffle playing card in deck.
	 */
	void reshuffle();

}