import java.util.UUID;
public class Account {
    private String _userName;
    // TODO: Passwords should hashed
    private String _passWord;
    private UUID _accountId;
    Account(String u, String p) {
        _accountId = UUID.randomUUID();
        _userName = u;
        _passWord = p;
        Hogwarts.accounts.add(this);
    }
    public boolean validatePassword(String enteredPassword) {
        if (_passWord.equals(enteredPassword)) return true;
        return false;
    }
    public boolean validateUserName(String enteredUserName) {
        if (_userName.equals(enteredUserName)) return true;
        return false;
    }
    public void changeUsername(String newUsername) {
        _userName = newUsername;
    }
    public void changePassword(String newPassword) {
        _passWord = newPassword;
    }
    public void show() {
        System.out.println(_userName + " " + _accountId.toString());
    }
}
