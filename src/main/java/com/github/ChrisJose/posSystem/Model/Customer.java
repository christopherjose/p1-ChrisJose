package com.github.ChrisJose.posSystem.Model;

import java.util.List;

public class Customer {

    private String customerId;
    private String firstName;
    private String lastName;
    private String primaryPhoneNo;
    private String email;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private List<String> orderId;

    public Customer(String customerId, String firstName, String lastName, String primaryPhoneNo, String emailAddress,
             String address, String address2, String city, String state, String zip) {
        this.setCustomerId(customerId);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPrimaryPhoneNo(primaryPhoneNo);
        this.setEmail(emailAddress);
        this.setAddress(address);
        this.setAddress2(address2);
        this.setCity(city);
        this.setState(state);
        this.setZip(zip);
    }

    public Customer() {};


    //GETTER & SETTER Statements
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPrimaryPhoneNo() {
        return primaryPhoneNo;
    }

    public void setPrimaryPhoneNo(String primaryPhoneNo) {
        this.primaryPhoneNo = primaryPhoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String emailAddress) {
        this.email = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public List<String> getOrderId() {
        return orderId;
    }

    public void setOrderId(List<String> orderId) {
        this.orderId = orderId;
    }




}
