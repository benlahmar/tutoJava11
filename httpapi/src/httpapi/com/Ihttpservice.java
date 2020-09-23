/**
 * 
 */
package httpapi.com;

/**
 * @author BEN LAHMAR EL HABIB
 * @param <T>
 * @param <K>
 *
 */
public interface Ihttpservice<T, K> {

	public T getdata(String url);
	public T getDataById(K id);
	public void deletedata(K id);
}
