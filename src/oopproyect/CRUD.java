/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproyect;

/**
 *
 * @author Sergio
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CRUD {


    public void createStudentData(int id, String firstNames, String lastNames,String semester,int access) {
        DBConnection db = new DBConnection();
        Connection connection = db.get_connection();
        PreparedStatement ps = null;
        try {
            String query = "insert into students(id,first_names,last_names,grade,semester,access) values (?,?,?,?,?,?)";
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, firstNames);
            ps.setString(3, lastNames);
            ps.setDouble(4, 0.0);
            ps.setString(5, semester);
            ps.setInt(6, access);
            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ResultSet readStudentData(int id) {
        DBConnection db = new DBConnection();
        Connection connection = db.get_connection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from students where id="+id;
            ps = connection.prepareStatement(query);
            //ps.setString(1, sl_no);
            System.out.println(ps);
            rs = ps.executeQuery();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }
    
    public ResultSet readTeacherData(int id) {
        DBConnection db = new DBConnection();
        Connection connection = db.get_connection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from teachers where id="+id;
            ps = connection.prepareStatement(query);
            //ps.setString(1, sl_no);
            System.out.println(ps);
            rs = ps.executeQuery();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }
    
    
    public ResultSet readAdminData(int id) {
        DBConnection db = new DBConnection();
        Connection connection = db.get_connection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from sys_admin where id="+id;
            ps = connection.prepareStatement(query);
            //ps.setString(1, sl_no);
            System.out.println(ps);
            rs = ps.executeQuery();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    public void update_data(String enrollment_no, String full_name, String first_last_name, String second_last_name,String mail, int grade, String career, String semester) {
        DBConnection db = new DBConnection();
        Connection connection = db.get_connection();
        PreparedStatement ps = null;
        try {
            String query = "update student  set full_name=?,first_last_name=?,second_last_name=?,mail=?,grade=?,career=?,semester=? where enrollment_no=?";
            ps = connection.prepareStatement(query);
            ps.setString(1, full_name);
            ps.setString(2, first_last_name);
            ps.setString(3, second_last_name);
            ps.setString(4, mail);
            ps.setInt(5, grade);
            ps.setString(6, career);
            ps.setString(7, semester);
            ps.setString(8, enrollment_no);
            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete_data(String enrollment_no) {
        DBConnection db = new DBConnection();
        Connection connection = db.get_connection();
        PreparedStatement ps = null;
        try {
            String query = "delete from student where enrollment_no=?";
            ps = connection.prepareStatement(query);
            ps.setString(1, enrollment_no);
            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
