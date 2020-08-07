package server.database;

import java.io.File;
import java.io.FileReader;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class OracleManager implements DBManager {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private Connection con;

	public OracleManager() throws Exception {
		Properties prop = new Properties();
		String path = getClass().getResource("").getPath();
		System.out.println(path);
		path = URLDecoder.decode(path, "UTF-8") + "log.txt";	// ��ο� �ѱ��� ���� ��� ������ ���� �ذ�
		File file = new File(path);
		if (!file.exists()) {
			throw new Exception("DB ���������� �����ϴ�");
		}
		prop.load(new FileReader(file));
		Class.forName(driver);
		con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("pwd"));
	}

	@Override
	public PreparedStatement create(String sql) throws SQLException {
		return con.prepareStatement(sql);
	}

	@Override
	public Statement create() throws SQLException {
		return con.createStatement();
	}

}
