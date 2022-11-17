package ReadURL;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Consumer;

public class ProcesaParrafo extends HTMLEditorKit.ParserCallback {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    private int contador;
    private int contadorword;
    //private char[] cword;
    private boolean inParagraph;
    //private int c = 0;
    //private int pos = 0;
    //private int comparacion = 0;
    private LinkedList<Integer> arraypos;

    String word;

    public ProcesaParrafo(String word) {
        this.word = word;
        //cword = word.toCharArray();
        this.arraypos = new LinkedList<>();
    }

    @Override
    public void handleText(char[] data, int pos) {
        if (inParagraph) {
            String texto = new String(data);
            System.out.print(texto);
            if (texto.contains(word)) {
                contadorword++;
            }

            String[] words = texto.split(" ");

            for (String one : words) {
                //System.out.println(ANSI_YELLOW + one + ANSI_RESET);
                if (one.equals(word)) {
                    //System.out.println(ANSI_PURPLE + one + ANSI_RESET);
                    //System.out.println();
                    pos = pos + 1;
                    arraypos.add(pos);
                } else {
                    pos = pos + 1;
                }
            }
            /*c = 0;
            System.out.println("lenght -> " + cword.length);
            comparacion = 0;
            for (int i = 0; i < texto.length(); i++) { //leer cada caracter del texto
                if (texto.charAt(i) != ' ') {
                    if (texto.charAt(i) == cword[c] && c < word.length()) {
                        System.out.println("cword -> " + cword[c]);
                        pos = pos + 1;
                        if (c < word.length())
                            c++;
                        System.out.println("c -> " + c);
                        comparacion = comparacion + 1;
                    }
                    if (comparacion == word.length()) {
                        arraypos.add(pos - word.length());
                    }
                } else {
                    c = 0;
                    comparacion = 0;
                }
                pos = pos + 1;
            }*/
        }
    }

    @Override
    public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos) {
        if (t == HTML.Tag.P) {
            inParagraph = true;
        }
    }

    @Override
    public void handleEndTag(HTML.Tag t, int pos) {
        if (t == HTML.Tag.P) {
            inParagraph = false;
            System.out.print("\nLine " + contador + ": ");
            contador++;
        }
        if (t == HTML.Tag.BODY) {
            System.out.print(ANSI_PURPLE + "\nTotal de párrafos en documento: " + ANSI_YELLOW + contador + ANSI_RESET);
            System.out.print(ANSI_PURPLE + "\nLa palabra " + ANSI_YELLOW + word + ANSI_PURPLE
                    + " tiene un total de " + ANSI_YELLOW + contadorword + ANSI_PURPLE
                    + " ocurrencias" + ANSI_RESET);
            System.out.print(ANSI_PURPLE + "\nen las posiciones " + ANSI_YELLOW + arraypos + ANSI_RESET);
            /*for (Integer arr : arraypos){
                System.out.print("En la posición " + arr + ", ");
            }*/
        }
    }

}