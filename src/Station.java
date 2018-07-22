
public class Station {
	
	Lock trainLock;
	Monitor passengerMonitor;
	
	//Start
	public void station_init() {
		(trainLock = new Lock()).lock_init();
		passengerMonitor = new Monitor();
	}
	
	//Train
	public void station_load_train(int count) {
		trainLock.lock_acquire();
		passengerMonitor.decrement();
		trainLock.lock_release();
	}	
	
	//Passenger
	public void station_wait_for_train() {
		passengerMonitor.increment();
	}
	
	//Passenger
	public void station_on_board() {
		
	}
	
}
