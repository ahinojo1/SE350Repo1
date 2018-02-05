package hw2;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class PirateShip implements Observer{
	Point shipPosition;
	Point pirateShipPosition;
	OceanMap oceanMap;
	Random rand = new Random();
	Ship ship;
	
	public PirateShip(OceanMap oceanMap) {
		this.oceanMap = oceanMap;
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		//when the ship moves, the pirate follows
		if (o instanceof Ship) {
			shipPosition = ((Ship) o).getShipLocation();
			movePirate();
		}
	}
	
	public void movePirate() {
		if(pirateShipPosition.x - shipPosition.x < 0) 
			pirateShipPosition.x++;
		
		else
			pirateShipPosition.x--;
		
		if (pirateShipPosition.y - shipPosition.y < 0)
			pirateShipPosition.y++;
		else
			pirateShipPosition.y--;
	}
	
}
