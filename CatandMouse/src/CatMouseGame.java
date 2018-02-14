
public class CatMouseGame {
	
	public static void main(String[] args) {
		
		Cat cat = new Cat();
		Cat cat2 = new Cat();
		Mouse mouse = new Mouse();
		mouse.registerObserver(cat);
		mouse.registerObserver(cat2);
		
		mouse.mouseMove();
		mouse.mouseMove();

	}

}
