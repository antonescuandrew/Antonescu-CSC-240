package org.example;

public class Inventory {
    private Book book;
    private int quantity, inventoryNumber;
    public Inventory(Book book, int quantity, int inventoryNumber){
        this.book = book;
        this.quantity = quantity;
        this.inventoryNumber = inventoryNumber;
    }
    public Book getBook(){
        return book;
    }

    public int getQuantity() {
        return quantity;
    }
    public int getInventoryNumber(){
        return inventoryNumber;
    }

}
