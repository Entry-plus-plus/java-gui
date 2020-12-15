import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DBConnections {
    public Connection connect = null;
    public Statement query = null;
    public ResultSet beheerders = null;
    private PreparedStatement User = null;
    //private ResultSet Userid = null;
    private ResultSet ResultSet = null;
    public String beheerderlijst;
    public String beheercode;

    private Connection connectDatabase() {
        // OUD (2019): SQLite database connection string, pas zonodig het pad aan:
        // String url = "jdbc:sqlite:C:\\tempgert\\sqlite3\\vb1.db";
        // NIEUW (2020): MySQL database connection string, pas zonodig het pad aan:
        String url = "jdbc:mysql://localhost/MySQL?serverTimezone=UTC"; // Als je met een andere computer wilt verbinden, pas dan 'localhost'
        // aan naar bijv. het IP adres of naar de URL (internet) van de machine waarmee je wilt verbinden.
        String username = "root"; // nieuw 8-12-2020, nodig bij MySQL
        String password = ""; // nieuw 8-12-2020, nodig bij MySQL
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);  // Aangepast 8-12-2020 t.b.v. MySQL
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void getAllAdmins() throws Exception {
        try (Connection conn = this.connectDatabase()){
            // Statements allow to issue SQL queries to the database
            query = conn.createStatement();
            // Result set get the result of the SQL query
            beheerders = query
                    .executeQuery("select * from `entry++`.`beheerder`");
            //writeResultSet(beheerders);
            beheerders.next();
            beheerderlijst = beheerders.getString("Username");
            beheercode = beheerders.getString("Beheerder Beheercode");
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    public void getUser(String gebruikerscode) throws Exception {
        try {
            // Statements allow to issue SQL queries to the database
            query = connect.createStatement();
            // Result set get the result of the SQL query
            User = connect
                    .prepareStatement("select * from `entry++`.`gebruiker` where gebruikerscode = '?' ");
            User.setString(1, gebruikerscode);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

//    private void writeMetaData(ResultSet resultSet) throws SQLException {
//        //  Now get some metadata from the database
//        // Result set get the result of the SQL query
//
//        System.out.println("The columns in the table are: ");
//
//        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
//        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
//            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
//        }
//    }

    public void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String beheerderlijst = resultSet.getString("Username");
//            String website = resultSet.getString("webpage");
//            String summary = resultSet.getString("summary");
//            Date date = resultSet.getDate("datum");
//            String comment = resultSet.getString("comments");
//            System.out.println("User: " + user);
//            System.out.println("Website: " + website);
//            System.out.println("summary: " + summary);
//            System.out.println("Date: " + date);
//            System.out.println("Comment: " + comment);
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