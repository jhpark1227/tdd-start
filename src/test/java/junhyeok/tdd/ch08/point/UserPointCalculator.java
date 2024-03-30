package junhyeok.tdd.ch08.point;

import java.time.LocalDate;

public class UserPointCalculator {
    private PointRule pointRule = new PointRule();
    private SubscriptionDao subscriptionDao;
    private ProductDao productDao;

    private Times times = new Times();

    public void setTimes(Times times){
        this.times = times;
    }

    public void setPointRule(PointRule pointRule) {
        this.pointRule = pointRule;
    }

    public UserPointCalculator(SubscriptionDao subScrptionDao, ProductDao productDao){
        this.subscriptionDao = subScrptionDao;
        this.productDao = productDao;
    }

    public int calculatePoint(User u){
        Subscription s = subscriptionDao.selectByUser(u.getId());
        if(s==null) throw new NoSubscriptionException();
        Product p = productDao.selectById(s.getProductId());
        LocalDate now = times.today();
        return new PointRule().calculate(s,p,now);
    }
}
