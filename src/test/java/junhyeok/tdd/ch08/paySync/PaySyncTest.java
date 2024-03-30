package junhyeok.tdd.ch08.paySync;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaySyncTest {
    private MemoryPayInfoDao memoryPayInfoDao = new MemoryPayInfoDao();

    @Test
    void someTest1() throws IOException {
        PaySync paySync = new PaySync(memoryPayInfoDao);
        paySync.setFilePath("src/test/resources/c0111.csv");

        paySync.sync();

        List<PayInfo> savedInfos = memoryPayInfoDao.getAll();
        assertEquals(2,savedInfos.size());
    }

    @Test
    void someTest2() throws IOException {
        PaySync paySync = new PaySync(memoryPayInfoDao);

        paySync.sync("src/test/resources/c0111.csv");
        //...
    }
}
