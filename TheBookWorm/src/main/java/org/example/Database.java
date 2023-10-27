package org.example;

import java.util.ArrayList;

public class Database {

    ArrayList<Inventory> database;
    public Database(){
        this.database = new ArrayList<>();
    }
    public void addToDatabase(Inventory inventory){
        this.database.add(inventory);
    }
    public void removeFromDatabase(int inventoryNumberChoice){
        this.database.remove(inventoryNumberChoice);

    }
    public void getDatabase() {
        for (Inventory inventory : database) {
            System.out.println("Inventory Number: " + inventory.getInventoryNumber() + " Quantity: " + inventory.getQuantity()
                    + "\n\tTitle: " + inventory.getBook().getTitle() + "\n\tAuthor: " + inventory.getBook().getAuthor() + "\n\tYear Published: " +
                    inventory.getBook().getYear() + "\n\tPrice: " + String.format("%.2f",inventory.getBook().getPrice()));

        }
    }


    public void getDatabase(String searchTerm){


        for (Inventory inventory : database){
            if (inventory.getBook().getTitle().contains(searchTerm)){
                System.out.println("Inventory Number: " + inventory.getInventoryNumber() + " Quantity: " + inventory.getQuantity()
                        + "\n\tTitle: " + inventory.getBook().getTitle() + "\n\tAuthor: " + inventory.getBook().getAuthor() + "\n\tYear Published: " +
                        inventory.getBook().getYear() + "\n\tPrice: " + String.format("%.2f",inventory.getBook().getPrice()));
            }
        }

    }



}
