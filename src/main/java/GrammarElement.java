/**
 * Created by dvalo on 05.12.2016.
 */
public abstract class GrammarElement {

    protected String symbol = "";
    protected String textualRepresentation = "";



    public String getTextualRepresentation() {
        return textualRepresentation;
    }

    public void setTextualRepresentation(String textualRepresentation) {
        this.textualRepresentation = textualRepresentation;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String toString(){
        return this.symbol;
    }
}
