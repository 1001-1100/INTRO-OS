import java.util.Random;

public class Train {

	static int id = 0;
	int currentId;
	int remainingSeats;
	
	public Train(Station[] stations) {
		Random rand = new Random();
		remainingSeats = rand.nextInt(10);
		currentId = Train.id;
		Train.id += 1;
		Interface.getInstance().updateConsole("Train with "+remainingSeats+" seats spawned!");
		Interface.getInstance().addTrain();
		Thread t = new Thread() {
			public void run() {
				for(int i = 0 ; i < 10 ; i++) {
					remainingSeats = stations[i].station_load_train(remainingSeats);
					Interface.getInstance().moveTrain(currentId, i, i+1, i==0);
				}
				Interface.getInstance().updateConsole("Train has ended!");
			}
		};
		t.start();
	}
	
}
