import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dvalo on 05.12.2016.
 */
public class Main {

    static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {


       // String user_input = "BEGIN var125 := ( 15 ) ; END";
        //"BEGIN IF NOT TRUE THEN WRITE ( expr_list ) ; ELSE statement ; END"
        //"BEGIN IF NOT TRUE THEN WRITE ( factor op factor ) ; ELSE statement ; END"
       // "BEGIN IF NOT TRUE THEN WRITE ( 3 - 2 ) ; ELSE WRITE ( 3 + 2 ) ; ; END"
        
        String user_input = "BEGIN IF NOT TRUE THEN WRITE ( 3 - 2 ) ; ; WRITE ( 3 + 2 ) ; END";
        Stack input = new Stack();
        String user_input_splitted[] = user_input.split(" ");
        for (int i = user_input_splitted.length -1; i>=0; i--){
            input.push(new Terminal(user_input_splitted[i]));
        }
        log.info("Start input: "+input);

        Stack stack = new Stack();
        stack.push(new Neterminal("S"));

        while(input.peek() != null){
            log.info(" ");
            log.info("Input: "+input);
            log.info("Stack: "+stack);
            GrammarElement stackValue = stack.pop();
            GrammarElement inputValue = input.peek();

            if(stackValue == null){
                log.info("stackValue is null");
                break;
            }
            if(stackValue instanceof Terminal){
                if(inputValue.getSymbol().equals(stackValue.getSymbol())){
                    input.pop();
                }else{

                    log.info("zasekol som sa ! Expected: "+stackValue.getSymbol()+"("+stackValue.getTextualRepresentation()+"). Got: "+
                            inputValue.getSymbol()+"("+inputValue.getTextualRepresentation()+").");
                    Terminal temp = (Terminal) input.peekSecond();
                    if(temp != null){
                        if(temp.getSymbol().equals(stackValue.getSymbol())){
                            stack.push(stackValue);
                            input.pop();
                            log.info("POPol som z inputu a pokracujem dalej (nasiel som zhodu s 2. znakom na vstupe)");
                            continue;
                        }
                    }
                    break;
                }
            }else if(stackValue instanceof Neterminal){

                LinkedList<GrammarElement> resut = ((Neterminal) stackValue).replace((Terminal) inputValue);
                if(resut!= null){
                    if(resut.isEmpty()){
                        //epsilon
                        continue;
                    }else{
                        for (int i = resut.size() -1; i>=0; i--){
                            stack.push(resut.get(i));
                        }
                    }
                }else{
                    //zasekol som sa
                    String error_msg = "zasekol som sa, neterminal na stacku bez aplikovatelneho pravidla! Ocakavane znaky na vstupe: ";
                    for (Terminal t : ((Neterminal) stackValue).getExpected()){
                        error_msg += t.getSymbol() + "(" + t.getTextualRepresentation() + "), ";
                    }
                    log.info(error_msg.substring(0, error_msg.length()-2)+". Got: "+inputValue.getSymbol()+"("+inputValue.getTextualRepresentation()+").");



                    //testujem 2 znak z inputu s neterminalom
                    Terminal temp = (Terminal) input.peekSecond();
                    if(temp != null){
                        if(((Neterminal) stackValue).replace(temp)!= null){
                            log.info("POPol som z inputu a pokracujem dalej (nasiel som moznost pokracovania s 2. neterminalom na vstupe)");
                            input.pop();
                            stack.push(stackValue);
                            continue;
                        }else {
                            log.info("Nenasiel som pravidlo pre 2. znak na vstupe - POPujem zo stacku a idem dalej");


                            continue;
                        }
                    }
                    log.info("Vstup ma menej ako 2 znaky, pokracujem popnutim zo stacku");
                    continue;
                }
            }
        }
        log.info("Finish Stack: "+stack);
        log.info("Finish Input: "+input);
    }
}
