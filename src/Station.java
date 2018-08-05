
public class Station {
	
	int stationNumber;
	Lock trainLock;
	Monitor passengerMonitor;
	
	//Start
	public void station_init() {
		(trainLock = new Lock()).lock_init();
		passengerMonitor = new Monitor(stationNumber);
	}
	
	//Train
	public int station_load_train(int count) {
		trainLock.lock_acquire();
		Interface.getInstance().updateStationLock(stationNumber, true);
		Interface.getInstance().addTrain(stationNumber);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count = passengerMonitor.decrement(count);
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
	public void station_on_board() {
		
	}
	
}
