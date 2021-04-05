package gametest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import game.Word;


public class wordtest {
	
	Word word1;
	Word word2;
	
	@Before
	public void setUp() {
		word1= new Word("alma");
		word2=new Word(4);
	}

	@Test
	public void lengthTest() {
		Assert.assertEquals(4, word1.length());
		Assert.assertEquals(4, word2.length());
	}
	
	@Test
	public void charAtTest() {
		Assert.assertEquals('a', word1.charAt(0));
		Assert.assertEquals('_', word2.charAt(0));
	}
	
	@Test
	public void wordToWriteTest() {
		Assert.assertEquals("a l m a ", word1.wordToWrite());
		Assert.assertEquals("_ _ _ _ ", word2.wordToWrite());
	}
	
	@Test
	public void wordPositionCodeTest() {
		int[] i= {0,3};
		Assert.assertArrayEquals(i, word1.wordPositionCode('a'));
	}

	@Test
	public void buildWordTest() {
		String word="a _ _ a ";
		int[] i= {0,3};
		word2.buildWord('a', i);
		Assert.assertEquals(word, word2.wordToWrite());
	}
	
	@Test
	public void countLettersTest() {
		Assert.assertEquals(0, word1.countLetters('h'));
		Assert.assertEquals(2, word1.countLetters('a'));
	}
}
