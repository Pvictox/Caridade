/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.ErrorAddressException;


public class Brinquedos extends AbstractItem{
    private String qualidade_Brinquedo;
    
    public Brinquedos(int ID_Item, String estado_Item, String endereco_Foto, String tipo_Brinquedo, String qualidade_Brinquedo) throws ErrorAddressException{
        super(ID_Item, estado_Item, endereco_Foto, "Brinquedos", tipo_Brinquedo);
       
        this.qualidade_Brinquedo = qualidade_Brinquedo;
    }

    public String getQualidade_Brinquedo() {
        return qualidade_Brinquedo;
    }
    
    public String toString(){
        return this.getEstado_Item()+";"+this.getEndereco_Foto()+";"+this.getTipo()+";"+this.getQualidade_Brinquedo()+";"+this.getInstancia();
    } 
    
    @Override
    public String Message() {
        return "ID:"+this.getID_Item()+" ||Estado:"+this.getEstado_Item()+" ||Tipo:"+this.getTipo()+" ||Qualidade:"+this.getQualidade_Brinquedo();
    }
    
    
}
