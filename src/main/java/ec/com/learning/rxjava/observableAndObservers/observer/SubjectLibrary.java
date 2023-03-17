package ec.com.learning.rxjava.observableAndObservers.observer;

/**
 *
 * @author Steven Guamán - February 2023
 */
public interface SubjectLibrary {
    
    public void subscribeObserver(Observer obj);
    
    public void unsubscribeObserver(Observer obj);
    
    public void notifyObserver();
    
}
