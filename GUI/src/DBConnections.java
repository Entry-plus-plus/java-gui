import java.sql.*;
import java.util.Date;

public class DBConnections {
    public Connection connect = null;
    public Statement query = null;
    public ResultSet beheerders = null;
    public ResultSet users = null;
    public PreparedStatement preparedStatement = null;
    public String username;

    private Connection connectDatabase() {
        String url = "jdbc:mysql://localhost/";
        String username = "root";
        String password = "THISISASTRONGFUCKINGPASSWORDHELLYEAH";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public String getAllAdmins() throws Exception {
        try (Connection conn = this.connectDatabase()){
            // Statements allow to issue SQL queries to the database
            query = conn.createStatement();
            // Result set get the result of the SQL query
            beheerders = query
                    .executeQuery("select * from `entry++`.`beheerder`");
            beheerders.next();
            String beheerderlijst;
            String beheercode;
            beheerderlijst = beheerders.getString("Username");
            beheercode = beheerders.getString("Beheerder Beheercode");
            return beheercode + beheerderlijst;
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    public void getUser(String gebruikerscode) throws Exception {
        try (Connection conn = this.connectDatabase()){
            // Statements allow to issue SQL queries to the database
            // Result set get the result of the SQL query
            preparedStatement = conn.prepareStatement("select * from `entry++`.`gebruiker` where Gebruikerscode = (?)");
            preparedStatement.setString(1, gebruikerscode);
            users = preparedStatement.executeQuery();
            users.next();
            username = users.getString("Username");
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    // You need to close the resultSet
    private void close() {
        try {
            if (beheerders != null) {
                beheerders.close();
            }

            if (query != null) {
                query.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}