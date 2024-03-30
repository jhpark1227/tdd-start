package junhyeok.tdd.ch08.login;

public class AuthService {
    public int authenticate(String id, String pw){
        //boolean authorized = AuthUtil.authorize(authKey);
        boolean authorized = false;
        if(authorized){
            //return AuthUtil.authenticate(id,pw);
            return 1;
        }else{
            return -1;
        }
    }
}
