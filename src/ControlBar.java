
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ControlBar {

	private JFrame frame;
	private JLabel lblWaiting;
	private JTextField tLock[];
	private JTextField pLock[];
	private JTextField waitAmount[];
	private JTextField trainSeats[];
	private JTextField trainTaken[];
	private JLabel trainLabel[];
	private JLabel lblSeats;
	private JLabel lblTaken;
	private JSlider trainSpeed;
	private JSlider passengerSpeed;
	private JTextArea console;
	
	public ControlBar(int x, int y, String title) {
		initialize(x,y,title);
	}
	
	public int getTrainSpeed() {
		return trainSpeed.getValue();
	}
	
	public int getPassengerSpeed() {
		return passengerSpeed.getValue();
	}
	
	public void updateConsole(String text) {
		console.append(text+"\n");
	}
	
	public void deployTrain(int trainNumber, int seats) {
		trainLabel[trainNumber].setEnabled(true);
		trainLabel[trainNumber].setBackground(Color.WHITE);
		trainSeats[trainNumber].setEnabled(true);
		trainSeats[trainNumber].setText(Integer.toString(seats));
		trainSeats[trainNumber].setBackground(Color.WHITE);
		trainTaken[trainNumber].setEnabled(true);
		trainTaken[trainNumber].setText("0");
		trainTaken[trainNumber].setBackground(Color.WHITE);
	}
	
	public void demobilizeTrain(int trainNumber) {
		trainLabel[trainNumber].setEnabled(false);
		trainLabel[trainNumber].setBackground(Color.GRAY);
		trainSeats[trainNumber].setEnabled(false);
		trainSeats[trainNumber].setText("0");
		trainSeats[trainNumber].setBackground(Color.GRAY);
		trainTaken[trainNumber].setEnabled(false);
		trainTaken[trainNumber].setText("0");
		trainTaken[trainNumber].setBackground(Color.GRAY);
	}
	
	public void updateMonitorLock(int stationNumber, boolean isLocked) {
		if(isLocked) {
			pLock[stationNumber].setText("LOCKED");
			pLock[stationNumber].setBackground(Color.RED);
		}else {
			pLock[stationNumber].setText("FREE");
			pLock[stationNumber].setBackground(Color.GREEN);
		}

	}	
	
	public void updateStationLock(int stationNumber, boolean isLocked) {
		if(isLocked) {
			tLock[stationNumber].setText("LOCKED");
			tLock[stationNumber].setBackground(Color.RED);
		}else {
			tLock[stationNumber].setText("FREE");
			tLock[stationNumber].setBackground(Color.GREEN);
		}
	}

	public void updateWaitingAmount(int stationNumber, int amount) {
		waitAmount[stationNumber].setText(Integer.toString(amount));
	}	
	
	private void initialize(int x, int y, String title) {
		frame = new JFrame();
		frame.setBounds(x, y, 318, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(title);
		
		tLock = new JTextField[8];
		pLock = new JTextField[8];
		waitAmount = new JTextField[8];
		trainSeats = new JTextField[16];
		trainTaken = new JTextField[16];
		trainLabel = new JLabel[16];
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
		);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Stations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Trains", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(tabbedPane, Alignment.LEADING)
						.addComponent(panel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
						.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("Manual", null, panel_2, null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Passenger", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Train", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setMaximumRowCount(16);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Train 1 (Red)"}));
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Train 1 (Red)"}));
		comboBox_2.setMaximumRowCount(16);
		
		JButton btnDeploy_1 = new JButton("Deploy");
		
		JButton btnGet = new JButton("Demobilize");
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 99, 1));
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(1, 1, 99, 1));
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_7.createSequentialGroup()
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDeploy_1))
						.addGroup(gl_panel_7.createSequentialGroup()
							.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnGet)))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeploy_1)
						.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGet)
						.addComponent(spinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		panel_7.setLayout(gl_panel_7);
		
		JLabel lblNewLabel = new JLabel("Arriving Station:");
		
		JLabel lblDepartingStation = new JLabel("Departing Station:");
		
		JLabel lblType = new JLabel("Type:");
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 8, 1));
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 8, 1));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2B", "A2", "21O", "Ronaldo"}));
		
		JButton btnDeploy = new JButton("Add");
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_6.createSequentialGroup()
							.addComponent(lblDepartingStation)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
							.addComponent(btnDeploy)
							.addGap(27))
						.addGroup(gl_panel_6.createSequentialGroup()
							.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_6.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_6.createSequentialGroup()
									.addComponent(lblType)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(120, Short.MAX_VALUE))))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDepartingStation)
						.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeploy))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblType)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		panel_6.setLayout(gl_panel_6);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("Automatic", null, panel_1, null);
		
		JToggleButton tglbtnToggleAutomatic = new JToggleButton("Toggle Automatic");
		tglbtnToggleAutomatic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CalTrain.getInstance().toggleAutomatic();
				CalTrain.getInstance().automaticMode();
			}
		});
		
		JSlider slider = new JSlider();
		slider.setMaximum(2100);
		slider.setValue(1100);
		slider.setMinimum(100);
		
		JLabel lblPassengerRate = new JLabel("Passenger Rate");
		
		JLabel lblTrainRate = new JLabel("Train Rate");
		
		JSlider slider_1 = new JSlider();
		slider_1.setMinimum(5);
		slider_1.setValue(55);
		slider_1.setMaximum(105);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(40, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(95)
					.addComponent(lblPassengerRate)
					.addContainerGap(104, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(108, Short.MAX_VALUE)
					.addComponent(lblTrainRate)
					.addGap(117))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(76)
					.addComponent(tglbtnToggleAutomatic)
					.addContainerGap(84, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addGap(39)
					.addComponent(lblPassengerRate)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(lblTrainRate)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(slider_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addComponent(tglbtnToggleAutomatic)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("Settings", null, panel_5, null);
		
		trainSpeed = new JSlider();
		trainSpeed.setValue(3);
		trainSpeed.setMinimum(1);
		trainSpeed.setMaximum(5);
		
		JLabel lblTrainSpeed = new JLabel("Train Speed");
		
		JLabel lblPassengerSpeed = new JLabel("Passenger Speed");
		
		passengerSpeed = new JSlider();
		passengerSpeed.setValue(8);
		passengerSpeed.setMinimum(1);
		passengerSpeed.setMaximum(15);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap(43, Short.MAX_VALUE)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
							.addComponent(passengerSpeed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(trainSpeed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel_5.createSequentialGroup()
								.addGap(72)
								.addComponent(lblTrainSpeed)))
						.addGroup(Alignment.TRAILING, gl_panel_5.createSequentialGroup()
							.addComponent(lblPassengerSpeed)
							.addGap(58)))
					.addGap(32))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(62)
					.addComponent(lblPassengerSpeed)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(passengerSpeed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(lblTrainSpeed)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(trainSpeed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(106, Short.MAX_VALUE))
		);
		panel_5.setLayout(gl_panel_5);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("Log", null, panel_8, null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		console = new JTextArea();
		scrollPane_1.setViewportView(console);
		panel_8.setLayout(gl_panel_8);
		
		lblSeats = new JLabel("Capacity");
		lblSeats.setFont(new Font("Serif", Font.PLAIN, 12));
		
		lblTaken = new JLabel("Taken");
		lblTaken.setFont(new Font("Serif", Font.PLAIN, 12));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JPanel trainPanel = new JPanel();
		scrollPane.setViewportView(trainPanel);
		trainPanel.setLayout(new GridLayout(16, 3, 1, 1));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(102)
					.addComponent(lblSeats)
					.addGap(36)
					.addComponent(lblTaken, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(53, Short.MAX_VALUE))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSeats)
						.addComponent(lblTaken))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		
		JLabel lblStatus = new JLabel("T-Lock");
		lblStatus.setFont(new Font("Serif", Font.PLAIN, 12));
		
		JLabel lblMonitorLock = new JLabel("P-Lock");
		lblMonitorLock.setFont(new Font("Serif", Font.PLAIN, 12));
		
		lblWaiting = new JLabel("Waiting");
		lblWaiting.setFont(new Font("Serif", Font.PLAIN, 12));
		
		JPanel statusPanel = new JPanel();
		statusPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
				statusPanel.setLayout(new GridLayout(0, 4, 1, 1));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(statusPanel, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(75)
					.addComponent(lblStatus)
					.addGap(26)
					.addComponent(lblMonitorLock)
					.addGap(26)
					.addComponent(lblWaiting)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStatus)
						.addComponent(lblMonitorLock)
						.addComponent(lblWaiting))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(statusPanel, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE))
		);
		panel_3.setLayout(gl_panel_3);
		
		for(int i = 0 ; i < 16 ; i++) {
			trainLabel[i] = new JLabel(" Train "+(i+1)+":");
			trainLabel[i].setEnabled(false);
			trainPanel.add(trainLabel[i]);
			
			trainSeats[i] = new JTextField();
			trainSeats[i].setText("0");
			trainSeats[i].setEditable(false);
			trainSeats[i].setColumns(1);
			trainSeats[i].setBackground(Color.GRAY);
			trainSeats[i].setEnabled(false);
			trainPanel.add(trainSeats[i]);
			
			trainTaken[i] = new JTextField();
			trainTaken[i].setText("0");
			trainTaken[i].setEditable(false);
			trainTaken[i].setColumns(1);
			trainTaken[i].setBackground(Color.GRAY);
			trainTaken[i].setEnabled(false);
			trainPanel.add(trainTaken[i]);
		}
		
		for(int i = 0 ; i < 8 ; i++) {
			JLabel lblStation = new JLabel(" Station "+(i+1)+":");
			statusPanel.add(lblStation);
			
			tLock[i] = new JTextField();
			tLock[i].setBackground(Color.GREEN);
			tLock[i].setText("FREE");
			tLock[i].setEditable(false);
			tLock[i].setColumns(1);
			statusPanel.add(tLock[i]);
			
			pLock[i] = new JTextField();
			pLock[i].setText("FREE");
			pLock[i].setEditable(false);
			pLock[i].setColumns(1);
			pLock[i].setBackground(Color.GREEN);
			statusPanel.add(pLock[i]);
			
			waitAmount[i] = new JTextField();
			waitAmount[i].setText("0");
			waitAmount[i].setEditable(false);
			waitAmount[i].setColumns(1);
			waitAmount[i].setBackground(Color.WHITE);
			statusPanel.add(waitAmount[i]);
		}

		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
		
		frame.setVisible(true);
	}
}
