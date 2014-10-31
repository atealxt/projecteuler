package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.TestBase;
import io.github.atealxt.projecteuler.problem.Card;
import io.github.atealxt.projecteuler.problem.Poker;
import io.github.atealxt.projecteuler.problem.Problem54;

import java.util.Collections;
import java.util.List;

import org.junit.Assert;

public class Problem54Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertEquals(5, Card.parse("5H").value);
		Assert.assertEquals("Q", Card.parse("QH").text);
		Assert.assertEquals("S", Card.parse("AS").suit);
		List<Card> cards = ((Problem54) problem).parseCards("KD 8S 9S 7C 2S");
		Collections.sort(cards);
		Assert.assertEquals(Card.parse("2S"), cards.get(0));
		Assert.assertEquals(Poker.RANK_THREE_OF_A_KIND, ((Problem54) problem).recognize(((Problem54) problem).parseCards("2D 9C AS AH AC")).rank);
		Assert.assertEquals(Poker.RANK_ROYAL_FLUSH, ((Problem54) problem).recognize(((Problem54) problem).parseCards("TD JD QD KD AD")).rank);
		Assert.assertEquals(Poker.RANK_STRAIGHT_FLUSH, ((Problem54) problem).recognize(((Problem54) problem).parseCards("9D TD JD QD KD")).rank);
		Assert.assertEquals(Poker.RANK_FOUR_OF_A_KIND, ((Problem54) problem).recognize(((Problem54) problem).parseCards("9D TD TC TS TH")).rank);

		Assert.assertFalse(((Problem54) problem).p1Win(((Problem54) problem).parseCards("5H 5C 6S 7S KD"), ((Problem54) problem).parseCards("2C 3S 8S 8D TD")));
		Assert.assertTrue(((Problem54) problem).p1Win(((Problem54) problem).parseCards("5D 8C 9S JS AC"), ((Problem54) problem).parseCards("2C 5C 7D 8S QH")));
		Assert.assertFalse(((Problem54) problem).p1Win(((Problem54) problem).parseCards("2D 9C AS AH AC"), ((Problem54) problem).parseCards("3D 6D 7D TD QD")));
		Assert.assertTrue(((Problem54) problem).p1Win(((Problem54) problem).parseCards("4D 6S 9H QH QC"), ((Problem54) problem).parseCards("3D 6D 7H QD QS")));
		Assert.assertTrue(((Problem54) problem).p1Win(((Problem54) problem).parseCards("2H 2D 4C 4D 4S"), ((Problem54) problem).parseCards("3C 3D 3S 9S 9D")));

		Assert.assertEquals("376", problem.getResult());
	}
}
