package junhyeok.tdd.ch07.register;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegisterTest {
    private UserRegister userRegister;
    private StubWeakPasswordChecker stubWeakPasswordChecker = new StubWeakPasswordChecker();
    private MemoryUserRepository fakeRepository = new MemoryUserRepository();

    private SpyEmailNotifier spyEmailNotifier = new SpyEmailNotifier();

    @BeforeEach
    void setUp(){
        userRegister = new UserRegister(stubWeakPasswordChecker, fakeRepository, spyEmailNotifier);
    }

    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword(){
        stubWeakPasswordChecker.setWeak(true);

        assertThrows(WeakPasswordException.class, ()->{
            userRegister.register("id","pw","email");
        });
    }

    @DisplayName("이미 같은 ID가 존재하면 가입 실패")
    @Test
    void dupIdExists(){
        fakeRepository.save(new User("id","pw1","email@email.com"));
        assertThrows(DupIdException.class,()->{
            userRegister.register("id","pw1","email@email.com");
        });
    }

    @DisplayName("같은 ID가 없으면 가입 성공함")
    @Test
    void noDupId_RegisterSuccess(){
        userRegister.register("id","pw","email");

        User savedUser = fakeRepository.findById("id");

        assertEquals("id",savedUser.getId());
        assertEquals("email",savedUser.getEmail());
    }

    @DisplayName("가입하면 메일을 전송함")
    @Test
    void whenRegisterThenSendMail(){
        userRegister.register("id","pw","email@email.com");

        assertTrue(spyEmailNotifier.isCalled());
        assertEquals("email@email.com", spyEmailNotifier.getEmail());
    }
}
