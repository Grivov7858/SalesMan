package validators;

import entities.Report;
import entities.Seller;

public interface Validator {
    boolean isValid(Seller seller, Report report, double score);
}
