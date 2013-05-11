package org.oliparmenter.esper;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class EsperEventListener implements UpdateListener {

	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		EventBean event = newEvents[0];
		System.out.println("Listener: avg=" + event.get("avg(mid)"));
	}

}
