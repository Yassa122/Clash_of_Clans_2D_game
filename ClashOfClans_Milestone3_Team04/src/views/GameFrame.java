package views;

import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.plaf.ColorUIResource;
import javax.swing.*;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import engine.Game;
import engine.Player;
import exceptions.InvalidActionException;
import exceptions.InvalidTargetException;
import exceptions.MovementException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;
import model.buildings.Barracks;
import model.buildings.Building;
import model.buildings.Palace;
import model.buildings.Tower;
import model.buildings.Wall;
import model.units.Archer;
import model.units.Assassin;
import model.units.Cavalry;
import model.units.Diplomat;
import model.units.Footman;
import model.units.Hero;
import model.units.Monk;
import model.units.Unit;
import model.units.Warchief;
import model.world.BuildingCell;
import model.world.Cell;
import model.world.EmptyCell;
import model.world.ResourceCell;
import model.world.ResourceType;
import model.world.UnitCell;

import java.awt.*;

public class GameFrame extends JFrame {

	private JLabel gameStatusLabel;
	private JPanel gamePanel;
	private JButton endGameButton;
	private Player currentPlayer;
	private Game game; 
	private JLabel goldLabel;
	private JLabel manpowerLabel;
	private int selectedX = -1;
	private int selectedY = -1;
	private JPanel gridPanel;
	private int targetX = -1; 
	private int targetY = -1;
	private boolean selectingTarget = false;
    private JLabel unitsLabel ;
    private JLabel buildingsLabel ;


	public GameFrame(Player player1, Player player2) {
		this.game = new Game(player1, player2);
		this.currentPlayer = player1; 


		setTitle("Game Frame");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		getContentPane().setBackground(Color.gray); 

		gameStatusLabel = new JLabel("Game has started! Current Turn: " + currentPlayer.getName(),
				SwingConstants.CENTER);
		gameStatusLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		add(gameStatusLabel, BorderLayout.NORTH);

		gamePanel = new JPanel(new GridBagLayout());
		gamePanel.setBackground(Color.white);

		gridPanel = new JPanel(new GridLayout(10, 10, 5, 5));
		gridPanel.setPreferredSize(new Dimension(700, 700));
		
		Hero player1Hero = player1.getSelectedHero();
		Hero player2Hero = player2.getSelectedHero();
	
		
		
	//	Hero player1Hero = new Monk("Monk", 100, 50, 30);
	//	Hero player2Hero = new Assassin("Assassin", 100, 1000, 1000, 1000);
		
		game.setMap( player1Hero,  player2Hero);
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				final int row = i;
				final int col = j;
				JButton gridCell = new JButton();
				gridCell.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						for (Component component : gridPanel.getComponents()) {
							if (component instanceof JButton) {
								component.setBackground(ColorUIResource.lightGray); 
							}
						}
						if (selectingTarget) {
							targetX = row;
							targetY = col;
							gridCell.setBackground(ColorUIResource.YELLOW);
						} else {
							selectedX = row;
							selectedY = col;
							gridCell.setBackground(ColorUIResource.DARK_GRAY); 
						}
					}
				});

				gridPanel.add(gridCell);
				Cell cell = game.getMap()[i][j];
				gridCell.setBackground(ColorUIResource.lightGray);
				gridCell.setIcon(getCellIcon(cell));
			}
		}

		JButton buildButton = new JButton("Build");
		buildButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buildAction();
				checkGameOverAndDisplayMessage();
			}
		});

		// movements
		JPanel movePanel = new JPanel(new GridLayout(2, 2));
		movePanel.setBackground(Color.LIGHT_GRAY);

		Font buttonFont = new Font("Arial", Font.BOLD, 14);

		JButton moveUpButton = new JButton("Move Up");
		moveUpButton.setFont(buttonFont);
		moveUpButton.setBackground(Color.BLUE);
		moveUpButton.setForeground(Color.BLACK);
		moveUpButton.setIcon(new ImageIcon("path/to/your/up_icon.png")); 
		moveUpButton.addActionListener(e -> moveUnit('U'));
		movePanel.add(moveUpButton);

		JButton moveDownButton = new JButton("Move Down");
		moveDownButton.setFont(buttonFont);
		moveDownButton.setBackground(Color.BLUE);
		moveDownButton.setForeground(Color.BLACK);
		moveDownButton.setIcon(new ImageIcon("path/to/your/down_icon.png")); 
		moveDownButton.addActionListener(e -> moveUnit('D'));
		movePanel.add(moveDownButton);

		JButton moveLeftButton = new JButton("Move Left");
		moveLeftButton.setFont(buttonFont);
		moveLeftButton.setBackground(Color.DARK_GRAY);
		moveLeftButton.setForeground(Color.BLACK);
		moveLeftButton.setIcon(new ImageIcon("path/to/your/left_icon.png")); 
		moveLeftButton.addActionListener(e -> moveUnit('L'));
		movePanel.add(moveLeftButton);

		JButton moveRightButton = new JButton("Move Right");
		moveRightButton.setFont(buttonFont);
		moveRightButton.setBackground(Color.DARK_GRAY);
		moveRightButton.setForeground(Color.BLACK);
		moveRightButton.setIcon(new ImageIcon("path/to/your/right_icon.png")); 
		moveRightButton.addActionListener(e -> moveUnit('R'));
		movePanel.add(moveRightButton);

		add(movePanel, BorderLayout.EAST);

		// endturn button

		JButton endTurnButton = new JButton("End Turn");
		endTurnButton.setFont(new Font("Arial", Font.BOLD, 14));
		endTurnButton.setBackground(new Color(70, 130, 180));
		endTurnButton.setForeground(Color.WHITE);
		endTurnButton.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 15, true));
		endTurnButton.addActionListener(e -> endTurn());

		 buildButton = new JButton("Build");
		buildButton.setFont(new Font("Arial", Font.BOLD, 14));
		buildButton.setBackground(new Color(34, 139, 34));
		buildButton.setForeground(Color.WHITE);
		buildButton.setBorder(BorderFactory.createLineBorder(new Color(34, 139, 34), 15, true));
		buildButton.addActionListener(e -> buildAction());
		
		
		JButton useSpecialButton = new JButton("Use Special");
		useSpecialButton.setFont(new Font("Arial", Font.BOLD, 14));
		useSpecialButton.setBackground(new Color(255, 99, 71));
		useSpecialButton.setForeground(Color.WHITE);
		endTurnButton.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 15, true));
		useSpecialButton.addActionListener(e -> useSpecialButton());

		JButton toggleSelectingTargetButton = new JButton("Toggle Selecting Target");
		toggleSelectingTargetButton.setFont(new Font("Arial", Font.BOLD, 14));
		toggleSelectingTargetButton.setBackground(new Color(218, 165, 32));
		toggleSelectingTargetButton.setForeground(Color.WHITE);
		endTurnButton.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 15, true));
		toggleSelectingTargetButton.addActionListener(e -> toggleSelectingTarget());

		JButton upgradeButton = new JButton("Upgrade");
		upgradeButton.setFont(new Font("Arial", Font.BOLD, 14));
		upgradeButton.setBackground(new Color(148, 0, 211));
		upgradeButton.setForeground(Color.WHITE);
		endTurnButton.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 15, true));
		upgradeButton.addActionListener(e -> upgradeButton());

		JButton attackButton = new JButton("Attack");
		attackButton.setFont(new Font("Arial", Font.BOLD, 14));
		attackButton.setBackground(new Color(220, 20, 60));
		attackButton.setForeground(Color.WHITE);
		endTurnButton.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 15, true));
		attackButton.addActionListener(e -> handleAttackButton());

        JButton recruitUnitButton = new JButton("Recruit Unit");
        recruitUnitButton.addActionListener(e -> recruitUnitButtonAction());

		
		JPanel westPanel = new JPanel();
		westPanel.setBackground(new Color(191, 188, 170)); 
		westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
		westPanel.add(endTurnButton);
		westPanel.add(buildButton);
		westPanel.add(useSpecialButton);
		westPanel.add(upgradeButton);

		westPanel.add(toggleSelectingTargetButton);
		westPanel.add(attackButton);
		westPanel.add(recruitUnitButton);
		goldLabel = new JLabel("<html><font color='#FFD700'>Gold: " + currentPlayer.getGoldAmount() + "</font></html>");
		manpowerLabel = new JLabel("<html><font color='green'>Manpower: " + currentPlayer.getManpowerAmount() + "</font></html>");

		StringBuilder unitInfo = new StringBuilder("<html>");
		for(Unit unit : currentPlayer.getUnits()) {
		    unitInfo.append("<font color='blue'>").append(unit.toString()).append("</font><br/>");
		}
		unitInfo.append("</html>");
		unitsLabel = new JLabel(unitInfo.toString());

		StringBuilder buildingsInfo = new StringBuilder("<html>");
		for(Building building : currentPlayer.getBuildings()) {
		    buildingsInfo.append("<font color='purple'>").append(building.toString()).append("</font><br/>");
		}
		buildingsInfo.append("</html>");
		buildingsLabel = new JLabel(buildingsInfo.toString());

		updateUIAfterMovement();
		westPanel.add(goldLabel);
		westPanel.add(manpowerLabel);
		westPanel.add(unitsLabel);
		westPanel.add(buildingsLabel);

		
		add(westPanel, BorderLayout.WEST);
		gamePanel.add(gridPanel);

		add(gamePanel, BorderLayout.CENTER);

		endGameButton = new JButton("End Game");
		endGameButton.addActionListener(e -> endGame());
		add(endGameButton, BorderLayout.SOUTH);
		endGameButton.setBackground(Color.black);
		setVisible(true);
        checkGameOverAndDisplayMessage();


	}
	
	
	 public void checkGameOverAndDisplayMessage() {
	        Player winner = game.checkGameOver();
	        if (winner != null) {
	            JOptionPane.showMessageDialog(this, "Game Over! The winner is: " + winner.getName(), "Game Over", JOptionPane.INFORMATION_MESSAGE);
	        }
	    }

	public void recruitUnitButtonAction() {
	    JButton footmanButton = new JButton();
	    ImageIcon footmanIcon = new ImageIcon("barbarian.png");
	    Image footmanImage = footmanIcon.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
	    footmanButton.setIcon(new ImageIcon(footmanImage));
	    footmanButton.addActionListener(e -> recruitUnit("Footman"));

	    JButton archerButton = new JButton();
	    ImageIcon archerIcon = new ImageIcon("archer.png");
	    Image archerImage = archerIcon.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
	    archerButton.setIcon(new ImageIcon(archerImage));
	    archerButton.addActionListener(e -> recruitUnit("Archer"));

	    JButton cavalryButton = new JButton();
	    ImageIcon cavalryIcon = new ImageIcon("horseback.png");
	    Image cavalryImage = cavalryIcon.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
	    cavalryButton.setIcon(new ImageIcon(cavalryImage));
	    cavalryButton.addActionListener(e -> recruitUnit("Cavalry"));

	    Object[] options = {footmanButton, archerButton, cavalryButton};

	    int n = JOptionPane.showOptionDialog(
	            this,
	            "What do you want to recruit?",
	            "Recruit Unit",
	            JOptionPane.YES_NO_CANCEL_OPTION,
	            JOptionPane.QUESTION_MESSAGE,
	            null,
	            options,
	            options[0]
	    );

	    if(n >= 0) {
	    } else {
	        JOptionPane.showMessageDialog(this, "No unit type selected", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

	private void recruitUnit(String unitType) {
	    try {
	        game.recruitUnit(selectedX, selectedY, unitType);
	        updateUIAfterMovement();
	        updatePlayerInfo();
			checkGameOverAndDisplayMessage();

	    } catch (InvalidTargetException | NoAvailableResourcesException | InvalidActionException exception) {
	        JOptionPane.showMessageDialog(this, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}




	private void handleAttackButton() {
	    if (selectedX != -1 && selectedY != -1 && targetX != -1 && targetY != -1) {
	        try {
	            game.attack(selectedX, selectedY, targetX, targetY);
	            updateUIAfterMovement();
	            updatePlayerInfo();
				checkGameOverAndDisplayMessage();

	        } catch (InvalidTargetException | InvalidActionException | NotEnoughActionsException ex) {
	            JOptionPane.showMessageDialog(null, "An Exception occured", "Error", JOptionPane.ERROR_MESSAGE);
	            

				
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Please select valid coordinates", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}


	private void upgradeButton() {
		if (selectedX != -1 && selectedY != -1) {
			try {
				game.upgrade(selectedX, selectedY); 
				JOptionPane.showMessageDialog(this, "Upgrade successful!");
				updateUIAfterMovement();
	            updatePlayerInfo();	
				checkGameOverAndDisplayMessage();

	            } catch (InvalidTargetException | NoAvailableResourcesException | InvalidActionException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(this, "Please select a valid target for upgrade."); 
		}
	}

	public void updatePlayerInfo() {

	    goldLabel.setText("Gold: " + currentPlayer.getGoldAmount());
	    manpowerLabel.setText("Manpower: " + currentPlayer.getManpowerAmount());
	}

	public void toggleSelectingTarget() {
		selectingTarget = !selectingTarget;
	}

	private void useSpecialButton() {
		try {
			if (selectedX < 0 || selectedY < 0 || targetX < 0 || targetY < 0) {
			
				JOptionPane.showMessageDialog(this, "Please select a valid unit and target location");
				return;
			}

			game.useSpecial(selectedX, selectedY, targetX, targetY);
			checkGameOverAndDisplayMessage();
			updateUIAfterMovement();
            updatePlayerInfo();	
			JOptionPane.showMessageDialog(this, "Special action applied successfully!");
		} catch (InvalidTargetException | InvalidActionException e) {
			JOptionPane.showMessageDialog(this, "Error applying special action: " + e.getMessage());
			e.printStackTrace();
		}
	}



	private void buildAction() {
	    if (selectedX != -1 && selectedY != -1 && targetX != -1 && targetY != -1) {
	        JButton wallButton = new JButton();
	        ImageIcon wallIcon = new ImageIcon("walls.png");
	        Image wallImage = wallIcon.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
	        wallButton.setIcon(new ImageIcon(wallImage));
	        wallButton.setBackground(Color.DARK_GRAY);

	        wallButton.addActionListener(e -> buildStructure("Wall"));

	        JButton towerButton = new JButton();
	        ImageIcon towerIcon = new ImageIcon("towers.png");
	        Image towerImage = towerIcon.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
	        towerButton.setIcon(new ImageIcon(towerImage));
	        towerButton.setBackground(Color.DARK_GRAY);
	        towerButton.addActionListener(e -> buildStructure("Tower"));

	        Object[] options = {wallButton, towerButton};

	        int choice = JOptionPane.showOptionDialog(
	                this,
	                "What do you want to build?",
	                "Build",
	                JOptionPane.YES_NO_OPTION,
	                JOptionPane.QUESTION_MESSAGE,
	                null,
	                options,
	                options[0]
	        );

	        if (choice != JOptionPane.CLOSED_OPTION) {
	        } else {
	            JOptionPane.showMessageDialog(this, "No building type selected");
	        }
	    } else {
	        JOptionPane.showMessageDialog(this, "Please select a valid unit and target location.");
	    }
	}

	private void buildStructure(String buildingType) {
	    try {
	        game.build(selectedX, selectedY, targetX, targetY, buildingType);
	        JOptionPane.showMessageDialog(this, "Building constructed successfully!");
	        checkGameOverAndDisplayMessage();
			updateUIAfterMovement();
            updatePlayerInfo();	
	    } catch (InvalidActionException | NoAvailableResourcesException | NotEnoughActionsException
	            | InvalidTargetException e) {
	        JOptionPane.showMessageDialog(this, e.getMessage());
	    }
	}



	private ImageIcon createScaledIcon(String path, int width, int height) {
		ImageIcon originalIcon = new ImageIcon(path);
		Image originalImage = originalIcon.getImage();
		Image scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = (Graphics2D) scaledImage.getGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.drawImage(originalImage, 0, 0, width, height, null);
		g2d.dispose();
		return new ImageIcon(scaledImage);
	}

	private ImageIcon getCellIcon(Cell cell) {

		if (cell instanceof EmptyCell) {
			return new ImageIcon();
		} else if (cell instanceof BuildingCell) {
			if (((BuildingCell) cell).getBuilding() instanceof Palace) {
				return createScaledIcon("palace.png", 60, 60);
			} else if (((BuildingCell) cell).getBuilding() instanceof Barracks) {
				return createScaledIcon("barracks.png", 50, 50);
			} else if (((BuildingCell) cell).getBuilding() instanceof Tower) {
				return createScaledIcon("towers.png", 55, 50);
			} else if (((BuildingCell) cell).getBuilding() instanceof Wall) {
				return createScaledIcon("brickwall.png", 55, 50);
			}
		} else if (cell instanceof UnitCell) {
			if (((UnitCell) cell).getUnit() instanceof Cavalry) {
				return createScaledIcon("horseback.png", 50, 50);
			} else if (((UnitCell) cell).getUnit() instanceof Footman) {
				return createScaledIcon("barbarian.png", 50, 50);
			} else if (((UnitCell) cell).getUnit() instanceof Archer) {
				return createScaledIcon("archer.png", 50, 50);
			} else if (((UnitCell) cell).getUnit() instanceof Assassin) {
				return createScaledIcon("AssassinIcon.png", 50, 50);
				
			}else if (((UnitCell) cell).getUnit() instanceof Diplomat) {
				return createScaledIcon("diplomat1.png", 60, 60);
			}
			else if (((UnitCell) cell).getUnit() instanceof Warchief) {
				return createScaledIcon("warchiefIcon.png", 60, 60);
			}
			else if (((UnitCell) cell).getUnit() instanceof Monk) {
				return createScaledIcon("monk.png", 60, 60);
			}
		} else if (cell instanceof ResourceCell) {
			if (((ResourceCell) cell).getType() == ResourceType.GOLD) {
				return createScaledIcon("gold-ingots.png", 50, 50);
			} else if (((ResourceCell) cell).getType() == ResourceType.MANPOWER) {
				return createScaledIcon("power.png", 50, 50);
			}

		}
		return new ImageIcon();
	}

	private void endTurn() {
		game.endTurn(); 
		checkGameOverAndDisplayMessage();
		updateUIAfterMovement();
        updatePlayerInfo();	

		currentPlayer = game.getCurrentPlayer();
		gameStatusLabel.setText("Game is ongoing. Current Turn: " + currentPlayer.getName());
		goldLabel.setText("Gold: " + currentPlayer.getGoldAmount());
		manpowerLabel.setText("Manpower: " + currentPlayer.getManpowerAmount());
		updateUIAfterMovement();
        updatePlayerInfo();

	}

	private void moveUnit(char direction) {
		if (selectedX != -1 && selectedY != -1) {
			try {
				int newSelectedX = selectedX;
				int newSelectedY = selectedY;

				switch (direction) {
				case 'U':
					game.moveUp(selectedX, selectedY);
					newSelectedX = Math.max(0, selectedX - 1);
					break;
				case 'D':
					game.moveDown(selectedX, selectedY);
					newSelectedX = Math.min(9, selectedX + 1);
					break;
				case 'L':
					game.moveLeft(selectedX, selectedY);
					newSelectedY = Math.max(0, selectedY - 1);
					break;
				case 'R':
					game.moveRight(selectedX, selectedY);
					newSelectedY = Math.min(9, selectedY + 1);
					break;
				}

				selectedX = newSelectedX; 
				selectedY = newSelectedY;
				checkGameOverAndDisplayMessage();
				updateUIAfterMovement();
	            updatePlayerInfo();	
			} catch (InvalidActionException | NotEnoughActionsException | MovementException e) {
				JOptionPane.showMessageDialog(this, ((Throwable) e).getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(this, "No unit selected. Please select a unit first.");
		}
	}

	private void updateUIAfterMovement() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Cell cell = game.getMap()[i][j];
				
				JButton gridButton = ((JButton) gridPanel.getComponent(i * 10 + j));
				gridButton.setIcon(getCellIcon(cell));
			}
		}
		gameStatusLabel.setText("Game is ongoing. Current Turn: " + currentPlayer.getName());
		 StringBuilder unitInfo = new StringBuilder("<html>");
		    StringBuilder buildingInfo = new StringBuilder("<html>");

		    for(Unit unit : currentPlayer.getUnits()) {
		        unitInfo.append(unit.toString()).append("<br/>");
		    }
		    unitInfo.append("</html>");
		    
		    for(Building buildings : currentPlayer.getBuildings()) {
		    	buildingInfo.append(buildings.toString()).append("<br/>");
		    }
		    buildingInfo.append("</html>");
		    
		    buildingsLabel.setText("<html><div style='color:#4CAF50; font-family:Arial; margin: 0 0 20px 0;'>" + buildingInfo.toString() + "</div></html>");
		    unitsLabel.setText("<html><div style='color:#FF5722; font-family:Arial; margin: 0 20px 20px 0;'>" + unitInfo.toString() + "</div></html>");

		    goldLabel.setText("<html><font color='#FFD700'>Gold: " + currentPlayer.getGoldAmount() + "</font></html>");
		    manpowerLabel.setText("<html><font color='green'>Manpower: " + currentPlayer.getManpowerAmount() + "</font></html>");

		

	}

	private void endGame() {
		int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to end the game?", "End Game",
				JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}

	public static void main(String[] args) {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");

		new GameFrame(p1, p2);
	}

}
