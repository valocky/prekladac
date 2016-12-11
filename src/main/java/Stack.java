import java.util.LinkedList;


public class Stack {

    private LinkedList<GrammarElement> list = new LinkedList<>();

    public void push (GrammarElement element){
        list.addFirst(element);
    }
    public GrammarElement pop (){
        try {
            return list.pop();
        } catch (Exception e){
            return null;
        }
    }

    public GrammarElement peek (){
        try {
            return list.peekFirst();
        } catch (Exception e){
            return null;
        }
    }

    public String toString(){
        return list.toString();
    }

    public String output(){
        if(list.size() == 0){
            return "[ ]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(GrammarElement g : list){
            sb.append(" "+g.getTextualRepresentation()+",");
        }
        sb.setLength(sb.length() - 1);
        sb.append(" ]");
        return sb.toString();
    }

    public GrammarElement peekSecond(){

        if(list.size()>=2) {
            return list.get(1);
        }
        return null;
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public LinkedList<GrammarElement> getList() {
        return list;
    }
}
