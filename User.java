/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


public class User {
    private Long id;
    private String login;
    private String password;

    public User(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEnonce(String login) {
        this.login = login;
    }
    
     public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return login;
    }

    @Override
    public String toString() {
        return "Question {" + "id=" + id + ", login=" + login + ", password=" + password + '}';
    }

}


