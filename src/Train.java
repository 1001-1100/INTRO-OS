import java.util.Random;

public class Train {

	int remainingSeats;
	
	public Train(Station[] stations) {
		Random rand = new Random();
		remainingSeats = rand.nextInt(10);
		Interface.getInstance().updateConsole("Train with "+remainingSeats+" seats spawned!");
		
		Thread t = new Thread() {
			public void run() {
				for(int i = 0 ; i < 8 ; i++) {
					remainingSeats = stations[i].station_load_train(remainingSeats);
				}
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Interface.getInstance().updateConsole("Train has ended!");
			}
		};
		t.start();
	}
	
}
