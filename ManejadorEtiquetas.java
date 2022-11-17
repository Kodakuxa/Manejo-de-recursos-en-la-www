package ReadURL;
import javax.management.ObjectName;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;

import java.util.Enumeration;

public class ManejadorEtiquetas   extends HTMLEditorKit.ParserCallback  {

    @Override
    public void handleText(char[] data, int pos) {
        String texto = new String( data );
        texto.replace("\n","");
        System.out.println("\t" + texto );
    }

    @Override
    public void handleStartTag(HTML.Tag tag, MutableAttributeSet attributes, int pos) {
        String tagName = tag.toString().toUpperCase();

        int n = attributes.getAttributeCount();

        System.out.printf("%s: %d%n", tagName, n );


        Enumeration a =  attributes.getAttributeNames();

        while ( a.hasMoreElements() ) {
            Object atribName = a.nextElement();

            System.out.printf("%s = %s%n", atribName.toString(),
                    attributes.getAttribute (atribName )  );
        }
    }

    @Override
    public void handleSimpleTag(HTML.Tag tag, MutableAttributeSet attributes, int pos) {
        String tagName = tag.toString().toUpperCase();
        int n = attributes.getAttributeCount();

        System.out.printf("%s: %d%n", tagName, n );

        Enumeration a = attributes.getAttributeNames();

        while ( a.hasMoreElements() ) {
            Object atribName = a.nextElement();

            System.out.printf("%s = %s%n", atribName.toString(),
                    attributes.getAttribute (atribName )  );
        }
    }
}