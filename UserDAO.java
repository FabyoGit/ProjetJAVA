/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author stag
 */

import beans.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO extends DAO<User> {

    private final String TABLE = "User";

    @Override
    public User find(Long id) {
        User user = null;
        try {
            String req = "SELECT * FROM " + TABLE + " WHERE id = ?";
//            System.out.println("requête : " + req); // Debug
            PreparedStatement pstmt = this.connection.prepareStatement(req);
            pstmt.setLong(1, id);
            ResultSet result = pstmt.executeQuery();
            if (result.first()) {
                user = new User(
                        id,
                        result.getString("login"),
                        result.getString("password")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public User create(User obj) {
        try {
            String req = "INSERT INTO " + TABLE + " (login, password) VALUES(?, ?)";
//            System.out.println("requête : " + req); // Debug
            PreparedStatement pstmt = this.connection.prepareStatement(
                    req, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, obj.getLogin());
            pstmt.setString(2, obj.getPassword());
           
            // On soumet la requête et on récupère l'id créé
            int id = pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            long last_inserted_id;
            if (rs.first()) { // Si on a des id créés
                last_inserted_id = rs.getInt(1);
                // On récupère l'enregistrement créé
                obj = this.find(last_inserted_id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
   
    @Override
    public User update(User obj) {
        try {
            String req = "UPDATE " + TABLE + " SET login = ?, password = ?"
                    + " WHERE id = ?";
//            System.out.println("requête : " + req); // Debug
            PreparedStatement pstmt = this.connection.prepareStatement(req);
            pstmt.setString(1, obj.getLogin());
            pstmt.setString(2, obj.getPassword());
            pstmt.setLong(3, obj.getId());
            pstmt.executeUpdate();
            // On récupère l'enregistrement modifié
            obj = this.find(obj.getId());
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    @Override
    public void delete(User obj) {
        try {
            String req = "DELETE FROM " + TABLE + " WHERE id = ?";
//            System.out.println("requête : " + req); // Debug
            PreparedStatement pstmt = this.connection.prepareStatement(req);
            pstmt.setLong(1, obj.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}