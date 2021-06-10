package com.example.springbootproject.基础.Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Collection<Integer> readOnlyList = Collections.unmodifiableCollection(list);
        readOnlyList.add(4); // 会报错

    }
}
