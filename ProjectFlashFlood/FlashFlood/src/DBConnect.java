import java.sql.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MAHFUZ AFTAB
 */
public class DBConnect {
    private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public DBConnect (){
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flooddbb","root","");
                st = con.createStatement();
                
	} 
        catch (Exception ex){
		System.out.println ("Error: "+ex);
	}
	}
        public void getData()
        {
            try{
               
                String query = "select * from floodinfoo";
                rs= st.executeQuery(query);
                System.out.println("All Records From DB");
                
                while (rs.next()){
                String level = rs.getString("level");
                Timestamp time = rs.getTimestamp("time");
                System.out.println("Water Level:"+ level+ "   Occured Time:"+time );
                }
            }
            catch (Exception ex){
		System.out.println (ex);
            }
        }
     
}



