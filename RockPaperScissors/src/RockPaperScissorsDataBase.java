import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class RockPaperScissorsDataBase {
	public Connection conn;
	public Statement stmt;
	String Name;
	public RockPaperScissorsDataBase(){
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");

	    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","12345");
		stmt =conn.createStatement();
		System.out.println("connection done");
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
}
	

	
	public void insertPlayer(String name, int points) {
        try {
        	Random r = new Random();
        	int low = 5000;
        	int high = 20000;
        	int Id = r.nextInt(high-low) + low; 
        	
        	System.out.println("Unique Id:"+Id);
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO scores (Id,Name,Points) VALUES ("+Id+",'" + name + "', " + points + ")";
            stmt.executeUpdate(sql);
            System.out.println("Player Id & Name "+Id+" " + name + " inserted into database.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
}
}

    public void updateScore(String name, int points) {
        try {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE scores SET Points=" + points + " WHERE Name='" + name + "'";
            stmt.executeUpdate(sql);
            System.out.println("Score updated for player " + name + ".");
            System.out.println("============================================");	
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
}
}
}

