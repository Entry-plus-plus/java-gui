public class User {

    String username;
    String firstName;
    String lastName;
    String password = passwordHasher.hashPassword("password");

    public User(String username, String firstName, String lastName) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //method waarmee je het wachtwoord van de user kan veranderen
    public void changePassword(String oldPassword, String newPassword, String confirmPassword) {

        //hasht de wachtwoorden, want veiligheid
        String hashedOld = passwordHasher.hashPassword(oldPassword);
        String hashedNew = passwordHasher.hashPassword(newPassword);
        String hashedConfirm = passwordHasher.hashPassword(confirmPassword);

        //als OldPassword overeenkomt met het bestaande wachtwoord en het nieuwe en de confirmation komen overeen
        //dan wordt het wachtwoord veranderd en wordt er een boodschap getoond dat het gelukt is
        if (hashedOld.equals(password) && hashedNew.equals(hashedConfirm)) {
                password = hashedNew;
                Settings.passwordChangedLabel.setText("Password changed.");
            }
    }
}
