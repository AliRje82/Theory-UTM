import java.util.HashMap;
/**
 * Binary Turing machine
 */

public class BTM {
    private final String[] rules;
    private final HashMap<String,String> alphabet;

    public BTM(HashMap<String,String> alphabet,String[] rules){
        this.rules=rules;
        this.alphabet=alphabet;
    }
    /**
     * Convert String tape to 0 and 1's
     */
    public String[] convert(String[] tape){

    }

    //getters
    public String[] getRules() {
        return rules;
    }
    public HashMap<String, String> getAlphabet() {
        return alphabet;
    }
    
}
