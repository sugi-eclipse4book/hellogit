package blog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
* �V���v���ȃR�l�N�V�����Ǘ��N���X
*/
public class ConnectionManager {
	/**
	* JDBC�h���C�o�̃N���X
	*/
	final static String DRIVER = "com.mysql.jdbc.Driver";

	/**
	* �f�[�^�x�[�X��URL
	*/
	final static String URL = "jdbc:mysql://localhost/mydb";

	/**
	* �f�[�^�x�[�X�̃p�X���[�hL
	*/
	final static String USER = "root";

	/**
	* �f�[�^�x�[�X�̃p�X���[�h
	*/
	final static String PASS = "hoge";

	/**
	* Connection���擾���܂�
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