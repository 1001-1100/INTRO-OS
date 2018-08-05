import java.util.Random;

public class Train {

	int currentStation;
	int trainNumber;
	int totalSeats;
	int remainingSeats;
	TrainCondition trainConditions[];
	
	public Train(Station[] stations, int trainNumber) {
		this.trainNumber = trainNumber;
		Random rand = new Random();
		trainConditions = new TrainCondition[8];
		for(int i = 0 ; i < 8 ; i++) {
			trainConditions[i] = new TrainCondition(i);
			trainConditions[i].cond_init();
		}
		totalSeats = rand.nextInt(99)+1;
		remainingSeats = totalSeats;
		Interface.getInstance().updateConsole("Train with "+remainingSeats+" seats spawned!");
		Thread t = new Thread() {
			public void run() {
				for(currentStation = 0; currentStation < 8 ; currentStation++) {
					remainingSeats = stations[currentStation].station_load_train(remainingSeats);
				}					
			}
		};
		Interface.getInstance().deployTrain(trainNumber, totalSeats);
		t.start();
	}
	
	public Train(Station[] stations, int trainNumber, int totalSeats) {
		this.trainNumber = trainNumber;
		trainConditions = new TrainCondition[8];
		for(int i = 0 ; i < 8 ; i++) {
			trainConditions[i] = new TrainCondition(i);
			trainConditions[i].cond_init();
		}
		this.totalSeats = totalSeats;
		remainingSeats = totalSeats;
		Interface.getInstance().updateConsole("Train with "+remainingSeats+" seats spawned!");
		Thread t = new Thread() {
			public void run() {
				//while(true) {
					for(currentStation = 0; currentStation < 8 ; currentStation++) {
						remainingSeats = stations[currentStation].station_load_train(remainingSeats);
					}
					Interface.getInstance().demobilizeTrain(trainNumber);
				//}
			}
		};
		Interface.getInstance().deployTrain(trainNumber, totalSeats);
		t.start();
	}
	
}
