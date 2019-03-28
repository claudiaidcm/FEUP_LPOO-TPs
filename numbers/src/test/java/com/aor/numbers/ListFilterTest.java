package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.mockito.Mockito;

public class ListFilterTest {

   List<Integer> list;

   @Before
   public void setUp() {
      list = new ArrayList<>();
      list.add(-1);
      list.add(20);
      list.add(-3);
      list.add(45);
   }


   @Test
   public void ListFilter() {

      IListFilter mock_filter = Mockito.mock(IListFilter.class);

      Mockito.when(mock_filter.accept(-1)).thenReturn(false);
      Mockito.when(mock_filter.accept(20)).thenReturn(true);
      Mockito.when(mock_filter.accept(-3)).thenReturn(false);
      Mockito.when(mock_filter.accept(45)).thenReturn(true);

      List<Integer> expected = new ArrayList<>();
      expected.add(20);
      expected.add(45);


      ListFilterer testing_listFilterer = new ListFilterer(this.list);

      List<Integer> return_list = testing_listFilterer.filter(mock_filter);

      assertEquals(expected, return_list);

      }
}
