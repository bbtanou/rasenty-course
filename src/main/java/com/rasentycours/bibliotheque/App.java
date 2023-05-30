package com.rasentycours.bibliotheque;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        System.out.println();
        List<Integer> maList = new ArrayList<>();

        maList.add(19);
        maList.add(1);
        maList.add(9);
        maList.add(90);
        maList.add(8);
        maList.forEach(e -> System.out.print(e + ", "));

        System.out.println();

        int somme = maList.stream().reduce((a, b) -> a + b).get();

        System.out.println(somme);

        List<Integer> list = new LinkedList<>();
        list.add(34);
        list.add(69);
        Integer[] integers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        list.addAll(Arrays.asList(integers));

        for (Integer i : list) {
            System.out.print(i + ", ");
        }

        Set<Integer> nombres = new LinkedHashSet<>();

        nombres.add(1);
        nombres.add(3);
        nombres.add(2);
        nombres.add(1);
        nombres.add(1);

        nombres.forEach(System.out::print);
        System.out.println();

        Map<String, Integer> map = new HashMap<>();

        map.put("age", 59);

        Map<String, List<Integer>> intMap = new HashMap<>();

        intMap.put("nombre paire", List.of(2, 4, 6, 8, 10));
        intMap.put("nombre impaire", List.of(1, 3, 5, 7, 9));

        intMap.forEach((cle, valeur) -> {
            System.out.print(" Cle : " + cle);
            valeur.forEach(e -> System.out.print(" " + e + ", "));
            System.out.println();
        });

        for (List<Integer> valeur : intMap.values()) {

            valeur.forEach(System.out::print);
            ;
        }
    }
}