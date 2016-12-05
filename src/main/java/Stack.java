import java.util.LinkedList;
import java.util.List;

/**
 * Created by dvalo on 05.12.2016.
 */
public class Stack {

    private LinkedList<GrammarElement> list = new LinkedList<>();

    public void push (GrammarElement element){
        list.addFirst(element);
    }
    public GrammarElement pop (){
        return list.pop();
    }

    public GrammarElement peek (){
        return list.peekFirst();
    }

    public String toString(){
        return list.toString();
    }

    public GrammarElement peekSecond(){

        if(list.size()>=1) {
            return list.get(1);
        }
        return null;
    }

    public LinkedList<GrammarElement> getList() {
        return list;
    }
}
