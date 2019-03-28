package com.aor.numbers;

public class DivisibleByFilter implements IListFilter {
    Integer divisor;

    public DivisibleByFilter(Integer number) {
        this.divisor = number;
    }

    public boolean accept(Integer number) {
        return (number % this.divisor) == 0;
    }
}
