
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

public class EndStation {

	private JFrame frame;
	
	public EndStation(int x, int y, String title) {
		initialize(x,y,title);
	}
	
	private void initialize(int x, int y, String title) {
		frame = new JFrame();
		frame.setBounds(x, y, 847, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(title);
		
		JLayeredPane layeredPane = new JLayeredPane();
		
		JLabel background = new JLabel("");
		layeredPane.setLayer(background, -1);
		background.setIcon(new ImageIcon("C:\\Users\\Nine\\Desktop\\Materials\\quarterMapv3.png"));
		background.setBounds(0, -20, 832, 448);
		layeredPane.add(background);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 1264, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(layeredPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
		);
		
		JLabel fountain1 = new JLabel("");
		fountain1.setIcon(new ImageIcon("C:\\Users\\Nine\\Desktop\\fountain.gif"));
		fountain1.setBounds(255, 252, 63, 64);
		layeredPane.add(fountain1);
		
		JLabel fountain2 = new JLabel("");
		fountain2.setIcon(new ImageIcon("C:\\Users\\Nine\\Desktop\\fountain.gif"));
		fountain2.setBounds(516, 252, 63, 64);
		layeredPane.add(fountain2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Nine\\Desktop\\biggerEntrance2.png"));
		label.setBounds(327, 379, 180, 49);
		layeredPane.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Nine\\Desktop\\trainEndChanger.png"));
		lblNewLabel.setBounds(345, -43, 144, 108);
		layeredPane.add(lblNewLabel);
		frame.getContentPane().setLayout(groupLayout);
		
		frame.setVisible(true);
	}

}
