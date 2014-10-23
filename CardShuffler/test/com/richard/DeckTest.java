package com.richard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class DeckTest {

	DeckShuffler deck = null;

	@Before
	public void setUp() throws Exception {
		deck = new Deck();
	}

	@Test
	public void newDeckHas52Cards() {
		assertEquals(52, deck.numberOfCardsinDeck());
	}

	@Test
	public void getting_first_card_from_new_deck_is_king_of_spades() {
		Card c = deck.giveMeTheTopCard();
		assertEquals(CardSuit.Spades, c.getSuit());
		assertEquals(CardValue.King, c.getValue());
	}

	@Test
	public void after_shuffle_is_not_the_same_as_a_new_deck() {
		DeckShuffler secondDeck = new Deck();

		secondDeck.shuffle();

		boolean bothDecksMatch = true;

		for (int i = 0; i < deck.numberOfCardsinDeck(); i++) {
			Card firstDeckCard = deck.giveMeTheTopCard();
			Card secondDeckCard = secondDeck.giveMeTheTopCard();

			bothDecksMatch = checkCardsMatch(firstDeckCard, secondDeckCard);

			if (!bothDecksMatch) {
				break;
			}
		}

		assertTrue(!bothDecksMatch);
	}

	@Test
	public void first_shuffle_is_not_the_same_as_another_first_shuffle() {
		DeckShuffler firstDeck = new Deck();
		DeckShuffler secondDeck = new Deck();

		secondDeck.shuffle();

		boolean bothDecksMatch = true;

		for (int i = 0; i < firstDeck.numberOfCardsinDeck(); i++) {
			Card firstDeckCard = firstDeck.giveMeTheTopCard();
			Card secondDeckCard = secondDeck.giveMeTheTopCard();

			bothDecksMatch = checkCardsMatch(firstDeckCard, secondDeckCard);

			if (!bothDecksMatch) {
				break;
			}
		}

		assertTrue(!bothDecksMatch);
	}

	@Test
	public void not_possible_to_return_duplicate_cards_until_deck_is_reshuffled() {
		ArrayList<Card> deckOfCards = new ArrayList<Card>();

		// Check each card in the deck and ensure its unique
		for (int i = deck.numberOfCardsinDeck(); i > 0; i--) {
			Card c = deck.giveMeTheTopCard();

			assertFalse(checkIfCardsMatchInADeck(deckOfCards, c));

			deckOfCards.add(c);
		}

		// re-shuffle them again
		deck.reshuffle();

		// Check again and this time they should match
		Card cardAfterReshuffle = deck.giveMeTheTopCard();

		assertTrue("Not matching cards in a new pack when reshuffled",
				checkIfCardsMatchInADeck(deckOfCards, cardAfterReshuffle));
	}

	private boolean checkIfCardsMatchInADeck(ArrayList<Card> deckOfCards, Card c) {
		for (Iterator<Card> iterator = deckOfCards.iterator(); iterator
				.hasNext();) {
			Card card = iterator.next();

			if (card.getSuit() == c.getSuit()
					&& card.getValue() == c.getValue()) {
				return true;
			}
		}

		return false;
	}

	private boolean checkCardsMatch(Card firstDeckCard, Card secondDeckCard) {
		boolean bothCardsMatch = true;

		if (firstDeckCard.getSuit() != secondDeckCard.getSuit()
				|| firstDeckCard.getValue() != secondDeckCard.getValue()) {

			System.out.println("These cards are not the same!");
			printCard(firstDeckCard);
			printCard(secondDeckCard);

			bothCardsMatch = false;
		}
		return bothCardsMatch;
	}

	private void printCard(Card card) {
		System.out.println("This card is the: " + card.getValue() + " of "
				+ card.getSuit());
	}
}
