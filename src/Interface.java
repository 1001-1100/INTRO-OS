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

public class Interface {

	private static Interface window = null;
	private JFrame frame;
	private JTextField totalPassenger;
	private JTextField totalTrain;
	private JTextField textField;
	private JTextArea consoleText;
	
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
	
	public void setTotalTrain(int totalTrains) {
		totalTrain.setText(Integer.toString(totalTrains));
	}
	
	public void updateConsole(String text) {
		consoleText.append(text+"\n");
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JPanel graphicPanel = new JPanel();
		graphicPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(graphicPanel, GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(infoPanel, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(graphicPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
						.addComponent(infoPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JLabel lblTotalPassenger = new JLabel("Total Passengers:");
		
		JLabel lblTotalTrain = new JLabel("Total Trains:");
		
		totalPassenger = new JTextField();
		totalPassenger.setEditable(false);
		totalPassenger.setColumns(10);
		
		totalTrain = new JTextField();
		totalTrain.setEditable(false);
		totalTrain.setColumns(10);
		
		JLabel lblWaitPassenger = new JLabel("Waiting Passengers:");
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		
		JScrollPane consoleScroll = new JScrollPane();
		GroupLayout gl_infoPanel = new GroupLayout(infoPanel);
		gl_infoPanel.setHorizontalGroup(
			gl_infoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_infoPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_infoPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_infoPanel.createSequentialGroup()
							.addComponent(lblTotalPassenger)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(totalPassenger, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_infoPanel.createSequentialGroup()
							.addComponent(lblWaitPassenger)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_infoPanel.createSequentialGroup()
							.addComponent(lblTotalTrain)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(totalTrain, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(consoleScroll, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
					.addContainerGap())
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
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_infoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotalTrain)
						.addComponent(totalTrain, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(consoleScroll, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
					.addGap(283))
		);
		
		consoleText = new JTextArea();
		consoleText.setEditable(false);
		consoleScroll.setViewportView(consoleText);
		infoPanel.setLayout(gl_infoPanel);
		frame.getContentPane().setLayout(groupLayout);
		
		frame.setVisible(true);
	}
}
