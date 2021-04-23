/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.AbstractItem;
import java.util.Hashtable;
import org.junit.Test;
import static org.junit.Assert.*;

public class ControlItemTest {
    
    private static Hashtable<Integer, AbstractItem> hashItens = null;
    @Test
    public void testQueryItensDisponiveis() {
        System.out.println("Verificando passagens de valores para o hash {Null e caso seja vazio}");
        ControlItem.queryItensDisponiveis(hashItens);
        assertNull(hashItens);
    }

   
    @Test
    public void testSwitchStatusItem() {
        System.out.println("Teste mudança de status de um item (Alocado//Disponivel) {Passagem de hashs nulos ou id's que não existem no arquivo}");
        int IDItem = 10;
        boolean expResult = false;
        boolean result = ControlItem.switchStatusItem(hashItens, IDItem);
        assertEquals(expResult, result);
    }

    
    @Test
    public void testQueryALLItensByName() {
        System.out.println("Busca itens que contém uma String {Passagem com uma hash nula ou item q não existe");
        String nome = "Pão de forma";
        boolean expResult = false;
        boolean result = ControlItem.queryALLItensByName(hashItens, nome);
        assertEquals(expResult, result);
        
    }
    
}
