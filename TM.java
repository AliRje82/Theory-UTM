
/**
 * Turing machine 
 */

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;

public class TM {
    private String[] states;
    private ArrayList<String> alphabet;
    private String start;
    private String end;
    private String[] rules;

    // Turing machine constructor
    public TM(String[] tm) throws Exception {
        // States pattern and matcher
        Pattern statePatern = Pattern.compile("q[9-0]+");
        Matcher matcherStates;
        long count;
        // finding alphabets
        statePatern = Pattern.compile("[(][^)]*[)]");
        matcherStates = statePatern.matcher(tm[3]);
        this.alphabet = new ArrayList<>();
        while (matcherStates.find()) {
            String[] str = matcherStates.group().replaceAll("[(.)]", "").split(",");
            if (!alphabet.contains(str[1]))
                alphabet.add(str[1]);
            if (!alphabet.contains(str[2]))
                alphabet.add(str[2]);
        }
        // start state
        matcherStates = statePatern.matcher(tm[1]);
        count = matcherStates.results().count();

        if (count != 1)
            throw new Exception("Two or less than 1 starting state");

        matcherStates = statePatern.matcher(tm[1]);
        matcherStates.find();
        this.start = matcherStates.group();
        // End state
        matcherStates = statePatern.matcher(tm[2]);
        count = matcherStates.results().count();

        matcherStates = statePatern.matcher(tm[2]);
        String[] newStates = null;
        // Checking to see if we have more than one final state
        if (count != 1) {
            String[] finalStates = new String[(int) count];
            int i = 0;
            while (matcherStates.find()) {
                finalStates[i++] = matcherStates.group();
            }

            newStates = singleFinal(finalStates);
            int len = newStates.length;
            this.end = newStates[len - 1];

        } else {
            matcherStates.find();
            this.end = matcherStates.group();
        }

        // Count them for init string[] states
        matcherStates = statePatern.matcher(tm[0]);
        count = matcherStates.results().count();
        // It means we have a new state
        if (newStates != null)
            count++;

        this.states = new String[(int) count];
        // finding them
        int i = 0;
        matcherStates = statePatern.matcher(tm[0]);
        while (matcherStates.find()) {
            states[i++] = matcherStates.group();
        }
        // Adding new final state
        if (i != count)
            states[i] = newStates[newStates.length - 1];

        // Production rules:
        statePatern = Pattern.compile("[(][^)]*[)]");
        matcherStates = statePatern.matcher(tm[3]);
        count = matcherStates.results().count();
        // see if we have new rules
        if (newStates != null)
            count += newStates.length - 1;
        rules = new String[(int) count];

        matcherStates = statePatern.matcher(tm[3]);
        i = 0;
        while (matcherStates.find()) {
            String[] s = matcherStates.group().replaceAll("[(.)]", "").split(",");
            String temp = "";
            for (String str : s) {
                temp += str + " ";
            }
            this.rules[i] = temp;

        }
        for (int j = 0; j < newStates.length - 1; j++, i++) {
            this.rules[i] = newStates[j];
        }

    }

    // Turing machine to binary string
    public BTM TMtoBTM() {
        Hashtable<String, String> states = new Hashtable<>();
        Hashtable<String, String> alphabet = new Hashtable<>();

        states.put(start, "1");
        states.put(end, "11");

        alphabet.put("blank", "1");

        StringBuilder state = new StringBuilder("111");
        StringBuilder alpha = new StringBuilder("11");

        String[] btmRules = new String[this.rules.length];
        int i = 0;

        for (String str : this.rules) {
            String[] r = str.split(" ");
            StringBuilder btm = new StringBuilder("");

            if (states.contains(r[0])) {
                btm.append(states.get(r[0]));
            } else {
                btm.append(state);
                states.put(r[0], state.toString());
                state.append("1");
            }
            btm.append("0");
            if (alphabet.contains(r[1])) {
                btm.append(states.get(r[1]));
            } else {
                btm.append(alpha);
                alphabet.put(r[1], alpha.toString());
                alpha.append("1");
            }
            btm.append("0");
            if (alphabet.contains(r[2])) {
                btm.append(states.get(r[2]));
            } else {
                btm.append(alpha);
                alphabet.put(r[2], alpha.toString());
                alpha.append("1");
            }

            btm.append("0");

            if (r[3] == "L")
                btm.append("1");
            else
                btm.append("11");

            btm.append("0");

            if (states.contains(r[4])) {
                btm.append(states.get(r[4]));
            } else {
                btm.append(state);
                states.put(r[4], state.toString());
                state.append("1");
            }

            btmRules[i++] = btm.toString();
        }

        return new BTM(alphabet, btmRules);

    }

    /**
     * print tapes
     */
    public void print() {
        System.out.println("The features of the turing machine are in following lines \n" +
                "The states : " + Arrays.toString(this.states) +
                "The alphabets : " + this.alphabet.toString() +
                "The initial and final states are respectively " + this.start + " " + this.end +
                "The rules : " + Arrays.toString(this.rules));

    }

    // returns new final state as last string in array and new production rules
    private String[] singleFinal(String[] finalStates) {

    }

}