import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;

public class DBConnections {
    private Connection connect = null;
    private Statement query = null;
    private ResultSet beheerders = null;
    private ResultSet users = null;
    private ResultSet verdieping = null;
    private ResultSet kamer = null;
    private PreparedStatement preparedStatement = null;
    private String username;
    private ResultSet kamersInVerdieping = null;
    private ResultSet encryptedPasswordSet = null;
    public static SecretKey key;

    static {
        try {
            key = Encryption.getKeyFromPassword("reallygoodpasswordlikereallythereisnobetterpassworedinexistence", "definitleyagloballyuniquesaltnowaysomeonehasusedthisasasalt before");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

    static byte[] iv = { 0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0, 7, 0, 8 };
    public static IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);


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
                String decryptedPassword = Encryption.decrypt("AES/CBC/PKCS5Padding", password, key, ivParameterSpec);
                GUI.adminsArrayList.add(new User(beheercode, username, decryptedPassword, firstname, lastname, true));
                //System.out.println(beheercode + " " + username + " " + firstname + " " + lastname);
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
            users = query.executeQuery("select * from `entry++`.`gebruiker`");
            while (users.next()) {
                String gebruikercode = users.getString("Gebruikerscode");
                String username = users.getString("Username");
                String password = users.getString("Password");
                String firstname = users.getString("Firstname");
                String lastname = users.getString("Lastname");
                String decryptedPassword = Encryption.decrypt("AES/CBC/PKCS5Padding", password, key, ivParameterSpec);
                GUI.usersArrayList.add(new User(gebruikercode, username, decryptedPassword, firstname, lastname, false));
                //System.out.println(gebruikercode + " " + username + " " + firstname + " " + lastname);
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
            //System.out.println(verdiepingNummer + " " + aantalMensen + " " + locatieCode + " " + maxMensen);
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
                //System.out.println(verdiepingNummer + " " + aantalMensen + " " + locatieCode + " " + maxMensen);
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
                GUI.roomsArray[i] = new Room(aantalMensen, maxMensen, kamerNummer, kamerCode, verdieping);
                i++;
                //System.out.println(kamerNummer + " " + aantalMensen + " " + kamerCode + " " + maxMensen + " " + kamerCode + " " + verdieping);
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
            //System.out.println(kamerNummer + " " + aantalMensen + " " + kamerCode + " " + maxMensen + " " + locatieCode + " " + verdieping);
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
        String encryptedPass = Encryption.encrypt("AES/CBC/PKCS5Padding", Password, key, ivParameterSpec);
        try (Connection conn = this.connectDatabase()){
            // Statements allow to issue SQL queries to the database
            // Result set get the result of the SQL query
            preparedStatement = conn.prepareStatement("INSERT INTO `entry++`.`Gebruiker` (`Gebruikerscode`, `Username`, `Password`, `Authorisatie`, `Firstname`, `Lastname`) VALUES ((?), (?), (?), (?), (?), (?));");
            preparedStatement.setString(1, Gebruikerscode);
            preparedStatement.setString(2, Username);
            preparedStatement.setString(3, encryptedPass);
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

    public void kamersInVerdieping(int verdieping) throws Exception {
        try (Connection conn = this.connectDatabase()){
            // Statements allow to issue SQL queries to the database
            // Result set get the result of the SQL query
            preparedStatement = conn.prepareStatement("SELECT * FROM `entry++`.`kamer` WHERE `verdieping` = (?);");
            preparedStatement.setInt(1, verdieping);
            kamersInVerdieping = preparedStatement.executeQuery();
            while (kamersInVerdieping.next()) {
                String kamerCode = kamersInVerdieping.getString("kamercode");
                int aantalMensen = kamersInVerdieping.getInt("Aantal Mensen");
                int maxMensen = kamersInVerdieping.getInt("Maximaal aantal mensen");
                int kamerNummer = kamersInVerdieping.getInt("Kamernummer");
                String locatieCode = kamersInVerdieping.getString("Locatiecode");
                verdieping = kamersInVerdieping.getInt("verdieping");
                //System.out.println(kamerNummer + " " + aantalMensen + " " + kamerCode + " " + maxMensen + " " + locatieCode + " " + verdieping);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    public void changePasswordAdmin(String Username, String newPassword) throws Exception {
        try (Connection conn = this.connectDatabase()){
            // Statements allow to issue SQL queries to the database
            // Result set get the result of the SQL query
            String encryptedPassword = Encryption.encrypt("AES/CBC/PKCS5Padding", newPassword, key, ivParameterSpec);
            preparedStatement = conn.prepareStatement("UPDATE `entry++`.`beheerder` SET `Password` = (?) WHERE Username = (?);");
            preparedStatement.setString(1, encryptedPassword);
            preparedStatement.setString(2, Username);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    public void changePasswordUser(String Username, String newPassword) throws Exception {
        try (Connection conn = this.connectDatabase()){
            // Statements allow to issue SQL queries to the database
            // Result set get the result of the SQL query
            String encryptedPassword = Encryption.encrypt("AES/CBC/PKCS5Padding", newPassword, key, ivParameterSpec);
            preparedStatement = conn.prepareStatement("UPDATE `entry++`.`gebruiker` SET `Password` = (?) WHERE Username = (?);");
            preparedStatement.setString(1, encryptedPassword);
            preparedStatement.setString(2, Username);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    public void removeUser(String username) throws Exception {
        try (Connection conn = this.connectDatabase()){
            // Statements allow to issue SQL queries to the database
            // Result set get the result of the SQL query
            preparedStatement = conn.prepareStatement("DELETE FROM `entry++`.`gebruiker` WHERE Username = (?)");
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    public void addAdmin(String Beheercode, String Username, String Password, String Authorisatie, String Firstname, String Lastname) throws Exception {
        try (Connection conn = this.connectDatabase()){
            // Statements allow to issue SQL queries to the database
            // Result set get the result of the SQL query
            String encryptedPassword = Encryption.encrypt("AES/CBC/PKCS5Padding", Password, key, ivParameterSpec);
            preparedStatement = conn.prepareStatement("INSERT INTO `entry++`.`beheerder` (`Beheerder Beheercode`, `Username`, `Password`, `Authorisatie`, `Firstname`, `Lastname`) VALUES ((?), (?), (?), (?), (?), (?));");
            preparedStatement.setString(1, Beheercode);
            preparedStatement.setString(2, Username);
            preparedStatement.setString(3, encryptedPassword);
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

    public void addDebugAdmin(String Beheercode, String Username, String Password, String Authorisatie, String Firstname, String Lastname) throws Exception {
        try (Connection conn = this.connectDatabase()){
            // Statements allow to issue SQL queries to the database
            // Result set get the result of the SQL query
            System.out.println(ivParameterSpec);
            String encryptedPass = Encryption.encrypt("AES/CBC/PKCS5Padding", Password, key, ivParameterSpec);
            preparedStatement = conn.prepareStatement("INSERT INTO `entry++`.`beheerder` (`Beheerder Beheercode`, `Username`, `Password`, `Authorisatie`, `Firstname`, `Lastname`) VALUES ((?), (?), (?), (?), (?), (?));");
            preparedStatement.setString(1, Beheercode);
            preparedStatement.setString(2, Username);
            preparedStatement.setString(3, encryptedPass);
            preparedStatement.setString(4, Authorisatie);
            preparedStatement.setString(5, Firstname);
            preparedStatement.setString(6, Lastname);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }    public void addDebugUser(String Gebruikerscode, String Username, String Password, String Authorisatie, String Firstname, String Lastname) throws Exception {
        try (Connection conn = this.connectDatabase()){
            // Statements allow to issue SQL queries to the database
            // Result set get the result of the SQL query
            System.out.println(ivParameterSpec);
            String encryptedPass = Encryption.encrypt("AES/CBC/PKCS5Padding", Password, key, ivParameterSpec);
            preparedStatement = conn.prepareStatement("INSERT INTO `entry++`.`gebruiker` (`Gebruikerscode`, `Username`, `Password`, `Authorisatie`, `Firstname`, `Lastname`) VALUES ((?), (?), (?), (?), (?), (?));");
            preparedStatement.setString(1, Gebruikerscode);
            preparedStatement.setString(2, Username);
            preparedStatement.setString(3, encryptedPass);
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