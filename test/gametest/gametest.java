package gametest;

import org.junit.Assert;
import javax.swing.JFrame;
import frame.GameFrame;
import org.junit.Before;
import game.Game;
import org.junit.Test;

public class gametest {
	Game game;
	
	@Before
	public void setUp() {
		game = new Game(new GameFrame(new JFrame()));
		game.gameStart();
	}

	@Test
	public void gameCheckTest() {
		Assert.assertEquals(0, game.gameCheck());
	}
	
	@Test
	public void positionsTest() {
		Assert.assertNotNull(game.positions('a'));
	}
	
	@Test
	public void letterMinTest() {
		Assert.assertEquals(true, (game.letterMin('a')>=0));
	}
	
	@Test
	public void maxLengthTest() {
		Assert.assertEquals(true, (game.maxLength()>0));
	}
	
	@Test
	public void invalidLengthTest() {
		Assert.assertEquals(true, game.invalidLength());
	}

}
