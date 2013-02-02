package iiitb.student.util;

public class RuntimeSettings {
	public static final String APPLICATION_NAME = "studentProfileSystem";
	public static final String VERSION_ID = " version 0.1" + " dated Feb 2, 2013";
	public static final String SERVER_IP = "localhost";
	static String databaseName = "studentProfileSystem";
	static String dbUserID = "root";
	static String dbPassword = "password";
	public static String RUN_MODE = "Test"; 
	public static boolean IS_IN_DEBUG_MODE = true; // false; //
	static int portNo = 3306;
	public static String scriptSql[] = {
			" use timesheet;",
			"DROP TABLE IF EXISTS role;",
			"CREATE TABLE  role ("
					+ "role_id int(10) unsigned NOT NULL,"
					+ "role_name varchar(20),"
					+ "PRIMARY KEY (role_id));" };


	public static String scriptSql1[] = {
		
		" use timesheet;",
		"DROP TABLE IF EXISTS useraccount;",
		"CREATE TABLE useraccount ("
				+ "uid int(10) unsigned NOT NULL,"
				+ "emp_id int(10),"
				+ "role_id int(10),"
				+ "username varchar(20),"
				+ "password varchar(20),"
				+ "PRIMARY KEY (uid),"
				+ "KEY fk_role_id(role_id),"
				+ "KEY fk_emp_id(emp_id));",
				"INSERT into useraccount values (1,1,1,'admin', 'admin');", 
				"INSERT into useraccount values (2,2,2,'manager', 'manager');",
				"INSERT into useraccount values (3,3,3,'member', 'member');",	
				"INSERT into useraccount values (4,4,4,'client', 'client');"

	};


public static String scriptSql2[] = {
	
	" use timesheet;",
	"DROP TABLE IF EXISTS employee;",
	"CREATE TABLE employee ("
			+ "emp_id int(10) unsigned NOT NULL AUTO_INCREMENT,"
			+ "firstname varchar(20) NOT NULL,"
			+ "lastname varchar(20) NOT NULL,"
			+ "email varchar(20) NOT NULL,"
			+ "phone_num int(20),"
			+ "join_date date,"
			+ "role_id int(10),"
			+ "manager_id int (10),"
			+ "PRIMARY KEY (emp_id),"
			+ "KEY fk_role_id(role_id),"
			+ "KEY fk_manager_id(manager_id));"
};
}
