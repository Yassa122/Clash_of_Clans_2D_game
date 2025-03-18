package engine;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
import model.units.HeroType;
import model.units.Monk;
import model.units.SupportUnit;
import model.units.Unit;
import model.units.Warchief;
import model.world.BuildingCell;
import model.world.Cell;
import model.world.EmptyCell;
import model.world.ResourceCell;
import model.world.ResourceType;
import model.world.UnitCell;
import exceptions.InvalidActionException;
import exceptions.InvalidTargetException;
import exceptions.MovementException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;

public class Game {

	public Player player1;
	public Player player2;
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public Player currentPlayer;
	public Cell[][] getMap() {
		return map;
	}

	public Cell[][] map;
	public static ArrayList<Hero> availableHeroes;

	public Game(Player p1, Player p2) {
		this.player1 = p1;
		this.player2 = p2;
		this.currentPlayer = p1;
	}

	public void canMoveChecker(int x, int y) throws InvalidActionException, NotEnoughActionsException {
		if (!(map[x][y] instanceof UnitCell))
			throw new InvalidActionException("Only units can move");

		Unit u = ((UnitCell) map[x][y]).getUnit();
		if (!(this.currentPlayer.getUnits().contains(u)))
			throw new InvalidActionException("Not your unit!! you can only move your units");
		if (u.getActionsAvailable() < 1)
			throw new NotEnoughActionsException("you need at least 1 Action point to move!!");

	}

	public void Move2TargetLocation(int x, int y, int targetX, int targetY)
			throws MovementException, InvalidActionException {
		// check within range
		if (targetX > 9 || targetX < 0 || targetY > 9 || targetY < 0)
			throw new InvalidActionException("you can't move out of the borders");
		// make sure you are going to a valid cell

		if (!(map[targetX][targetY] instanceof EmptyCell) && !(map[targetX][targetY] instanceof ResourceCell))
			throw new InvalidActionException("you can only go to an Empty or a Resource cell");

		Unit u = ((UnitCell) map[x][y]).getUnit();
		if (map[targetX][targetY] instanceof ResourceCell) {

			ResourceType rt = ((ResourceCell) map[targetX][targetY]).getType();
			if (rt == ResourceType.GOLD)
				currentPlayer.setGoldAmount(
						currentPlayer.getGoldAmount() + ((ResourceCell) map[targetX][targetY]).getAmount());
			else
				currentPlayer.setManpowerAmount(
						currentPlayer.getManpowerAmount() + ((ResourceCell) map[targetX][targetY]).getAmount());

		}
		u.setLocation(new Point(targetX, targetY));
		map[x][y] = new EmptyCell();
		map[targetX][targetY] = new UnitCell(u);
		u.setActionsAvailable(u.getActionsAvailable() - 1);
	}

	public void moveUp(int x, int y) throws InvalidActionException, NotEnoughActionsException, MovementException {
		canMoveChecker(x, y);

		int targetX = x - 1;
		int targetY = y;

		Move2TargetLocation(x, y, targetX, targetY);

	}

	public void moveDown(int x, int y) throws InvalidActionException, NotEnoughActionsException, MovementException {
		canMoveChecker(x, y);
		int targetX = x + 1;
		int targetY = y;

		Move2TargetLocation(x, y, targetX, targetY);

	}

	public void moveLeft(int x, int y) throws InvalidActionException, NotEnoughActionsException, MovementException {
		canMoveChecker(x, y);

		int targetX = x;
		int targetY = y - 1;

		Move2TargetLocation(x, y, targetX, targetY);
	}

	public void moveRight(int x, int y) throws InvalidActionException, NotEnoughActionsException, MovementException {
		canMoveChecker(x, y);

		int targetX = x;
		int targetY = y + 1;

		Move2TargetLocation(x, y, targetX, targetY);
	}

	public void build(int x, int y, int tx, int ty, String building) throws InvalidActionException,
			NoAvailableResourcesException, NotEnoughActionsException, InvalidTargetException {
		Cell hCell = map[x][y];
		if (hCell instanceof UnitCell && ((UnitCell) hCell).getUnit() instanceof Hero) {
			Hero h = (Hero) ((UnitCell) hCell).getUnit();
			if (h.getType() != HeroType.PACIFIST)
				throw new InvalidActionException("Hero is not PACIFIST!");
			if (Math.abs(x - tx) > 1 || Math.abs(y - ty) > 1)
				throw new InvalidActionException();
			if (!(map[tx][ty] instanceof EmptyCell))
				throw new InvalidTargetException("Cell is not empty");
			if (building.equals("Tower")) {
				Tower t = currentPlayer.buildTower(h);
				map[tx][ty] = new BuildingCell(t);
			} else if (building.equals("Wall")) {
				Wall t = currentPlayer.buildWall(h);
				map[tx][ty] = new BuildingCell(t);
			} else {
				throw new InvalidActionException("Error: Invalid Action");
			}
		} else {
			throw new InvalidActionException("Error: Invalid Action");
		}
	}

	public void useSpecial(int x, int y, int tx, int ty) throws InvalidTargetException, InvalidActionException {
		Cell hCell = map[x][y];
		if (hCell instanceof UnitCell && ((UnitCell) hCell).getUnit() instanceof Hero) {
			Hero h = (Hero) ((UnitCell) hCell).getUnit();
			Cell uCell = map[tx][ty];
			if (uCell instanceof UnitCell && ((UnitCell) uCell).getUnit() instanceof SupportUnit) {
				SupportUnit u = (SupportUnit) ((UnitCell) uCell).getUnit();
				if (calculateDistance(x, y, tx, ty) > u.getRange())
					throw new InvalidActionException("Range is too far");
				currentPlayer.useSpecial(h, u);
				if (h instanceof Diplomat) {
					if (currentPlayer == player1) {
						player1.getUnits().add(u);
						player2.getUnits().remove(u);
					} else {
						player2.getUnits().add(u);
						player1.getUnits().remove(u);
					}
				} else if (h instanceof Assassin) {
					map[tx][ty] = new EmptyCell();
				}
			} else {
				throw new InvalidTargetException("Error: Invalid Target");
			}
		} else {
			throw new InvalidActionException("Error: Target Action");
		}
	}

	public static void loadHeroes(String filePath) throws IOException {
		availableHeroes = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String line = br.readLine();
		int i = 0;

		while (line != null) {
			String[] sp = line.split(",");
			Hero h;
			if (sp[1].equals("Diplomat")) {
				h = new Diplomat(sp[0], Integer.parseInt(sp[2]), Integer.parseInt(sp[3]), Integer.parseInt(sp[4]));
			} else if (sp[1].equals("Monk")) {
				h = new Monk(sp[0], Integer.parseInt(sp[2]), Integer.parseInt(sp[3]), Integer.parseInt(sp[4]));
			} else if (sp[1].equals("Warchief")) {
				h = new Warchief(sp[0], Integer.parseInt(sp[2]), Integer.parseInt(sp[3]), Integer.parseInt(sp[4]),
						Integer.parseInt(sp[5]));
			} else {
				h = new Assassin(sp[0], Integer.parseInt(sp[2]), Integer.parseInt(sp[3]), Integer.parseInt(sp[4]),
						Integer.parseInt(sp[5]));
			}
			availableHeroes.add(h);
			line = br.readLine();
		}
		br.close();
	}

	public void attack(int x, int y, int tx, int ty)
			throws InvalidTargetException, InvalidActionException, NotEnoughActionsException {
		Cell uCell = map[x][y];
		int damage = 0;
		int range = 0;
		if (uCell instanceof UnitCell) {
			Unit u = ((UnitCell) uCell).getUnit();
			if (!currentPlayer.getUnits().contains(u))
				throw new InvalidActionException("not your units");
			if (u instanceof Hero && ((Hero) u).getType() != HeroType.AGGRESSOR)
				throw new InvalidActionException("This hero is not AGGRESSOR can't attack");
			if (u.getActionsAvailable() < 1)
				throw new NotEnoughActionsException("Not enough actions");
			if (u instanceof SupportUnit) {
				damage = ((SupportUnit) u).getAttackDmg();
			} else if (u instanceof Warchief) {
				damage = ((Warchief) u).getAttackDmg();
			} else {
				damage = ((Assassin) u).getAttackDmg();
			}
			range = u.getRange();
		} else if (uCell instanceof BuildingCell && ((BuildingCell) uCell).getBuilding() instanceof Tower) {
			Tower t = (Tower) ((BuildingCell) uCell).getBuilding();
			if (!currentPlayer.getBuildings().contains(t))
				throw new InvalidActionException("Player doesn't have a tower");
			if (!t.isCanAttack())
				throw new InvalidActionException("Can't attack the tower");
			damage = 50;
			range = t.getRange();
		} else {
			throw new InvalidActionException("Invalid action");
		}
		Cell tCell = map[tx][ty];
		if (tCell instanceof BuildingCell) {
			Building b = ((BuildingCell) tCell).getBuilding();
			if (currentPlayer.getBuildings().contains(b))
				throw new InvalidTargetException("Can't attack buildings");
			if (calculateDistance(x, y, tx, ty) > range)
				throw new InvalidActionException("Target is too far");
			b.setCurrentHp(b.getCurrentHp() - damage);
			if (b.getCurrentHp() == 0) {
				map[tx][ty] = new EmptyCell();
				if (currentPlayer == player1)
					player2.getBuildings().remove(b);
				else
					player1.getBuildings().remove(b);
			}
		} else if (tCell instanceof UnitCell) {
			Unit eU = ((UnitCell) tCell).getUnit();
			if (currentPlayer.getUnits().contains(eU))
				throw new InvalidTargetException("Can't attack units");
			if (calculateDistance(x, y, tx, ty) > range)
				throw new InvalidActionException("Target is too far");
			eU.setCurrentHp(eU.getCurrentHp() - damage);
			if (eU.getCurrentHp() == 0) {
				map[tx][ty] = new EmptyCell();
				if (currentPlayer == player1)
					player2.getUnits().remove(eU);
				else
					player1.getUnits().remove(eU);
			}
		} else {
			throw new InvalidTargetException("Invalid Action");
		}
		if (uCell instanceof UnitCell) {
			Unit u = ((UnitCell) uCell).getUnit();
			u.setActionsAvailable(0);
		} else {
			Tower t = (Tower) ((BuildingCell) uCell).getBuilding();
			t.setCanAttack(false);
		}
	}

	public static int calculateDistance(int x, int y, int tx, int ty) {
		return Math.abs(x - tx) + Math.abs(y - ty);
	}

	public void recruitUnit(int x, int y, String s)
			throws InvalidTargetException, NoAvailableResourcesException, InvalidActionException {
		Cell barracksCell = map[x][y];
		if (barracksCell instanceof BuildingCell && ((BuildingCell) barracksCell).getBuilding() instanceof Barracks) {
			Barracks b = ((Barracks) ((BuildingCell) barracksCell).getBuilding());
			if (!(map[x][y + 1] instanceof EmptyCell))
				throw new InvalidTargetException("Barracks should have space to the right to spawn unit.");
			SupportUnit u = currentPlayer.recruit(b, s);
			map[x][y + 1] = new UnitCell(u);
			u.setLocation(new Point(x, y + 1));
		} else {
			throw new InvalidTargetException("Invalid Target");
		}
	}

	public void upgrade(int x, int y)
			throws InvalidTargetException, NoAvailableResourcesException, InvalidActionException {
		Cell targetCell = map[x][y];
		if (targetCell instanceof UnitCell && ((UnitCell) targetCell).getUnit() instanceof SupportUnit) {
			SupportUnit su = (SupportUnit) ((UnitCell) targetCell).getUnit();
			currentPlayer.upgradeUnit(su);
		} else if (targetCell instanceof BuildingCell) {
			Building b = ((BuildingCell) targetCell).getBuilding();
			currentPlayer.upgradeBuilding(b);
		} else
			throw new InvalidTargetException("Target Cell must contain upgradeable object.");
	}

	public void endTurn() {
		if (player1 == currentPlayer)
			currentPlayer = player2;
		else
			currentPlayer = player1;

		for (Unit u : currentPlayer.getUnits()) {
			u.setActionsAvailable(u.getMaxActions());
			if (u instanceof Hero && ((Hero) u).getSpecialActionCooldown() > 0)
				((Hero) u).setSpecialActionCooldown(((Hero) u).getSpecialActionCooldown() - 1);
		}
		for (Building b : currentPlayer.getBuildings()) {
			if (b instanceof Tower)
				((Tower) b).setCanAttack(true);
			else if (b instanceof Barracks)
				((Barracks) b).setCanRecruit(true);
		}
	}

	public void setMap(Hero h1, Hero h2) {
		map = new Cell[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[i][j] = new EmptyCell();
			}
		}
		setPlayerUnitsAndBuildings(player1, h1);
		setPlayerUnitsAndBuildings(player2, h2);
		for (int i = 1; i <= 5; i++) {
			int x, y;
			do {
				x = (int) (Math.random() * 10);
				y = (int) (Math.random() * 10);
			} while (!(map[x][y] instanceof EmptyCell));
			map[x][y] = new ResourceCell(ResourceType.GOLD, 200);
		}
		for (int i = 1; i <= 5; i++) {
			int x, y;
			do {
				x = (int) (Math.random() * 10);
				y = (int) (Math.random() * 10);
			} while (!(map[x][y] instanceof EmptyCell));
			map[x][y] = new ResourceCell(ResourceType.MANPOWER, 200);
		}
	}

	private void setPlayerUnitsAndBuildings(Player player, Hero h) {
		Cavalry c = new Cavalry();
		Footman f = new Footman();
		Archer a = new Archer();
		Barracks b = new Barracks();
		Tower t = new Tower();
		Palace p = new Palace();
		player.getBuildings().add(b);
		player.getBuildings().add(t);
		player.getBuildings().add(p);
		player.getUnits().add(h);
		player.getUnits().add(c);
		player.getUnits().add(f);
		player.getUnits().add(a);

		if (player == player1) {
			map[0][0] = new BuildingCell(p);
			map[0][1] = new BuildingCell(b);
			map[0][3] = new BuildingCell(t);
			map[1][0] = new UnitCell(h);
			h.setLocation(new Point(1, 0));
			map[1][1] = new UnitCell(c);
			c.setLocation(new Point(1, 1));
			map[1][2] = new UnitCell(f);
			f.setLocation(new Point(1, 2));
			map[1][3] = new UnitCell(a);
			a.setLocation(new Point(1, 3));
		} else {
			map[9][9] = new BuildingCell(p);
			map[9][7] = new BuildingCell(b);
			map[9][6] = new BuildingCell(t);
			map[8][9] = new UnitCell(h);
			h.setLocation(new Point(8, 9));
			map[8][8] = new UnitCell(c);
			c.setLocation(new Point(8, 8));
			map[8][7] = new UnitCell(f);
			f.setLocation(new Point(8, 7));
			map[8][6] = new UnitCell(a);
			a.setLocation(new Point(8, 6));
		}
	}

	public Player checkGameOver() {
		boolean p1 = false;
		boolean p2 = false;
		for (Building b : player1.getBuildings()) {
			if (b instanceof Palace)
				p1 = true;
		}
		if (!p1)
			return player2;
		for (Building b : player2.getBuildings()) {
			if (b instanceof Palace)
				p2 = true;
		}
		if (!p2)
			return player1;
		return null;
	}

	public static void main(String[] args) {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		g.setMap(h1, h2);
		System.out.println(p1);

	}

}
