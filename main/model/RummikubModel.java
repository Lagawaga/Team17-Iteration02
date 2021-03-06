package model;

import java.util.ArrayList;

public class RummikubModel {

	
	private ArrayList<Player> players;
	private Table table;
	private Pile pile;
	private ArrayList<Meld> melds;
	private boolean timer;
	public boolean status;
	
	public RummikubModel() {
		table = new Table();
		pile = new Pile();
		pile.populate();
		pile.shuffle();
		melds = new ArrayList<Meld>();

		timer = false;
	}
	
	public RummikubModel(RummikubModel model) {
		this.melds = new ArrayList<Meld>(model.melds);
		this.pile = new Pile(model.pile);
		this.players = new ArrayList<Player>(model.getPlayers());
	}
	
	//GETTERS and SETTERS
	
	public Table getTable() {
		return this.table;
	}
	
	public void setPlayers(ArrayList<Player> p) {
		players = p;
	}
	
	public void setTable(Table t) {
		table = t;
	}


	public ArrayList<Player> getPlayers() {
		return players;
	}

	public boolean getTimer() {
		return this.timer;
	}
	
	public Pile getPile() {
		return this.pile;
	}
	
	public void setTimer(boolean b) {
		this.timer = b;
		
	}


	public void findTurnOrder() {
		
		Pile tmpPile = new Pile();
		for(int i=1; i<5; i++) {
			for(int j=1; j<=13; j++) {
				tmpPile.addTile(new Tile(i,j,false));
			}
		}
		
		for(Player p : players) {
			p.drawInitialTile(tmpPile);
		}
	}


	public ArrayList<Meld> getMelds() {
		return this.melds;
	}


	public void dealPlayerHands() {
		for(Player p : players) {
			p.drawHand(pile);
		}
		
	}


	public void clearMelds() {
		this.melds.clear();
		
	}
	
}
