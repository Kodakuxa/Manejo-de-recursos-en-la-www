package ReadURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WordInURL {

    public static final String TAG = WordInURL.class.getSimpleName();

    public static final Logger LOG = Logger.getLogger(TAG);

    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";
    //public static final String THE_URL = "http://www.gutenberg.org/cache/epub/29640/";
    //public final String THE_URL = null;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String surl;

        System.out.print(ANSI_PURPLE + "Escriba el URL: " + ANSI_RESET);
        surl = sc.nextLine();

        URL webPage = null;
        try {
            webPage = new URL(surl);
        } catch (MalformedURLException ex) {
            LOG.severe(ex.getMessage());
        }

        // Crear un flujo para leer datos del URL
        BufferedReader htmlReader = null;
        try {
            htmlReader = new BufferedReader(
                    new InputStreamReader(webPage.openStream()));
        } catch (IOException ex) {
            LOG.severe(ex.getMessage());
        }


        //ManejadorEtiquetas(word);
        ProcesaHTML wordin = new ProcesaHTML();
        wordin.procesa(htmlReader);

        /*try {
            while ((htmlLine = htmlReader.readLine()) != null) {
                if (htmlLine.toLowerCase().contains("<br")) {
                    System.out.println(htmlLine);
                } else {
                }
            }
        } catch (IOException ex) {
            LOG.severe(ex.getMessage());
        } finally {
            try {
                if (htmlReader != null) {
                    htmlReader.close();
                }
            } catch (IOException ex) {
                LOG.severe(ex.getMessage());
            }
        }*/

    }
}