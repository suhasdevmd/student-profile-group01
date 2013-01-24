package carpooling.util;
import java.sql.*;

public class DB {
		static int timeCounter = 0;
		static boolean isActiveConnectionsWatcherStarted = false;
		protected static Connection conn;
		protected ResultSet rs;
		protected Statement stmt;
		protected static boolean isSeekingConnectionFirstTime = true;
		protected static boolean isEnteredBMTCFirstTime = true;
		protected static boolean isEnteredCelcabsFirstTime = true;
		protected static int activeConnections;
//Sravya's part
		
		public static ResultSet selectRegUsers(){
			ResultSet res;
		
		
			try {
				Statement stmt1;
				
			
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/mysql";
				Connection con = DriverManager.getConnection(url,
						RuntimeSettings.dbUserID, 
						RuntimeSettings.dbPassword);
				stmt1=con.createStatement();
				
				stmt1.execute("use carpooling;");
				
				PreparedStatement stmt=con.prepareStatement("select * from registeredusers;");
				res=stmt.executeQuery();
		
				
			} catch (Exception e) {
				res=null;
			
				e.printStackTrace();
			}
			return res;
		}
		
		public static ResultSet getDetails(){
			ResultSet res;
		
		
			try {
				Statement stmt1;
				
				
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/mysql";
				Connection con = DriverManager.getConnection(url,
						RuntimeSettings.dbUserID, 
						RuntimeSettings.dbPassword);
				stmt1=con.createStatement();
				
				stmt1.execute("use carpooling;");
				
				PreparedStatement stmt=con.prepareStatement("select * from employees;");
				res=stmt.executeQuery();
				
		
				
			} catch (Exception e) {
				res=null;
			
				e.printStackTrace();
			}
			return res;
		}
		public static void updateWeekDay(String empId,String Weekday){
			
			try {
				Statement stmt1;
				System.out.println("************"+Weekday+"************"+empId);
				
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/mysql";
				Connection con = DriverManager.getConnection(url,
						RuntimeSettings.dbUserID, 
						RuntimeSettings.dbPassword);
				String updateweekday="update registeredusers set weekday='"+Weekday+"'where Employee_id= '"+empId+"'";
				stmt1=con.createStatement();
				
				stmt1.execute("use carpooling;");
				
				PreparedStatement stmt=con.prepareStatement(updateweekday);
				stmt.executeUpdate();
				
		
				
			} catch (Exception e) {
				e.printStackTrace();
			
			
			}
			
			
		}
		public static ResultSet getEmpIDList(){
			ResultSet rs=null;
			
				try {
					Statement stmt1;
					
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3306/mysql";
					Connection con = DriverManager.getConnection(url,
							RuntimeSettings.dbUserID, 
							RuntimeSettings.dbPassword);
					
					stmt1=con.createStatement();
					
					stmt1.execute("use carpooling;");
					
					PreparedStatement stmt=con.prepareStatement("select Employee_id from registeredusers;");
					rs=stmt.executeQuery();
					
			
					
				} catch (Exception e) {
					rs=null;
					e.printStackTrace();
				
				
				}
				return rs;
			}
		public static ResultSet getFeedback(){
		ResultSet res;
		
		
		try {
			Statement stmt1;
			
		
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mysql";
			Connection con = DriverManager.getConnection(url,
					RuntimeSettings.dbUserID, 
					RuntimeSettings.dbPassword);
			stmt1=con.createStatement();
			
			stmt1.execute("use carpooling;");
			
			PreparedStatement stmt=con.prepareStatement("select * from feedback;");
			res=stmt.executeQuery();
			
				System.out.println("res =" + res);
			
	
			
		} catch (Exception e) {
			res=null;
		
			e.printStackTrace();
		}
		return res;
		}
		

		public static void unregister(String empid){
		ResultSet res;
		
		
		try {
			Statement stmt1;
			
		
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mysql";
			Connection con = DriverManager.getConnection(url,
					RuntimeSettings.dbUserID, 
					RuntimeSettings.dbPassword);
			stmt1=con.createStatement();
			
			stmt1.execute("use carpooling;");
			String our_query = "delete from registeredusers where Employee_id='"+empid+"'";
			PreparedStatement stmt=con.prepareStatement(our_query);
			stmt.executeUpdate();
			
		
			
	
			
		} catch (Exception e) {
			res=null;
		
			e.printStackTrace();
		}
		}
		
		public static String getEmail(String empId){
			ResultSet res;
			String mailid=null;
			
			try {
				Statement stmt1;
				String myquery;
			
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/mysql";
				Connection con = DriverManager.getConnection(url,
						RuntimeSettings.dbUserID, 
						RuntimeSettings.dbPassword);
				stmt1=con.createStatement();
				
				stmt1.execute("use carpooling;");
				myquery="select EmailId from employee where Employee_Id='"+empId+"'";
				PreparedStatement stmt=con.prepareStatement(myquery);
				res=stmt.executeQuery();
				
					//System.out.println("res =" + res);
				while(res.next())
					mailid=res.getString("EmailId");
				
			} catch (Exception e) {
				res=null;
				mailid=null;
				e.printStackTrace();
			}
			return mailid;

			
			
		}
		
		public static boolean getBookedUsers(String empid){
			ResultSet res;
			boolean rs;
			try {
				Statement stmt1;
				String myquery;
			
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/mysql";
				Connection con = DriverManager.getConnection(url,
						RuntimeSettings.dbUserID, 
						RuntimeSettings.dbPassword);
				stmt1=con.createStatement();
				
				stmt1.execute("use carpooling;");
				myquery="select Employee_id from bookedseats;";
				PreparedStatement stmt=con.prepareStatement(myquery);
				res=stmt.executeQuery();
				while(res.next()){
					rs=empid.equals(res.getString("Employee_id"));
					System.out.println("**********"+rs);
					if(rs==true)
						return true;
				}
					
			
				
			  }
			
			catch (Exception e) {
				res=null;
				
				e.printStackTrace();
			}
			return false;


			
			
		}
		public static ResultSet cancelSeat(String empid){
			ResultSet res;
		
			
			try {
				String dest=null,time=null;
				Statement stmt1;
				String myquery;
			
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/mysql";
				Connection con = DriverManager.getConnection(url,
						RuntimeSettings.dbUserID, 
						RuntimeSettings.dbPassword);
				stmt1=con.createStatement();
				
				stmt1.execute("use carpooling;");
				myquery="select * from bookedseats where Employee_id='"+empid+"'";
				PreparedStatement stmt=con.prepareStatement(myquery);
				res=stmt.executeQuery();
				while(res.next()){
					dest=res.getString("Destination");
					time=res.getString("DepartureTime");
				}
				myquery="delete  from bookedseats where Employee_id='"+empid+"'";
				stmt=con.prepareStatement(myquery);
				stmt.executeUpdate();
				myquery="select * from placerequest where Destination='"+dest+"' and DepartureTime='"+time+"'";
				stmt=con.prepareStatement(myquery);
				res=stmt.executeQuery();
				return res;	
			}
			catch(Exception e){
				res=null;
				e.printStackTrace();
			}
			return res;
			
}
		
		
		public static void removeRequest(String empid){
			
			
			
			try {
				Statement stmt1;
				String myquery;
			
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/mysql";
				Connection con = DriverManager.getConnection(url,
						RuntimeSettings.dbUserID, 
						RuntimeSettings.dbPassword);
				stmt1=con.createStatement();
				
				stmt1.execute("use carpooling;");
				myquery="delete from placerequest where Employee_id='"+empid+"'";
				PreparedStatement stmt=con.prepareStatement(myquery);
				stmt.executeUpdate();
				
					
				
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		

}

		
		public static void insertIntoBookedSeats(String empId,String destination,String departuretime,String carno){
			
			try {
				Statement stmt1;
				String myquery;
			
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/mysql";
				Connection con = DriverManager.getConnection(url,
						RuntimeSettings.dbUserID, 
						RuntimeSettings.dbPassword);
				stmt1=con.createStatement();
				
				stmt1.execute("use carpooling;");
				myquery="insert into bookedseats values('"+empId+"','"+destination+"',CURDATE(),'"+departuretime+"','"+carno+"');";
				System.out.println(myquery);
				PreparedStatement stmt=con.prepareStatement(myquery);
				stmt.executeUpdate();
				
					
				
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		
			
		}
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//My part 
		
		public void createDatabase(String databaseName) {
			try {
				Statement stmt;

				// Register the JDBC driver for MySQL.
				Class.forName("com.mysql.jdbc.Driver");

				// Define URL of database server for
				// database named mysql on the localhost
				// with the default port number 3306.
				String url = "jdbc:mysql://localhost:3306/mysql";

				// Get a connection to the database for a
				// user named root with a blank password.
				// This user is the default administrator
				// having full privileges to do anything.
				Connection con = DriverManager.getConnection(url,
						RuntimeSettings.dbUserID, 
						RuntimeSettings.dbPassword);

				// Display URL and connection information
				System.out.println("URL: " + url);
				System.out.println("Connection: " + con);

				// Get a Statement object
				stmt = con.createStatement();

				// Create the new database after 1st dropping it if it exists
				stmt.executeUpdate("drop database if exists " + databaseName);

				stmt.executeUpdate("CREATE DATABASE " + databaseName);
				close(stmt);
				close(con);
			} catch (Exception e) {
				e.printStackTrace();
			}// end catch
		}

				
		//used
		public static int update(String sql) {

			int rowsUpdated = 0;
			Connection connection = null;
			try {
				connection = getConnection();
				connection.setAutoCommit(true);
				rowsUpdated = update(connection, sql);
			} catch (SQLException ex) {
				MyLog.myCatch("/java", 143, ex);
			} finally {
				close(connection);
			}
			return rowsUpdated;
		}	
		
		
		//used
		public static ResultSet readFromDB(String query, Connection connection) {
			ResultSet result = null;
			Statement stmt = null;
			try {
				System.out.println("In readFrom DB");
				MyLog.log("in readFromDB with query:\n" + query);
				if ((query.indexOf(" where ") >= 0)
						|| (query.indexOf("count ") >= 0)) {
					// ok
				} else {
					MyLog.myIO("@@@ please check as query without a where clause!");
				}
				stmt = connection.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				 System.out.println("in readFromDB inside result with query:\n" +
				 query);
				 stmt.execute("use carpooling;");
				result = stmt.executeQuery(query);
				MyLog.myIO("readFromDB sql:" + query);
			} catch (SQLException se) {
				MyLog.myCatch("/java", 66, se);
			}
			System.out.println("result inside db = " + result);
			return result;
		}

		public static int update(Connection connection, String sql) {
			System.out.println("query inside DB.java "+ sql);
			Statement statement = null;
			int rows = 0;
			try {
				statement = connection.createStatement();
				statement.execute("use carpooling;");//wont work without this line
				rows = statement.executeUpdate(sql);
				MyLog.myIO("updating " + rows + " rows for sql:" + sql + ":");
			} catch (SQLException ex) {
				MyLog.myCatch("/update() while running sql:" + sql + ":", 79, ex);
			} finally {
				close(statement);
			}
			return rows;
		}

		public static void close(Connection connection) {
			// return;
			if (connection == null) {
				return;
			}
			try {
				if (connection.isClosed()) {
					connection = null;
				} else {
					try {
						connection.close();
						MyLog.log("closing a conn; total conn:" + activeConnections);
						connection = null;
					} catch (SQLException ex) {
						MyLog.myCatch("/java", 106, ex);
					}
				}
			} catch (SQLException ex) {
				MyLog.myCatch("/java", 110, ex);
			}
		}
		//used
		public static Connection getConnection() {
			Connection con = null;
			try {

				if (isSeekingConnectionFirstTime) {
					isSeekingConnectionFirstTime = false;
					try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (ClassNotFoundException ex) {
						MyLog.myCatch("/java", 162, ex);
					}
				}
				String connectionUrl = "jdbc:mysql://localhost:3306/mysql" ;
				
				con = DriverManager.getConnection(connectionUrl,
						RuntimeSettings.dbUserID, RuntimeSettings.dbPassword);
				System.out.println("con  while modify "+ con);
			} catch (SQLException ex) {
				MyLog.myCatch("/java", 217, ex);
			}
			activeConnections++;
			MyLog.log("in DBDataStandAlone added new tms conn; total connections:"
					+ activeConnections);
			return con;
		}

		public static void close(Statement statement) {
			if (statement != null) {
				try {
					statement.close();
					statement = null;
				} catch (SQLException ex) {
					MyLog.myCatch("/java", 202, ex);
				}
			}
		}

		public static void close(ResultSet rs) {
			// return;
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (SQLException ex) {
					MyLog.myCatch("/java", 214, ex);
				}
			}
		}

		public static void close(PreparedStatement preparedStmt) {
			if (preparedStmt != null) {
				try {
					preparedStmt.close();
					preparedStmt = null;
				} catch (SQLException ex) {
					MyLog.myCatch("/java", 225, ex);
				}
			}
		}

		public int runScript(String sqlStatement) {
			int rowsUpdated = update(sqlStatement);
			return rowsUpdated;
		}

				
}


		