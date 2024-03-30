package junhyeok.tdd.ch07.autoDebit;

import java.time.LocalDateTime;

public class AutoDebitInfo {
    private String userId;
    private String cardNumber;

    private LocalDateTime time;


    public AutoDebitInfo(String userId, String cardNumber, LocalDateTime time){
        this.userId = userId;
        this.cardNumber = cardNumber;
        this.time = time;
    }

    public String getUserId() {
        return userId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void changeCardNumber(String cardNumber){
        this.cardNumber = cardNumber;
    }
}
