package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import static com.company.Serialization.*;
import static com.company.WriteToFile.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Fruit f = new Fruit();
        f.Input();
        Citrus c = new Citrus();
        c.Input();
        ArrayList<Fruit> fruit= new ArrayList<Fruit>();
        fruit.add(f);
        fruit.add(c);
        fruit.add(new Fruit("Banana", "yellow"));
        fruit.add(new Fruit("Melon", "yellow"));
        fruit.add(new Fruit("Apple", "red"));
        fruit.add(new Citrus("Lemon", "yellow", 25.3));
        fruit.add(new Citrus("Tangerine", "orange", 12.3));

        System.out.println("***********Information about fruit************");
        ConsoleOutput(fruit);

        System.out.println("***********Information about yellow fruit************"); // TODO Make method to output yellow
        for (Fruit temp : fruit) {
            if(temp.getColor().equals("yellow")){
                temp.Output();
            }
        }
        //Sorting
        Collections.sort(fruit);
        System.out.println("***********After sorting**********");
        ConsoleOutput(fruit);

        //Writing to fIle
        WriteToFile(fruit);

        //Serialization
        SerializeToXML(fruit);

        //Deserialization
        fruit = DeserializeFromXML();
        System.out.println("***********After deserialization**********");
        ConsoleOutput(fruit);
    }

    private static void ConsoleOutput(ArrayList<Fruit> fruit) {
        for (Fruit temp : fruit) {
            temp.Output();
        }
    }
}
