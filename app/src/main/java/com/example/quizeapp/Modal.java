package com.example.quizeapp;

public class Modal {

    String qurtion;
    boolean truefalse;
    int image;

    public String getQurtion() {
        return qurtion;
    }

    public void setQurtion(String qurtion) {
        this.qurtion = qurtion;
    }

    public boolean isTruefalse() {
        return truefalse;
    }

    public void setTruefalse(boolean truefalse) {
        this.truefalse = truefalse;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Modal(String qurtion, boolean truefalse, int image) {
        this.qurtion = qurtion;
        this.truefalse = truefalse;
        this.image = image;
    }

}
