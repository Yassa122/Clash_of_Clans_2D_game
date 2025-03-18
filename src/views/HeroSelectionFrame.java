package views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.awt.image.BufferedImage;

import engine.Player;
import model.units.Assassin;
import model.units.Diplomat;
import model.units.Hero;
import model.units.Monk;
import model.units.Warchief;

public class HeroSelectionFrame extends JFrame implements ActionListener {
    private JButton monkButton;
    private JButton diplomatButton;
    private JButton warchiefButton;
    private JButton assassinButton;
    private JLabel heroDescriptionLabel; 
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private boolean isPlayer1Turn = true;
    private JLabel playerLabel;
    private JLabel heroSelectedLabel;
    private JLabel heroDetailsLabel;
    private JButton switchPlayerButton;
    public Set<String> getSelectedHeroes() {
		return selectedHeroes;
	}

	private Set<String> selectedHeroes = new HashSet<>(); 
    private JButton startGameButton;
    
    public HeroSelectionFrame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;

        setTitle("Hero Selection");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel leftPanel = new JPanel(new BorderLayout());

        updatePlayerLabel();
        
        

        heroDescriptionLabel = new JLabel("", SwingConstants.CENTER); 
        heroDescriptionLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        heroDescriptionLabel.setVerticalAlignment(SwingConstants.CENTER);

        
        JPanel playerDetailsPanel = new JPanel(new GridLayout(5, 1)); 
        heroSelectedLabel = new JLabel("Hero Selected: None");
        heroDetailsLabel = new JLabel("Hero Details: ");

        playerDetailsPanel.add(new JLabel("Player Name: " + currentPlayer.getName()));
        playerDetailsPanel.add(new JLabel("Current Player: " + currentPlayer.getName()));
        playerDetailsPanel.add(heroSelectedLabel);
        playerDetailsPanel.add(heroDetailsLabel);
        playerDetailsPanel.add(heroDescriptionLabel); 

        leftPanel.add(playerDetailsPanel, BorderLayout.CENTER);
        startGameButton = new JButton("Start Game");
        startGameButton.setEnabled(false);
        

        startGameButton = new JButton("Start Game");
        startGameButton.setEnabled(false);
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        switchPlayerButton = new JButton("Switch to Player 2");
        switchPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPlayer();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,1)); 
        buttonPanel.add(startGameButton);
        buttonPanel.add(switchPlayerButton);

        leftPanel.add(buttonPanel, BorderLayout.SOUTH); 
        leftPanel.add(playerLabel, BorderLayout.NORTH);
        JPanel rightPanel = new JPanel(new GridLayout(2, 2)); 

        JPanel monkBox = new JPanel(new BorderLayout());
        monkBox.add(createHeroButton("Monk", "monkImg.jpg", 400, 400), BorderLayout.CENTER);
        JButton monkDescriptionButton = new JButton("Monk Description");
        monkDescriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel messagePanel = new JPanel(new BorderLayout());
                JLabel descriptionLabel = new JLabel("Monk: Allows the player to heal one of their injured units fully...");
                JLabel iconLabel = new JLabel();
                
                try {
                    ImageIcon imageIcon = new ImageIcon(ImageIO.read(new File("monkImg.jpg"))); 
                    iconLabel.setIcon(imageIcon);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                
                messagePanel.add(iconLabel, BorderLayout.CENTER);
                messagePanel.add(descriptionLabel, BorderLayout.SOUTH);
                
                JOptionPane.showMessageDialog(null, messagePanel, "Monk Description", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        monkBox.add(monkDescriptionButton, BorderLayout.SOUTH);

        JPanel diplomatBox = new JPanel(new BorderLayout());
        diplomatBox.add(createHeroButton("Diplomat", "diplo.jpg",400, 400), BorderLayout.CENTER);
        JButton diplomatDescriptionButton = new JButton("Diplomat Description");
        diplomatDescriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel messagePanel = new JPanel(new BorderLayout());
                JLabel descriptionLabel = new JLabel("Diplomat: Allows the player to convert one of the enemy player units (Excluding Heroes) to the player’s side.");
                JLabel iconLabel = new JLabel();
                
                try {
                    ImageIcon imageIcon = new ImageIcon(ImageIO.read(new File("diplo.jpg")));
                    iconLabel.setIcon(imageIcon);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                
                messagePanel.add(iconLabel, BorderLayout.CENTER);
                messagePanel.add(descriptionLabel, BorderLayout.SOUTH);
                
                JOptionPane.showMessageDialog(null, messagePanel, "Diplomat Description", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        diplomatBox.add(diplomatDescriptionButton, BorderLayout.SOUTH);

        JPanel warchiefBox = new JPanel(new BorderLayout());
        warchiefBox.add(createHeroButton("Warchief", "warchief.jpg",400, 400), BorderLayout.CENTER);
        JButton warchiefDescriptionButton = new JButton("Warchief Description");
        warchiefDescriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel messagePanel = new JPanel(new BorderLayout());
                JLabel descriptionLabel = new JLabel("Warchief: Allows the player to fully upgrade a unit to level 3 without costing resources.");
                JLabel iconLabel = new JLabel();
                
                try {
                    Image img = ImageIO.read(new File("warchief.jpg"));
                    Image resizedImg = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
                    ImageIcon imageIcon = new ImageIcon(resizedImg);
                    iconLabel.setIcon(imageIcon);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                
                messagePanel.add(iconLabel, BorderLayout.CENTER);
                messagePanel.add(descriptionLabel, BorderLayout.SOUTH);
                
                JOptionPane.showMessageDialog(null, messagePanel, "Warchief Description", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        warchiefBox.add(warchiefDescriptionButton, BorderLayout.SOUTH);

        JPanel assassinBox = new JPanel(new BorderLayout());
        assassinBox.add(createHeroButton("Assassin", "assassin.jpg", 400, 400), BorderLayout.CENTER);
        JButton assassinDescriptionButton = new JButton("Assassin Description");
        assassinDescriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel messagePanel = new JPanel(new BorderLayout());
                JLabel descriptionLabel = new JLabel("Assassin: Allows the player to completely kill one of the enemy player units (Excluding Heroes).");
                JLabel iconLabel = new JLabel();
                
                try {
                    ImageIcon imageIcon = new ImageIcon(ImageIO.read(new File("assassin.jpg"))); 
                    iconLabel.setIcon(imageIcon);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                
                messagePanel.add(iconLabel, BorderLayout.CENTER);
                messagePanel.add(descriptionLabel, BorderLayout.SOUTH);
                
                JOptionPane.showMessageDialog(null, messagePanel, "Assassin Description", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        assassinBox.add(assassinDescriptionButton, BorderLayout.SOUTH);

        rightPanel.add(monkBox);
        rightPanel.add(diplomatBox);
        rightPanel.add(warchiefBox);
        rightPanel.add(assassinBox);


        setLayout(new GridLayout(1, 2));
        add(leftPanel);
        add(rightPanel);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                String player1Name = JOptionPane.showInputDialog("Enter the name for Player 1:");
                player1.setName(player1Name != null ? player1Name : "Player 1");

                String player2Name = JOptionPane.showInputDialog("Enter the name for Player 2:");
                player2.setName(player2Name != null ? player2Name : "Player 2");
            }
        });

        setVisible(true);
    }

    public JButton createHeroButton(String heroName, String imagePath, int width, int height) {
        JButton button = new JButton();
        try {
            Image img = ImageIO.read(new File(imagePath));
            Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);

            BufferedImage bufferedImg = new BufferedImage(scaledImg.getWidth(null), scaledImg.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = bufferedImg.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.drawImage(scaledImg, 0, 0, null);
            g2d.dispose();

            button.setIcon(new ImageIcon(bufferedImg));
        } catch (IOException ex) {
            System.out.println("Image not found: " + imagePath);
        }
        button.setText(heroName);
        button.addActionListener(this); 
        button.setBackground(new Color(255, 255, 192));
        return button;
    }




    private void updatePlayerLabel() {
        playerLabel = new JLabel("<html><div style='text-align: center; color: blue; font-size: 20px;'>Current Player: " + currentPlayer.getName() + "</div></html>", SwingConstants.CENTER);
        playerLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void switchPlayer() {
        if (this.currentPlayer == player1) {
            this.currentPlayer = player2;
            switchPlayerButton.setText("Switch to Player 1");
        } else {
            this.currentPlayer = player1;
            switchPlayerButton.setText("Switch to Player 2");
        }
        updatePlayerLabel();
    }


    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        String heroDescriptionText = "";
        
        Hero selectedHero = null;
        if ("Monk".equals(clickedButton.getText()) && !selectedHeroes.contains("Monk")) {
            monkButton = clickedButton;
            selectedHero = new Monk("Monk", 100, 3, 1); 
            selectedHeroes.add("Monk");
            currentPlayer.setSelectedHero(selectedHero);
            heroDescriptionText = "Monk: Allows the player to heal one of their injured units fully.";
            updatePlayerLabel();
        } else if ("Diplomat".equals(clickedButton.getText()) && !selectedHeroes.contains("Diplomat")) {
            diplomatButton = clickedButton;
            selectedHero = new Diplomat("Diplomat", 100, 3, 1); 
            currentPlayer.setSelectedHero(selectedHero);
            heroDescriptionText = "Diplomat: Allows the player to convert one of the enemy player units (Excluding Heroes) to the player’s side.";
            updatePlayerLabel();

        } else if ("Warchief".equals(clickedButton.getText()) && !selectedHeroes.contains("Warchief")) {
            warchiefButton = clickedButton;
            selectedHero = new Warchief("Warchief",12, 100, 3, 1); 
            currentPlayer.setSelectedHero(selectedHero);
            heroDescriptionText = "Warchief: Allows the player to fully upgrade a unit to level 3 without costing resources.";
            updatePlayerLabel();

        } else if ("Assassin".equals(clickedButton.getText()) && !selectedHeroes.contains("Assassin")) {
            assassinButton = clickedButton;
            selectedHero = new Assassin("Assassin",12, 100, 3, 1); 
            currentPlayer.setSelectedHero(selectedHero);
            heroDescriptionText = "Assassin: Allows the player to completely kill one of the enemy player units (Excluding Heroes).";
            updatePlayerLabel();

        }

        if (selectedHero != null) {
            if (isPlayer1Turn) {
                player1.getUnits().add(selectedHero);
                currentPlayer = player2;
                isPlayer1Turn = false;
            } else {
                player2.getUnits().add(selectedHero);
                currentPlayer = player1;
                isPlayer1Turn = true;
            }
            
            heroDescriptionText += "\n\nSome hero types: Monks, and Diplomats; are pacifists and thus cannot be used to attack enemy units or buildings, unlike aggressors: Warchiefs and Assassins. However, pacifist heroes are able to build additional buildings for the player while aggressors are not.";
            heroSelectedLabel.setText("Selected Hero: " + selectedHero.getName());
            clickedButton.setEnabled(false); 
        }

        heroDescriptionLabel.setText("<html><div style='text-align: center;'>" + heroDescriptionText.replace("\n", "<br/>") + "</div></html>");

        playerLabel.setText("Current Player: " + currentPlayer.getName());

        checkIfBothPlayersSelected();
    }
    private void checkIfBothPlayersSelected() {
        if (player1.getUnits().size() > 0 && player2.getUnits().size() > 0) {
            startGameButton.setEnabled(true);
        }
    }
    private void startGame() {
        this.dispose(); 
        
        new GameFrame(player1, player2); 
    }

    public static void main(String[] args) {
    	
    	Player player1=new Player("p1");

    	Player player2=new Player("p2");
    	
    	
    	new HeroSelectionFrame(player1, player2);
    	
	}

}
