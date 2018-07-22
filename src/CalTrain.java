import java.util.Random;

public class CalTrain {
	
	private static CalTrain calTrain = null;
	private Station[] stations;
	private int totalPassengers;
	private int totalTrains;
	
	private CalTrain() {
		totalPassengers = 0;
		totalTrains = 0;
		stations = new Station[8];
		for(int i = 0 ; i < 8 ; i++)
			(stations[i] = new Station()).station_init();
		generatePassengers();
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
					Passenger.id += 1;
					totalPassengers += 1;
					Interface.getInstance().setTotalPassenger(totalPassengers);
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
		
	}
	
}
