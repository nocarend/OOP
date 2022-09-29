package ru.nsu.valikov;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.function.Consumer;

public class DFSIteratorTree<T> implements Iterator<T> {
    private Node<T> current;
    private final Stack<Node<T>> dfsStack = new Stack<>();

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    public DFSIteratorTree(Tree<T> tree) {
        this.current = tree.getRoot();
        for (Node<T> autoIt : tree.getRoot().getChildren()) {
            this.dfsStack.push(autoIt);
        }
    }

    @Override
    public boolean hasNext() {
        return !this.dfsStack.empty() || this.current.getChildCount()>0;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public T next() throws NoSuchElementException {
        if (this.current.getValue() != null) {
            for (Node<T> autoIt : this.current.getChildren()) {
                this.dfsStack.push(autoIt);
            }
        }
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.current = dfsStack.pop();
        return this.current.getValue();
    }

    /**
     * Removes from the underlying collection the last element returned
     * by this iterator (optional operation).  This method can be called
     * only once per call to {@link #next}.
     * <p>
     * The behavior of an iterator is unspecified if the underlying collection
     * is modified while the iteration is in progress in any way other than by
     * calling this method, unless an overriding class has specified a
     * concurrent modification policy.
     * <p>
     * The behavior of an iterator is unspecified if this method is called
     * after a call to the {@link #forEachRemaining forEachRemaining} method.
     *
     * @throws UnsupportedOperationException if the {@code remove}
     *                                       operation is not supported by this iterator
     * @throws IllegalStateException         if the {@code next} method has not
     *                                       yet been called, or the {@code remove} method has already
     *                                       been called after the last call to the {@code next}
     *                                       method
     * @implSpec The default implementation throws an instance of
     * {@link UnsupportedOperationException} and performs no other action.
     */
    @Override
    public void remove() {
        this.current.delete();
    }

}
