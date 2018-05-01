/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency.exceptions;

/**
 *
 * @author angel
 */
public class errorException extends Exception{
    
    public errorException(){
        
    }
    
    public errorException(String mensaje){
        super(mensaje);
    }
    
}
