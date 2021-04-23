/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.ErrorAddressException;
import org.junit.Test;
import static org.junit.Assert.*;


public class AbstractItemTest {
    @Test
    public void checkInstaceErrorAddress() throws ErrorAddressException{
        ErrorAddressException e;
        int id = 1;
        System.out.println("Teste de instancia com caractere não permitido");
        String estado = "Disponível";
        String endFoto = "Teste/teste";
        String inst = "Comida";
        String tipo = "Feijão";
        int quantidade = 10;
        /*
        try{
            AbstractItem instace = new Comida(id, estado, endFoto, tipo, quantidade);
            assertFalse(true);
        }catch(ErrorAddressException ex){
            assertTrue(true);
        }*/
        assertThrows(ErrorAddressException.class,  () -> new Comida(id, estado, endFoto, tipo, quantidade ));
        
    } 
    
    @Test
    public void checkInstace(){
        int id = 1;
        System.out.println("Teste de instancia. Objeto deve ser criado");
        String estado = "Disponível";
        String endFoto = "Teste/teste.png";
        String inst = "Comida";
        String tipo = "Feijão";
        int quantidade = 10;
        try{
            AbstractItem instace = new Comida(id, estado, endFoto, tipo, quantidade);
            assertTrue(true);
        }catch(ErrorAddressException ex){
            assertFalse(true);
        }
    }
  
    
    
}
