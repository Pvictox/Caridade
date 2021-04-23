/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Model.AbstractItem;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class ControlItem {
    public static void queryItensDisponiveis(Hashtable<Integer, AbstractItem> hashItens){
        if (hashItens != null){
            Set<Integer> setKeys = hashItens.keySet();
            for (Integer key : setKeys){
                AbstractItem item = (AbstractItem)hashItens.get(key);
                if (item.getEstado_Item().equals("Disponível")){
                    System.out.println(item.Message());
                }
            }
        }
    }
    
    public static void queryItensAlocados(Hashtable<Integer, AbstractItem> hashItens){
        if (hashItens != null){
            Set<Integer> setKeys = hashItens.keySet();
            for (Integer key : setKeys){
                AbstractItem item = (AbstractItem)hashItens.get(key);
                if (item.getEstado_Item().equals("Alocado")){
                    System.out.println(item.Message());
                }
            }
        }
    }
    
    public static boolean switchStatusItem(Hashtable<Integer, AbstractItem> hashItens, int IDItem){
        boolean flag = false;
        if (hashItens != null){
            Set<Integer> setKeys = hashItens.keySet();
            for (Integer key : setKeys){
                if (IDItem == key){
                    flag = true;
                    AbstractItem item = (AbstractItem)hashItens.get(key);
                    item.setEstado_Item("Alocado");
                }
            }
        }
        return flag;
    }
    public static boolean queryALLItensByName(Hashtable<Integer, AbstractItem> hashItens, String nome){
        boolean flagCount = false;
        if (hashItens != null){
            Set<Integer> setKeys = hashItens.keySet();
            for (Integer key : setKeys){
                AbstractItem item = (AbstractItem)hashItens.get(key);
                if (item.getTipo().contains(nome)){
                    flagCount = true;
                    System.out.println(item.Message());
                }
            }
        }
        return flagCount;
    }
}
