package org.oliparmenter.esper;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Test;

public class TestTick {


	@Test
	public void testTickCreate(){
		DateTime timeStamp = new DateTime();
		
		Tick t = new Tick(1.5, timeStamp);
		
		assertNotNull(t);
		
		assertEquals(1.5, t.getMid(), 0.000001);
		assertEquals(timeStamp, t.getTimestamp());
		
	}

}
