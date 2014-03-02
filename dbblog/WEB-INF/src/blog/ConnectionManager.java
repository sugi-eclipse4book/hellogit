package blog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
* シンプルなコネクション管理クラス
*/
public class ConnectionManager {
	/**
	* JDBCドライバのクラス
	*/
	final static String DRIVER = "com.mysql.jdbc.Driver";

	/**
	* データベースのURL
	*/
	final static String URL = "jdbc:mysql://localhost/mydb";

	/**
	* データベースのパスワードL
	*/
	final static String USER = "root";

	/**
	* データベースのパスワード
	*/
	final static String PASS = "hoge";

	/**
	* Connectionを取得します
	*/
	public static Connection getConnection()
		throws SQLException{
	try{
		Class.forName(DRIVER);
	}catch (ClassNotFoundException e){
		e.printStackTrace();
		throw new IllegalStateException(
				"fail to class load : "
						+ e.getMessage());
	}
	Connection con = DriverManager.getConnection(URL,USER,PASS);
	return con;

	}
}