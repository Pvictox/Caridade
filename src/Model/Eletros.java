/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.ErrorAddressException;


public class Eletros extends AbstractItem{
    private int tempoDeUso;
    
    public Eletros(int ID_Item, String estado_Item, String endereco_Foto, String tipo, int tempoDeUso) throws ErrorAddressException{
        super(ID_Item, estado_Item, endereco_Foto,"Eletro" ,tipo);
        this.tempoDeUso = tempoDeUso;
    }

    public int getTempoDeUso() {
        return tempoDeUso;
    }
    
    public String toString(){
        return this.getEstado_Item()+";"+this.getEndereco_Foto()+";"+this.getTipo()+";"+this.getTempoDeUso()+";"+this.getInstancia();
    }

    @Override
    public String Message() {
        return "ID:"+this.getID_Item()+" ||Estado:"+this.getEstado_Item()+" ||Tipo:"+this.getTipo()+" ||Tempo de Uso:"+this.getTempoDeUso();
    }
    
    
}
