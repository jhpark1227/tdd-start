package junhyeok.tdd.ch08.point;

import java.time.LocalDate;

import static junhyeok.tdd.ch08.point.Grade.GOLD;

public class PointRule {
    public int calculate(Subscription s, Product p, LocalDate now){
        int point = 0;
        if(s.isFinished(now)){
            point += p.getDefaultPoint();
        }else{
            point += p.getDefaultPoint() + 10;
        }
        if(s.getGrade()==GOLD){
            point += 100;
        }
        return point;
    }
}
