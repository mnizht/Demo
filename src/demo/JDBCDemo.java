package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JDBCDemo {

	public List<Student> findAll() {
		List<Student> stuList = new ArrayList<Student>();

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String uname = "root";
		String password = "root";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 加载驱动
			Class.forName(driver);
			// 获取连接
			conn = DriverManager.getConnection(url, uname, password);
			// 建立会话
			stmt = conn.createStatement();
			// 发送sql命令得到结果
			rs = stmt.executeQuery("select * from t_student");
			// 处理结果

			while (rs.next()) {
				// 取出结果集中各列数据
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				double score = rs.getDouble("score");
				Date enterDate = rs.getDate("enterDate");
				// 封装成Student对象
				Student stu = new Student(id, name, age, score, enterDate);
				// 加入集合
				stuList.add(stu);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭资源（一次关闭 rs,stmt,conn）
			closeAll(rs, stmt, conn);
		}

		return stuList;
	}

	public void closeAll(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
