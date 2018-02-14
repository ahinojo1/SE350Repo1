import java.awt.Point;
import java.util.Random;
//import javax.security.auth.Subject;

public class Cat implements Observer{
	Point mousePosition; //Current position of the mouse
	Point catPosition;	//Current position of the cat
	Random rand = new Random();
	
	public Cat(){
		catPosition = new Point(rand.nextInt(800), rand.nextInt(800));
	}
  
	@Override
	public void update (Mouse mouse){
		
	  if(mouse instanceof Mouse){
		  mousePosition = ((Mouse)mouse).getPosition();
		  moveCat();
	  }
	} 
	  
	 public void moveCat(){
		 
		 if(rand.nextInt(2)==1){ //Slow down the cat
			
			 
			 if (catPosition.x - mousePosition.x < 0)
				 catPosition.x++;
			 else
				 catPosition.x--;
			 
			 if (catPosition.y - mousePosition.y < 0)
				 catPosition.y++;
			 else
				 catPosition.y--;
		 }
	 
		 System.out.println("Cat:" + catPosition.x + " " + catPosition.y);
	 }
	 
}
