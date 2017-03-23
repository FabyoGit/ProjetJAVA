/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multijeux;

/**
 *
 * @author stag
 */

    public class Niveau 
    
 {

    private static Niveau instance = null;
    private int nNiveau; 

    private Niveau()
    {  
        this.nNiveau = 1;
    }
    
    
    public static Niveau getInstance() 
    {
      if(instance == null) 
      {
        instance = new Niveau();
      }
      return instance;
   }

    public void setNiveau(int n)
    {
        if(n == 1 || n == 2)
        this.nNiveau = n;
    }
    
    public int getNiveau()
    {
     return   this.nNiveau;
    }
    
    
}
    
    
