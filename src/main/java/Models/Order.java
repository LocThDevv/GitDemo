/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Order {

    private int order_id;
    private int account_id;
    private Date order_date;
    private int order_total;
    private int customer_id;
    private int monthRevenue;
    private double totalRevenue;

    public Order() {
    }

    public Order(int order_id, int account_id, Date order_date, int order_total, int customer_id) {
        this.order_id = order_id;
        this.account_id = account_id;
        this.order_date = order_date;
        this.order_total = order_total;
        this.customer_id = customer_id;
    }

    public Order(int monthRevenue, double totalRevenue) {
        this.monthRevenue = monthRevenue;
        this.totalRevenue = totalRevenue;
    }
    
   

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public int getOrder_total() {
        return order_total;
    }

    public void setOrder_total(int order_total) {
        this.order_total = order_total;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getMonthRevenue() {
        return monthRevenue;
    }

    public void setMonthRevenue(int monthRevenue) {
        this.monthRevenue = monthRevenue;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

  
    
}
