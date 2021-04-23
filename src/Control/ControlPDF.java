/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.AbstractItem;
import Model.User;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class ControlPDF {

    private static PDDocument document = new PDDocument();
    private static PDPageContentStream contentStream = null;
    private static PDFont fonte = PDType1Font.HELVETICA_BOLD;

    public static void adicionaItensPDF(Hashtable<Integer, AbstractItem> hashItens, Hashtable<String, User> hashUsuarios) throws IOException {
        PDPage pagina = new PDPage();
        document.addPage(pagina);
        PDImageXObject image = null;
        float alturaPagina = pagina.getMediaBox().getHeight();
        try {
            contentStream = new PDPageContentStream(document, pagina);
            Set<Integer> chavesItens = hashItens.keySet();
            alturaPagina = alturaPagina - 100;
            ///Adicionando o titulo da pag

            contentStream.beginText();
            contentStream.setFont(fonte, 14);
            contentStream.setLeading(14.5f);
            contentStream.newLineAtOffset((pagina.getMediaBox().getWidth() / 2) - 75, alturaPagina);
            contentStream.showText("ITENS");
            contentStream.newLine();
            alturaPagina = alturaPagina - 80;
            contentStream.endText();

            ///Fim titulo
            for (Integer key : chavesItens) {
                if (alturaPagina < 0) {
                    contentStream.close();
                    pagina = new PDPage();
                    document.addPage(pagina);
                    contentStream = new PDPageContentStream(document, pagina);
                    alturaPagina = pagina.getMediaBox().getHeight();
                    alturaPagina = alturaPagina - 100;
                }
                contentStream.beginText();
                contentStream.setFont(fonte, 12);
                contentStream.setLeading(14.5f);
                contentStream.newLineAtOffset(25, alturaPagina);
                contentStream.showText(hashItens.get(key).Message());
                contentStream.newLine();
                alturaPagina = alturaPagina - 180;
                contentStream.endText();
                try {
                    image = PDImageXObject.createFromFile(hashItens.get(key).getEndereco_Foto(), document);
                } catch (FileNotFoundException e) {
                    image = null;
                } finally {
                    if (image != null) {
                        if (image.getHeight() < 200) {
                            if (alturaPagina - image.getHeight() >= 0) {
                                contentStream.drawImage(image, (pagina.getMediaBox().getWidth() / 2) - 75, alturaPagina);
                                alturaPagina = alturaPagina - 25;
                            } else {
                                contentStream.close();
                                pagina = new PDPage();
                                document.addPage(pagina);
                                contentStream = new PDPageContentStream(document, pagina);
                                alturaPagina = pagina.getMediaBox().getHeight();
                                alturaPagina = alturaPagina - image.getHeight();
                                contentStream.drawImage(image, (pagina.getMediaBox().getWidth() / 2) - 75, alturaPagina);
                                alturaPagina = alturaPagina - 25;
                            }
                        } else {
                            contentStream.beginText();
                            contentStream.setFont(fonte, 8);
                            contentStream.setLeading(14.5f);
                            alturaPagina = alturaPagina + 160;
                            contentStream.newLineAtOffset((pagina.getMediaBox().getWidth() / 2) - 75, alturaPagina);
                            contentStream.showText("Altura da imagem não suportada");
                            contentStream.newLine();
                            contentStream.endText();
                        }
                    } else if (image == null) {
                        contentStream.beginText();
                        contentStream.setFont(fonte, 8);
                        contentStream.setLeading(14.5f);
                        alturaPagina = alturaPagina + 160;
                        contentStream.newLineAtOffset((pagina.getMediaBox().getWidth() / 2) - 75, alturaPagina);
                        contentStream.showText("Sem imagem");
                        contentStream.newLine();
                        contentStream.endText();
                    }
                    alturaPagina = alturaPagina - 25;
                }
            }
            contentStream.close();
            contentStream = null;
            adicionaRankingPDF(hashUsuarios);
            document.save("Arquivos/Relatório.pdf");
            document.close();
            System.out.println("Adicionado itens");
        } catch (IOException e) {
            throw new IOException();
        }
    }

    public static void adicionaRankingPDF(Hashtable<String, User> hashUsuarios) throws IOException {
        PDPage pagina = new PDPage();
        int cont = 1;
        ArrayList<User> ranking = new ArrayList<>();
        document.addPage(pagina);
        float alturaPagina = pagina.getMediaBox().getHeight();
        try {
            contentStream = new PDPageContentStream(document, pagina);
            Set<String> chavesUsuarios = hashUsuarios.keySet();
            alturaPagina = alturaPagina - 100;
            for (String key : chavesUsuarios) {
                User u = hashUsuarios.get(key);
                ranking.add(u);
            }
            Collections.sort(ranking, Collections.reverseOrder());
            contentStream.beginText();
            contentStream.setFont(fonte, 14);
            contentStream.setLeading(14.5f);
            contentStream.newLineAtOffset((pagina.getMediaBox().getWidth() / 2) - 75, alturaPagina);
            contentStream.showText("RANKING");
            contentStream.newLine();
            alturaPagina = alturaPagina - 80;
            contentStream.endText();
            
            for (User u : ranking) {
                contentStream.beginText();
                contentStream.setFont(fonte, 12);
                contentStream.setLeading(14.5f);
                contentStream.newLineAtOffset(25, alturaPagina);
                contentStream.showText(cont + "º lugar = " + u.getUserName() + " com " + u.getPontos() + " pontos");
                contentStream.newLine();
                alturaPagina = alturaPagina - 25;
                contentStream.endText();
                cont++;
            }
            contentStream.close();

        } catch (IOException ex) {
            throw new IOException();
        }
    }
}
