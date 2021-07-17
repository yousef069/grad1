package com.example.yousefgrad;

public class locationtrack {

    private Double location1;
    private Double location2;





    public locationtrack(Double location1, Double location2) {
        this.location1 = location1;
        this.location2 = location2;


    }

    public locationtrack()
    {

    }



    public Double getLocation1() {
        return location1;
    }

    public void setLocation1(Double location1) {
        this.location1 = location1;
    }

    public Double getLocation2() {
        return location2;
    }

    public void setLocation2(Double location2) {
        this.location2 = location2;
    }

}
