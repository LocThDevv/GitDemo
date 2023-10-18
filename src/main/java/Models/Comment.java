/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 *
 * @author Admin
 */
public class Comment {
    private int comment_id;
    private String comment_text;
    private Date comment_date;
    private String username;
private int product_id;
    public Comment() {
    }

    public Comment(int comment_id, String comment_text, Date comment_date, String username) {
        this.comment_id = comment_id;
        this.comment_text = comment_text;
        this.comment_date = comment_date;
        this.username = username;
    }

    public Comment(int comment_id, String comment_text, Date comment_date, String username, int product_id) {
        this.comment_id = comment_id;
        this.comment_text = comment_text;
        this.comment_date = comment_date;
        this.username = username;
        this.product_id = product_id;
    }
    
    

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public Date getComment_date() {
        return comment_date;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    @Override
    public String toString() {
        return comment_text + " " + comment_date + " " + username;
    }

}
