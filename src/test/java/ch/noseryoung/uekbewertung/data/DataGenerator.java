/**
 * 
 */
package ch.noseryoung.uekbewertung.data;

/**
 * @author lohse
 *
 */
public interface DataGenerator<T> {

	DataHolder<T> generate();
}
