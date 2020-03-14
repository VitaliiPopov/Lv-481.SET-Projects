package com.company;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;

public class DataProviderClass {

    @DataProvider(name = "SortingTest")
    public static Object[][] getUnsortedList() {
        ArrayList<Fruit> list = new ArrayList<Fruit>();
        list.add(new Fruit("Banana", "yellow"));
        list.add(new Fruit("Apple", "red"));
        list.add(new Citrus("Lemon", "yellow", 25.3));
        list.add(new Citrus("Tangerine", "orange", 12.3));

        return new Object[][]{{list}};
    }

    @DataProvider(name = "DeserializationTest")
    public static Object[][] getSerializedList() {
        ArrayList<Fruit> list = new ArrayList<Fruit>();
        list.add(new Fruit("Banana", "yellow"));
        list.add(new Citrus("Lemon", "yellow", 25.3));

        FruitList.SerializeListToXML(list);

        return new Object[][]{{list}};
    }

    @DataProvider(name = "OutputYellowFruitTest")
    public static Object[][] getYellowFruits() {
        ArrayList<Fruit> list = new ArrayList<Fruit>();
        list.add(new Fruit("Apple", "red"));
        list.add(new Fruit("Banana", "yellow"));
        list.add(new Citrus("Lemon", "yellow", 25.3));
        list.add(new Citrus("Tangerine", "orange", 10.3));

        return new Object[][]{{list}};
    }
}
