package org.oliparmenter.esper;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

public class Testbed {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider();
		String expression = "select avg(mid) from org.oliparmenter.esper.Tick.win:time(10 sec)";
		EPStatement statement = epService.getEPAdministrator().createEPL(expression);
		
		EsperEventListener listener = new EsperEventListener();
		statement.addListener(listener);
		
		TickGenerator t = new TickGenerator();
		while(true){

			Tick tick = t.getTick();
			//System.out.println(tick);
			
			epService.getEPRuntime().sendEvent(tick);
		}
	}

}
