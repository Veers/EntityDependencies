package ru.handler;

import ru.entity.Item;

import java.util.ArrayList;

public class EntityHandler {

    private ArrayList<Item> items;
    private String result;

    public void validate(ArrayList<Item> fileList) {

        if (!fileList.isEmpty()) {
            items = fileList;
            for (int i = 0; i < items.size(); i++) {
                result = "";
                result = checkCycle(i);
                String[] arr = result.split(", ");
                if (arr.length > 1)
                    showResult(arr);
            }
        }
    }

    private void showResult(String[] arr) {
        for (String anArr : arr) System.out.print(anArr + " ");
        for (int i = arr.length - 2; i >= 0; i--)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    private String checkCycle(int index) {

        if (!items.isEmpty()) {
            Item item = items.remove(index);
            if (result.equals(""))
                result += item.getKey();
            int link = item.getItemId();
            for (int i = 0; i < items.size(); i++) {
                Item item1 = items.get(i);
                if (item1.getKey() == link) {
                    result = result + ", " + item1.getKey();
                    checkCycle(i);
                }
            }
        }
        return result;
    }
}
