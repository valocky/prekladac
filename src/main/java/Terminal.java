import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class Terminal extends GrammarElement {

    static Logger log = Logger.getLogger(Terminal.class.getName());

    public Terminal(String textualRepresentation) {
        this.textualRepresentation = textualRepresentation;

        switch (textualRepresentation){
            case "BEGIN":
                symbol = "a";
                break;
            case "END":
                symbol = "b";
                break;
            case ":=":
                symbol = "c";
                break;
            case ";":
                symbol = "d";
                break;
            case "READ":
                symbol = "e";
                break;
            case "(":
                symbol = "f";
                break;
            case ")":
                symbol = "g";
                break;
            case "WRITE":
                symbol = "h";
                break;
            case "IF":
                symbol = "i";
                break;
            case "THEN":
                symbol = "j";
                break;
            case "ELSE":
                symbol = "k";
                break;
            case ",":
                symbol = "l";
                break;
            case "+":
                symbol = "m";
                break;
            case "-":
                symbol = "o";
                break;
            case "OR":
                symbol = "p";
                break;
            case "NOT":
                symbol = "r";
                break;
            case "TRUE":
                symbol = "s";
                break;
            case "FALSE":
                symbol = "t";
                break;
            case "AND":
                symbol = "q";
                break;
            default:

                boolean isDigit = textualRepresentation.matches("[0-9]+");
                boolean isLetter = textualRepresentation.matches("[a-z,A-Z][a-z,A-Z,0-9]*");

                if(isDigit){

                    if(textualRepresentation.startsWith("0")){
                        //digit 0-9 -return exception
                    }else{
                        symbol = "u";
                    }

                } else if(isLetter){
                    symbol = "z";
                } else {
                    symbol = "UNKNOWN";
                }

                break;

        }

    }

    public Terminal(char symbol) {
        this.symbol = String.valueOf(symbol);

        switch (symbol){
            case 'a':
                textualRepresentation = "BEGIN";
                break;
            case 'b':
                textualRepresentation = "END";
                break;
            case 'c':
                textualRepresentation = ":=";
                break;
            case 'd':
                textualRepresentation = ";";
                break;
            case 'e':
                textualRepresentation = "READ";
                break;
            case 'f':
                textualRepresentation = "(";
                break;
            case 'g':
                textualRepresentation = ")";
                break;
            case 'h':
                textualRepresentation = "WRITE";
                break;
            case 'i':
                textualRepresentation = "IF";
                break;
            case 'j':
                textualRepresentation = "THEN";
                break;
            case 'k':
                textualRepresentation = "ELSE";
                break;
            case 'l':
                textualRepresentation = ",";
                break;
            case 'm':
                textualRepresentation = "+";
                break;
            case 'o':
                textualRepresentation = "-";
                break;
            case 'p':
                textualRepresentation = "OR";
                break;
            case 'r':
                textualRepresentation = "NOT";
                break;
            case 's':
                textualRepresentation = "TRUE";
                break;
            case 't':
                textualRepresentation = "FALSE";
                break;
            case 'q':
                textualRepresentation = "AND";
                break;
            case 'z':
                textualRepresentation = "variableName";
                break;
            case 'u':
                textualRepresentation = "numberValue";
                break;
            case 'x':
                textualRepresentation = "error_revocery_terminal";
                break;

        }

    }

}
