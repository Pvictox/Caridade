/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


public class ErrorAddressException extends Exception {
    private boolean flagString;    
    public ErrorAddressException(boolean flag){
        this.flagString = flag;
    }
    
    public String toString(){
        if (this.flagString == false){
            return "Endereço fornecido incorretamente. Substitua a barra por /";
        }else{
            return "Endereço fornecido incorretamente. Insira a extensão do arquivo";
        }
    }
}
