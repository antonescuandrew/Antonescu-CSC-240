package org.example;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userChoice = "";
        Database database = new Database();
        int inventoryNumber = 0;
        System.out.println("Welcome to the Book Worm");
        System.out.println("What would you like to do?");
        System.out.println("\tadd");
        System.out.println("\tprint");
        System.out.println("\tremove");
        System.out.println("\tdone");
        while(! userChoice.equals("done")){
            System.out.print("Enter choice: ");
            userChoice = scanner.nextLine();

            if(Objects.equals(userChoice, "add")){
                System.out.print("Enter title: ");
                String title = scanner.nextLine();

                System.out.print("Enter author: ");
                String author = scanner.nextLine();

                System.out.print("Enter year published: ");
                int year = Integer.parseInt(scanner.nextLine());

                System.out.print("Do you want to enter the sell price? (yes|no): ");
                String setPriceAnswer = scanner.nextLine();
                boolean setPrice = setPriceAnswer.equals("yes");
                Book book = null;
                if(setPrice){
                    System.out.print("Enter price: ");
                    float price = Float.parseFloat(scanner.nextLine());
                    book = new Book(title, author, year, price);
                }
                else{
                    book = new Book(title, author, year);
                }

                System.out.print("Enter quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine());
                Inventory inventory = new Inventory(book, quantity, inventoryNumber);
                database.addToDatabase(inventory);
                inventoryNumber++;
                }
            if (Objects.equals(userChoice,"print")) {
                System.out.print("Enter search to print books with title or enter all to print all: ");
                String printBooksWithTitleAnswer = scanner.nextLine();
                boolean printAllBooks = printBooksWithTitleAnswer.equals("all");
                if (!printAllBooks) {
                    database.getDatabase(printBooksWithTitleAnswer);
                } else {
                    database.getDatabase();
                }
            }
            if (Objects.equals(userChoice, "remove")) {
                System.out.print("Enter inventory number to remove: ");
                int inventoryNumberChoice = Integer.parseInt(scanner.nextLine());
                database.removeFromDatabase(inventoryNumberChoice);
            }
            }




        }


        }
