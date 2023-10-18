/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Admin
 */
public class Account {
    
    private int account_id;
    private String username;
    private String password;
    private String phone_number;
    private String email;
    private int isSell;
    private int isAdmin;
    private String fullname;

    public Account() {
    }

    public Account( String username, String password, String phone_number, String email, int isSell, int isAdmin, String fullname) {
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.email = email;
        this.isSell = isSell;
        this.isAdmin = isAdmin;
        this.fullname = fullname;
    }

    public Account(int account_id, String username, String password, String phone_number, String email, int isSell, int isAdmin, String fullname) {
        this.account_id = account_id;
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.email = email;
        this.isSell = isSell;
        this.isAdmin = isAdmin;
        this.fullname = fullname;
    }

   

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIsSell() {
        return isSell;
    }

    public void setIsSell(int isSell) {
        this.isSell = isSell;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

}
