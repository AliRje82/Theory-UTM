
import java.util.Hashtable;
/**
 * Binary Turing machine
 */

public class BTM {
    private final String[] rules;
    private final Hashtable<String,String> alphabet;

    public BTM(Hashtable<String,String> alphabet,String[] rules){
        this.rules=rules;
        this.alphabet=alphabet;
    }
    /**
     * Convert String tape to 0 and 1's
     */
    public String[] convert(String[] tape){
            String[] newTape=new String[tape.length];
            for(int i =0 ;i<tape.length;i++){
                newTape[i] = alphabet.get(tape[i]);
            }
            return newTape;
    }

    //getters
    public String[] getRules() {
        return rules;
    }
    public Hashtable<String, String> getAlphabet() {
        return alphabet;
    }
    
}
