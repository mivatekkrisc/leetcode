package leecode;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iter;
    Integer top = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iter = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (top == null)
            top = iter.next();
        return top;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (top != null) {
            int value = top.intValue();
            top = null;
            return value;
        }
        return iter.next();
    }

    @Override
    public boolean hasNext() {
        return top != null || iter.hasNext();
    }
}
