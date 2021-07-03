package com.example.backend.model;

public class FrontendDto {
    private String city1;
    private String city2;
    private String date;

    public FrontendDto(String city1, String city2, String date) {
        this.city1 = city1;
        this.city2 = city2;
        this.date = date;
    }

    public String getCity1() {
        return city1;
    }

    public void setCity1(String city1) {
        this.city1 = city1;
    }

    public String getCity2() {
        return city2;
    }

    public void setCity2(String city2) {
        this.city2 = city2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "com.example.backend.FrontendData{" +
                "city1='" + city1 + '\'' +
                ", city2='" + city2 + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
