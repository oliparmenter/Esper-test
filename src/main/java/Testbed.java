
public class Testbed {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TickGenerator t = new TickGenerator();
		while(true){

			Tick tick = t.getTick();
			System.out.println(tick);
		}
	}

}
