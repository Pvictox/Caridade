/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Control.ErrorAddressException;
public class Comida extends AbstractItem{
    private int quantidade;
    
    public Comida(int ID_Item, String estado_Item, String endereco_Foto, String tipo, int quantidade) throws ErrorAddressException{
      super(ID_Item, estado_Item, endereco_Foto, "Comida", tipo);  
      this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String toString(){
        return this.getEstado_Item()+";"+this.getEndereco_Foto()+";"+this.getTipo()+";"+this.getQuantidade()+";"+this.getInstancia();
    }
    @Override
    public String Message() {
        return "ID:"+this.getID_Item()+" ||Estado:"+this.getEstado_Item()+" ||Tipo:"+this.getTipo()+" ||Quantidade:"+this.getQuantidade();
    }
    
}
