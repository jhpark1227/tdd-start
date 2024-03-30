package junhyeok.tdd.ch07.register;

public class UserRegister {
    private WeakPasswordChecker passwordChecker;
    private MemoryUserRepository userRepository;
    private EmailNotifier emailNotifier;

    public UserRegister(WeakPasswordChecker passwordChecker, MemoryUserRepository userRepository, EmailNotifier emailNotifier){
        this.passwordChecker = passwordChecker;
        this.userRepository = userRepository;
        this.emailNotifier = emailNotifier;
    }
    public void register(String id, String password, String email){
        if(passwordChecker.checkPasswordWeak(password)){
            throw new WeakPasswordException();
        }
        User user = userRepository.findById(id);
        if(user != null){
            throw new DupIdException();
        }
        userRepository.save(new User(id, password, email));

        emailNotifier.sendRegisterEmail(email);
    }
}
