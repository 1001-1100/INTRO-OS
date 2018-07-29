import java.util.Random;

public class CalTrain {
	
	private static CalTrain calTrain = null;
	private Station[] stations;
	private int totalPassengers;
	private int waitingPassengers;
	private int totalTrains;
	
	private CalTrain() {
		totalPassengers = 0;
		waitingPassengers = 0;
		totalTrains = 0;
		Interface.getInstance().setTotalPassenger(totalPassengers);
		Interface.getInstance().setWaitingPassenger(waitingPassengers);
		Interface.getInstance().setTotalTrain(totalTrains);
		stations = new Station[10];
		for(int i = 0 ; i < 10 ; i++)
			(stations[i] = new Station()).station_init();
		generatePassengers();
		generateTrains();
	}
	
	public static CalTrain getInstance() {
		if(calTrain == null) {
			calTrain = new CalTrain();
		}
		return calTrain;
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
					try {
						sleep(rand.nextInt(1000)+100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
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
					try {
						sleep(rand.nextInt(5000)+5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		t.start();
	}
	
}
