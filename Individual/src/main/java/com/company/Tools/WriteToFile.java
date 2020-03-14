package com.company.Tools;

import com.company.Fruit;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class WriteToFile {
    private static File file = new File("output.txt");

    public static void WriteToFile(ArrayList<Fruit> fruits) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter myWrite = new FileWriter("output.txt");
            for (Fruit f : fruits) {
                myWrite.write(f.toString());
                myWrite.write("\n");
            }
            myWrite.close();
            System.out.println("\n*****Successfully wrote to the file.*******\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
