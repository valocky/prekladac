import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dvalo on 05.12.2016.
 */
public abstract class Pravidla {

    public static LinkedList<GrammarElement> applyRuleS(Terminal term){

        LinkedList<GrammarElement> result = new LinkedList<>();

        if(term.getSymbol().equals("a")){

            result.addFirst(new Terminal('b'));
            result.addFirst(new Neterminal("B"));
            result.addFirst(new Terminal('a'));
        }else{
            return null;
        }
        return result;
    }

    public static LinkedList<GrammarElement> applyRuleB(Terminal terminal){

        LinkedList<GrammarElement> result = new LinkedList<>();
        String term = terminal.getSymbol();
        if(term.equals("e") || term.equals("h") || term.equals("i") || term.equals("z")){

            result.addFirst(new Neterminal("X"));
            result.addFirst(new Neterminal("C"));
        }else{
            return null;
        }
        return result;
    }

    public static LinkedList<GrammarElement> applyRuleX(Terminal terminal){

        LinkedList<GrammarElement> result = new LinkedList<>();
        String term = terminal.getSymbol();
        if(term.equals("e") || term.equals("h") || term.equals("i") || term.equals("z")){

            result.addFirst(new Neterminal("X"));
            result.addFirst(new Neterminal("C"));
        }else if(term.equals("b")){
            return result;
        }else{
            return null;
        }
        return result;
    }

    public static LinkedList<GrammarElement> applyRuleC(Terminal terminal){

        LinkedList<GrammarElement> result = new LinkedList<>();
        String term = terminal.getSymbol();
        if(term.equals("z")){

            result.addFirst(new Terminal('d'));
            result.addFirst(new Neterminal("E"));
            result.addFirst(new Terminal('c'));
            result.addFirst(new Neterminal("D"));

        }else if(term.equals("e")){

            result.addFirst(new Terminal('d'));
            result.addFirst(new Terminal('g'));
            result.addFirst(new Neterminal("F"));
            result.addFirst(new Terminal('f'));
            result.addFirst(new Terminal('e'));

        }else if(term.equals("h")){

            result.addFirst(new Terminal('d'));
            result.addFirst(new Terminal('g'));
            result.addFirst(new Neterminal("G"));
            result.addFirst(new Terminal('f'));
            result.addFirst(new Terminal('h'));

        }else if(term.equals("i")){

            result.addFirst(new Terminal('d'));
            result.addFirst(new Neterminal("Y"));
            result.addFirst(new Neterminal("C"));
            result.addFirst(new Terminal('j'));
            result.addFirst(new Neterminal("H"));
            result.addFirst(new Terminal('i'));
        }

        return result;
    }

    public static LinkedList<GrammarElement> applyRuleY(Terminal terminal){

        LinkedList<GrammarElement> result = new LinkedList<>();
        String term = terminal.getSymbol();
        if(term.equals("k")){

            result.addFirst(new Neterminal("C"));
            result.addFirst(new Terminal('k'));
        }else if(term.equals("d")){
            return result;
        }else{
            return null;
        }
        return result;
    }

    public static LinkedList<GrammarElement> applyRuleF(Terminal terminal){

        LinkedList<GrammarElement> result = new LinkedList<>();
        String term = terminal.getSymbol();
        if(term.equals("z")){

            result.addFirst(new Neterminal("Z"));
            result.addFirst(new Neterminal("D"));
        }else{
            return null;
        }
        return result;
    }

    public static LinkedList<GrammarElement> applyRuleZ(Terminal terminal){

        LinkedList<GrammarElement> result = new LinkedList<>();
        String term = terminal.getSymbol();
        if(term.equals("l")){

            result.addFirst(new Neterminal("Z"));
            result.addFirst(new Neterminal("D"));
            result.addFirst(new Terminal('l'));
        }else if(term.equals("g")){
            return result;
        }else{
            return null;
        }
        return result;
    }

    public static LinkedList<GrammarElement> applyRuleG(Terminal terminal){

        LinkedList<GrammarElement> result = new LinkedList<>();
        String term = terminal.getSymbol();
        if(term.equals("f") || term.equals("z") || term.equals("m") || term.equals("o") || term.equals("u")){

            result.addFirst(new Neterminal("W"));
            result.addFirst(new Neterminal("E"));

        } else{
            return null;
        }
        return result;
    }

    public static LinkedList<GrammarElement> applyRuleW(Terminal terminal){

        LinkedList<GrammarElement> result = new LinkedList<>();
        String term = terminal.getSymbol();
        if(term.equals("l")){

            result.addFirst(new Neterminal("W"));
            result.addFirst(new Neterminal("E"));
            result.addFirst(new Terminal('l'));
        }else if(term.equals("g")){
            return result;
        }else{
            return null;
        }
        return result;
    }

    public static LinkedList<GrammarElement> applyRuleE(Terminal terminal){

        LinkedList<GrammarElement> result = new LinkedList<>();
        String term = terminal.getSymbol();
        if(term.equals("f") || term.equals("z") || term.equals("m") || term.equals("o") || term.equals("u")){

            result.addFirst(new Neterminal("E''"));
            result.addFirst(new Neterminal("K"));
        }else{
            return null;
        }
        return result;
    }

    public static LinkedList<GrammarElement> applyRuleE_E(Terminal terminal){

        LinkedList<GrammarElement> result = new LinkedList<>();
        String term = terminal.getSymbol();
        if(term.equals("m") || term.equals("o")){

            result.addFirst(new Neterminal("E''"));
            result.addFirst(new Neterminal("K"));
            result.addFirst(new Neterminal("J"));
        }else{
            return null;
        }
        return result;
    }

    public static LinkedList<GrammarElement> applyRuleE_EE(Terminal terminal){

        LinkedList<GrammarElement> result = new LinkedList<>();
        String term = terminal.getSymbol();
        if(term.equals("m") || term.equals("o")){

            result.addFirst(new Neterminal("E'"));
        }else if(term.equals("d") || term.equals("g") || term.equals("l")){
            return result;
        }else{
            return null;
        }
        return result;
    }

    public static LinkedList<GrammarElement> applyRuleK(Terminal terminal){

        LinkedList<GrammarElement> result = new LinkedList<>();
        String term = terminal.getSymbol();
        if(term.equals("f")){
            result.addFirst(new Terminal('g'));
            result.addFirst(new Neterminal("E"));
            result.addFirst(new Terminal('f'));
        }else if(term.equals("z")){

            result.addFirst(new Neterminal("D"));
        }else if(term.equals("m") || term.equals("o") || term.equals("u")){

            result.addFirst(new Neterminal("L"));
        }else{
            return null;
        }
        return result;
    }

    public static LinkedList<GrammarElement> applyRuleJ(Terminal terminal){

        LinkedList<GrammarElement> result = new LinkedList<>();
        String term = terminal.getSymbol();
        if(term.equals("m")){

            result.addFirst(new Terminal('m'));
        }else if(term.equals("o")){

            result.addFirst(new Terminal('o'));
        }else{
            return null;
        }
        return result;
    }

    public static LinkedList<GrammarElement> applyRuleH(Terminal terminal){

        LinkedList<GrammarElement> result = new LinkedList<>();
        String term = terminal.getSymbol();
        if(term.equals("r") || term.equals("f") || term.equals("s") || term.equals("t") ){

            result.addFirst(new Neterminal("H''"));
            result.addFirst(new Neterminal("M"));
        }else{
            return null;
        }
        return result;
    }

    public static LinkedList<GrammarElement> applyRuleH_H(Terminal terminal){

        LinkedList<GrammarElement> result = new LinkedList<>();
        String term = terminal.getSymbol();
        if(term.equals("p") ){

            result.addFirst(new Neterminal("H''"));
            result.addFirst(new Neterminal("M"));
            result.addFirst(new Terminal('p'));
        }else{
            return null;
        }
        return result;
    }

    public static LinkedList<GrammarElement> applyRuleH_HH(Terminal terminal){

        LinkedList<GrammarElement> result = new LinkedList<>();
        String term = terminal.getSymbol();
        if(term.equals("p")){

            result.addFirst(new Neterminal("H'"));
        }else if(term.equals("j") || term.equals("g")){

            return result;
        }else{
            return null;
        }
        return result;
    }

    public static LinkedList<GrammarElement> applyRuleM(Terminal terminal){

        LinkedList<GrammarElement> result = new LinkedList<>();
        String term = terminal.getSymbol();
        if(term.equals("r") || term.equals("f") || term.equals("s") || term.equals("t") ){

            result.addFirst(new Neterminal("M''"));
            result.addFirst(new Neterminal("N"));
        }else{
            return null;
        }
        return result;
    }

    public static LinkedList<GrammarElement> applyRuleM_M(Terminal terminal){

        LinkedList<GrammarElement> result = new LinkedList<>();
        String term = terminal.getSymbol();
        if(term.equals("q")){

            result.addFirst(new Neterminal("M''"));
            result.addFirst(new Neterminal("N"));
            result.addFirst(new Terminal('q'));
        }else{
            return null;
        }
        return result;
    }

    public static LinkedList<GrammarElement> applyRuleM_MM(Terminal terminal){

        LinkedList<GrammarElement> result = new LinkedList<>();
        String term = terminal.getSymbol();
        if(term.equals("q")){

            result.addFirst(new Neterminal("M'"));
        }else if(term.equals("p") || term.equals("j") || term.equals("g")){

            return result;
        }else{
            return null;
        }
        return result;
    }

    public static LinkedList<GrammarElement> applyRuleN(Terminal terminal){

        LinkedList<GrammarElement> result = new LinkedList<>();
        String term = terminal.getSymbol();
        if(term.equals("r")){

            result.addFirst(new Neterminal("N"));
            result.addFirst(new Terminal('r'));
        }else if(term.equals("f")){

            result.addFirst(new Terminal('g'));
            result.addFirst(new Neterminal("H"));
            result.addFirst(new Terminal('f'));
        }else if(term.equals("s")){

            result.addFirst(new Terminal('s'));
        }else if(term.equals("t")){

            result.addFirst(new Terminal('t'));
        }else{
            return null;
        }
        return result;
    }

    public static LinkedList<GrammarElement> applyRuleD(Terminal terminal){

        LinkedList<GrammarElement> result = new LinkedList<>();
        String term = terminal.getSymbol();
        if(term.equals("z")){

            result.addFirst(new Terminal('z'));
        }else{
            return null;
        }
        return result;
    }

    public static LinkedList<GrammarElement> applyRuleL(Terminal terminal){

        LinkedList<GrammarElement> result = new LinkedList<>();
        String term = terminal.getSymbol();
        if(term.equals("m") || term.equals("o") || term.equals("u") ){

            result.addFirst(new Terminal('u'));
            result.addFirst(new Neterminal("B'"));
        }else{
            return null;
        }
        return result;
    }

    public static LinkedList<GrammarElement> applyRuleB_B(Terminal terminal){

        LinkedList<GrammarElement> result = new LinkedList<>();
        String term = terminal.getSymbol();
        if(term.equals("m")){

            result.addFirst(new Terminal('m'));
        }else if(term.equals("o")){

            result.addFirst(new Terminal('o'));
        }else if(term.equals("u")){

            return result;
        }else{
            return null;
        }
        return result;
    }
}
