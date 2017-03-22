/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import beans.Question;
import beans.User;


public class DAOFactory {

    public static DAO<Question> getQuestionDAO() {
        return new QuestionDAO();
    }
    
     public static DAO<User> getUserDAO() {
        return new UserDAO();
    }

}
