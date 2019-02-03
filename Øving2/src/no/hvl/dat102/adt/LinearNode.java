package no.hvl.dat102.adt;

/**
 * LinearNode
 */
public class LinearNode<T> {

    private LinearNode<T> neste;
    private T element;

    /**
     * Opprettar ein tom node
     */
    public LinearNode() {
        this(null);
    }

    /**
     * Opprettar ein node med eit element
     * @param elem
     */
    public LinearNode(T elem) {
        element = elem;
        neste = null;
    }

    /**
     * @return elementet
     */
    public T getElement() {
        return element;
    }

    /**
     * @param element 
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * @return 
     */
    public LinearNode<T> getNeste() {
        return neste;
    }

    /**
     * @param neste 
     */
    public void setNeste(LinearNode<T> neste) {
        this.neste = neste;
    }
}