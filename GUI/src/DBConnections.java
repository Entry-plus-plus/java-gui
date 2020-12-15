import java.sql.*;
import java.util.Date;

public class DBConnections {
    private Connection connect = null;
    private Statement query = null;
    private ResultSet beheerders = null;
    private ResultSet users = null;
    private ResultSet verdieping = null;
    private PreparedStatement preparedStatement = null;
    private String username;

    private Connection connectDatabase() {
        String url = "jdbc:mysql://localhost/Mysql?serverTimezone=UTC";
        String username = "root";
        String password = "password";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
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
            while (beheerders.next()) {
                String beheerderlijst = beheerders.getString("Username");
                String beheercode = beheerders.getString("Beheerder Beheercode");
                String Firstname = beheerders.getString("Firstname");
                String Lastname = beheerders.getString("Lastname");
                System.out.println(beheercode + " " + beheerderlijst + " " + Firstname + " " + Lastname);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    public void getAllUsers() throws Exception {
        try (Connection conn = this.connectDatabase()){
            // Statements allow to issue SQL queries to the database
            query = conn.createStatement();
            // Result set get the result of the SQL query
            users = query
                    .executeQuery("select * from `entry++`.`gebruiker`");
            while (users.next()) {
                String gebruikercode = users.getString("Gebruikerscode");
                String gebruikerlijst = users.getString("Username");
                String Firstname = users.getString("Firstname");
                String Lastname = users.getString("Lastname");
                String Password = users.getString("Password");
                System.out.println(gebruikercode + " " + gebruikerlijst + " " + Firstname + " " + Lastname);
            }
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

    public void getFloor(String verdiepingnummer) throws Exception {
        try (Connection conn = this.connectDatabase()){
            // Statements allow to issue SQL queries to the database
            // Result set get the result of the SQL query
            preparedStatement = conn.prepareStatement("select * from `entry++`.`verdieping` where `Verdieping nummer gebouw` = (?)");
            preparedStatement.setString(1, verdiepingnummer);
            verdieping = preparedStatement.executeQuery();
            verdieping.next();
            String aantalMensen = verdieping.getString("Aantal mensen");
            String locatieCode = verdieping.getString("Locatiecode");
            String maxMensen = verdieping.getString("maxmensen");
            String verdiepingNummer = verdieping.getString("Verdieping nummer gebouw");
            System.out.println(verdiepingNummer + " " + aantalMensen + " " + locatieCode + " " + maxMensen);
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    public void getAllFloors() throws Exception {
        try (Connection conn = this.connectDatabase()){
            // Statements allow to issue SQL queries to the database
            query = conn.createStatement();
            // Result set get the result of the SQL query
            verdieping = query
                    .executeQuery("select * from `entry++`.`verdieping`");
            while (verdieping.next()) {
                String aantalMensen = verdieping.getString("Aantal mensen");
                String locatieCode = verdieping.getString("Locatiecode");
                String maxMensen = verdieping.getString("maxmensen");
                String verdiepingNummer = verdieping.getString("Verdieping nummer gebouw");
                System.out.println(verdiepingNummer + " " + aantalMensen + " " + locatieCode + " " + maxMensen);
            }
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