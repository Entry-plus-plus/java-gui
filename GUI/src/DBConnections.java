import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DBConnections {
    private Connection connect = null;
    private Statement query = null;
    private ResultSet Users = null;
    private PreparedStatement User = null;
    private ResultSet Userid = null;
    private ResultSet userList = null;

    public void connectDatabase() throws Exception{
        // This will load the MySQL driver, each DB has its own driver
        Class.forName("com.mysql.jdbc.Driver");
        // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/entry++?"
                        + "user=root&password=");
    }

    public void getAllUsers() throws Exception {
        try {
            // Statements allow to issue SQL queries to the database
            query = connect.createStatement();
            // Result set get the result of the SQL query
            Users = query
                    .executeQuery("select * from entry++.gebruiker");
            writeResultSet(userList);

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
                    .prepareStatement("select * from entry++.gebruiker where gebruikerscode = '?' ");
            User.setString(1, gebruikerscode);
            writeResultSet(Userid);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String user = resultSet.getString("myuser");
            String website = resultSet.getString("webpage");
            String summary = resultSet.getString("summary");
            Date date = resultSet.getDate("datum");
            String comment = resultSet.getString("comments");
            System.out.println("User: " + user);
            System.out.println("Website: " + website);
            System.out.println("summary: " + summary);
            System.out.println("Date: " + date);
            System.out.println("Comment: " + comment);
        }
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (Users != null) {
                Users.close();
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