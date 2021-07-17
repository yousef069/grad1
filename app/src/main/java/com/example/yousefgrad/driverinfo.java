package com.example.yousefgrad;

public class driverinfo {
    private String status;
    private String email;
    private Double location1;
    private Double location2;
    private String driverid;

    public String getDriverid() {
        return driverid;
    }

    public void setDriverid(String driverid) {
        this.driverid = driverid;
    }




    public driverinfo(String status, String email,Double location1,Double location2,String driverid) {
            this.status = status;
        this.email = email;
        this.location1 = location1;
        this.location2 = location2;
        this.driverid = driverid;


    }

    public driverinfo()
    {

    }




    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
