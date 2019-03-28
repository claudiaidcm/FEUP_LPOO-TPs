package com.aor.numbers;

public class PositiveFilter implements IListFilter {
    public boolean accept(Integer number) {
        return number >= 0;
    }

}
