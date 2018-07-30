
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

public class ControlBar {

	private JFrame frame;
	private JTextField sl1;
	private JTextField sl2;
	private JTextField sl3;
	private JTextField sl4;
	private JTextField sl5;
	private JTextField sl6;
	private JTextField sl7;
	private JTextField sl8;
	private JTextField sm1;
	private JTextField sm2;
	private JTextField sm5;
	private JTextField sm3;
	private JTextField sm4;
	private JTextField sm6;
	private JTextField sm7;
	private JTextField sm8;
	private JTextField wa1;
	private JTextField wa2;
	private JTextField wa3;
	private JTextField wa4;
	private JTextField wa5;
	private JTextField wa6;
	private JTextField wa7;
	private JTextField wa8;
	private JLabel lblWaiting;
	private JLabel label;

	public ControlBar(int x, int y, String title) {
		initialize(x,y,title);
	}
	
	public void updateMonitorLock(int stationNumber, boolean isLocked) {
		if(stationNumber == 0) {
			if(isLocked) {
				sm1.setText("LOCKED");
				sm1.setBackground(Color.RED);
			}else {
				sm1.setText("FREE");
				sm1.setBackground(Color.GREEN);
			}
		}else if(stationNumber == 1) {
			if(isLocked) {
				sm2.setText("LOCKED");
				sm2.setBackground(Color.RED);
			}else {
				sm2.setText("FREE");
				sm2.setBackground(Color.GREEN);
			}
		}else if(stationNumber == 2) {
			if(isLocked) {
				sm3.setText("LOCKED");
				sm3.setBackground(Color.RED);
			}else {
				sm3.setText("FREE");
				sm3.setBackground(Color.GREEN);
			}
		}else if(stationNumber == 3) {
			if(isLocked) {
				sm4.setText("LOCKED");
				sm4.setBackground(Color.RED);
			}else {
				sm4.setText("FREE");
				sm4.setBackground(Color.GREEN);
			}
		}else if(stationNumber == 4) {
			if(isLocked) {
				sm5.setText("LOCKED");
				sm5.setBackground(Color.RED);
			}else {
				sm5.setText("FREE");
				sm5.setBackground(Color.GREEN);
			}
		}else if(stationNumber == 5) {
			if(isLocked) {
				sm6.setText("LOCKED");
				sm6.setBackground(Color.RED);
			}else {
				sm6.setText("FREE");
				sm6.setBackground(Color.GREEN);
			}
		}else if(stationNumber == 6) {
			if(isLocked) {
				sm7.setText("LOCKED");
				sm7.setBackground(Color.RED);
			}else {
				sm7.setText("FREE");
				sm7.setBackground(Color.GREEN);
			}
		}else if(stationNumber == 7) {
			if(isLocked) {
				sm8.setText("LOCKED");
				sm8.setBackground(Color.RED);
			}else {
				sm8.setText("FREE");
				sm8.setBackground(Color.GREEN);
			}
		}
	}	
	
	public void updateStationLock(int stationNumber, boolean isLocked) {
		if(stationNumber == 0) {
			if(isLocked) {
				sl1.setText("LOCKED");
				sl1.setBackground(Color.RED);
			}else {
				sl1.setText("FREE");
				sl1.setBackground(Color.GREEN);
			}
		}else if(stationNumber == 1) {
			if(isLocked) {
				sl2.setText("LOCKED");
				sl2.setBackground(Color.RED);
			}else {
				sl2.setText("FREE");
				sl2.setBackground(Color.GREEN);
			}
		}else if(stationNumber == 2) {
			if(isLocked) {
				sl3.setText("LOCKED");
				sl3.setBackground(Color.RED);
			}else {
				sl3.setText("FREE");
				sl3.setBackground(Color.GREEN);
			}
		}else if(stationNumber == 3) {
			if(isLocked) {
				sl4.setText("LOCKED");
				sl4.setBackground(Color.RED);
			}else {
				sl4.setText("FREE");
				sl4.setBackground(Color.GREEN);
			}
		}else if(stationNumber == 4) {
			if(isLocked) {
				sl5.setText("LOCKED");
				sl5.setBackground(Color.RED);
			}else {
				sl5.setText("FREE");
				sl5.setBackground(Color.GREEN);
			}
		}else if(stationNumber == 5) {
			if(isLocked) {
				sl6.setText("LOCKED");
				sl6.setBackground(Color.RED);
			}else {
				sl6.setText("FREE");
				sl6.setBackground(Color.GREEN);
			}
		}else if(stationNumber == 6) {
			if(isLocked) {
				sl7.setText("LOCKED");
				sl7.setBackground(Color.RED);
			}else {
				sl7.setText("FREE");
				sl7.setBackground(Color.GREEN);
			}
		}else if(stationNumber == 7) {
			if(isLocked) {
				sl8.setText("LOCKED");
				sl8.setBackground(Color.RED);
			}else {
				sl8.setText("FREE");
				sl8.setBackground(Color.GREEN);
			}
		}
	}

	public void updateWaitingAmount(int stationNumber, int amount) {
		if(stationNumber == 0) {
			wa1.setText(Integer.toString(amount));
		}else if(stationNumber == 1) {
			wa2.setText(Integer.toString(amount));
		}else if(stationNumber == 2) {
			wa3.setText(Integer.toString(amount));
		}else if(stationNumber == 3) {
			wa4.setText(Integer.toString(amount));
		}else if(stationNumber == 4) {
			wa5.setText(Integer.toString(amount));
		}else if(stationNumber == 5) {
			wa6.setText(Integer.toString(amount));
		}else if(stationNumber == 6) {
			wa7.setText(Integer.toString(amount));
		}else if(stationNumber == 7) {
			wa8.setText(Integer.toString(amount));
		}
	}	
	
	private void initialize(int x, int y, String title) {
		frame = new JFrame();
		frame.setBounds(x, y, 720, 274);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(title);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(339, Short.MAX_VALUE))
		);
		
		JLabel lblStatus = new JLabel("T-Lock");
		lblStatus.setFont(new Font("Serif", Font.PLAIN, 12));
		
		JPanel statusPanel = new JPanel();
		
		JLabel lblMonitorLock = new JLabel("P-Lock");
		lblMonitorLock.setFont(new Font("Serif", Font.PLAIN, 12));
		
		JLabel lblTlock = new JLabel("T-Lock");
		lblTlock.setFont(new Font("Serif", Font.PLAIN, 12));
		
		JLabel lblPlock = new JLabel("P-Lock");
		lblPlock.setFont(new Font("Serif", Font.PLAIN, 12));
		
		lblWaiting = new JLabel("Waiting");
		lblWaiting.setFont(new Font("Serif", Font.PLAIN, 12));
		
		label = new JLabel("Waiting");
		label.setFont(new Font("Serif", Font.PLAIN, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(105)
							.addComponent(lblStatus)
							.addGap(47)
							.addComponent(lblMonitorLock)
							.addGap(47)
							.addComponent(lblWaiting)
							.addPreferredGap(ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
							.addComponent(lblTlock)
							.addGap(41)
							.addComponent(lblPlock, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(26))
						.addComponent(statusPanel, GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblMonitorLock, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblStatus)
							.addComponent(lblTlock, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblPlock, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblWaiting, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(statusPanel, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(339, Short.MAX_VALUE))
		);
		statusPanel.setLayout(new GridLayout(4, 6, 0, 0));
		
		JLabel lblStationOne = new JLabel("Station 1:");
		statusPanel.add(lblStationOne);
		
		sl1 = new JTextField();
		statusPanel.add(sl1);
		sl1.setBackground(Color.GREEN);
		sl1.setText("FREE");
		sl1.setEditable(false);
		sl1.setColumns(10);
		
		sm1 = new JTextField();
		sm1.setText("FREE");
		sm1.setEditable(false);
		sm1.setColumns(10);
		sm1.setBackground(Color.GREEN);
		statusPanel.add(sm1);
		
		wa1 = new JTextField();
		wa1.setText("0");
		wa1.setEditable(false);
		wa1.setColumns(10);
		wa1.setBackground(Color.WHITE);
		statusPanel.add(wa1);
		
		JLabel lblStation_1 = new JLabel("  Station 5:");
		statusPanel.add(lblStation_1);
		
		sl5 = new JTextField();
		statusPanel.add(sl5);
		sl5.setBackground(Color.GREEN);
		sl5.setText("FREE");
		sl5.setEditable(false);
		sl5.setColumns(10);
		
		sm5 = new JTextField();
		sm5.setText("FREE");
		sm5.setEditable(false);
		sm5.setColumns(10);
		sm5.setBackground(Color.GREEN);
		statusPanel.add(sm5);
		
		wa5 = new JTextField();
		wa5.setText("0");
		wa5.setEditable(false);
		wa5.setColumns(10);
		wa5.setBackground(Color.WHITE);
		statusPanel.add(wa5);
		
		JLabel lblStationTwo = new JLabel("Station 2:");
		statusPanel.add(lblStationTwo);
		
		sl2 = new JTextField();
		statusPanel.add(sl2);
		sl2.setBackground(Color.GREEN);
		sl2.setText("FREE");
		sl2.setEditable(false);
		sl2.setColumns(10);
		
		sm2 = new JTextField();
		sm2.setText("FREE");
		sm2.setEditable(false);
		sm2.setColumns(10);
		sm2.setBackground(Color.GREEN);
		statusPanel.add(sm2);
		
		wa2 = new JTextField();
		wa2.setText("0");
		wa2.setEditable(false);
		wa2.setColumns(10);
		wa2.setBackground(Color.WHITE);
		statusPanel.add(wa2);
		
		JLabel lblStation_2 = new JLabel("  Station 6:");
		statusPanel.add(lblStation_2);
		
		sl6 = new JTextField();
		statusPanel.add(sl6);
		sl6.setBackground(Color.GREEN);
		sl6.setText("FREE");
		sl6.setEditable(false);
		sl6.setColumns(10);
		
		sm6 = new JTextField();
		sm6.setText("FREE");
		sm6.setEditable(false);
		sm6.setColumns(10);
		sm6.setBackground(Color.GREEN);
		statusPanel.add(sm6);
		
		wa6 = new JTextField();
		wa6.setText("0");
		wa6.setEditable(false);
		wa6.setColumns(10);
		wa6.setBackground(Color.WHITE);
		statusPanel.add(wa6);
		
		JLabel lblStationThree = new JLabel("Station 3:");
		statusPanel.add(lblStationThree);
		
		sl3 = new JTextField();
		statusPanel.add(sl3);
		sl3.setBackground(Color.GREEN);
		sl3.setText("FREE");
		sl3.setEditable(false);
		sl3.setColumns(10);
		
		sm3 = new JTextField();
		sm3.setText("FREE");
		sm3.setEditable(false);
		sm3.setColumns(10);
		sm3.setBackground(Color.GREEN);
		statusPanel.add(sm3);
		
		wa3 = new JTextField();
		wa3.setText("0");
		wa3.setEditable(false);
		wa3.setColumns(10);
		wa3.setBackground(Color.WHITE);
		statusPanel.add(wa3);
		
		JLabel lblStation_3 = new JLabel("  Station 7:");
		statusPanel.add(lblStation_3);
		
		sl7 = new JTextField();
		statusPanel.add(sl7);
		sl7.setBackground(Color.GREEN);
		sl7.setText("FREE");
		sl7.setEditable(false);
		sl7.setColumns(10);
		
		sm7 = new JTextField();
		sm7.setText("FREE");
		sm7.setEditable(false);
		sm7.setColumns(10);
		sm7.setBackground(Color.GREEN);
		statusPanel.add(sm7);
		
		wa7 = new JTextField();
		wa7.setText("0");
		wa7.setEditable(false);
		wa7.setColumns(10);
		wa7.setBackground(Color.WHITE);
		statusPanel.add(wa7);
		
		JLabel lblStation = new JLabel("Station 4:");
		statusPanel.add(lblStation);
		
		sl4 = new JTextField();
		statusPanel.add(sl4);
		sl4.setBackground(Color.GREEN);
		sl4.setText("FREE");
		sl4.setEditable(false);
		sl4.setColumns(10);
		
		sm4 = new JTextField();
		sm4.setText("FREE");
		sm4.setEditable(false);
		sm4.setColumns(10);
		sm4.setBackground(Color.GREEN);
		statusPanel.add(sm4);
		
		wa4 = new JTextField();
		wa4.setText("0");
		wa4.setEditable(false);
		wa4.setColumns(10);
		wa4.setBackground(Color.WHITE);
		statusPanel.add(wa4);
		
		JLabel lblStation_4 = new JLabel("  Station 8:");
		statusPanel.add(lblStation_4);
		
		sl8 = new JTextField();
		statusPanel.add(sl8);
		sl8.setBackground(Color.GREEN);
		sl8.setText("FREE");
		sl8.setEditable(false);
		sl8.setColumns(10);
		
		sm8 = new JTextField();
		sm8.setText("FREE");
		sm8.setEditable(false);
		sm8.setColumns(10);
		sm8.setBackground(Color.GREEN);
		statusPanel.add(sm8);
		
		wa8 = new JTextField();
		wa8.setText("0");
		wa8.setEditable(false);
		wa8.setColumns(10);
		wa8.setBackground(Color.WHITE);
		statusPanel.add(wa8);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
		
		frame.setVisible(true);
	}
}
