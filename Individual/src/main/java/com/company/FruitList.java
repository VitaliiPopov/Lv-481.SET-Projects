package com.company;

import com.company.Citrus;
import com.company.Fruit;

import static com.company.Tools.WriteToFile.*;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FruitList {

    public FruitList(){}

    public void InitializeList(ArrayList<Fruit> fruitList) {
        fruitList.add(new Fruit("Banana", "yellow"));
        fruitList.add(new Fruit("Melon", "yellow"));
        fruitList.add(new Citrus("Lemon", "yellow", 25.3));
    }

    public void AddNewFruitToList(ArrayList<Fruit> fruitList) {
        Fruit fruit = new Fruit();
        fruit.Input();
        fruitList.add(fruit);
    }

    public void AddNewCitrusToList(ArrayList<Fruit> fruitList) {
        Citrus citrus = new Citrus();
        citrus.Input();
        fruitList.add(citrus);
    }

    public void ConsoleOutput(ArrayList<Fruit> fruitList) {
        for (Fruit temp : fruitList) {
            temp.Output();
        }
    }

    public void OutputYellowFruits(ArrayList<Fruit> fruitList) {
        for (Fruit temp : fruitList) {
            if (temp.getColor().equals("yellow")) {
                temp.Output();
            }
        }
    }

    public void SortFruitList(ArrayList<Fruit> fruitList) {
        Collections.sort(fruitList);
    }

    public void WriteListToFile(ArrayList<Fruit> fruitList) {
        WriteToFile(fruitList);
    }

    public static void SerializeListToXML(ArrayList<Fruit> fruitList) {
        try (XMLEncoder encoder = new XMLEncoder(new FileOutputStream("settings.xml"))) {
            encoder.writeObject(fruitList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Fruit> DeserializeListFromXML(ArrayList<Fruit> fruitList) {
        fruitList.clear();
        try (XMLDecoder decoder = new XMLDecoder(new FileInputStream("settings.xml"))) {
            fruitList.addAll((ArrayList<Fruit>) decoder.readObject());
            System.out.println("Successfully");
        } catch (FileNotFoundException e) {
            System.out.println("The file isn't exist");
        }
        return fruitList;
    }
}
