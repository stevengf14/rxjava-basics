package ec.com.learning.rxjava.calback;

/**
 *
 * @author Steven Guamán - February 2023
 */
public interface CallBack {

    void pushData(String data);

    void pushComplete();

    void pushError(Exception ex);

}
