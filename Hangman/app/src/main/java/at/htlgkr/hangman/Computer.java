package at.htlgkr.hangman;

import java.util.Random;

public class Computer {
    String[] easyWords;
    String[] hardWords;

    public Computer(){
        easyWords =  new String[]{"Adler", "Affen", "Apfel", "Angel", "Autos", "Biene", "Blume", "Clown", "Comic", "Dachs", "Dampf", "Draht", "Drums", "Ecken", "Eisig", "Ernte", "Fahne", "Falke", "Faser", "Feuer", "Fuchs", "Farbe", "Garbe", "Gebet", "Geist", "Gelee", "Gabel", "Hafen", "Hafer", "Haare", "Haken", "Helme", "Hirse", "Hotel", "Kabel", "Kamel", "Kegel", "Kekse", "Kiste", "Klage", "Klare", "Knopf", "Knete", "Kohle", "Komma", "Korb", "Kralle", "Kufen", "Lager", "Lampe", "Lachs", "Lanze", "Laser", "Leben", "Leder", "Licht", "Magen", "Maler", "Mauer", "Melde", "Meile", "Minus", "Moped", "Motor", "Nacht", "Nadel", "Nebel", "Niete", "Noten", "Nutze", "Orden", "Ozean", "Parka", "Piste", "Plage", "Poren", "Pulpe", "Quark", "Quell", "Raben", "Rasen", "Reife", "Reise", "Rohre", "Wolle"};
        hardWords = new String[]{"Abfrage", "Anfangs", "Achtung", "Beispiel", "Befreier", "Blenden", "Brunnen", "Computer", "Dampfen", "Drachen", "Einblick", "Erfinder", "Familie", "Feuerer", "Fliegen", "Formeln", "Fragen", "Freitag", "Gelaende", "Geister", "Gewitter", "Grenzen", "Handlung", "Klammer", "Kommen", "Koerper", "Leuchten", "Leserin", "Loesung", "Menschin", "Muster", "Nadeln", "Nuetzlich", "Ordnung", "Planung", "Punkte", "Rauchen", "Rechner", "Reifen", "Richtung", "Rueckkehr", "Schaden", "Schauen", "Schueler", "Spielen", "Strassen", "Studium", "Tanzen", "Tausend", "Treiben", "Trinken", "Verwandt", "Waldung", "Weggang", "Zeichen", "Zirkeln"};
    }

    public String getRandomEasyWord(){
        Random random = new Random();
        return easyWords[random.nextInt(hardWords.length)];
    }

    public String getRandomHardWord(){
        Random random = new Random();
        return hardWords[random.nextInt(hardWords.length)];
    }
}
