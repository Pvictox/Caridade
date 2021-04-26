/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.ControlFile;
import Control.UserNameUsageException;
import Control.ErrorAddressException;
import Control.ControlItem;
import Control.ControlPDF;
import Control.ControlUser;
import Model.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    /*
    * 
    *  Algumas imagens estão disponíveis na pasta Imagens (todas são JPEG)
    *
     */
    public static void main(String[] args) {
        int op = 1, op2 = 0;
        boolean modItem = false;
        boolean modUser = false;
        Hashtable<String, User> hashUsuarios = new Hashtable<>();
        Hashtable<Integer, AbstractItem> hashItens = new Hashtable<>();
        //hashUsuarios.put("Pedro", new User("Pedro", "123")); // caso de teste

        while (op < 7) {
            String endereco = "";
            if (ControlFile.existsFile("Arquivos/Itens.txt")) {
                try {
                    ControlFile.readFile(hashItens, "Arquivos/Itens.txt", 0);
                } catch (UnsupportedEncodingException e) {
                    System.out.println("Codificação não suportada");
                } catch (IOException e) {
                    System.out.println("Erro na manipulação dos arquivos");
                } catch (ErrorAddressException e) {
                    System.out.println("Erro na alocação do endereço da imagem");
                }

            }
            if (ControlFile.existsFile("Arquivos/Users.txt")) {
                try {
                    ControlFile.readFile(hashUsuarios, "Arquivos/Users.txt", 1);
                } catch (UnsupportedEncodingException e) {
                    System.out.println("Codificação não suportada");
                } catch (IOException e) {
                    System.out.println("Erro na manipulação dos arquivos");
                } catch (ErrorAddressException e) {
                    System.out.println("Erro na alocação do endereço da imagem");
                }
            }
            System.out.println("1 - Doar Item\n2 - Retirar Item\n3 - Itens disponíveis\n4 - Itens Alocados\n5 - Mostra Ranking\n6 - Relatório");
            op = Leitor.leInteiro();
            switch (op) {
                case 1:
                    System.out.println("1 - Login\n2 - Cadastro");
                    op2 = Leitor.leInteiro();
                    String nome = "",
                     pass = "";
                    switch (op2) {
                        case 1:
                            System.out.println("Digite o userName");
                            nome = Leitor.leString();
                            System.out.println("Digite a senha");
                            pass = Leitor.leString();
                            User loginUser = ControlUser.hasUser(nome, pass, hashUsuarios);
                            if (loginUser != null) {
                                System.out.println(loginUser.getMessageLogon());
                                String tipo = "";
                                System.out.println("1 - Vestuário\n2 - Brinquedos\n3 - Comida\n4 - Eletros");
                                op2 = Leitor.leInteiro();
                                switch (op2) {
                                    case 1:
                                        System.out.println("Digite o tipo de vestuário");
                                        tipo = Leitor.leString();
                                        System.out.println("Digite o tamanho");
                                        String tamanho = Leitor.leString();
                                        System.out.println("Digite o endereço da imagem ");
                                        endereco = Leitor.leString();
                                        try {
                                            Vestuario v = new Vestuario(hashItens.size(), "Disponível", endereco, tipo, tamanho);
                                            hashItens.put(hashItens.size(), v);
                                            loginUser.increasePoints();
                                            try {
                                                ControlFile.writeFile("Arquivos/Itens.txt", hashItens, 0);
                                                ControlFile.writeFile("Arquivos/Users.txt", hashUsuarios, 1);
                                            } catch (IOException ex) {
                                                System.out.println("Erro ao manipular");
                                            }

                                        } catch (ErrorAddressException e) {
                                            System.out.println("Erro no endereço motivo: " + e.toString());
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Digite o nome do brinquedo");
                                        tipo = Leitor.leString();
                                        System.out.println("Endereço da imagem");
                                        endereco = Leitor.leString();
                                        System.out.println("Condição do brinquedo");
                                        String cond = Leitor.leString();
                                        try {
                                            Brinquedos b = new Brinquedos(hashItens.size(), "Disponível", endereco, tipo, cond);
                                            hashItens.put(hashItens.size(), b);
                                            loginUser.increasePoints();
                                            try {
                                                ControlFile.writeFile("Arquivos/Itens.txt", hashItens, 0);
                                                ControlFile.writeFile("Arquivos/Users.txt", hashUsuarios, 1);
                                            } catch (IOException ex) {
                                                System.out.println("Erro ao manipular");
                                            }

                                        } catch (ErrorAddressException e) {
                                            System.out.println("Erro no endereço motivo: " + e.toString());
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Qual o tipo de comida");
                                        tipo = Leitor.leString();
                                        System.out.println("Quantidade fornecida");
                                        int quant = Leitor.leInteiro();
                                        System.out.println("Endereço da imagem");
                                        endereco = Leitor.leString();
                                        try {
                                            Comida c = new Comida(hashItens.size(), "Disponível", endereco, tipo, quant);
                                            hashItens.put(hashItens.size(), c);
                                            loginUser.increasePoints();
                                            try {
                                                ControlFile.writeFile("Arquivos/Itens.txt", hashItens, 0);
                                                ControlFile.writeFile("Arquivos/Users.txt", hashUsuarios, 1);
                                            } catch (IOException ex) {
                                                System.out.println("Erro ao manipular");
                                            }

                                        } catch (ErrorAddressException e) {
                                            System.out.println("Erro no endereço motivo: " + e.toString());
                                        }
                                        break;
                                    case 4:
                                        System.out.println("Qual o Eletrônico");
                                        tipo = Leitor.leString();
                                        System.out.println("Tempo de uso (anos)");
                                        int temp = Leitor.leInteiro();
                                        System.out.println("Endereço da imagem");
                                        endereco = Leitor.leString();
                                        try {
                                            Eletros e = new Eletros(hashItens.size(), "Disponível", endereco, tipo, temp);
                                            hashItens.put(hashItens.size(), e);
                                            loginUser.increasePoints();
                                            try {
                                                ControlFile.writeFile("Arquivos/Itens.txt", hashItens, 0);
                                                ControlFile.writeFile("Arquivos/Users.txt", hashUsuarios, 1);
                                            } catch (IOException ex) {
                                                System.out.println("Erro ao manipular");
                                            }

                                        } catch (ErrorAddressException e) {
                                            System.out.println("Erro no endereço motivo: " + e.toString());
                                        }
                                        break;
                                    default:
                                        break;
                                }// Fim switch 2
                            } else {
                                System.out.println("Não está cadastrado");
                            }
                            break;
                        case 2:
                            boolean flag = true;
                            while (flag) {
                                nome = "";
                                System.out.println("Digite o userName:");
                                nome = Leitor.leString();
                                try {
                                    ControlUser.checkUserNameUsage(nome, hashUsuarios);
                                    flag = false;
                                } catch (UserNameUsageException e) {
                                    System.out.println(e.toString());
                                }
                            }
                            System.out.println("Digite a senha");
                            pass = Leitor.leString();
                            hashUsuarios.put(nome, new User(nome, pass, 0));
                            try {
                                ControlFile.writeFile("Arquivos/Users.txt", hashUsuarios, 1);
                            } catch (IOException ex) {
                                System.out.println("Erro ao manipular arquivo");
                            }
                            break;

                        default:
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Digite o nome do item que procura");
                    nome = Leitor.leString();
                    if (ControlItem.queryALLItensByName(hashItens, nome)) {
                        System.out.println("Digite o ID do item");
                        int IDItem = Leitor.leInteiro();
                        if (ControlItem.switchStatusItem(hashItens, IDItem) == false) {
                            System.out.println("Erro");
                        } else {
                            System.out.println("Mudança feita");
                            try {
                                ControlFile.writeFile("Arquivos/Itens.txt", hashItens, 0);
                            } catch (IOException ex) {
                                System.out.println("Erro ao manipular");
                            }
                        }
                    } else {
                        System.out.println("Nada encontrado");
                    }
                    break;
                case 3:
                    if (hashItens.isEmpty()) {
                        System.out.println("Não há nenhum item cadastrado");
                    } else {
                        ControlItem.queryItensDisponiveis(hashItens);
                    }
                    break;
                case 4:

                    if (hashItens.isEmpty()) {
                        System.out.println("Não há nenhum item cadastrado");
                    } else {
                        ControlItem.queryItensAlocados(hashItens);
                    }
                    break;
                case 5:
                    if (hashUsuarios.isEmpty()) {
                        System.out.println("Não há usuários cadastrados");
                    } else {
                        ControlUser.showRanking(hashUsuarios);
                    }
                    break;
                case 6: {
                    try {

                        if ((ControlFile.existsFile("Arquivos/Itens.txt") == false || ControlFile.existsFile("Arquivos/Users.txt") == false)) {
                            System.out.println("Erro ao criar relatório. Um dos arquivos está faltando");
                        } else {
                            ControlPDF.adicionaItensPDF(hashItens, hashUsuarios);
                        }
                    } catch (IOException ex) {
                        System.out.println("Erro na manipulação do documento PDF3");
                    }
                }
                break;

                default:
                try {
                    ControlFile.writeFile("Arquivos/Itens.txt", hashItens, 0);
                    ControlFile.writeFile("Arquivos/Users.txt", hashUsuarios, 1);
                } catch (IOException ex) {
                    System.out.println("Erro ao manipular");
                }
                break;
            } // fim switch
        } //Fim while
    }
}
