package com.aor.refactoring.example3;

public class FixedDiscount implements Discount{
    private final int fixed;

    public FixedDiscount(int fixed) {
        this.fixed = fixed;
    }

    public double applyDiscount(double price) {
       return fixed > price ? 0 : price - fixed;
    }
}
