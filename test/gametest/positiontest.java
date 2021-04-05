package gametest;

import java.util.Arrays;
import org.junit.Before;
import game.Position;
import game.PositionList;
import org.junit.Assert;

import org.junit.Test;

public class positiontest {
	int[] i = {0,1,2};
	Position pos;
	PositionList list;
	
	@Before
	public void setUp() {

		pos = new Position(i);
		list = new PositionList();
		list.addNewNumber(pos.getNumber());
	}

	@Test
	public void getCntTest() {
		int resoultCnt = pos.getCnt();
		Assert.assertEquals(0, resoultCnt);
	}
	
	@Test
	public void getNumberTest() {
		int[] resoultNumber= pos.getNumber();
		Assert.assertArrayEquals(i, resoultNumber);
	}
	
	@Test
	public void increaseCntTest() {
		pos.increaseCnt();
		Assert.assertEquals(1, pos.getCnt());
	}
	
	@Test
	public void positionaMaxTest() {
		Assert.assertNotNull(list.positionMax());
		Assert.assertEquals(pos.getNumber(), list.positionMax().getNumber());
	}
	
	@Test
	public void searchNumberTest() {
		Assert.assertEquals(true, list.searchNumber(i));
	}

}
