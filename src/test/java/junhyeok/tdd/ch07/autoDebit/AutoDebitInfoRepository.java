package junhyeok.tdd.ch07.autoDebit;

public interface AutoDebitInfoRepository {
    void save(AutoDebitInfo info);
    AutoDebitInfo findOne(String userId);
}
