public class Monitor {
	
	int data;
	Lock monitorLock;
	Condition cond;
	
	public Monitor() {
		(monitorLock = new Lock()).lock_init();
		(cond = new Condition()).cond_init();
	}
	
	public void procedure(String obj) {
		monitorLock.lock_acquire();
		data++;
		System.out.println(obj+" : "+data);
		monitorLock.lock_release();
	}

	//Train
	public void station_load_train(Station station, int count) {
		
	}	
	
	//Passenger
	public void station_wait_for_train(Station station) {
		
	}
	
	//Passenger
	public void station_on_board(Station station) {
		
	}
	
	//Start
	public void station_init() {
		
	}
	
}
