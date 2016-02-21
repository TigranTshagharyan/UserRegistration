import java.sql.*;

public class DbManager {
	
	public static void Insert(User user) throws ClassNotFoundException, SQLException{
        // This will load the MySQL driver, each DB has its own driver
        Class.forName("com.mysql.jdbc.Driver");
        // Setup the connection with the DB
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/my_db?"
                        + "user=root&password=123456");
		
		String sql = "INSERT INTO users (UserName,Password,FirstName,LastName,Email,Gender,Age,Address) VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = connect.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getFirstName());
		pstmt.setString(4, user.getLastName());
		pstmt.setString(5, user.getEmail());
		pstmt.setString(6, user.getGender());
		pstmt.setInt(7, user.getAge());
		pstmt.setString(8, user.getAddress());
		pstmt.executeUpdate();
		connect.close();
	}
	
	/*public static int checkUser(User get) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");

		String sql	=	"SELECT COUNT(*) FROM register WHERE email=? AND password=?";
		PreparedStatement pstmt	=	conn.prepareStatement(sql);
		pstmt.setString(1, get.getEmail());
		pstmt.setString(2, get.getPassword());
		ResultSet rs	=	pstmt.executeQuery();

		int count = 0;
		while(rs.next()){
			count	=	rs.getInt(1);
		}
		ConnectionManager.getInstance().close();
		return count;

	}*/

}
