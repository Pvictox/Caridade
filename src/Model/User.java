/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class User implements Comparable<User> {
    private String userName;
    private String passWord;
    private int pontos;
    private boolean hasWrited;
    
    public User(String userName, String passWord, int pontos){
        this.userName = userName;
        this.passWord = passWord;
        this.pontos = pontos;
        this.hasWrited = false;
    }

    public int getPontos() {
        return pontos;
    }

    public void increasePoints(){
        this.pontos++;
    }
    public boolean isHasWrited() {
        return hasWrited;
    }
    
    public void switchWriter(){
        this.hasWrited = true;
    }
    
    public String toString(){
        return this.passWord+";"+this.pontos;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }
    

    public String getMessageLogon(){
        return "Logado em "+this.userName;
    }

    @Override
    public int compareTo(User outroUser) {
        return Integer.compare(this.getPontos(), outroUser.getPontos());
    }
}
