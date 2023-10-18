/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Admin
 */
public class Product {

    private int product_id;
    private String product_name;
    private String product_pic;
    private String product_color;
    private int price;
    private int stock_quantity;
    private String des;
    private int category_id;

    public Product() {
    }

    public Product(int product_id, String product_name, String product_pic, String product_color, int price, int stock_quantity, String des, int category_id) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_pic = product_pic;
        this.product_color = product_color;
        this.price = price;
        this.stock_quantity = stock_quantity;
        this.des = des;
        this.category_id = category_id;
    }

    public Product(String product_name, String product_pic, String product_color, int price, int stock_quantity, String des, int category_id) {

        this.product_name = product_name;
        this.product_pic = product_pic;
        this.product_color = product_color;
        this.price = price;
        this.stock_quantity = stock_quantity;
        this.des = des;
        this.category_id = category_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_pic() {
        return product_pic;
    }

    public void setProduct_pic(String product_pic) {
        this.product_pic = product_pic;
    }

    public String getProduct_color() {
        return product_color;
    }

    public void setProduct_color(String product_color) {
        this.product_color = product_color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

}
