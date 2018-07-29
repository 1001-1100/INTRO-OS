import java.util.Random;

public class Passenger {

	static int id = 0;
	int currentId;
	int stationNumber;
	 
	public Passenger(Station[] stations) {
		Random rand = new Random();
		stationNumber = rand.nextInt(5) + 5;
		currentId = Passenger.id;
		Passenger.id += 1;
		Interface.getInstance().addPassenger(stationNumber);
		Interface.getInstance().refreshWaitingAmount();
		Interface.getInstance().movePassenger(currentId, stationNumber);
		Thread t = new Thread() {
			public void run() {
				Interface.getInstance().updateConsole("Passenger "+currentId+" waiting at Station "+(stationNumber));
				stations[stationNumber].station_wait_for_train();
				Interface.getInstance().removePassenger(currentId,stationNumber);
				CalTrain.getInstance().removeWaitingPassenger();
				Interface.getInstance().refreshWaitingAmount();
				Interface.getInstance().updateConsole("Passenger "+currentId+" boarded at Station "+(stationNumber));
			}
		};
		t.start();
	}
	
	public int getStationNumber() {
		return stationNumber+1;
	}
	
}
