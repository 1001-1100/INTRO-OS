import java.util.ArrayList;
import java.util.Random;

public class CalTrain {
	
	private static CalTrain calTrain = null;
	private Station[] stations;
	private Train[] trains;
	private ArrayList<Integer> availableTrains;
	private int totalPassengers;
	private int waitingPassengers;
	private int totalTrains;
	private boolean turboMode = true;
	private boolean isAuto = false;
	
	private CalTrain() {
		totalPassengers = 0;
		waitingPassengers = 0;
		totalTrains = 0;
		availableTrains = new ArrayList<>();
		Interface.getInstance().setTotalPassenger(totalPassengers);
		Interface.getInstance().setWaitingPassenger(waitingPassengers);
		Interface.getInstance().setTotalTrain(totalTrains);
		stations = new Station[8];
		for(int i = 0 ; i < 8 ; i++) {
			stations[i] = new Station();
			stations[i].stationNumber = i;
			stations[i].station_init();
		}
		trains = new Train[16];
		for(int i = 0 ; i < 16 ; i++) {
			availableTrains.add(i);
		}
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
	
	public void toggleAutomatic() {
		if(isAuto) {
			isAuto = false;
		}else {
			isAuto = true;
		}
	}
	
	public void automaticMode() {
		generatePassengers();
		generateTrains();
	}
	
	public void generatePassengers() {
		Thread t = new Thread() {
			public void run() {
				Random rand = new Random();
				Passenger p;
				while(isAuto) {
					p = new Passenger(stations);
					totalPassengers += 1;
					waitingPassengers += 1;
					Interface.getInstance().setTotalPassenger(totalPassengers);
					Interface.getInstance().setWaitingPassenger(waitingPassengers);
					try {
						Thread.sleep(1500);
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
				while(isAuto) {
					if(availableTrains.get(0) != null) {
						t = new Train(stations,availableTrains.get(0));	
						availableTrains.remove(0);
						totalTrains += 1;
						Interface.getInstance().setTotalTrain(totalTrains);
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		};
		t.start();
	}
	
}
