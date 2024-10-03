package at.htlgkr.minigame;

public class Words {
    String[] words;

    public Words(){
        words = new String[]{"Adler", "Affen", "Apfel", "Angel", "Autos", "Biene", "Blume", "Clown", "Comic", "Dachs", "Dampf", "Draht", "Drums", "Ecken", "Eisig", "Ernte", "Fahne", "Falke", "Faser", "Feuer", "Fuchs", "Farbe", "Garbe", "Gebet", "Geist", "Gelee", "Gabel", "Hafen", "Hafer", "Haare", "Haken", "Helme", "Hirse", "Hotel", "Kabel", "Kamel", "Kegel", "Kekse", "Kiste", "Klage", "Klare", "Knopf", "Knete", "Kohle", "Komma", "Korb", "Kralle", "Kufen", "Lager", "Lampe", "Lachs", "Lanze", "Laser", "Leben", "Leder", "Licht", "Magen", "Maler", "Mauer", "Melde", "Meile", "Minus", "Moped", "Motor", "Nacht", "Nadel", "Nebel", "Niete", "Noten", "Nutze", "Orden", "Ozean", "Parka", "Piste", "Plage", "Poren", "Pulpe", "Quark", "Quell", "Raben", "Rasen", "Reife", "Reise", "Rohre", "Wolle"};
    }

    public String getOneWord(int i){
        return words[i];
    }
}
