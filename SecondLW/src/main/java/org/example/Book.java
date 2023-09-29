package org.example;

public class Book {
    private String title;
    private String author;
    private int year;
    private String publisher;
    private String genre;
    private int pageCount;

    public Book() {
    }
    public Book(String title, String author){
        this.title = title;
        this.author = author;
        this.year = 0;
        this.publisher = "publisher";
        this.genre = "genre";
        this.pageCount = 0;
    }
    public Book(String title, String author, int year, String publisher, String genre, int pageCount) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.publisher = publisher;
        this.genre = genre;
        this.pageCount = pageCount;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
@Override
public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Назва книги: " + title);
        builder.append("Автор: " + author);
        builder.append("Рік випуску: " + year);
        builder.append("Видавництво: " + publisher);
        builder.append("Жанр: " + genre);
        builder.append("Кількість сторінок: " + pageCount);
        return builder.toString();
}
}
