/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.AbstractItem;
import Model.Brinquedos;
import Model.Comida;
import Model.Eletros;
import Model.User;
import Model.Vestuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Set;


public class ControlFile {
    
    public static boolean existsFile(String path){
        File arquivo = null;
        arquivo = new File(path);
        return arquivo.exists();
    }
    
    // 0 para itens - 1 para pessoas
    public static void writeFile(String path, Hashtable hash, int flag) throws IOException{
        File arquivo = null;
        arquivo = new File(path);
        FileWriter fwArquivo = null;
       if (existsFile(path) == false){ //Cria um arquivo
           
            try{
                fwArquivo = new FileWriter(arquivo);
            }catch(IOException e){
                throw new IOException();
            }
        }else{//Abre o arquivo para alteração
           
            try{
                fwArquivo = new FileWriter(arquivo, true);
            }catch(IOException e){
                throw new IOException();
            }
        }
        
        OutputStreamWriter escritor = new OutputStreamWriter(new FileOutputStream(path), "UTF-8");
        try{
           if (flag == 0){
               Set<Integer> keys = hash.keySet();
               for (Integer chave : keys){ // iTENS
                   AbstractItem abs = (AbstractItem)hash.get(chave);
                   if (abs.isWrited() == false){
                       escritor.append(chave+";"+hash.get(chave)+"\n");
                       abs.switchWrited();
                   }
               }
           }else if (flag == 1){ // Usuarios
               Set<String> keys = hash.keySet();
               for (String chave : keys){
                   User u = (User)hash.get(chave);
                   escritor.append(chave+";"+hash.get(chave)+"\n");
                }
           }
           escritor.close();
           fwArquivo.close();
        }catch(IOException e){
            throw new IOException();
        }
    }
    
    // 0 para itens - 1 para usuários
    public static void readFile(Hashtable hash, String path, int flag) throws FileNotFoundException, UnsupportedEncodingException, IOException, ErrorAddressException{
        BufferedReader leitor = null;
        String linha = "";
        try{
            leitor = new BufferedReader( new InputStreamReader(new FileInputStream(path), "UTF-8") );
        }catch(FileNotFoundException e){
            throw new FileNotFoundException();
        }
        catch(UnsupportedEncodingException ex){
            throw new UnsupportedEncodingException();
        }
        
        if (leitor != null){
            try{
                while (true){
                    linha = leitor.readLine();
                    if (linha != null){
                        String[] partes = linha.split(";");
                        try{
                            if (flag == 0){ // Itens
                               if (partes[partes.length-1].equals("Vestuario")){
                                    Vestuario v = new Vestuario(Integer.parseInt(partes[0]), partes[1], partes[2], partes[3], partes[4]);
                                    hash.put(v.getID_Item(), v);
                               }else if (partes[partes.length-1].equals("Brinquedos")){
                                   Brinquedos b = new Brinquedos(Integer.parseInt(partes[0]),partes[1], partes[2], partes[3], partes[4]);
                                   hash.put(b.getID_Item(), b);
                               }else if (partes[partes.length-1].equals("Comida")){
                                   Comida c = new Comida(Integer.parseInt(partes[0]), partes[1], partes[2], partes[3], Integer.parseInt(partes[4]));
                                   hash.put(c.getID_Item(), c);
                               }else if (partes[partes.length-1].equals("Eletro")){
                                   Eletros e = new Eletros(Integer.parseInt(partes[0]), partes[1], partes[2], partes[3], Integer.parseInt(partes[4]));
                                   hash.put(e.getID_Item(), e);
                               }
                            }else if (flag == 1){ // Usuários
                                User u = new User(partes[0], partes[1], Integer.parseInt(partes[2]));
                                hash.put(u.getUserName(), u);
                            }
                        }catch(ErrorAddressException e){
                            throw new ErrorAddressException(false);
                        }
                    }else{
                        break;
                    }
                }
                leitor.close();
                        
            }catch(IOException e ){
                throw new IOException();
            }
        }
    }
}
