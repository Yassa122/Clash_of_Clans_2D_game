package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameDescriptionFrame extends JFrame {

    private JButton returnButton;
    private Image backgroundImage;

    public GameDescriptionFrame() {
        setTitle("Game Description");
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setLayout(new BorderLayout());
        backgroundImage = new ImageIcon("descriptionframe.jpg").getImage();
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        add(backgroundPanel, BorderLayout.CENTER);
        returnButton = new JButton("Return");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameDescriptionFrame.this.setVisible(false);
            }
        });
        returnButton.setFont(new Font("Arial", Font.BOLD, 20));
        returnButton.setForeground(Color.black);
        returnButton.setBackground(new Color(0, 153, 76));
        returnButton.setBorderPainted(false);
        returnButton.setFocusPainted(false);
        returnButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        returnButton.setPreferredSize(new Dimension(150, 50));
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(returnButton);
        add(panel, BorderLayout.SOUTH);
        pack();
    }
}

