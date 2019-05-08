/**
 * 
 */
package ch.noseryoung.uekbewertung.data;

/**
 * This class include the method to genereate datainput
 * @author lohse
 *
 */
public interface DataGenerator<T> {

	DataHolder<T> generate();
}
