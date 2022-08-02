package com.my.dailynews.Model;

public class Users {
    String name;

    public Users() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfe() {
        return profe;
    }

    public void setProfe(String profe) {
        this.profe = profe;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String profe;
    String pass;
    String email;

    public Users(String name, String profe, String pass, String email) {
        this.name = name;
        this.profe = profe;
        this.pass = pass;
        this.email = email;
    }
}
