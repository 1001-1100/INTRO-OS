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
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;

public class Interface {

	private static Interface window = null;
	private JFrame frame;
	private JLayeredPane graphicalPanel;
	private JTextField totalPassenger;
	private JTextField totalTrain;
	private JTextField waitingPassenger;
	private JTextArea consoleText;
	private ArrayList<JLabel> trains;
	private int stations[][];
	
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
	
	public void addTrain() {
		JLabel train = new JLabel();
		train.setIcon(new ImageIcon("C:\\Users\\Nine\\Desktop\\train.png"));
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
				initSpeed = 50;
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
					initSpeed = 50;
				}
				int initDistance = trains.get(trainID).getY() - (-150);
				int distance = initDistance;
				while(trains.get(trainID).getY() > (-150)) {
					if(initSpeed > 1 && distance > initDistance/2 && distance % 2 == 1) {
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
					initSpeed = 50;
				}
				int initDistance = trains.get(trainID).getY() - (-150);
				int distance = initDistance;
				while(trains.get(trainID).getY() > (-150)) {
					if(initSpeed > 1 && distance > initDistance/2 && distance % 2 == 1) {
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
					initSpeed = 50;
				}
				int initDistance = trains.get(trainID).getY() - (-150);
				int distance = initDistance;
				while(trains.get(trainID).getY() > (-150)) {
					if(initSpeed > 1 && distance > initDistance/2 && distance % 2 == 1) {
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
	
	public void startSimulation() {
		trains = new ArrayList<>();
		stations = new int[11][2];
		for(int i = 0 ; i < 4 ; i++) {
			stations[i][0] = 260;
		}
		for(int i = 4 ; i < 7 ; i++) {
			stations[i][0] = 573;
		}
		for(int i = 7 ; i < 11 ; i++) {
			stations[i][0] = 884;
		}
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
		background.setIcon(new ImageIcon("C:\\Users\\Nine\\Desktop\\mapSmall.png"));
		background.setBounds(0, 0, 947, 670);
		graphicalPanel.add(background);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Nine\\Desktop\\train.png"));
		lblNewLabel.setBounds(260, -150, 60, 130);
		graphicalPanel.add(lblNewLabel);
		
		JLabel lblTotalPassenger = new JLabel("Total Passengers:");
		
		JLabel lblTotalTrain = new JLabel("Total Trains:");
		
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
		
		JScrollPane consoleScroll = new JScrollPane();
		
		JButton btnStartSimulation = new JButton("Start Simulation");
		btnStartSimulation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startSimulation();
			}
		});
		GroupLayout gl_infoPanel = new GroupLayout(infoPanel);
		gl_infoPanel.setHorizontalGroup(
			gl_infoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_infoPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_infoPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_infoPanel.createSequentialGroup()
							.addComponent(consoleScroll, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_infoPanel.createSequentialGroup()
							.addGroup(gl_infoPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_infoPanel.createSequentialGroup()
									.addComponent(lblTotalPassenger)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(totalPassenger, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_infoPanel.createSequentialGroup()
									.addComponent(lblWaitPassenger)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(waitingPassenger, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_infoPanel.createSequentialGroup()
									.addComponent(lblTotalTrain)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(totalTrain, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(79, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_infoPanel.createSequentialGroup()
							.addComponent(btnStartSimulation)
							.addGap(80))))
		);
		gl_infoPanel.setVerticalGroup(
			gl_infoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_infoPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_infoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotalPassenger)
						.addComponent(totalPassenger, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_infoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWaitPassenger)
						.addComponent(waitingPassenger, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_infoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotalTrain)
						.addComponent(totalTrain, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(consoleScroll, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnStartSimulation)
					.addContainerGap())
		);
		
		consoleText = new JTextArea();
		consoleText.setEditable(false);
		consoleScroll.setViewportView(consoleText);
		infoPanel.setLayout(gl_infoPanel);
		frame.getContentPane().setLayout(groupLayout);
		
		frame.setVisible(true);
	}
}
