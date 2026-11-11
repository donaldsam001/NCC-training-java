package com.news;

import java.util.ArrayList;
import java.util.List;

public class News implements INews {
    private int id;
    private String title;
    private String publishDate;
    private String author;
    private String content;
    private double averageRate;
    private int[] rateList = new int[3];

    public int[] getRateList(){
        return rateList;
    }

    public void setRateList(int i, int rateList){
        this.rateList[i] = rateList;
    }
    public int getId(){
        return this.id;
    }

    public String getTitle() {
        return title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public double getAverageRate() {
        return averageRate;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void display(){
        System.out.println("Title: " + title + " publish date: " + publishDate
                +" author: "+ author + " content: " + content
                + " average rate: " + averageRate);
    }

    public void calculate(){
        int sum = 0;

        for (int i: rateList){
            sum += i;
        }

        this.averageRate = sum/ rateList.length;
    }
}