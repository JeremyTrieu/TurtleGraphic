package tools;
import java.util.HashSet;
import java.util.Set;
public class Publisher {
    private Set<Subscriber> subscribers;
    public Publisher(){
        subscribers = new HashSet<Subscriber>();
    }

    public void notifySubscriber(){
        for(Subscriber sub : subscribers){
            sub.update();
        }
    }

    public void subscribe(Subscriber s){
        subscribers.add(s);
    }
    public void unsubscribe(Subscriber s){
        subscribers.remove(s);
    }
}
