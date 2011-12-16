package org.paukov.combinatorics.subsets;

import org.paukov.combinatorics.CombinatoricsVector;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.Iterator;

/**
 * Iterator over the all subsets
 * 
 * @param <T>
 *            Type of elements of subset
 */
public class SubSetIterator<T> extends Iterator<CombinatoricsVector<T>> {

    /**
     * Subset generator
     */
    protected final Generator<T> _generator;

    /**
     * Current subset
     */
    protected CombinatoricsVector<T> _currentSubSet = null;

    /**
     * Index of the current subset
     */
    protected long _currentIndex = 0;

    /**
     * Size of the subset
     */
    protected final int _length;

    /**
     * internal bit vector, representing the subset
     */
    private int[] _bitVector = null;

    /**
     * Constructor
     * 
     * @param generator
     *            The subset generator
     */
    public SubSetIterator(Generator<T> generator) {
	_generator = generator;
	_length = generator.getCoreObject().getSize();
	_currentSubSet = new CombinatoricsVector<T>();
	_bitVector = new int[_length + 2];
	init();
    }

    /**
     * initialize the iterator
     * 
     * @see org.paukov.combinatorics.iterator.Iterator#first()
     */
    private void init() {
	_currentIndex = 0;
	for (int i = 0; i <= _length + 1; i++) {
	    _bitVector[i] = 0;
	}

    }

    /**
     * Returns the current subset
     * 
     * @see org.paukov.combinatorics.iterator.Iterator#getCurrentItem()
     */
    @Override
    public CombinatoricsVector<T> getCurrentItem() {
	return _currentSubSet;
    }

    /**
     * Returns true if iteration is done, otherwise false
     * 
     * @see org.paukov.combinatorics.iterator.Iterator#isDone()
     */
    @Override
    public boolean isDone() {
	return _bitVector[_length + 1] == 1;
    }

    /**
     * Returns the next subset if it is available
     * 
     * @see org.paukov.combinatorics.iterator.Iterator#next()
     */
    @Override
    public CombinatoricsVector<T> next() {
	_currentIndex++;
	_currentSubSet.getVector().clear();
	for (int index = 1; index <= _length; index++) {
	    if (_bitVector[index] == 1) {
		T value = _generator.getCoreObject().getValue(index - 1);
		_currentSubSet.getVector().add(value);
	    }
	}
	int i = 1;
	while (_bitVector[i] == 1) {
	    _bitVector[i] = 0;
	    i++;
	}
	_bitVector[i] = 1;

	return getCurrentItem();
    }

    /**
     * Convert
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "SubSetIterator=[#" + _currentIndex + ", " + _currentSubSet
		+ "]";
    }

}