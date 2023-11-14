package fr.iut.editeur.document;

/**
 * Classz Document permet de créer, supprimer, modifier, mettre en majuscules et minuscules
 */
public class Document {

    private String texte;

    public Document() {
        this.texte = "";
    }
	
    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public void ajouter(String texte) {
        this.texte += texte;
    }

    @Override
    public String toString() {
        return this.texte;
    }
    /**
     * Remplacer remplace le texte du document entre l'intervalle start et end par les caractere remplacement
     * @param start début du texte a remplacer
     * @param end fin du texte a remplacer
     * @param remplacement texte de remplacement
     */
    public void remplacer(int start, int end, String remplacement) {
        String leftPart = texte.substring(0, start);
        String rightPart = texte.substring(end);
        texte = leftPart + remplacement + rightPart;
    }

    public void majuscules(int start, int end) {
        if (start < 0 || start >= end || end > texte.length()) {
            System.err.println("Indices non valides pour la mise en majuscules.");
            return;
        }

        String portionEnMajuscules = texte.substring(start, end).toUpperCase();
        remplacer(start, end, portionEnMajuscules);
    }

    public void effacer(int start, int end) {
        if (start < 0 || start >= end || end > texte.length()) {
            System.err.println("Indices non valides pour l'effacement.");
            return;
        }

        texte = texte.substring(0, start) + texte.substring(end);
    }

    public void clear() {
        texte = "";
    }


}


