import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import java.awt.GridLayout;

public class Interface {

	private static Interface window = null;
	private JFrame frame;
	private JLayeredPane graphicalPanel;
	private JTextField totalPassenger;
	private JTextField totalTrain;
	private JTextField waitingPassenger;
	private JTextArea consoleText;
	private ArrayList<JLabel> trains;
	private ArrayList<JLabel> passengers;
	private int stations[][];
	private int stationPassengers[][];
	private int stationPassengerAmount[];
	private int stationEntrance[][];
	private JTextField s1;
	private JTextField s2;
	private JTextField s3;
	private JTextField s4;
	private JTextField s5;
	private JTextField s6;
	private JTextField s7;
	private JTextField s8;
	private JTextField s9;
	
	/* Graphical Info:
	 	Train X First col = 260
	 	Train X Second col = 573
	 	Train X Third col = 884
		Train Y start = 670
		Station 1 Y = 520
		Station 2 Y = 280 
		Station 3 Y = 40
		End Y = -150
	 */
	
	private Interface() {
		initialize();
	}
	
	public static Interface getInstance() {
		if(window == null) {
			window = new Interface();
		}
		return window;
	}
	
	public void setTotalPassenger(int totalPassengers) {
		totalPassenger.setText(Integer.toString(totalPassengers));
	}
	
	public void setWaitingPassenger(int waitingPassengers) {
		waitingPassenger.setText(Integer.toString(waitingPassengers));
	}
	
	public void setTotalTrain(int totalTrains) {
		totalTrain.setText(Integer.toString(totalTrains));
	}
	
	public synchronized void updateConsole(String text) {
		consoleText.append(text+"\n");
	}
	
	public void addPassenger(int stationNumber) {
		Random rand = new Random();
		int randNum = rand.nextInt(2);
		JLabel passenger = new JLabel();
		passenger.setIcon(new ImageIcon("C:\\Users\\Nine\\Desktop\\2bMoveRight.png"));
		if(stationNumber == 1) {
			passenger.setBounds(stationEntrance[0][0], stationEntrance[0][1], 84, 73);
		}else if(stationNumber == 2) {
			if(randNum == 0) {
				passenger.setBounds(stationEntrance[0][0], stationEntrance[0][1], 84, 73);
			}else if(randNum == 1){
				passenger.setBounds(stationEntrance[1][0], stationEntrance[1][1], 84, 73);
			}
		}else if(stationNumber == 3) {
			passenger.setBounds(stationEntrance[1][0], stationEntrance[1][1], 84, 73);
		}else if(stationNumber == 4) {
			passenger.setBounds(stationEntrance[2][0], stationEntrance[2][1], 84, 73);
		}else if(stationNumber == 5) {
			if(randNum == 0) {
				passenger.setBounds(stationEntrance[2][0], stationEntrance[2][1], 84, 73);
			}else if(randNum == 1){
				passenger.setBounds(stationEntrance[3][0], stationEntrance[3][1], 84, 73);
			}
		}else if(stationNumber == 6) {
			passenger.setBounds(stationEntrance[3][0], stationEntrance[3][1], 84, 73);
		}else if(stationNumber == 7) {
			passenger.setBounds(stationEntrance[4][0], stationEntrance[4][1], 84, 73);
		}else if(stationNumber == 8) {
			if(randNum == 0) {
				passenger.setBounds(stationEntrance[4][0], stationEntrance[4][1], 84, 73);
			}else if(randNum == 1){
				passenger.setBounds(stationEntrance[5][0], stationEntrance[5][1], 84, 73);
			}
		}else if(stationNumber == 9) {
			passenger.setBounds(stationEntrance[5][0], stationEntrance[5][1], 84, 73);
		}
		passengers.add(passenger);
		graphicalPanel.add(passenger);
	}
	
	public void movePassenger(int passengerID, int stationNumber) {
		//198 290
		while(passengers.get(passengerID).getX() != stationPassengers[stationNumber][0]-(20*stationPassengerAmount[stationNumber]) || passengers.get(passengerID).getY() != stationPassengers[stationNumber][1]) {
			if(passengers.get(passengerID).getX() < stationPassengers[stationNumber][0]-(20*stationPassengerAmount[stationNumber])) {
				passengers.get(passengerID).setLocation(passengers.get(passengerID).getX()+1,passengers.get(passengerID).getY());
			}
			if(passengers.get(passengerID).getY() > stationPassengers[stationNumber][1]) {
				passengers.get(passengerID).setLocation(passengers.get(passengerID).getX(),passengers.get(passengerID).getY()-1);
			}
			if(passengers.get(passengerID).getY() < stationPassengers[stationNumber][1]) {
				passengers.get(passengerID).setLocation(passengers.get(passengerID).getX(),passengers.get(passengerID).getY()+1);
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//passengers.get(passengerID).setLocation(passengers.get(passengerID).getX(), passengers.get(passengerID).getY());
		passengers.get(passengerID).setIcon(new ImageIcon("C:\\Users\\Nine\\Desktop\\2bRight.gif"));
		stationPassengerAmount[stationNumber] += 1;
	}
	
	public void removePassenger(int passengerID, int stationNumber) {
		//198 290
		stationPassengerAmount[stationNumber] -= 1;
		passengers.get(passengerID).setIcon(null);
		graphicalPanel.remove(passengers.get(passengerID));
		passengers.set(passengerID, null);
	}
	
	public void addTrain() {
		JLabel train = new JLabel();
		train.setIcon(new ImageIcon(Interface.class.getResource("/train.png")));
		train.setBounds(260, 670, 60, 136);
		trains.add(train);
		graphicalPanel.add(train);
	}
	
	public void removeTrain(int trainID) {
		graphicalPanel.remove(trains.get(trainID));
		trains.get(trainID).setIcon(null);
		trains.set(trainID, null);
	}	
	
	public void moveTrain(int trainID, int fromStation, int toStation, boolean fromStart) {

		if(stations[fromStation][0] == stations[toStation][0]) {
			float initSpeed;
			if(fromStart) {
				initSpeed = 1;
			}else {
				initSpeed = 25;
			}
			int initDistance = trains.get(trainID).getY() - stations[toStation][1];
			int distance = initDistance;
			while(trains.get(trainID).getY() > stations[toStation][1]) {
				if(initSpeed > 1 && distance > initDistance/2 && distance % 2 == 1) {
					initSpeed -= 1;
				}else if(toStation != 10){
					if(initSpeed < 5) {
						initSpeed += 1;
					}
				}
				distance -= 1;
				trains.get(trainID).setLocation(trains.get(trainID).getX(), trains.get(trainID).getY()-1);
				try {
					Thread.sleep((long) initSpeed);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(toStation == 10) {
				removeTrain(trainID);
			}
		}else {
			if(fromStation >= 0 && fromStation < 4 && toStation >= 4 && toStation < 7) {
				float initSpeed;
				if(fromStart) {
					initSpeed = 1;
				}else {
					initSpeed = 25;
				}
				while(trains.get(trainID).getY() > (-150)) {
					if(initSpeed > 1) {
						initSpeed -= 1;
					}
					trains.get(trainID).setLocation(trains.get(trainID).getX(), trains.get(trainID).getY()-1);
					try {
						Thread.sleep((long) initSpeed);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				trains.get(trainID).setLocation(stations[toStation][0], 670);
				moveTrain(trainID, 4, toStation, true);
			}
			if(fromStation >= 4 && fromStation < 7 && toStation >= 7 && toStation <= 10) {
				float initSpeed;
				if(fromStart) {
					initSpeed = 1;
				}else {
					initSpeed = 25;
				}
				while(trains.get(trainID).getY() > (-150)) {
					if(initSpeed > 1) {
						initSpeed -= 1;
					}
					trains.get(trainID).setLocation(trains.get(trainID).getX(), trains.get(trainID).getY()-1);
					try {
						Thread.sleep((long) initSpeed);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				trains.get(trainID).setLocation(stations[toStation][0], 670);
				moveTrain(trainID, 7, toStation, true);
			}
			if(fromStation >= 0 && fromStation < 4 && toStation >= 7 && toStation <= 10) {
				float initSpeed;
				if(fromStart) {
					initSpeed = 1;
				}else {
					initSpeed = 25;
				}
				while(trains.get(trainID).getY() > (-150)) {
					if(initSpeed > 1) {
						initSpeed -= 1;
					}
					trains.get(trainID).setLocation(trains.get(trainID).getX(), trains.get(trainID).getY()-1);
					try {
						Thread.sleep((long) initSpeed);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				trains.get(trainID).setLocation(573, 670);
				moveTrain(trainID, 4, toStation, true);
			}
		}
	}
	
	public void refreshWaitingAmount() {
		s1.setText(Integer.toString(stationPassengerAmount[1]));
		s2.setText(Integer.toString(stationPassengerAmount[2]));
		s3.setText(Integer.toString(stationPassengerAmount[3]));
		s4.setText(Integer.toString(stationPassengerAmount[4]));
		s5.setText(Integer.toString(stationPassengerAmount[5]));
		s6.setText(Integer.toString(stationPassengerAmount[6]));
		s7.setText(Integer.toString(stationPassengerAmount[7]));
		s8.setText(Integer.toString(stationPassengerAmount[8]));
		s9.setText(Integer.toString(stationPassengerAmount[9]));
	}
	
	public void startSimulation() {
		trains = new ArrayList<>();
		passengers = new ArrayList<>();
		stations = new int[11][2];
		stationPassengers = new int[11][2];
		stationPassengerAmount = new int[11];
		stationEntrance = new int[6][2];
		
		for(int i = 0 ; i < 11 ; i++) {
			stationPassengerAmount[i] = 0;
		}
		for(int i = 0 ; i < 4 ; i++) {
			stations[i][0] = 260;
			stationPassengers[i][0] = 198;
		}
		for(int i = 4 ; i < 7 ; i++) {
			stations[i][0] = 573;
			stationPassengers[i][0] = 507;
		}
		for(int i = 7 ; i < 11 ; i++) {
			stations[i][0] = 884;
			stationPassengers[i][0] = 819;
		}
		
		stationEntrance[0][0] = 50; 
		stationEntrance[0][1] = 375; 
		stationEntrance[1][0] = 50; 
		stationEntrance[1][1] = 135; 
		stationEntrance[2][0] = 360; 
		stationEntrance[2][1] = 375; 
		stationEntrance[3][0] = 360; 
		stationEntrance[3][1] = 135; 
		stationEntrance[4][0] = 672; 
		stationEntrance[4][1] = 375; 
		stationEntrance[5][0] = 672; 
		stationEntrance[5][1] = 135; 
		
		stationPassengers[1][1] = 530;
		stationPassengers[2][1] = 290;
		stationPassengers[3][1] = 50;
		stationPassengers[4][1] = 530;
		stationPassengers[5][1] = 290;
		stationPassengers[6][1] = 50;
		stationPassengers[7][1] = 530;
		stationPassengers[8][1] = 290;
		stationPassengers[9][1] = 50;
		
		stations[1][1] = 520;
		stations[2][1] = 280;
		stations[3][1] = 40;
		stations[4][1] = 520;
		stations[5][1] = 280;
		stations[6][1] = 40;
		stations[7][1] = 520;
		stations[8][1] = 280;
		stations[9][1] = 40;
		stations[10][1] = -150;
		
		Thread t = new Thread() {
			public void run() {
				CalTrain.getInstance();
			}
		};
		t.start();

	};
	
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		graphicalPanel = new JLayeredPane();
		graphicalPanel.setBorder(null);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(graphicalPanel, GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(infoPanel, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(infoPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
						.addComponent(graphicalPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JLabel background = new JLabel("");
		graphicalPanel.setLayer(background, -1);
		background.setIcon(new ImageIcon(Interface.class.getResource("/mapSmall.png")));
		background.setBounds(0, 0, 947, 670);
		graphicalPanel.add(background);
		
		JLabel label = new JLabel("");
		graphicalPanel.setLayer(label, -2);
		label.setIcon(new ImageIcon("C:\\Users\\Nine\\Desktop\\2bRight.gif"));
		label.setBounds(198, 290, 60, 73);
		graphicalPanel.add(label);
		
		JLabel label_1 = new JLabel("");
		graphicalPanel.setLayer(label_1, -2);
		label_1.setIcon(new ImageIcon("C:\\Users\\Nine\\Desktop\\2bRight.gif"));
		label_1.setBounds(178, 290, 60, 73);
		graphicalPanel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		graphicalPanel.setLayer(label_2, -3);
		label_2.setIcon(new ImageIcon("C:\\Users\\Nine\\Desktop\\2bMoveRight.png"));
		label_2.setBounds(184, 290, 84, 71);
		graphicalPanel.add(label_2);
		
		JLabel label_3 = new JLabel((String) null);
		label_3.setBounds(169, 249, 6, 14);
		graphicalPanel.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(507, 290, 60, 73);
		graphicalPanel.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(819, 290, 60, 73);
		graphicalPanel.add(label_5);
		
		JLabel label_6 = new JLabel("");
		graphicalPanel.setLayer(label_6, -2);
		label_6.setIcon(new ImageIcon("C:\\Users\\Nine\\Desktop\\2bMoveRight.png"));
		label_6.setBounds(672, 135, 84, 71);
		graphicalPanel.add(label_6);
		
		JLabel lblTotalPassenger = new JLabel("Total Passengers Arrived:");
		
		JLabel lblTotalTrain = new JLabel("Total Trains Dispatched:");
		
		totalPassenger = new JTextField();
		totalPassenger.setEditable(false);
		totalPassenger.setColumns(10);
		
		totalTrain = new JTextField();
		totalTrain.setEditable(false);
		totalTrain.setColumns(10);
		
		JLabel lblWaitPassenger = new JLabel("Waiting Passengers:");
		
		waitingPassenger = new JTextField();
		waitingPassenger.setEditable(false);
		waitingPassenger.setColumns(10);
		
		JButton btnStartSimulation = new JButton("Start Simulation");
		btnStartSimulation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startSimulation();
			}
		});
		
		JPanel panel = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_infoPanel = new GroupLayout(infoPanel);
		gl_infoPanel.setHorizontalGroup(
			gl_infoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_infoPanel.createSequentialGroup()
					.addGroup(gl_infoPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_infoPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_infoPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_infoPanel.createSequentialGroup()
									.addGap(18)
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_infoPanel.createSequentialGroup()
									.addComponent(lblTotalPassenger)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(totalPassenger, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_infoPanel.createSequentialGroup()
									.addComponent(lblTotalTrain)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(totalTrain, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_infoPanel.createSequentialGroup()
									.addComponent(lblWaitPassenger)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(waitingPassenger, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_infoPanel.createSequentialGroup()
							.addGap(91)
							.addComponent(btnStartSimulation))
						.addGroup(gl_infoPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_infoPanel.setVerticalGroup(
			gl_infoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_infoPanel.createSequentialGroup()
					.addGroup(gl_infoPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_infoPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_infoPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTotalPassenger)
								.addComponent(totalPassenger, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_infoPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTotalTrain)
								.addComponent(totalTrain, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_infoPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblWaitPassenger)
								.addComponent(waitingPassenger, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_infoPanel.createSequentialGroup()
							.addGap(101)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnStartSimulation)
					.addContainerGap())
		);
		
		consoleText = new JTextArea();
		scrollPane.setViewportView(consoleText);
		consoleText.setEditable(false);
		
		JLabel lblStation = new JLabel("Station 1:");
		
		s1 = new JTextField();
		s1.setEditable(false);
		s1.setColumns(10);
		
		JLabel lblStation_4 = new JLabel("Station 5:");
		
		s5 = new JTextField();
		s5.setEditable(false);
		s5.setColumns(10);
		
		s6 = new JTextField();
		s6.setEditable(false);
		s6.setColumns(10);
		
		s7 = new JTextField();
		s7.setEditable(false);
		s7.setColumns(10);
		
		s8 = new JTextField();
		s8.setEditable(false);
		s8.setColumns(10);
		panel.setLayout(new GridLayout(0, 4, 10, 0));
		panel.add(lblStation);
		panel.add(s1);
		panel.add(lblStation_4);
		panel.add(s5);
		
		JLabel lblStation_1 = new JLabel("Station 2:");
		panel.add(lblStation_1);
		
		s2 = new JTextField();
		s2.setEditable(false);
		s2.setColumns(10);
		panel.add(s2);
		
		JLabel lblStation_5 = new JLabel("Station 6:");
		panel.add(lblStation_5);
		panel.add(s6);
		
		JLabel lblStation_2 = new JLabel("Station 3:");
		panel.add(lblStation_2);
		
		s3 = new JTextField();
		s3.setEditable(false);
		s3.setColumns(10);
		panel.add(s3);
		
		JLabel lblStation_6 = new JLabel("Station 7:");
		panel.add(lblStation_6);
		panel.add(s7);
		
		JLabel lblStation_3 = new JLabel("Station 4:");
		panel.add(lblStation_3);
		
		s4 = new JTextField();
		s4.setEditable(false);
		s4.setColumns(10);
		panel.add(s4);
		
		JLabel lblStation_7 = new JLabel("Station 8:");
		panel.add(lblStation_7);
		panel.add(s8);
		
		JLabel lblStation_8 = new JLabel("Station 9:");
		panel.add(lblStation_8);
		
		s9 = new JTextField();
		s9.setEditable(false);
		s9.setColumns(10);
		panel.add(s9);
		infoPanel.setLayout(gl_infoPanel);
		frame.getContentPane().setLayout(groupLayout);
		
		frame.setVisible(true);
	}
}
