package toplisttest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import toplist.Player;

public class playertest {
	
	Player player;
	
	@Before
	public void setUp() {
		player = new Player("Nev", 0.5, true);
	}

	@Test
	public void getNameTest() {
		Assert.assertEquals("Nev", player.getName());
	}
	
	@Test
	public void getPointsTest() {
		double point = 0.5;
		Assert.assertEquals(point, player.getPoints(), 0);
	}
	
	@Test
	public void setPointsTest() {
		player.setPoints(0.3);
		Assert.assertEquals(0.8, player.getPoints(), 0);
	}
	
	@Test
	public void getWinsTest() {
		Assert.assertEquals(100, player.getWins(), 0);
		player.setGames();
		Assert.assertEquals(50, player.getWins(), 0);
	}

}
