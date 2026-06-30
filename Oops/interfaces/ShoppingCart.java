package oops.interfaces;

public class ShoppingCart implements CouponValidator {
    private static final String[] coupons = {
        "SAVE10",
        "DISCOUNT50",
        "WELCOME",
        "INVALID",
        "ABC",
        "SUMMER2026"
    };

    @Override
    public boolean validateCoupon(String code) {
        if (!CouponValidator.isLengthValid(code)) {
            return false;
        }
        return code.matches("^[A-Z0-9]+$");
    }

    public void checkCoupons() {
        for (String coupon : coupons) {
            boolean valid = validateCoupon(coupon);
            System.out.println(coupon + " is " + (valid ? "valid" : "invalid"));
        }
    }

    public static void main(String[] args) {
        new ShoppingCart().checkCoupons();
    }
}
