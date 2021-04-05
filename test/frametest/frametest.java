package frametest;

import javax.swing.JFrame;
import org.junit.Assert;
import org.junit.Test;
import frame.*;


public class frametest {

	
	@Test
	public void menuFrameTest() {
		MenuFrame menu = new MenuFrame();
		Assert.assertNotNull(menu);
	}
	
	@Test
	public void gameFrameTest() {
		GameFrame game = new GameFrame(new JFrame());
		Assert.assertNotNull(game);
	}
	
	@Test
	public void exitFrameTest() {
		ExitFrame exit = new ExitFrame(0.25, true, new GameFrame(new JFrame()));
		Assert.assertNotNull(exit);
	}
	
	@Test
	public void toplisFrameTest() {
		ToplistFrame toplist = new ToplistFrame(new JFrame());
		Assert.assertNotNull(toplist);
	}
	
	@Test
	public void hangmanTest() {
		Hangman hangman = new Hangman();
		Assert.assertNotNull(hangman);
	}
}
