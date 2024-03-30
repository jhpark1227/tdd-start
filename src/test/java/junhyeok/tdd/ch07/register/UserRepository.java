package junhyeok.tdd.ch07.register;

public interface UserRepository {
    void save(User user);

    User findById(String id);
}
