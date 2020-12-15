import java.sql.*;
import java.util.Date;

public class DBConnections {
    private Connection connect = null;
    private Statement query = null;
    private ResultSet beheerders = null;
    private ResultSet users = null;
    private ResultSet verdieping = null;
    private ResultSet kamer = null;
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
                String username = beheerders.getString("Username");
                String beheercode = beheerders.getString("Beheerder Beheercode");
                String password = beheerders.getString("Password");
                String firstname = beheerders.getString("Firstname");
                String lastname = beheerders.getString("Lastname");
                GUI.adminsArrayList.add(new User(beheercode, username, password, firstname, lastname));
                System.out.println(beheercode + " " + username + " " + firstname + " " + lastname);
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
                String username = users.getString("Username");
                String password = users.getString("Password");
                String firstname = users.getString("Firstname");
                String lastname = users.getString("Lastname");
                GUI.usersArrayList.add(new User(gebruikercode, username, password, firstname, lastname));
                System.out.println(gebruikercode + " " + username + " " + firstname + " " + lastname);
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
            int aantalMensen = verdieping.getInt("Aantal mensen");
            String locatieCode = verdieping.getString("Locatiecode");
            int maxMensen = verdieping.getInt("maxmensen");
            int verdiepingNummer = verdieping.getInt("Verdieping nummer gebouw");
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
            int i = 0;
            while (verdieping.next()) {
                int aantalMensen = verdieping.getInt("Aantal mensen");
                String locatieCode = verdieping.getString("Locatiecode");
                int maxMensen = verdieping.getInt("maxmensen");
                int verdiepingNummer = verdieping.getInt("Verdieping nummer gebouw");
                int aantalKamers = verdieping.getInt("aantalkamers");
                GUI.floorsArray[i] = new Floor(aantalKamers, locatieCode, verdiepingNummer);
                i++;
                System.out.println(verdiepingNummer + " " + aantalMensen + " " + locatieCode + " " + maxMensen);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    public void getAllRooms() throws Exception {
        try (Connection conn = this.connectDatabase()){
            // Statements allow to issue SQL queries to the database
            query = conn.createStatement();
            // Result set get the result of the SQL query
            kamer = query
                    .executeQuery("select * from `entry++`.`kamer`");
            int i = 0;
            while (kamer.next()) {
                String kamerCode = kamer.getString("kamercode");
                int aantalMensen = kamer.getInt("Aantal Mensen");
                int maxMensen = kamer.getInt("Maximaal aantal mensen");
                int kamerNummer = kamer.getInt("Kamernummer");
                String locatieCode = kamer.getString("Locatiecode");
                int verdieping = kamer.getInt("verdieping");
                GUI.roomsArray[i] = new Room(aantalMensen, maxMensen, kamerNummer, locatieCode, verdieping);
                i++;
                System.out.println(kamerNummer + " " + aantalMensen + " " + kamerCode + " " + maxMensen + " " + locatieCode + " " + verdieping);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    public void getRoom(String kamercode) throws Exception {
        try (Connection conn = this.connectDatabase()){
            // Statements allow to issue SQL queries to the database
            // Result set get the result of the SQL query
            preparedStatement = conn.prepareStatement("select * from `entry++`.`kamer` where `Kamercode` = (?)");
            preparedStatement.setString(1, kamercode);
            kamer = preparedStatement.executeQuery();
            kamer.next();
            String kamerCode = kamer.getString("kamercode");
            String aantalMensen = kamer.getString("Aantal Mensen");
            String maxMensen = kamer.getString("Maximaal aantal mensen");
            String kamerNummer = kamer.getString("Kamernummer");
            String locatieCode = kamer.getString("Locatiecode");
            String verdieping = kamer.getString("verdieping");
            System.out.println(kamerNummer + " " + aantalMensen + " " + kamerCode + " " + maxMensen + " " + locatieCode + " " + verdieping);
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    public void addEntry(String kamercode) throws Exception {
        try (Connection conn = this.connectDatabase()){
            // Statements allow to issue SQL queries to the database
            // Result set get the result of the SQL query
            preparedStatement = conn.prepareStatement("UPDATE `entry++`.`kamer` SET `Aantal mensen` = `Aantal mensen` + 1 WHERE Kamercode = (?)");
            preparedStatement.setString(1, kamercode);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    public void addUser(String Gebruikerscode, String Username, String Password, String Authorisatie, String Firstname, String Lastname) throws Exception {
        try (Connection conn = this.connectDatabase()){
            // Statements allow to issue SQL queries to the database
            // Result set get the result of the SQL query
            preparedStatement = conn.prepareStatement("INSERT INTO `entry++`.`Gebruiker` (`Gebruikerscode`, `Username`, `Password`, `Authorisatie`, `Firstname`, `Lastname`) VALUES ((?), (?), (?), (?), (?), (?));");
            preparedStatement.setString(1, Gebruikerscode);
            preparedStatement.setString(2, Username);
            preparedStatement.setString(3, Password);
            preparedStatement.setString(4, Authorisatie);
            preparedStatement.setString(5, Firstname);
            preparedStatement.setString(6, Lastname);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    public void removeEntry(String kamercode) throws Exception {
        try (Connection conn = this.connectDatabase()){
            // Statements allow to issue SQL queries to the database
            // Result set get the result of the SQL query
            preparedStatement = conn.prepareStatement("UPDATE `entry++`.`kamer` SET `Aantal mensen` = `Aantal mensen` - 1 WHERE Kamercode = (?)");
            preparedStatement.setString(1, kamercode);
            preparedStatement.executeUpdate();
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