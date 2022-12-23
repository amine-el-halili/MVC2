package connection;

import java.sql.*;


public class MyConnection {
    private static MyConnection instance;
    private Connection connection;
    private MyConnection(String str, String user, String psw) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(str, user, psw);
    }
    public static MyConnection getInstance() throws ClassNotFoundException, SQLException {
        if (instance == null) {
            instance = new MyConnection("jdbc:mysql://localhost:3306/product", "root", "");
            return instance;
        }
        return instance;
    }

    public ResultSet query(String qr) throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(qr);
    }
    public void insert(String qr) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(qr, Statement.RETURN_GENERATED_KEYS);
        ps.execute();
    }
}
