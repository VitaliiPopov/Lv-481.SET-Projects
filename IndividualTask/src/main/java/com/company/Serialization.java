package com.company;

import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

class Serialization {

    public static void SerializeToXML(ArrayList<Fruit> fruit) throws IOException
    {
        FileOutputStream fos = new FileOutputStream("settings.xml");
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.setExceptionListener(new ExceptionListener() {
            public void exceptionThrown(Exception e) {
                System.out.println("Exception! :"+e.toString());
            }
        });
        encoder.writeObject(fruit);
        encoder.close();
        fos.close();
    }

    public static ArrayList<Fruit> DeserializeFromXML() throws IOException {

        FileInputStream fis = new FileInputStream("settings.xml");
        XMLDecoder decoder = new XMLDecoder(fis);
        ArrayList<Fruit> setting = (ArrayList<Fruit>) decoder.readObject();
        decoder.close();
        fis.close();
        return setting;
    }
}
