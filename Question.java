/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


public class Question {
    private Long id;
    private Integer niveau;
    private String enonce;
    private String reponse;

    public Question(Long id, Integer niveau, String enonce, String reponse) {
        this.id = id;
        this.niveau = niveau;
        this.enonce = enonce;
        this.reponse = reponse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNiveau() {
        return niveau;
    }

    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }

    public String getEnonce() {
        return enonce;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }
    
     public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    @Override
    public String toString() {
        return "Question {" + "id=" + id + ", niveau=" + niveau + ", enonce=" + enonce + ", reponse=" + reponse + '}';
    }

}

