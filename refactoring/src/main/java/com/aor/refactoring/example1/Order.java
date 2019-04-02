package com.aor.refactoring.example1;

import java.util.ArrayList;
import java.util.List;

/* CODE SMELLS:
    -> Duplicated code;
    -> Data class;
    -> Feature envy;
*/

public class Order {
    private List<OrderLine> lines;

    public Order() {
        lines = new ArrayList<>();
    }

    public void add(Product product, int quantity) {
        lines.add(new OrderLine(product, quantity));
    }

    public double getTotal() {
        double total = 0;

        for (OrderLine line : lines)
            total += line.getProduct().getPrice() * line.getQuantity();

        return total;
    }

    public boolean isElegibleForFreeDelivery() {
        if (getTotal() > 100) return true;
        else return false;
    }

    public String printOrder() {
        StringBuffer printBuffer = new StringBuffer();

        for (OrderLine line : lines)
            printBuffer.append(line.toString());

        printBuffer.append("Total: " + getTotal());

        return printBuffer.toString();
    }
}