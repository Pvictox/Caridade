/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.ErrorAddressException;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public abstract class AbstractItem {
        private int ID_Item;
        private String tipo;
        private String estado_Item;  //Alocado ou Disponível 
        private String endereco_Foto;
        private PDImageXObject image;
        private boolean writed;
        private String instancia;

    public AbstractItem(int ID_Item, String estado_Item, String endereco_Foto, String instancia, String tipo) throws ErrorAddressException{
        this.ID_Item = ID_Item;
            this.estado_Item = estado_Item;
            if (endereco_Foto.contains("\\")){
                throw new ErrorAddressException(false);
            }else if ( endereco_Foto.contains(".jpg") == false && endereco_Foto.contains(".png") == false){
                throw new ErrorAddressException(true);
            }
            else{
                this.endereco_Foto = endereco_Foto;
                
            }
            this.writed = false;
            this.instancia = instancia;
            this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    
    public void setEstado_Item(String estado_Item) {
        this.estado_Item = estado_Item;
    }

    public String getInstancia() {
        return instancia;
    }

    public abstract String Message();
    public boolean isWrited() {
        return writed;
    }
        
    public void switchWrited(){
        this.writed = true;
    }
    public int getID_Item() {
        return ID_Item;
    }

    public String getEstado_Item() {
        return estado_Item;
    }

    public String getEndereco_Foto() {
        return endereco_Foto;
    }
        
        
}
