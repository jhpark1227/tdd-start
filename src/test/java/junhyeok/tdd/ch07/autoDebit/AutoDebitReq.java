package junhyeok.tdd.ch07.autoDebit;

public class AutoDebitReq {
    private String userId;
    private String cardNumber;

    public AutoDebitReq(String id, String number){
        this.userId = id;
        this.cardNumber = number;
    }

    public String getUserId() {
        return userId;
    }

    public String getCardNumber(){
        return cardNumber;
    }
}
