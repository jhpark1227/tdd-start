package junhyeok.tdd.ch08.login;

public class LoginResult {
    public static LoginResult badAuthKey() {
        return null;
    }

    public static LoginResult authenticated(Customer c) {
        return new LoginResult();
    }

    public static LoginResult fail(int resp) {
        return null;
    }
}
