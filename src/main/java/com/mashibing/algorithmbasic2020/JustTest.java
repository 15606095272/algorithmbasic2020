package com.mashibing.algorithmbasic2020;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class JustTest {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalDate yesterday = localDate.plusDays(-1);
        LocalDate yesterday2 = localDate.plusDays(-1);
        LocalDate tomorrow = localDate.plusDays(1);
        System.out.println(yesterday);
        System.out.println(localDate);
        System.out.println(tomorrow);
        System.out.println(yesterday.isEqual(yesterday2));
        Map<LocalDate, Integer> map = new HashMap<>();
        map.put(yesterday, 1);
        map.put(localDate, 2);
        map.put(tomorrow, 3);
        System.out.println(map);
        System.out.println(map.get(yesterday2));
    }
}
