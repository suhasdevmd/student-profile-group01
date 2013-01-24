package carpooling.util;

public class RuntimeSettings {
	public static final String APPLICATION_NAME = "carpooling";
	public static final String VERSION_ID = " version 0.1"
			+ " dated October 28, 2012";
	public static final String SERVER_IP = "localhost";
	static String databaseName = "carpooling";
	static String dbUserID = "root";
	// "" for apple Macbook Air
	static String dbPassword = "root"; 
	public static String RUN_MODE = "Test"; // "Production"; //
	public static boolean IS_IN_DEBUG_MODE = true; // false; //
	static int portNo = 3306;// 5432; //
	public static String scriptSql[] = {
			// " drop database if exists carpooling;",
			// " create database carpooling;",
			"use carpooling;",
			"DROP TABLE IF EXISTS Employee;",
			"CREATE TABLE  Employee ("
					+ "Employee_id varchar(45) NOT NULL,"
					+ "EmployeeName varchar(45) NOT NULL,"
					+ "EmailId varchar(45) NOT NULL,"
					+ "Password varchar(500),"
					+ "updated_at datetime,"
					+ "created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,"
					+ "PRIMARY KEY (`Employee_id`));",
			"insert into Employee (Employee_id, EmployeeName, EmailId, Password) " +
			" values('IC00102', 'Bert Bates', " +
			"'bates@tech.com', 'bates123'); "
	    };

}
