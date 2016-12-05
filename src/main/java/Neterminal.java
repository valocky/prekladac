import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dvalo on 05.12.2016.
 */
public class Neterminal extends GrammarElement {

    private List<Terminal> expected = new ArrayList<Terminal>();

    public Neterminal(String symbol) {

        this.symbol = symbol;

        switch (symbol){
            case "S":
                textualRepresentation = "program";
                expected.add(new Terminal('a'));
                break;
            case "B":
                textualRepresentation = "statement_list";
                expected.add(new Terminal('e'));
                expected.add(new Terminal('h'));
                expected.add(new Terminal('i'));
                expected.add(new Terminal('z'));
                break;
            case "X":
                textualRepresentation = "statement_list";
                expected.add(new Terminal('e'));
                expected.add(new Terminal('h'));
                expected.add(new Terminal('i'));
                expected.add(new Terminal('z'));
                expected.add(new Terminal('b'));
                break;
            case "C":
                textualRepresentation = "statement";
                expected.add(new Terminal('e'));
                expected.add(new Terminal('h'));
                expected.add(new Terminal('i'));
                expected.add(new Terminal('z'));
                break;
            case "Y":
                textualRepresentation = "statement";
                expected.add(new Terminal('d'));
                expected.add(new Terminal('k'));
                break;
            case "F":
                textualRepresentation = "id_list";
                expected.add(new Terminal('z'));
                break;
            case "Z":
                textualRepresentation = "ident_optional";
                expected.add(new Terminal('g'));
                expected.add(new Terminal('l'));
                break;
            case "G":
                textualRepresentation = "expr_list";
                expected.add(new Terminal('f'));
                expected.add(new Terminal('m'));
                expected.add(new Terminal('o'));
                expected.add(new Terminal('u'));
                expected.add(new Terminal('z'));
                break;
            case "W":
                textualRepresentation = "expression_optional";
                expected.add(new Terminal('g'));
                expected.add(new Terminal('l'));
                break;
            case "E":
                textualRepresentation = "expression";
                expected.add(new Terminal('f'));
                expected.add(new Terminal('m'));
                expected.add(new Terminal('o'));
                expected.add(new Terminal('u'));
                expected.add(new Terminal('z'));
                break;
            case "E'":
                textualRepresentation = "expression_optional";
                expected.add(new Terminal('m'));
                expected.add(new Terminal('o'));
                break;
            case "E''":
                textualRepresentation = "expression_optional";
                expected.add(new Terminal('d'));
                expected.add(new Terminal('g'));
                expected.add(new Terminal('l'));
                expected.add(new Terminal('m'));
                expected.add(new Terminal('o'));
                break;
            case "K":
                textualRepresentation = "factor";
                expected.add(new Terminal('f'));
                expected.add(new Terminal('m'));
                expected.add(new Terminal('o'));
                expected.add(new Terminal('u'));
                expected.add(new Terminal('z'));
                break;
            case "J":
                textualRepresentation = "op";
                expected.add(new Terminal('m'));
                expected.add(new Terminal('o'));
                break;
            case "H":
                textualRepresentation = "bexpr";
                expected.add(new Terminal('f'));
                expected.add(new Terminal('r'));
                expected.add(new Terminal('s'));
                expected.add(new Terminal('t'));
                break;
            case "H'":
                textualRepresentation = "bexpr_optional";
                expected.add(new Terminal('p'));
                break;
            case "H''":
                textualRepresentation = "bexpr_optional";
                expected.add(new Terminal('g'));
                expected.add(new Terminal('j'));
                expected.add(new Terminal('p'));
                break;
            case "M":
                textualRepresentation = "bterm";
                expected.add(new Terminal('f'));
                expected.add(new Terminal('r'));
                expected.add(new Terminal('s'));
                expected.add(new Terminal('t'));
                break;
            case "M'":
                textualRepresentation = "bterm_optional";
                expected.add(new Terminal('q'));
                break;
            case "M''":
                textualRepresentation = "bterm_optional";
                expected.add(new Terminal('g'));
                expected.add(new Terminal('j'));
                expected.add(new Terminal('p'));
                expected.add(new Terminal('q'));
                break;
            case "N":
                textualRepresentation = "bfactor";
                expected.add(new Terminal('f'));
                expected.add(new Terminal('r'));
                expected.add(new Terminal('s'));
                expected.add(new Terminal('t'));
                break;
            case "D":
                textualRepresentation = "ident";
                expected.add(new Terminal('z'));
                break;
            case "L":
                textualRepresentation = "number";
                expected.add(new Terminal('m'));
                expected.add(new Terminal('o'));
                expected.add(new Terminal('u'));
                break;
            case "B'":
                textualRepresentation = "sign_optional";
                expected.add(new Terminal('m'));
                expected.add(new Terminal('o'));
                expected.add(new Terminal('u'));
                break;
        }
    }

    public LinkedList<GrammarElement> replace(Terminal term){

        LinkedList<GrammarElement> result = new LinkedList<GrammarElement>();

        switch (symbol){
            case "S":
                result = Pravidla.applyRuleS(term);
                break;
            case "B":
                result = Pravidla.applyRuleB(term);
                break;
            case "X":
                result = Pravidla.applyRuleX(term);
                break;
            case "C":
                result = Pravidla.applyRuleC(term);
                break;
            case "Y":
                result = Pravidla.applyRuleY(term);
                break;
            case "F":
                result = Pravidla.applyRuleF(term);
                break;
            case "Z":
                result = Pravidla.applyRuleZ(term);
                break;
            case "G":
                result = Pravidla.applyRuleG(term);
                break;
            case "W":
                result = Pravidla.applyRuleW(term);
                break;
            case "E":
                result = Pravidla.applyRuleE(term);
                break;
            case "E'":
                result = Pravidla.applyRuleE_E(term);
                break;
            case "E''":
                result = Pravidla.applyRuleE_EE(term);
                break;
            case "K":
                result = Pravidla.applyRuleK(term);
                break;
            case "J":
                result = Pravidla.applyRuleJ(term);
                break;
            case "H":
                result = Pravidla.applyRuleH(term);
                break;
            case "H'":
                result = Pravidla.applyRuleH_H(term);
                break;
            case "H''":
                result = Pravidla.applyRuleH_HH(term);
                break;
            case "M":
                result = Pravidla.applyRuleM(term);
                break;
            case "M'":
                result = Pravidla.applyRuleM_M(term);
                break;
            case "M''":
                result = Pravidla.applyRuleM_MM(term);
                break;
            case "N":
                result = Pravidla.applyRuleN(term);
                break;
            case "D":
                result = Pravidla.applyRuleD(term);
                break;
            case "L":
                result = Pravidla.applyRuleL(term);
                break;
            case "B'":
                result = Pravidla.applyRuleB_B(term);
                break;
        }

        return result;
    }

    public List<Terminal> getExpected() {
        return expected;
    }
}
