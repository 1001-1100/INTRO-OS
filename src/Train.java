import java.util.Random;

public class Train {

	int remainingSeats;
	
	public Train() {
		Random rand = new Random();
		remainingSeats = rand.nextInt(10);
		
		Thread t = new Thread() {
			public void run() {
				
			}
		};
		t.start();
	}
	
}
