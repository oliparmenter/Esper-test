import org.joda.time.DateTime;


public class Tick {

	private double mid;
	private DateTime timestamp;
	
	public Tick(double mid, DateTime timestamp){
		this.mid = mid;
		this.timestamp = new DateTime(timestamp);
	}
	
	public double getMid(){
		return mid;
	}
	
	public DateTime getTimestamp(){
		return timestamp;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Price: %f @ %s", mid, timestamp));
		return( sb.toString());
	}
}
