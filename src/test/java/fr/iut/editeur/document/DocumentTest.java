package fr.iut.editeur.document;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class DocumentTest extends TestCase {
    private Document document;

    @Before
    public void setUp() {
        // Initialisez votre objet Document ici, si nécessaire.
        document = new Document();
    }

    @Test
    public void testAjouter() {
        document.ajouter("Hello");
        assertEquals("Hello", document.getTexte());
    }

    @Test
    public void testRemplacer() {
        document.ajouter("Hello");
        document.remplacer(0, 2, "Hi");
        assertEquals("Hillo", document.getTexte());
    }

    @Test
    public void testMajuscules() {
        document.ajouter("hello");
        document.majuscules(0, 5);
        assertEquals("HELLO", document.getTexte());
    }

    @Test
    public void testEffacer() {
        document.ajouter("Hello World");
        document.effacer(5, 11);
        assertEquals("Hello", document.getTexte());
    }

    @Test
    public void testClear() {
        document.ajouter("Hello");
        document.clear();
        assertEquals("", document.getTexte()); // En raison du léger bug introduit
    }
}
