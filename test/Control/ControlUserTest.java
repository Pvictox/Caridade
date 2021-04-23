/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.User;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import org.junit.Test;
import static org.junit.Assert.*;


public class ControlUserTest {    

    Hashtable<String, User> hashUserTest = new Hashtable<>();
   
    @Test
    public void testNotHasUser() throws UnsupportedEncodingException, IOException, FileNotFoundException, ErrorAddressException {
        System.out.println("Busca de um usuário no arquivo de teste que não existe");
        String name = "Pamona";
        String pass = "123";
        ControlFile.readFile(hashUserTest, "Arquivos_De_Teste/Teste.csv", 1);
        User expResult = null;
        User result = ControlUser.hasUser(name, pass, hashUserTest);
        assertEquals(expResult, result);
        
    }
    
     @Test
    public void testHasUser() throws UnsupportedEncodingException, IOException, FileNotFoundException, ErrorAddressException {
        System.out.println("Busca de um usuário no arquivo de teste que existe");
        String name = "Pedro";
        String pass = "pedro123";
        ControlFile.readFile(hashUserTest, "Arquivos_De_Teste/Teste.csv", 1);
        User result = ControlUser.hasUser(name, pass, hashUserTest);
         assertNotNull(result);
        
    }

     
}
