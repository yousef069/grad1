package com.example.yousefgrad;

import java.io.Serializable;

public class driver implements Serializable {
    private String Mobile;
    private String email;
    private String username;
    private String password;
    private String status;
    private Double location1;
    private Double location2;

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

    public String getDriverid() {
        return driverid;
    }

    public void setDriverid(String driverid) {
        this.driverid = driverid;
    }

    private String driverid;



    public driver(String Mobile, String email, String username, String password,String driverid,Double location1,
                  Double location2,String status) {
            this.Mobile = Mobile;
        this.email = email;
        this.password=password;
        this.username = username;
        this.driverid = driverid;
        this.location1 = location1;
        this.location2 = location2;
        this.status = status;

    }

    public driver()
    {

    }



    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
