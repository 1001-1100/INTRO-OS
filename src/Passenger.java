import java.util.Random;

public class Passenger {

	static int id = 0;
	int stationNumber;
	
	public Passenger(Station[] stations) {
		Random rand = new Random();
		stationNumber = rand.nextInt(7);
		
		Thread t = new Thread() {
			public void run() {
				Interface.getInstance().updateConsole("Passenger "+id+" waiting at Station "+(stationNumber+1));
				stations[stationNumber].station_wait_for_train();
			}
		};
		t.start();
	}
	
	public int getStationNumber() {
		return stationNumber+1;
	}
	
}
