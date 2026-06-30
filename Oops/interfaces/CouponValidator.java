package oops.interfaces;

public interface CouponValidator {
    boolean validateCoupon(String code);

    static boolean isLengthValid(String code) {
        return code != null && code.length() >= 6 && code.length() <= 12;
    }
}
