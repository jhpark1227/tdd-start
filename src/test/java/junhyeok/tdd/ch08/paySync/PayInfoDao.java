package junhyeok.tdd.ch08.paySync;

import java.util.List;

public interface PayInfoDao {
    void insert(PayInfo pi);

    List<PayInfo> getAll();
}
