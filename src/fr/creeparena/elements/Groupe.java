package fr.creeparena.elements;
import java.util.LinkedList;

// classe modèle générique de collection d'objets
public abstract class Groupe<E> {
    
    private LinkedList<E> elements = new LinkedList<E>();
    
    public void ajouter(E element) {
        elements.add(element);
    }
    public LinkedList<E> getElements() {
        return elements;
    }
}
