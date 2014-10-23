package com.richard;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CardTest {
	
	private Card card;
	
	@Before
	public void setup() {
		card = new Card(CardSuit.Clubs, CardValue.Ace);
	}

	@Test
	public void setAndGetClubsAsSuit() {		
		
		assertEquals(CardSuit.Clubs, card.getSuit());
	}
	
	@Test
	public void setAndGetValue() {
		
		assertEquals(CardValue.Ace, card.getValue());
		
	}

}
