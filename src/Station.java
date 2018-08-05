
public class Station {
	
	int stationNumber;
	Train currentTrain;
	Lock trainLock;
	Monitor passengerMonitor;
	TrainCondition trainCondition;
	
	//Start
	public void station_init() {
		(trainLock = new Lock()).lock_init();
		passengerMonitor = new Monitor(stationNumber);
		(trainCondition = new TrainCondition(stationNumber)).cond_init();
	}
	
	//Train
	public int station_load_train(int count, int trainNumber) {
		trainLock.lock_acquire();
		this.currentTrain = CalTrain.getInstance().getTrain(trainNumber);
		Interface.getInstance().updateStationLock(stationNumber, true);
		Interface.getInstance().addTrain(stationNumber);
		CalTrain.getInstance().getTrain(trainNumber).unloadTrain(stationNumber);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count += CalTrain.getInstance().getTrain(trainNumber).unboardedSeats;
		CalTrain.getInstance().getTrain(trainNumber).unboardedSeats = 0;
		count = passengerMonitor.decrement(count);
		Interface.getInstance().updateTrainTaken(trainNumber, currentTrain.totalSeats-count);
		Interface.getInstance().removeTrain(stationNumber);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Interface.getInstance().updateStationLock(stationNumber, false);
		trainLock.lock_release();
		return count;
	}	
	
	//Passenger
	public void station_wait_for_train() {
		passengerMonitor.increment();
	}
	
	//Passenger
	public void station_on_board(int destNumber) {
		currentTrain.boardTrain(destNumber);	
	}
	
}
