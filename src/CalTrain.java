import java.util.Random;

public class CalTrain {
	
	private static CalTrain calTrain = null;
	private Station[] stations;
	private int totalPassengers;
	private int waitingPassengers;
	private int totalTrains;
	
	private CalTrain() {
		totalPassengers = 0;
		totalTrains = 0;
		stations = new Station[8];
		for(int i = 0 ; i < 8 ; i++)
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
				Train t;
				while(true) {
					try {
						sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					t = new Train(stations);					
				}
			}
		};
		t.start();
	}
	
}
