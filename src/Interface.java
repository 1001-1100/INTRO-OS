
public class Interface {

	private static Interface window = null;
	StartStation t1;
	TrainStations t2;
	TrainStations t3;
	EndStation t4;
	ControlBar cB;
	
	/* Graphical Info:
	 	left start: 356, 430
		right start: 420, -130
		left Station: 105
		right station: 90
		
		leftPassenger start: 85 240
		leftPassenger stop: 260 135
		
		leftPassenger idle: 278 130
		
		rightPassenger start: 464 240
		rightPassenger stop: 494 135
		
		rightPassenger idle: 495 131
	 */
	
	private Interface() {
		initialize();
		startSimulation();
	}
	
	public static Interface getInstance() {
		if(window == null) {
			window = new Interface();
		}
		return window;
	}
	
	public void updateStationLock(int stationNumber, boolean isLocked) {
		cB.updateStationLock(stationNumber, isLocked);
	}
	
	public void updateMonitorLock(int stationNumber, boolean isLocked) {
		cB.updateMonitorLock(stationNumber, isLocked);
	}
	
	public void updateWaitingAmount(int stationNumber, int amount) {
		cB.updateWaitingAmount(stationNumber, amount);
	}
	
	public void setTotalPassenger(int totalPassengers) {
	}
	
	public void setWaitingPassenger(int waitingPassengers) {
	}
	
	public void setTotalTrain(int totalTrains) {
	}
	
	public synchronized void updateConsole(String text) {
		cB.updateConsole(text);
	}
	
	public void deployTrain(int trainNumber, int seats) {
		cB.deployTrain(trainNumber, seats);
	}
	
	public void demobilizeTrain(int trainNumber) {
		cB.demobilizeTrain(trainNumber);
	}	
	
	public void addPassenger(int stationNumber) {
		if(stationNumber == 0) {
			t1.addLeftPassenger();
		}else if(stationNumber == 1) {
			t2.addLeftPassenger();
		}else if(stationNumber == 2) {
			t3.addLeftPassenger();
		}else if(stationNumber == 3) {
			t4.addLeftPassenger();
		}else if(stationNumber == 4) {
			t4.addRightPassenger();
		}else if(stationNumber == 5) {
			t3.addRightPassenger();
		}else if(stationNumber == 6) {
			t2.addRightPassenger();
		}else if(stationNumber == 7) {
			t1.addRightPassenger();
		}
	}
	
	public void removePassenger(int stationNumber) {
		if(stationNumber == 0) {
			t1.removeLeftPassenger();
		}else if(stationNumber == 1) {
			t2.removeLeftPassenger();
		}else if(stationNumber == 2) {
			t3.removeLeftPassenger();
		}else if(stationNumber == 3) {
			t4.removeLeftPassenger();
		}else if(stationNumber == 4) {
			t4.removeRightPassenger();
		}else if(stationNumber == 5) {
			t3.removeRightPassenger();
		}else if(stationNumber == 6) {
			t2.removeRightPassenger();
		}else if(stationNumber == 7) {
			t1.removeRightPassenger();
		}
	}
	
	public void addTrain(int stationNumber) {
		if(stationNumber == 0) {
			t1.addLeftTrain();
		}else if(stationNumber == 1) {
			t2.addLeftTrain();
		}else if(stationNumber == 2) {
			t3.addLeftTrain();
		}else if(stationNumber == 3) {
			t4.addLeftTrain();
		}else if(stationNumber == 4) {
			t4.addRightTrain();
		}else if(stationNumber == 5) {
			t3.addRightTrain();
		}else if(stationNumber == 6) {
			t2.addRightTrain();
		}else if(stationNumber == 7) {
			t1.addRightTrain();
		}
	}
	
	public void removeTrain(int stationNumber) {
		if(stationNumber == 0) {
			t1.removeLeftTrain();
		}else if(stationNumber == 1) {
			t2.removeLeftTrain();
		}else if(stationNumber == 2) {
			t3.removeLeftTrain();
		}else if(stationNumber == 3) {
			t4.removeLeftTrain();
		}else if(stationNumber == 4) {
			t4.removeRightTrain();
		}else if(stationNumber == 5) {
			t3.removeRightTrain();
		}else if(stationNumber == 6) {
			t2.removeRightTrain();
		}else if(stationNumber == 7) {
			t1.removeRightTrain();
		}
	}	
	
	public void moveTrain(int stationNumber) {
		if(stationNumber == 0) {
			t1.removeLeftTrain();
			t2.addLeftTrain();
		}else if(stationNumber == 1) {
			t2.removeLeftTrain();
			t3.addLeftTrain();
		}else if(stationNumber == 2) {
			t3.removeLeftTrain();
			t4.addLeftTrain();
		}else if(stationNumber == 3) {
			t4.removeLeftTrain();
			t4.addRightTrain();
		}else if(stationNumber == 4) {
			t4.removeRightTrain();
			t3.addRightTrain();
		}else if(stationNumber == 5) {
			t3.removeRightTrain();
			t2.addRightTrain();
		}else if(stationNumber == 6) {
			t2.removeRightTrain();
			t1.addRightTrain();
		}else if(stationNumber == 7) {
			t1.removeRightTrain();
			t1.addLeftTrain();
		}
	}
	
	public void refreshWaitingAmount() {

	}
	
	public void startSimulation() {
		
		Thread t = new Thread() {
			public void run() {
				CalTrain.getInstance();
			}
		};
		t.start();

	};
	
	public int getTrainSpeed() {
		return 6-cB.getTrainSpeed();
	}
	
	public int getPassengerSpeed() {
		return 16-cB.getPassengerSpeed();
	}
	
	private void initialize() {
		t1 = new StartStation(0,465, "Train Station 1 and 2");
		t2 = new TrainStations(0,0, "Train Station 3 and 4");
		t3 = new TrainStations(847,465, "Train Station 5 and 6");
		t4 = new EndStation(847,0, "Train Station 7 and 8");
		cB = new ControlBar(1600,0,"Control Bar");
	}
		
}
