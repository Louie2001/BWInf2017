/*
 * BWInf - Junioraufgabe 1
 * Aufgabenblatt: https://www.bwinf.de/fileadmin/user_upload/BwInf/2017/36/1._Runde/Aufgaben/BWINF_36_Aufgaben_WEB.pdf
 * Material für Testeingaben: https://www.bwinf.de/bundeswettbewerb/der-36-bwinf/1-runde/material-361/
 *
 * Gegeben ist eine Vorgabe an Dekofiguren und eine Anzahl an Buechern und die Hoehe der einzelnen Buecher.
 * Die Buecher sollen so gruppiert werden, dass der maximale Abstand zwischen kleinstem und groesstem Buch 30mm ist.
 * Zwischen den Gruppen steht jeweils eine Dekofigur. Es gibt also Dekofiguren+1 Abtrennungen.
 *
 * Die Aufgabe soll zum Testen von netbeans, github und junit verwendet werden.
 * Eine Loesung ist zu entwerfen, kommentierte Methoden sind zu erstellen und vor deren Implementierung sind Testfaelle in junit zu bauen.
 */
package junior1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 *
 * @author koeppen
 */
public class Buecherregal {

    int anzahlDekofiguren;
    ArrayList<Integer> buecher;
    ArrayList<Integer> gruppen;

    public Buecherregal() {
        buecher = new ArrayList();
        gruppen = new ArrayList();
    }

    public Buecherregal(int aDeko, ArrayList<Integer> dieBuecher) {
        anzahlDekofiguren = aDeko;
        buecher = dieBuecher;
    }

    public void dateiNachAufgabe() {
        JFileChooser jfc = new JFileChooser();
        int returnVal = jfc.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File f = jfc.getSelectedFile();
            BufferedReader in = null;
            try {
                in = new BufferedReader(new FileReader(f));
                String zeile = null;
                int anzahlZeile = 0;
                while ((zeile = in.readLine()) != null) {
                    anzahlZeile = anzahlZeile + 1;
                    System.out.println("Gelesene Zeile: " + zeile);
                    if (anzahlZeile == 1) { // erste Zeile: Anzahl Dekofiguren
                        anzahlDekofiguren = Integer.parseInt(zeile);
                    } else {
                        if (anzahlZeile != 2) { //zweite Zeile: Anzahl Buecher, Alle weiteren Zeilen sind die Buecherhoehen
                            buecher.add(Integer.parseInt(zeile));
                        }
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
    }

    public void dateiNachAufgabeMitDatei(File f) {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(f));
            String zeile = null;
            int anzahlZeile = 0;
            while ((zeile = in.readLine()) != null) {
                anzahlZeile = anzahlZeile + 1;
                System.out.println("Gelesene Zeile: " + zeile);
                if (anzahlZeile == 1) { // erste Zeile: Anzahl Dekofiguren
                    anzahlDekofiguren = Integer.parseInt(zeile);
                } else {
                    if (anzahlZeile > 2) { //zweite Zeile: Anzahl Buecher, Alle weiteren Zeilen sind die Buecherhoehen
                        buecher.add(Integer.parseInt(zeile));
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public void gruppiere() {
        //Begonnen beim Minimum der Liste werden die Buecher elementweise übernommen
        //Das aktuelle Minimum wird gemerkt
        //Ist der Unterschied zum Minimum groesser als 30, dann wird eine -1 (als Dekofigur) eingefuegt
        //Das naechste Buch ist das neue Minimum

        int min = buecher.get(0);
        for (int i=0; i < buecher.size(); i++) {
            if(buecher.get(i)<= min+30) {
                gruppen.add(buecher.get(i));
            }else{
                gruppen.add(-1);
                min=buecher.get(i);
                i=i-1;
                
            } 
            
        }
    }
// int buecherh : buecher
    public boolean loesungErlaubt() {
        //Ist die Anzahl der gruppen hoechstens die Anzahl der dekofiguren+1?
        return false;
    }

    @Override
    public String toString() {
        //schoene Ausgabe der Buecher erzeugen
        String ausgabe = "";
        return ausgabe;
    }

    public static void main(String[] args) {
        Buecherregal b = new Buecherregal();
        b.dateiNachAufgabe();
    }
}
