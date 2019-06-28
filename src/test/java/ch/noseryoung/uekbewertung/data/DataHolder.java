/**
 * 
 */
package ch.noseryoung.uekbewertung.data;

import java.util.List;

/*
 * This class includes methods for datainput
 * @author lohse
 *
 */
public class DataHolder<T> {

	/**
	 * 
	 * @param first
	 * @param second
	 * @param third
	 * @return methods
	 */
    static <T> DataHolder<T> of (T first, T second, T third) {
        return new DataHolder<>(first, second, third);
    }

    private List<T> data;

    /**
     * 
     * @param first
     * @param second
     * @param third
     */
    private DataHolder(T first, T second, T third) {
        this.data = List.of(first, second, third);
    }

    /**
     * 
     * @return first datainput
     */
    public T first() {
        return data.get(0);
    }

    /**
     * 
     * @return second datainput
     */
    public T second() {
        return data.get(1);
    }

    /**
     * 
     * @return third datainput
     */
    public T third() {
        return data.get(2);
    }

    /**
     * 
     * @return fourth datainput
     */
    public List<T> asList() {
        return data;
    }
}
