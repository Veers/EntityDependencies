package ru.entity;

public class Item {
    private int key;
    private int itemId;

    public Item(int key, int itemId) {
        setKey(key);
        setItemId(itemId);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}
