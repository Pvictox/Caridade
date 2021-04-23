/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.User;
import java.io.IOException;
import java.util.Hashtable;
import org.junit.Test;
import static org.junit.Assert.*;


public class ControlFileTest {
    
   private static Hashtable<String, User> hashEscrita = new Hashtable<>();
   private static Hashtable<String, User> hashLeitura = new Hashtable<>();
   private User uTest = new User("Pedro", "pedro123", 10);
    @Test
    public void testExistsFile() {
        System.out.println("Verificar existência de arquivo");
        String path = "Arquivos/Itens.txt"; 
        boolean value = ControlFile.existsFile(path);
        boolean expectedResult = true;
        assertEquals(expectedResult, value);
    }

  
    @Test
    public void testWriteFile() throws Exception {
        System.out.println("Escrita de arquivo");
        String path = "Arquivos_De_Teste/Teste.csv";
        hashEscrita.put(uTest.getUserName(), uTest);
        int flag = 1;
        try{
            ControlFile.writeFile(path, hashEscrita, flag);
            assertTrue(true);
        }catch(IOException e){
            assertFalse(true);
        }
        
    }

   
    @Test
    public void testReadFile() throws Exception {
        System.out.println("Lendo arquivo");
        String path = "Arquivos_De_Teste/Teste.csv";
        try{
            ControlFile.readFile(hashLeitura, path, 1);
            if (hashLeitura.containsKey(uTest.getUserName())){
                assertTrue(true);
            }else{
                assertFalse(true);
            }
        }catch(IOException e){
            assertFalse(true);
        }
      
    }
    
}
