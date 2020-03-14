package com.company;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

public class FruitTest {

    @Test(dataProvider = "SortingTest", dataProviderClass = DataProviderClass.class)
    public void SortingTest(ArrayList<Fruit> actual) {
        //Arrange
        ArrayList<Fruit> expected = new ArrayList<Fruit>();
        expected.add(new Fruit("Apple", "red"));
        expected.add(new Fruit("Banana", "yellow"));
        expected.add(new Citrus("Lemon", "yellow", 25.3));
        expected.add(new Citrus("Tangerine", "orange", 12.3));

        //Act
        Collections.sort(actual);

        //Assert
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "DeserializationTest", dataProviderClass = DataProviderClass.class)
    public void DeserializationTest(ArrayList<Fruit> list) {
        //Arrange
        ArrayList<Fruit> expected = new ArrayList<>();
        expected.add(new Fruit("Banana", "yellow"));
        expected.add(new Citrus("Lemon", "yellow", 25.3));

        //Act
        ArrayList<Fruit> actual = FruitList.DeserializeListFromXML(list);

        //Assert
        Assert.assertEquals(actual, expected);
    }

    @Test
    @Parameters("expected")
    public void OutputTest(String expected){
        //Arrange
        Citrus citrus = new Citrus("Lemon", "yellow", 10.1);

        //Act
        String actual = citrus.toString();

        //Assert
        Assert.assertEquals(actual , expected);
    }
}
