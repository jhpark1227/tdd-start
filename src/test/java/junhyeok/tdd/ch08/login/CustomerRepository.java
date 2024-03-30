package junhyeok.tdd.ch08.login;

public interface CustomerRepository {
    Customer findOne(String id);
}
