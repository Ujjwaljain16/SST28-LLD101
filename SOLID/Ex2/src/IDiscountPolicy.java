public interface IDiscountPolicy {
    double getDiscount(String customerType, double subtotal, int distinctLines);
}
