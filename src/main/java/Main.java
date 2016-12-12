import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;


public class Main {

    static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {


        // String user_input = "BEGIN var125 := ( 15 ) ; END";
        //"BEGIN IF NOT TRUE THEN WRITE ( expr_list ) ; ELSE statement ; END"
        //"BEGIN IF NOT TRUE THEN WRITE ( factor op factor ) ; ELSE statement ; END"
        // "BEGIN IF NOT TRUE THEN WRITE ( 3 - 2 ) ; ELSE WRITE ( 3 + 2 ) ; ; END"

        String user_input = "IF NOT TRUE THEN WRITE ( 3 - 2 ) ; ; WRITE ( 3 + 2 ) ; END";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Zadajte program na kontrolu:");
            user_input = br.readLine();
            if (user_input.equals("exit")) {
                System.exit(1);
            }
            Stack input = new Stack();
            String user_input_splitted[] = user_input.split(" ");
            for (int i = user_input_splitted.length - 1; i >= 0; i--) {
                input.push(new Terminal(user_input_splitted[i]));
            }
            log.info("Prepisany vstup: " + input);

            Stack stack = new Stack();
            stack.push(new Neterminal("S"));
            int errors = 0;
            while (input.peek() != null) {
                log.info(" ");
                log.info("Vstup: " + input);
                log.info("Zasobnik: " + stack);
                GrammarElement stackValue = stack.pop();
                GrammarElement inputValue = input.peek();

                if (stackValue == null) {

                    break;
                }
                if (stackValue instanceof Terminal) {
                    if (inputValue.getSymbol().equals(stackValue.getSymbol())) {
                        input.pop();
                        continue;
                    } else {
                        errors++;
                        log.info("Chyba! Ocakavane: " + stackValue.getSymbol() + "(" + stackValue.getTextualRepresentation() + "). Na vstupe: " +
                                inputValue.getSymbol() + "(" + inputValue.getTextualRepresentation() + ").");
                        Terminal temp = (Terminal) input.peekSecond();
                        if (temp != null) {
                            if (temp.getSymbol().equals(stackValue.getSymbol())) {
                                stack.push(stackValue);
                                input.pop();
                                log.info("POPol som zo vstupu a pokracujem dalej (nasiel som zhodu s 2. znakom na vstupe)");
                                continue;
                            }
                        }
                        log.info("POPol som zo zasobniku a pokracujem dalej");
                        continue;
                    }
                } else if (stackValue instanceof Neterminal) {

                    LinkedList<GrammarElement> result = ((Neterminal) stackValue).replace((Terminal) inputValue);
                    if (result != null) {
                        if (result.isEmpty()) {
                            //epsilon
                            continue;
                        } else {
                            for (int i = result.size() - 1; i >= 0; i--) {
                                stack.push(result.get(i));
                            }
                        }
                    } else {
                        //zasekol som sa
                        errors++;
                        String error_msg = "Chyba! Neterminal v zasobniku bez aplikovatelneho pravidla! Ocakavane znaky na vstupe: ";
                        for (Terminal t : ((Neterminal) stackValue).getExpected()) {
                            error_msg += t.getSymbol() + "(" + t.getTextualRepresentation() + "), ";
                        }
                        log.info(error_msg.substring(0, error_msg.length() - 2) + ". Znak na vstupe: " + inputValue.getSymbol() + "(" + inputValue.getTextualRepresentation() + ").");


                        //testujem 2 znak z inputu s neterminalom
                        Terminal temp = (Terminal) input.peekSecond();
                        if (temp != null) {
                            if (((Neterminal) stackValue).replace(temp) != null) {
                                log.info("POPol som zo vstupu a pokracujem dalej (nasiel som moznost pokracovania s 2. neterminalom na vstupe)");
                                input.pop();
                                stack.push(stackValue);
                                continue;
                            }
                        }

                        log.info("Nenasiel som pravidlo ani pre 2. znak na vstupe - aplikujem defaultne pravidlo pre neterminal v zasobniku a idem dalej");

                        result = ((Neterminal) stackValue).replace(new Terminal('x'));
                        if(result == null){
                            log.info("SOMETHING WENT WRONG - I SHOULD NEVER GET HERE");
                            log.info("POPol som zo zasobniku a idem dalej");
                            continue;
                        }
                        if (result.isEmpty()) {
                            //epsilon
                            continue;
                        } else {
                            for (int i = result.size() - 1; i >= 0; i--) {
                                stack.push(result.get(i));
                            }
                            continue;
                        }

                    }
                }
            }
            if (errors == 0 && stack.isEmpty() && input.isEmpty()) {
                log.info("Kontrola dokoncena uspesne!");
            } else {
                log.info("Kontrola dokoncena s poctom pokusov o zotavenie z chyb: " + errors + ".");
                log.info("Obsah zasobniku: " + stack.output());
                log.info("Obsah vstupu: " + input.output());
            }

        }
    }


}
