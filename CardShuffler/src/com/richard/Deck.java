package com.richard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * This represents a deck of 52 playing cards.
 */
public class Deck implements DeckShuffler {
	
	/** When splitting the deck roughly this represents the 
     * maximum number of cards in the smaller half of the deck. */
	private static final int MIN_NUM_IN_SMALL_HALF = 20;

    /** When splitting the deck roughly this represents the 
     * maximum number of cards in the larger half of the deck. */
    private static final int MAX_NUM_IN_LARGE_HALF = 40;

    /** The maximum number of cards in a deck. */
	private static final int MAX_NUM_IN_DECK = 52;

    /** The deck. */
	private ArrayList<Card> deck = null;
	
	/** The number of cards currently in the deck. */
	private int numberOfCardsInDeck = MAX_NUM_IN_DECK;
	
	/**
	 * Instantiates a new deck of playing cards. Each new
	 * deck has the cards in the order of 
	 * 
	 * Ace, Two, Three, Four, Five, Six, Seven,
     * Eight,Nine,Ten,Jack,Queen,King
	 * 
     * and with all of the same suit together in the order
     * Clubs, Diamonds, Hearts and Spades
	 */
	public Deck() {
		deck = new ArrayList<Card>();
		
		for (CardSuit suit : CardSuit.values()) {
			for (CardValue value : CardValue.values()) {
				Card card = new Card(suit, value);
				deck.add(card);
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.richard.DeckShuffler#numberOfCardsinDeck()
	 */
	@Override
	public final int numberOfCardsinDeck() {
		return numberOfCardsInDeck;
	}

	/* (non-Javadoc)
	 * @see com.richard.DeckShuffler#giveMeTheTopCard()
	 */
	@Override
	public final Card giveMeTheTopCard() {
		return deck.get(--numberOfCardsInDeck);
	}

	/* (non-Javadoc)
	 * @see com.richard.DeckShuffler#shuffle()
	 */
	@Override
	public final void shuffle() {
		// Split the pack into roughly two piles
		ArrayList<Card> firstPile = new ArrayList<Card>();
		ArrayList<Card> secondPile = new ArrayList<Card>();
		
		// Try to split in a way a human would
		// ie into roughly similar sized piles
		Random random = new Random();
		int numberInFirstPile = random.nextInt(
		        MAX_NUM_IN_LARGE_HALF - MIN_NUM_IN_SMALL_HALF + 1) 
		        + MIN_NUM_IN_SMALL_HALF;
		
		// some in one pile
		for (int i = 0; i < numberInFirstPile; i++) {
			firstPile.add(this.giveMeTheTopCard());
		}
		
		// some in another pile
		for (int i = numberInFirstPile; i < MAX_NUM_IN_DECK; i++) {
			secondPile.add(this.giveMeTheTopCard());
		}
		
		putSplitPilesBackToMainDeck(firstPile, secondPile);
		
	}

	/**
	 * This method amalgamates the two piles into
	 * one and copies it into the deck .
	 *
	 * @param firstPile first pile of cards
	 * @param secondPile second pile of cards
	 */
	private void putSplitPilesBackToMainDeck(
	        final ArrayList<Card> firstPile,
			final ArrayList<Card> secondPile) {
		//Take one of each pile and add it to the new pile
		ArrayList<Card> shuffledDeck = new ArrayList<Card>();
		
		for (int i = 0; i < MAX_NUM_IN_DECK; i++) {
			if (!firstPile.isEmpty()) {
				shuffledDeck.add(firstPile.remove(0));	
			}
			if (!secondPile.isEmpty()) {
				shuffledDeck.add(secondPile.remove(0));
			}
		}
		
		// Copy the shuffled deck back to the actual deck
		Collections.copy(deck, shuffledDeck);
		
		// Set the number of cards in the pack again
		numberOfCardsInDeck = deck.size();
	}

	/* (non-Javadoc)
	 * @see com.richard.DeckShuffler#reshuffle()
	 */
	@Override
	public final void reshuffle() {
		deck = new ArrayList<Card>();
		
		for (CardSuit suit : CardSuit.values()) {
			for (CardValue value : CardValue.values()) {
				Card card = new Card(suit, value);
				deck.add(card);
			}
		}
		
		this.numberOfCardsInDeck = MAX_NUM_IN_DECK;
		
		this.shuffle();
	}

}
