import java.util.Random;

public class CalTrain {
	
	private static CalTrain calTrain = null;
	private Station[] stations;
	private int totalPassengers;
	private int waitingPassengers;
	private int totalTrains;
	private boolean turboMode = true;
	
	private CalTrain() {
		totalPassengers = 0;
		waitingPassengers = 0;
		totalTrains = 0;
		Interface.getInstance().setTotalPassenger(totalPassengers);
		Interface.getInstance().setWaitingPassenger(waitingPassengers);
		Interface.getInstance().setTotalTrain(totalTrains);
		stations = new Station[8];
		for(int i = 0 ; i < 8 ; i++) {
			stations[i] = new Station();
			stations[i].stationNumber = i;
			stations[i].station_init();
		}
			
		generatePassengers();
		generateTrains();
	}
	
	public static CalTrain getInstance() {
		if(calTrain == null) {
			calTrain = new CalTrain();
		}
		return calTrain;
	}
	
	public boolean isTurbo() {
		return turboMode;
	}
	
	public void removeWaitingPassenger() {
		waitingPassengers -= 1;
		Interface.getInstance().setWaitingPassenger(waitingPassengers);
	}
	
	public void generatePassengers() {
		Thread t = new Thread() {
			public void run() {
				Random rand = new Random();
				Passenger p;
				while(true) {
					p = new Passenger(stations);
					totalPassengers += 1;
					waitingPassengers += 1;
					Interface.getInstance().setTotalPassenger(totalPassengers);
					Interface.getInstance().setWaitingPassenger(waitingPassengers);
					//if(!CalTrain.getInstance().isTurbo()) {
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					//}				
				}
			}
		};
		t.start();
	}
	
	public void generateTrains() {
		Thread t = new Thread() {
			public void run() {
				Random rand = new Random();
				Train t;
				while(true) {
					t = new Train(stations);	
					totalTrains += 1;
					Interface.getInstance().setTotalTrain(totalTrains);
					//if(!CalTrain.getInstance().isTurbo()) {
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					//}
				}
			}
		};
		t.start();
	}
	
}
