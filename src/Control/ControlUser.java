/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.ArrayList;
import Model.User;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Set;
public class ControlUser {
    
    public static void checkUserNameUsage(String name, Hashtable hashUsuarios) throws UserNameUsageException{
        
        if (name.equals("") == false && hashUsuarios.containsKey(name)){
            throw new UserNameUsageException();
        }
    }
    
    public static User hasUser(String name, String pass, Hashtable hashUsuarios){
        User u = (User)hashUsuarios.get(name);
        if (u != null){
            if (u.getPassWord().equals(pass)){
                return u;
            }
        }
        return null;
    }
    
    public static void showRanking(Hashtable hashUsuarios){
        Set<String> keySet = hashUsuarios.keySet();
        ArrayList<User> arrayRanking = new ArrayList<>();
        for (String str : keySet){
            User u = (User)hashUsuarios.get(str);
            arrayRanking.add(u);
        }
        Collections.sort(arrayRanking, Collections.reverseOrder());
        int cont =1;
        for (User u: arrayRanking){
            System.out.println(cont+"º lugar = "+u.getUserName()+" com "+u.getPontos()+" pontos");
            cont++;
        }
    }
}
