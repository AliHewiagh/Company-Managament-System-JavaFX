/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd;

/**
 *
 * @author alihewaigh
 */
public class CustomerClass {
    
   private String id;
   private String fname;
   private String sname;
   private String pnumber;
   
   
   public void setId(String id){
       
       this.id = id;
       
   }
   
   public void setFname(String fname){
       
       this.fname = fname;
       
   }
   
   public void setSname(String Sname){
       
       this.sname = Sname;
       
   }
   
   public void setPnumber(String pnumber){
       
       this.pnumber = pnumber;
       
   }
    
   
   
   public String getId(){
       
       
       return id;
   }
   
   public String getFname(){
       
       
       
       return fname;
   }
   
   public String getSname(){
       
       return sname;
       
   }
   
   
   public String getPnumber(){
       
       
       return pnumber;
   }
    
}
