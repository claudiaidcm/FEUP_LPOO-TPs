package com.aor.refactoring.example3;

/* CODE SMELLS:
    -> SWITCH: (REFACTORING) replace type code with subclasses;

   REFACTORING:
    -> Introduce null object;
 */

public class SimpleOrder {
    private Discount discount;
    private double price;

    public SimpleOrder(double price) {
        this.price = price;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public double getTotal() {

     class NullDiscount implements Discount {
         @Override
         public double applyDiscount(double price) {
             return price;
         }
     }

        if (discount == null)
            discount = new NullDiscount();

        return discount.applyDiscount(price);
    }
}
