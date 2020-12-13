/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package welcome;

/**
 *
 * @author duruj
 */
public class Item {
     private String username;
     int id;
    String name ;
    int quantity;
    double price;
  
    public Item(String username)
    {
      this.username = username;
    }

    
  // get n set methods
  //
    public void setId(int n)
    {
      id = n;
    }
     public void setName(String s)
    {
        name = s;
    }
     public void setQuantity(int n)
    {
      quantity = n;
    }
    
    public void setPrice(double n)
    {
      price = n;
    }
   
    public int getId()
    {
      return id;
    }
    public String getName()
    {
      return name;
    }
   
   public int getQuantity()
   {
    return quantity;
   }
  
   public double getPrice()
   {
     return price;
   }
  
  
   @Override
   public String toString()
   {
     return id+" "+  name + " " + quantity+"="+price;
   }
    
}
