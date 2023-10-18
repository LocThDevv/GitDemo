/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Admin
 */
public class Customer {

    private int customer_id;
    private String customer_name;
    private String email;
    private String phone_number;
    private String address;
    private int account_id;
    private String fullname;
    private int solan;
    private double order_total;

    public Customer() {
    }

    public Customer(int customer_id, String customer_name, String email, String phone_number, String address, int account_id) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.email = email;
        this.phone_number = phone_number;
        this.address = address;
        this.account_id = account_id;
    }

    public Customer(String customer_name, String email, String phone_number, String address, int account_id) {
        this.customer_name = customer_name;
        this.email = email;
        this.phone_number = phone_number;
        this.address = address;
        this.account_id = account_id;
    }

    //dung de lay top 5 khach hang
    public Customer(String fullname, int account_id, int solan, double order_total) {
        this.fullname = fullname;
        this.account_id = account_id;
        this.solan = solan;
        this.order_total = order_total;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getSolan() {
        return solan;
    }

    public void setSolan(int solan) {
        this.solan = solan;
    }

    public double getOrder_total() {
        return order_total;
    }

    public void setOrder_total(double order_total) {
        this.order_total = order_total;
    }

    @Override
    public String toString() {
        return fullname +" "+ account_id + " " + solan + " " + order_total; 
    }
    
    

}
