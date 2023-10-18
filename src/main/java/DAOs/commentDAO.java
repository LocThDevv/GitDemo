/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Account;
import Models.Comment;
import Models.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class commentDAO {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public commentDAO() {
        conn = DBConnection.DbConnection.getConnection();
    }

    //getAll
    public List<Comment> getAllCommentByPID(int PID) {
        List<Comment> list = new ArrayList<>();
        String sql = "select * from comment where product_id =?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, PID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Comment(rs.getInt("comment_id"),
                        rs.getString("comment_text"),
                        rs.getDate("comment_date"),
                        rs.getString("username"),
                        rs.getInt("product_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(commentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //addproduct
    public int AddNewComment(String txt, String user, int PID) {
        int kq = 0;
        String sql = "insert into Comment values(?,?,?,?)";
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txt);
            ps.setString(2, date);
            ps.setString(3, user);
            ps.setInt(4, PID);
            kq = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(commentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    //get total comment
    public int getTotalCM(int PID) {
        rs = null;
        int kq = 0;
        String sql = "select count(Comment.product_id) as [ttcomment] from Comment\n"
                + "where product_id = ?\n"
                + "group by product_id";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, PID);
            rs = ps.executeQuery();
            if (rs.next()) {
                kq = rs.getInt("ttcomment");
            }
        } catch (SQLException ex) {
            Logger.getLogger(commentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    //delete
    public int DeleteComment(int PID) {
        int kq = 0;
        String sql = "delete from Comment where product_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, PID);
            kq = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(commentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    //delete
    public int DeleteCommentByUs(String us) {
        int kq = 0;
        String sql = "delete from Comment where username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, us);
            kq = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(commentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    public static void main(String[] args) {
        commentDAO c = new commentDAO();
        List<Comment> clist = c.getAllCommentByPID(1018);
        for (Comment o : clist) {
            System.out.println(o);
        }
    }

}
