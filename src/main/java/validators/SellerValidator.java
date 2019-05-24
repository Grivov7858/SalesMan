package validators;

import entities.Report;
import entities.Seller;

public class SellerValidator implements Validator {

    @Override
    public boolean isValid(Seller seller, Report report, double sellerScore) {
        return seller.getSalesPeriod() <= report.getPeriodLimit() &&
                sellerScore >= report.getTopPerformersThreshold();
    }
}
