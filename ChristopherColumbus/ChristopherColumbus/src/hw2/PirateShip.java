package hw2;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class PirateShip implements Observer{
	Point shipPosition ;
	Point pirateShipPosition;
	OceanExplorer oceanExplorer;
	OceanMap oceanMap;
	Random rand = new Random();
	Ship ship;
	
	public PirateShip(OceanMap oceanMap, OceanExplorer oceanExplorer) {
		this.oceanExplorer = oceanExplorer;
		this.oceanMap = oceanMap;
		pirateShipPosition = new Point(0,0);
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		//when the ship moves, the pirate follows
		if (o instanceof Ship) {
			shipPosition = ((Ship) o).getShipLocation();
			movePirate();
			oceanExplorer.loadPirateShipImage();
		}
	}
	
	public void movePirate() {
		if(pirateShipPosition.x - shipPosition.x < 0) 
			goEast();
		
		else
			goWest();
		
		if (pirateShipPosition.y - shipPosition.y < 0)
			goSouth();
		else
			goNorth();
	}
	
	public void goEast(){
    	if(pirateShipPosition.x<oceanMap.getDimensions()-1 && oceanMap.isOcean(pirateShipPosition.x+1, pirateShipPosition.y)){
    		pirateShipPosition.x++;
    		
    		
    	}  
    	    	
    }
    
    public void goWest(){
    	if(pirateShipPosition.x >0 && oceanMap.isOcean(pirateShipPosition.x-1, pirateShipPosition.y)){
    		pirateShipPosition.x--;
    		
    	}  	
    	
    }
    
    public void goNorth(){
    	if(pirateShipPosition.y>0 && oceanMap.isOcean(pirateShipPosition.x, pirateShipPosition.y-1)){
    		pirateShipPosition.y--;
    		
    	}  	
    	
    }
    
    public void goSouth(){
    	if(pirateShipPosition.y<oceanMap.getDimensions()-1 && oceanMap.isOcean(pirateShipPosition.x, pirateShipPosition.y+1)){
    		pirateShipPosition.y++;
    		
    	}  			
    	
    }
}
