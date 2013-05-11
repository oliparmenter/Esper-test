package org.oliparmenter.esper;

import org.apache.log4j.Logger;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

public class Testbed {

	private static final Logger logger = Logger.getLogger(Testbed.class);;
	
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		logger.debug("Starting ESPER test");
		
		EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider();
		String expression = "select avg(mid) from org.oliparmenter.esper.Tick.win:time(15 sec)";
		EPStatement statement = epService.getEPAdministrator().createEPL(expression);
		
		EsperEventListener listener = new EsperEventListener();
		statement.addListener(listener);
		
		TickGenerator t = new TickGenerator();
		while(true){

			Tick tick = t.getTick();
			//System.out.println(tick);
			Thread.currentThread().sleep(500);
			epService.getEPRuntime().sendEvent(tick);
		}
	}

}
