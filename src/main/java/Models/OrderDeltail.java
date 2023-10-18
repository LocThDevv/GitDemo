/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class OrderDeltail {
    private int order_id;
    private int product_id;
    private int unit_price;
    private int quantity;

    public OrderDeltail() {
    }

    public OrderDeltail(int order_id, int product_id, int unit_price, int quantity) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.unit_price = unit_price;
        this.quantity = quantity;
    }
    
     public OrderDeltail(int order_id, int product_id, int unit_price, int quantity, int category, String product_name  ) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.unit_price = unit_price;
        this.quantity = quantity;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(int unit_price) {
        this.unit_price = unit_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return " "+ order_id + ", " + product_id + ", " + unit_price +" " + quantity ;
    }
    
}
