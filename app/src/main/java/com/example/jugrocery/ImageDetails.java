package com.example.jugrocery;

public class ImageDetails {
    private String title;
    private String category;
    private String description;
    private String amount;
    private String avnum;

    public ImageDetails(String title, String category, String description, String amount, String avnum) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.amount = amount;
        this.avnum = avnum;
    }
    public String gettitle() {
        return title;
    }
    public String getcategory() {
        return category;
    }
    public String getdescription() {
        return description;
    }
    public String getamount() {
        return amount;
    }
    public String getavnum() {
        return avnum;
    }
}
