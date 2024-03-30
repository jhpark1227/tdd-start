package junhyeok.tdd.ch08.paySync;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class PaySync {
    private String filePath = "D://data//pay//cp0001.csv";

    private PayInfoDao payInfoDao;

    public PaySync(PayInfoDao payInfoDao){
        this.payInfoDao = payInfoDao;
    }

    public void setPayInfoDao(PayInfoDao payInfoDao){
        this.payInfoDao = payInfoDao;
    }

    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

    public void sync() throws IOException {
        Path path = Paths.get(filePath);
        List<PayInfo> payInfos = Files.lines(path)
                .map(line->{
                    String[] data = line.split(",");
                    PayInfo payInfo = new PayInfo(
                            data[0], data[1], Integer.parseInt(data[2])
                    );
                    return payInfo;
                }).collect(Collectors.toList());
        payInfos.forEach(pi->payInfoDao.insert(pi));
    }

    public void sync(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        List<PayInfo> payInfos = Files.lines(path)
                .map(line->{
                    String[] data = line.split(",");
                    PayInfo payInfo = new PayInfo(
                            data[0], data[1], Integer.parseInt(data[2])
                    );
                    return payInfo;
                }).collect(Collectors.toList());
        payInfos.forEach(pi->payInfoDao.insert(pi));
    }
}
