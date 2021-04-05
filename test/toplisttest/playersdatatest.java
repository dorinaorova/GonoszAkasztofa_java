package toplisttest;

import org.junit.Assert;
import org.junit.Before;
import toplist.PlayerData;
import org.junit.Test;

public class playersdatatest {
	
	PlayerData data;
	
	@Before
	public void setUp() {
		data= new PlayerData();
	}

	@Test
	public void getRowCountTest() {
		Assert.assertEquals(0, data.getRowCount());
	}
	
	@Test
	public void getColumnCountTest() {
		Assert.assertEquals(3, data.getColumnCount());
	}
	
	@Test
	public void getColumnClassTest() {
		Assert.assertEquals(String.class, data.getColumnClass(0));
		Assert.assertEquals(Double.class, data.getColumnClass(1));
		Assert.assertEquals(Double.class, data.getColumnClass(2));
	}
	
	@Test
	public void getColumnNameTest() {
		Assert.assertEquals("Név", data.getColumnName(0));
		Assert.assertEquals("Pontok", data.getColumnName(1));
		Assert.assertEquals("Nyerési arány (%)", data.getColumnName(2));
	}

}
