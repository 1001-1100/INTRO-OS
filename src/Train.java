import java.util.Random;

public class Train {

	int currentStation;
	int remainingSeats;
	
	public Train(Station[] stations) {
		Random rand = new Random();
		remainingSeats = rand.nextInt(9)+99;
		Interface.getInstance().updateConsole("Train with "+remainingSeats+" seats spawned!");
		Thread t = new Thread() {
			public void run() {
				//while(true) {
					for(currentStation = 0; currentStation < 8 ; currentStation++) {
						remainingSeats = stations[currentStation].station_load_train(remainingSeats);
					}					
				//}
			}
		};
		t.start();
	}
	
}
