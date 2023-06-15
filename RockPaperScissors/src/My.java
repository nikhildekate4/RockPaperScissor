import java.util.Random;

public class My {
public static void main(String[] args) {
	
 Random r = new Random();
	int low = 5;
	int high = 10;
	int result = r.nextInt(high-low) + low; 
	System.out.println(result);
}
}
