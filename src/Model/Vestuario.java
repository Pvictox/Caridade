/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.ErrorAddressException;


public class Vestuario extends AbstractItem {
    private String tamanho_Vestuario;

    public Vestuario(int ID_Item, String estado_Item, String endereco_Foto, String tipo_Vestuario, String tamanho_Vestuario) throws ErrorAddressException {
        super(ID_Item, estado_Item, endereco_Foto, "Vestuario", tipo_Vestuario);  
        this.tamanho_Vestuario = tamanho_Vestuario;
        
    }

    public String getTamanho_Vestuario() {
        return tamanho_Vestuario;
    }
    
    public String toString(){
        return this.getEstado_Item()+";"+this.getEndereco_Foto()+";"+this.getTipo()+";"+this.getTamanho_Vestuario()+";"+this.getInstancia();
    }

    @Override
    public String Message() {
        return "ID: "+this.getID_Item()+";Estado: "+this.getEstado_Item()+";Tipo de vestuário: "+ this.getTipo()+ ";Tamanho:"+this.getTamanho_Vestuario();
    }
    
   
    
    
}
