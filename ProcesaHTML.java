package ReadURL;

import javax.swing.text.html.HTMLEditorKit;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class ProcesaHTML {

    public static final Logger LOG = Logger.getLogger(ProcesaHTML.class.getName());
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void procesa(BufferedReader html) {
        String word;
        Scanner sc = new Scanner(System.in);
       /* if( args.length == 0 ) {
            LOG.severe("Falto incluir documento HTML");
            System.exit(1);
        }*/

        //FileReader fileReader = null;

       /* try {
            fileReader = new FileReader( html );
        } catch (FileNotFoundException e) {
            LOG.severe("No se puede abrr documento HTML");
            System.exit(2);
        }*/

        HTMLParser p = new HTMLParser();

        HTMLEditorKit.Parser procesador = p.getParser();
        System.out.print(ANSI_PURPLE + "Escriba la palabra a buscar: " + ANSI_RESET);
        word = sc.nextLine();


        try {
            // procesador.parse( fileReader, new ManejadorEtiquetas(), true);
            procesador.parse(html, new ProcesaParrafo(word), true);
        } catch (IOException e) {
            LOG.severe("No se puede leer documento HTML");
            System.exit(2);
        }
    }
}