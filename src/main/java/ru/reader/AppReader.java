package ru.reader;

import com.sun.corba.se.spi.ior.ObjectKey;
import ru.entity.Item;

import java.io.*;
import java.util.ArrayList;

public class AppReader {
    private File inputFile;
    private ArrayList<Item> itemList;

    public ArrayList<Item> readFile() {
        itemList = new ArrayList<>();
        System.out.println("Input file path");
        BufferedReader bfReader = new BufferedReader(new InputStreamReader(
                System.in));
        String filePath = null;
        try {
            filePath = bfReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (filePath != null)
            checkFile(filePath);
        try {
            fileToCollection(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    private void fileToCollection(File inputFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        String line;
        while((line = br.readLine()) != null) {
            String[] arr = line.split(" ");
            Item item = new Item(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]));
            itemList.add(item);
        }
    }

    private void checkFile(String filePath) {
        inputFile = new File(filePath);
        System.out.println(inputFile.exists());
    }
}
