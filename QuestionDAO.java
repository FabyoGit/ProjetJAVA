/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import beans.Question;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuestionDAO extends DAO<Question> {

    private final String TABLE = "question";

    @Override
    public Question find(Long id) {
        Question question = null;
        try {
            String req = "SELECT * FROM " + TABLE + " WHERE id = ?";
//            System.out.println("requête : " + req); // Debug
            PreparedStatement pstmt = this.connection.prepareStatement(req);
            pstmt.setLong(1, id);
            
            ResultSet result = pstmt.executeQuery();
            if (result.first()) {
                question = new Question(
                        id,
                        result.getInt("niveau"),
                        result.getString("enonce"),
                        result.getString("reponse")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return question;
    }
    
    //@Override
    public Question find(int niveau) {
        Question question1 = null;
        try {
            String req = "SELECT * FROM " + TABLE + " WHERE niveau = ? ORDER BY RAND() LIMIT 1";
//            System.out.println("requête : " + req); // Debug
            PreparedStatement pstmt = this.connection.prepareStatement(req);
            pstmt.setLong(1, niveau);
            
            ResultSet result = pstmt.executeQuery();
            if (result.first()) {
                question1 = new Question(
                        result.getLong("id"),
                        result.getInt("niveau"),
                        result.getString("enonce"),
                        result.getString("reponse")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return question1;
    }

    @Override
    public Question create(Question obj) {
        try {
            String req = "INSERT INTO " + TABLE + " (niveau, enonce, reponse) VALUES(?, ?, ?)";
//            System.out.println("requête : " + req); // Debug
            PreparedStatement pstmt = this.connection.prepareStatement(
                    req, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, obj.getNiveau());
            pstmt.setString(2, obj.getEnonce());
            pstmt.setString(3, obj.getReponse());
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
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    @Override
    public Question update(Question obj) {
        try {
            String req = "UPDATE " + TABLE + " SET niveau = ?, enonce = ?, reponse = ?"
                    + " WHERE id = ?";
//            System.out.println("requête : " + req); // Debug
            PreparedStatement pstmt = this.connection.prepareStatement(req);
            pstmt.setInt(1, obj.getNiveau());
            pstmt.setString(2, obj.getEnonce());
            pstmt.setString(2, obj.getReponse());
            pstmt.setLong(3, obj.getId());
            pstmt.executeUpdate();
            // On récupère l'enregistrement modifié
            obj = this.find(obj.getId());
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    @Override
    public void delete(Question obj) {
        try {
            String req = "DELETE FROM " + TABLE + " WHERE id = ?";
//            System.out.println("requête : " + req); // Debug
            PreparedStatement pstmt = this.connection.prepareStatement(req);
            pstmt.setLong(1, obj.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
