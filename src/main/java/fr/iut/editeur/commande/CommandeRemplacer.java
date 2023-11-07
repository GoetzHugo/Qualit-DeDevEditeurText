package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeRemplacer extends CommandeDocument {

    public CommandeRemplacer(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        if (parameters.length < 3) {
            System.err.println("Format attendu : remplacer;depart;fin;chaine");
            return;
        }

        try {
            int depart = Integer.parseInt(parameters[1]);
            int fin = Integer.parseInt(parameters[2]);
            String chaine = "";
            if (parameters.length > 3){
                chaine = parameters[3];
            }
            String texteDocument = document.getTexte();

            if (depart < 0 || depart >= texteDocument.length() || fin <= depart || fin > texteDocument.length()) {
                System.err.println("Indices de départ et de fin non valides.");
                return;
            }

            document.remplacer(depart, fin, chaine);
            super.executer();
        } catch (NumberFormatException e) {
            System.err.println("Les indices de départ et de fin doivent être des nombres entiers.");
        }
    }
}
