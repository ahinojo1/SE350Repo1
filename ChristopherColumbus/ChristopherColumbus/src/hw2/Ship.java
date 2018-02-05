package hw2;

import java.awt.Point;
import java.util.Observable;



public class Ship extends Observable{
    Point currentLocation;
    OceanMap oceanMap;
    
    public Ship(OceanMap oceanMap){    	
    	this.oceanMap = oceanMap;
    	currentLocation = oceanMap.getShipLocation();
    }
    
    public Point getShipLocation(){
    	return currentLocation;
    }
    
    public void goEast(){
    	if(currentLocation.x<oceanMap.getDimensions()-1 && oceanMap.isOcean(currentLocation.x+1, currentLocation.y)){
    		currentLocation.x++;
    	}  			
    }
    
    public void goWest(){
    	if(currentLocation.x >0 && oceanMap.isOcean(currentLocation.x-1, currentLocation.y)){
    		currentLocation.x--;
    	}  			
    }
    
    public void goNorth(){
    	if(currentLocation.y>0 && oceanMap.isOcean(currentLocation.x, currentLocation.y-1)){
    		currentLocation.y--;
    	}  			
    }
    
    public void goSouth(){
    	if(currentLocation.y<oceanMap.getDimensions()-1 && oceanMap.isOcean(currentLocation.x, currentLocation.y+1)){
    		currentLocation.y++;
    	}  			
    }
	
}

