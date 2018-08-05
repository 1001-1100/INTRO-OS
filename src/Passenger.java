import java.util.Random;

public class Passenger {

	static int id = 0;
	int currentId;
	int stationNumber;
	int destNumber; 
	
	public Passenger(Station[] stations) {
		Random rand = new Random();
		stationNumber = rand.nextInt(8);
		destNumber = rand.nextInt(8);
		currentId = Passenger.id;
		Passenger.id += 1;
		Thread t = new Thread() {
			public void run() {
				Interface.getInstance().updateConsole("Passenger "+currentId+" waiting at Station "+(stationNumber));
				stations[stationNumber].station_wait_for_train();
				Interface.getInstance().updateConsole("Passenger "+currentId+" boarded at Station "+(stationNumber));
			}
		};
		t.start();
	}
	
	public Passenger(Station[] stations, int stationNumber, int destNumber) {
		this.stationNumber = stationNumber;
		this.destNumber = destNumber;
		currentId = Passenger.id;
		Passenger.id += 1;
		Thread t = new Thread() {
			public void run() {
				Interface.getInstance().updateConsole("Passenger "+currentId+" waiting at Station "+(stationNumber));
				stations[stationNumber].station_wait_for_train();
				Interface.getInstance().updateConsole("Passenger "+currentId+" boarded at Station "+(stationNumber));
			}
		};
		t.start();
	}
	
}
