import java.util.Random;

public class Passenger {

	static int id = 0;
	int currentId;
	int stationNumber;
	
	public Passenger(Station[] stations) {
		Random rand = new Random();
		stationNumber = rand.nextInt(7);
		Passenger.id += 1;
		currentId = Passenger.id;
		Thread t = new Thread() {
			public void run() {
				Interface.getInstance().updateConsole("Passenger "+currentId+" waiting at Station "+(stationNumber+1));
				stations[stationNumber].station_wait_for_train();
				Interface.getInstance().updateConsole("Passenger "+currentId+" boarded at Station "+(stationNumber+1));
			}
		};
		t.start();
	}
	
	public int getStationNumber() {
		return stationNumber+1;
	}
	
}
