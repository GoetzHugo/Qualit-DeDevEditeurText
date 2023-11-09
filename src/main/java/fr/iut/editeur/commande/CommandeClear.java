package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeClear extends CommandeDocument {

    public CommandeClear(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        if (parameters.length < 1) {
            System.err.println("Format attendu : clear");
            return;
        }

        document.clear();
        super.executer();
    }
}