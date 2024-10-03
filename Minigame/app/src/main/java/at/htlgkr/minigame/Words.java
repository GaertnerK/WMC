package at.htlgkr.minigame;

public class Words {
    String[] words;

    public Words(){
        words = new String[]{"Adler", "Affen", "Apfel", "Angel", "Autos", "Baum", "Biene", "Blume", "Brot", "Buch", "Chaos", "Clown", "Comic", "Dachs", "Dampf", "Draht", "Drums", "Ecken", "Eisig", "Erde", "Ernte", "Fahne", "Falke", "Faser", "Feuer", "Fuchs", "Farbe", "Garbe", "Gebet", "Geist", "Gelee", "Gabel", "Ganse", "Hafen", "Hafer", "Haare", "Haken", "Hase", "Helme", "Hirse", "Hotel", "Hund", "Hufte", "Kabel", "Kamel", "Kegel", "Kekse", "Kiste", "Klage", "Klare", "Knopf", "Knete", "Kohle", "Komma", "Korb", "Kralle", "Kufen", "Lager", "Lampe", "Lachs", "Lanze", "Laser", "Leben", "Leder", "Licht", "Lowen", "Loffel", "Magen", "Maler", "Mauer", "Melde", "Meile", "Minus", "Mond", "Moped", "Motor", "Nacht", "Nadel", "Nebel", "Niete", "Noten", "Nutze", "Orden", "Ozean", "Parka", "Piste", "Plage", "Poren", "Pulpe", "Quark", "Quell", "Raben", "Rasen", "Reife", "Reise", "Ring", "Ritter", "Rohre", "Raume", "Wolle"};
    }

    public String getOneWord(int i){
        return words[i];
    }
}
