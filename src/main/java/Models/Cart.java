/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import DAOs.productDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Cart {

    private List<Items> items;

    public Cart() {
    }

    public Cart(List<Items> items) {
        this.items = items;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    //getItemById
    private Items getItemById(int id) {
        for (Items o : items) {
            if (o.getProduct().getProduct_id() == id) {
                return o;
            }
        }
        return null;
    }

    //getQuantityById
    public int getQuantityById(int id) {
        return getItemById(id).getQuantity();//lay quantity cua item 1003
    }

    //add items
    public void addItem(Items t) {
        if (getItemById(t.getProduct().getProduct_id()) != null) {
            Items m = getItemById(t.getProduct().getProduct_id());//1003
            m.setQuantity(m.getQuantity() + t.getQuantity());// cu + moi 
        } else {
            items.add(t);
        }
    }

    //remove
    public void removeItem(int id) {
        if (getItemById(id) != null) {
            items.remove(getItemById(id));
        }
    }

    //Totalprice
    public double getTotalPrice() {
        double t = 0;
        for (Items o : items) {
            t += (o.getQuantity() * o.getPrice());
        }
        return t;
    }

    //getProductbyID
    private Product getProductByID(int id, List<Product> list) {
        for (Product o : list) {
            if (o.getProduct_id() == id) {
                return o;
            }
        }
        return null;
    }

    //
    public Cart(String txt, List<Product> list) {
        items = new ArrayList<>();
        try {
            if (txt != null && txt.length() != 0) {
                String[] s = txt.split(","); //1003:1,1003:1
                for (String o : s) {
                    String[] n = o.split(":");
                    int id = Integer.parseInt(n[0]);//1003
                    int quantity = Integer.parseInt(n[1]);//1
                    Product p = getProductByID(id, list);
                    Items t = new Items(p, quantity, p.getPrice());
                    addItem(t);
                }
            }
        } catch (Exception e) {
        }

    }
    

}
