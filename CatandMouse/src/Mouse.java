import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Mouse implements Subject{
	
	List<Observer> observers = new LinkedList<Observer>();
	Point myPosition = new Point(0,0);
	Point targetPosition;
	Random rand;
	
	public Mouse(){
		targetPosition = new Point(0,0);
		setTargetPosition();
	
	}

	private void setTargetPosition() {
		rand = new Random();
		targetPosition.x = rand.nextInt(800);
		targetPosition.y = rand.nextInt(800);	
	}
	
	private void setMousePosition() {
		rand = new Random();
		targetPosition.x = rand.nextInt(800);
		targetPosition.y = rand.nextInt(800);	
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
		
	}

	@Override
	public void removeObserver(Observer o) {
		if(observers.contains(o))
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for (Observer catObserver: observers)
			catObserver.update(this);
		
	}

	public Point getPosition() {
		return myPosition;
	}
	
	public void mouseMove(){
		
		while(Math.abs (myPosition.x - targetPosition.x) + 
				Math.abs (myPosition.y - targetPosition.y) < 20){
			
			setTargetPosition();
			setMousePosition();
		}
		
		if (myPosition.x - targetPosition.x < 0)
			myPosition.x++;
		else
			myPosition.x--;
		
		if (myPosition.y - targetPosition.y < 0)
			myPosition.y++;
		else
			myPosition.y--;
		
		notifyObservers();
	}	
}
