package views;

import javax.swing.*;

import engine.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameStarterFrame extends JFrame implements ActionListener {
	private JButton startGameButton;
	private JButton seeGameDescButton;
	private GameDescriptionFrame gameDescriptionFrame;

	public GameStarterFrame() {
		setTitle("Start Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		startGameButton = new JButton("Start Game");
		startGameButton.addActionListener(this);

		gameDescriptionFrame = new GameDescriptionFrame();

		seeGameDescButton = new JButton("See Game Description");
		seeGameDescButton.addActionListener(e -> gameDescriptionFrame.setVisible(true));
		startGameButton.setFont(new Font("Arial", Font.BOLD, 20));
		startGameButton.setForeground(Color.WHITE);
		startGameButton.setBackground(new Color(0, 153, 76));
		startGameButton.setBorderPainted(false);
		startGameButton.setFocusPainted(false);
		startGameButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		startGameButton.setPreferredSize(new Dimension(150, 50));
		seeGameDescButton.setFont(new Font("Arial", Font.BOLD, 20));
		seeGameDescButton.setForeground(Color.WHITE);
		seeGameDescButton.setBackground(new Color(0, 76, 153));
		seeGameDescButton.setBorderPainted(false);
		seeGameDescButton.setFocusPainted(false);
		seeGameDescButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		seeGameDescButton.setPreferredSize(new Dimension(200, 50));
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.setOpaque(false); 
		buttonPanel.add(startGameButton);
		buttonPanel.add(seeGameDescButton);

		JPanel contentPane = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				try {
					ImageIcon imageIcon = new ImageIcon("bgClash2.jpg"); 																	
					Image image = imageIcon.getImage();
					Graphics2D g2d = (Graphics2D) g;
					g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
					g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
					g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
					g2d.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		contentPane.setLayout(new BorderLayout());
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		setContentPane(contentPane);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startGameButton) {
			Player p1 = new Player("p1"); 
			Player p2 = new Player("p2");
			new HeroSelectionFrame(p1, p2);
			this.dispose();
		}
	}
	public static void main(String[] args) {
		new VideoPlayer("clashOfclansIntro.mp4", () -> {
			new GameStarterFrame();
		});
		
		//new GameStarterFrame();//In case the video player is not working
	}

}
