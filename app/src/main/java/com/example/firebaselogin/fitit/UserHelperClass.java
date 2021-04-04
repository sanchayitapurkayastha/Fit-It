package com.example.firebaselogin.fitit;

public class UserHelperClass {

    String name,phoneno,email,address,password;

    public UserHelperClass(){

    }
    public UserHelperClass(String name, String phoneno, String email, String address, String password) {
        this.name = name;
        this.phoneno = phoneno;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
