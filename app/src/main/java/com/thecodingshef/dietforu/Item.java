package com.thecodingshef.dietforu;

public class Item {
private String header;
    private String fact;
    private int image;

    public Item(String header,String fact, int image) {
this.header=header;
        this.fact = fact;
        this.image = image;
    }
    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
    public String getFact() {
        return fact;
    }

    public void setFact(String description) {
        this.fact = fact;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
