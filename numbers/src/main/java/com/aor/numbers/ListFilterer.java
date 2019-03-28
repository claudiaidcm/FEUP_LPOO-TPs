package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer {
    List<Integer> numbers;

    public ListFilterer(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> filter(IListFilter filter) {
        List<Integer> filtered = new ArrayList<>();

        for (Integer number : numbers)
            if (filter.accept(number))
                filtered.add(number);

        return filtered;
    }
}
