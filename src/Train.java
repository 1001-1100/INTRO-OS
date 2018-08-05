import java.util.Random;

public class Train {

	int currentStation;
	int trainNumber;
	int totalSeats;
	int remainingSeats;
	int unboardedSeats;
	Lock passengerLock;
	TrainCondition trainConditions[];
	boolean isMobilized;
	
	public Train(Station[] stations, int trainNumber) {
		isMobilized = true;
		unboardedSeats = 0;
		this.trainNumber = trainNumber;
		Random rand = new Random();
		(passengerLock = new Lock()).lock_init();
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
				while(isMobilized) {
					for(currentStation = 0; currentStation < 8 ; currentStation++) {
						Interface.getInstance().updateTrainStation(trainNumber, currentStation);
						remainingSeats = stations[currentStation].station_load_train(remainingSeats, trainNumber);
					}					
				}	
				Interface.getInstance().demobilizeTrain(trainNumber);
				CalTrain.getInstance().addAvailableTrain(trainNumber);
				Interface.getInstance().updateConsole("Train "+trainNumber+" has been demobilized!");
			}
		};
		Interface.getInstance().deployTrain(trainNumber, totalSeats);
		t.start();
	}
	
	public Train(Station[] stations, int trainNumber, int totalSeats) {
		isMobilized = true;
		unboardedSeats = 0;
		this.trainNumber = trainNumber;
		(passengerLock = new Lock()).lock_init();
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
				while(isMobilized) {
					for(currentStation = 0; currentStation < 8 ; currentStation++) {
						Interface.getInstance().updateTrainStation(trainNumber, currentStation);
						remainingSeats = stations[currentStation].station_load_train(remainingSeats, trainNumber);
					}					
				}
				Interface.getInstance().demobilizeTrain(trainNumber);
				CalTrain.getInstance().addAvailableTrain(trainNumber);
				Interface.getInstance().updateConsole("Train "+trainNumber+" has been demobilized!");
			}
		};
		Interface.getInstance().deployTrain(trainNumber, totalSeats);
		t.start();
	}
	
	public void unloadTrain(int stationNumber) {
		passengerLock.lock_acquire();
		trainConditions[stationNumber].cond_broadcast(passengerLock);
		trainConditions[stationNumber].cond_check(passengerLock);
		passengerLock.lock_release();
	}
	
	public void boardTrain(int stationNumber) {
		passengerLock.lock_acquire();
		unboardedSeats = 0;
		trainConditions[stationNumber].cond_wait(passengerLock);
		unboardedSeats += 1;
		Interface.getInstance().unloadPassenger(stationNumber);
		passengerLock.lock_release();
	}
	
	public void demobilize() {
		isMobilized = false;
	}
	
}
