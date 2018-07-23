
public class Station {
	
	Lock trainLock;
	Monitor passengerMonitor;
	
	//Start
	public void station_init() {
		(trainLock = new Lock()).lock_init();
		passengerMonitor = new Monitor();
	}
	
	//Train
	public int station_load_train(int count) {
		trainLock.lock_acquire();
		count = passengerMonitor.decrement(count);
		trainLock.lock_release();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
