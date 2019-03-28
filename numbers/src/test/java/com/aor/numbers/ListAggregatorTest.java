package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.mockito.Mockito;

public class ListAggregatorTest {

    private ListDeduplicator ldd;

    private List<Integer> helper() {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);

        return list;
    }

    @Test
    public void sum() {
        List<Integer> list = helper();
        ListAggregator aggregator = new ListAggregator(list);
        int sum = aggregator.sum();
        assertEquals(14, sum);
    }

    @Test
    public void max() {
        List<Integer> list = helper();
        ListAggregator aggregator = new ListAggregator(list);
        int max = aggregator.max();
        assertEquals(5, max);
    }

    @Test
    public void maxFail() {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(-4);
        list.add(-5);

        ListAggregator aggregator = new ListAggregator(list);
        int max = aggregator.max();
        assertEquals(-1, max);
    }

    @Test
    public void min() {
        List<Integer> list = helper();
        ListAggregator aggregator = new ListAggregator(list);
        int min = aggregator.min();
        assertEquals(1, min);
    }

    @Test
    public void distinct() {
        List<Integer> list = helper();
        ListAggregator aggregator = new ListAggregator(list);
        int distinct = aggregator.distinct(new ListDeduplicator(list));
        assertEquals(4, distinct);
    }

    @Before
    public void setUp() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        ldd = Mockito.mock(ListDeduplicator.class);   // really a stub
        when(ldd.deduplicate()).thenReturn(list); // with canned answers
    }

    @Test
    public void distinctFail() {

        /*class StubDeduplicator implements IListDeduplicator {
            @Override
            public List<Integer> deduplicate() {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(2);
                list.add(4);

                return list;
            }
        }*/

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct(ldd);

        //int distinct = aggregator.distinct(new StubDeduplicator());

        //int distinct = aggregator.distinct();
        assertEquals(3, distinct);
    }
}