/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc220;

/**
 *
 * @author aauli
 */
 public class OrderById implements Order
 {
public boolean comesAfter(Student s1, Student s2)
    {
        return s1.getId() > s2.getId();
    }

    @Override
    public boolean matches(Student s1, Student s2) 
    {
        return s1.getId() == s2.getId(); 
        
    }
    
   
}
