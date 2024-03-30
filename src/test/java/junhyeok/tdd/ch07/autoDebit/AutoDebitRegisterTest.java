package junhyeok.tdd.ch07.autoDebit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static junhyeok.tdd.ch07.autoDebit.CardValidity.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoDebitRegisterTest {
    private AutoDebitRegister register;
    private StubCardNumberValidator stubValidator;
    private MemoryAutoDebitInfoRepository repository;

    @BeforeEach
    void setUp(){
        stubValidator = new StubCardNumberValidator();
        repository = new MemoryAutoDebitInfoRepository();
        register = new AutoDebitRegister(stubValidator, repository);
    }

    @Test
    void alreadyRegistered_InfoUpdated(){
        //이미 존재하는 유저를 등록해서 카드번호를 변경하는 테스트
        repository.save(new AutoDebitInfo("user1","111222333444", LocalDateTime.now()));

        AutoDebitReq req = new AutoDebitReq("user1","123456789012");
        RegisterResult result = this.register.register(req);

        AutoDebitInfo saved = repository.findOne("user1");
        assertEquals("123456789012",saved.getCardNumber());
    }

    @Test
    void notYetRegistered_newInfoRegistered(){
        AutoDebitReq req = new AutoDebitReq("user1","1234123412341234");
        RegisterResult result = this.register.register(req);

        AutoDebitInfo saved = repository.findOne("user1");
        assertEquals("1234123412341234",saved.getCardNumber());
    }

    @Test
    void invalidCard(){
        stubValidator.setInvalidNo("111122223333");

        AutoDebitReq req = new AutoDebitReq("user1", "111122223333");
        RegisterResult result = register.register(req);

        assertEquals(INVALID, result.getValidity());
    }

    @Test
    void theftCard(){
        stubValidator.setTheftNo("1234567890123456");

        AutoDebitReq req = new AutoDebitReq("user1","1234567890123456");
        RegisterResult result = this.register.register(req);
        assertEquals(THEFT, result.getValidity());
    }

    @Test
    void validCard(){
        AutoDebitReq req = new AutoDebitReq("user1", "1234123412341234");
        RegisterResult result = this.register.register(req);
        assertEquals(VALID, result.getValidity());
    }
}
