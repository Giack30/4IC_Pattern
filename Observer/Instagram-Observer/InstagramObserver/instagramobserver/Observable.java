package instagramobserver;

public interface Observable { 
    
    public void registerObserver(Observer observer);
    
    public void notifyObserver();
    
    public void unRegisterObserver(Observer observer);
    
    public Object getUpdate();

    public void proponiFollow(Observer aThis);
}
