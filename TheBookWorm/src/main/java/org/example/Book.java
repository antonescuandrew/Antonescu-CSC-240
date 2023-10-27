package org.example;

public class Book {
    private String title, author;
    private int year;
    private float price;
    public Book(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;
    }
    public Book(String title, String author, int year, float cost){
        this(title, author, year);
        this.price = cost;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public int getYear(){
        return year;
    }
    public float getPrice(){
        return price;
    }
}
