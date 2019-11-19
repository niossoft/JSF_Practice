package com.wudouli.beans;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;

@SessionScoped
public class Customer implements Serializable {
  
    private String name;
    private String gender;
  
    /**
     * Creates a new instance of Customer
     */
    public Customer() {
    }
  
    public String getName() {
        return name;
    }
  
    public void setName(String name) {
        this.name = name;
    }
  
    public String getGender() {
        return gender;
    }
  
    public void setGender(String gender) {
        this.gender = gender;
    }
  
    public String handleAction(){
        return "showinfo?faces-redirect=true";
    }
  
}
