package junhyeok.tdd.ch07.autoDebit;

public class RegisterResult {
    CardValidity validity;

    public RegisterResult(CardValidity validity){
        this.validity = validity;
    }

    public CardValidity getValidity() {
        return validity;
    }

    public static RegisterResult success(){
        return new RegisterResult(CardValidity.VALID);
    }

    public static RegisterResult error(CardValidity cardValidity){
        return new RegisterResult(cardValidity);
    }
}
