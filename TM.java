/**
 * Turing machine 
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TM {
    private String[] states;
    private String start;
    private String end;
    private String[] rules;
    //Turing machine constructor
    public TM(String[] tm) throws Exception{
        //States pattern and matcher
        Pattern statePatern=Pattern.compile("q[9-0]+");
        Matcher matcherStates;
        long count;
        //start state
        matcherStates = statePatern.matcher(tm[1]);
        count = matcherStates.results().count();

        if(count!=1) throw new Exception("Two or less than 1 starting state");
        
        matcherStates=statePatern.matcher(tm[1]);
        matcherStates.find();
        this.start=matcherStates.group();
        //End state
        matcherStates = statePatern.matcher(tm[2]);
        count = matcherStates.results().count();
        
        matcherStates = statePatern.matcher(tm[2]);
        String[] newStates=null;
        //Checking to see if we have more than one final state
        if(count!=1){
            String[] finalStates = new String[(int) count];
            int i=0;
            while (matcherStates.find()) {
                finalStates[i++]=matcherStates.group();
            }
            
            newStates = singleFinal(finalStates);
            int len=newStates.length;
            this.end=newStates[len-1];

        }else{
            matcherStates.find();
            this.end=matcherStates.group();
        }



        //Count them for init string[] states
        matcherStates=statePatern.matcher(tm[0]);
        count = matcherStates.results().count();
        //It means we have a new state 
        if(newStates!=null) count++;

        this.states = new String[(int) count];
        //finding them
        int i=0;
        matcherStates=statePatern.matcher(tm[0]);
        while (matcherStates.find()) {
            states[i++]=matcherStates.group();
        }
        //Adding new final state
        if(i!=count) states[i]=newStates[newStates.length-1];
        
        //Production rules:
        statePatern = Pattern.compile("[(][^)]*[)]");
        matcherStates = statePatern.matcher(tm[3]);
        count = matcherStates.results().count();
        //see if we have new rules
        if(newStates!=null) count+=newStates.length-1;
        rules = new String[(int)count];

        matcherStates = statePatern.matcher(tm[3]);
        i=0;
        while (matcherStates.find()) {
            String[] s = matcherStates.group().replaceAll("[(.)]","").split(",");
            String temp="";
            for (String str : s) {
                temp+=str+" ";
            }
            this.rules[i]=temp;

        }
        for(int j=0;j<newStates.length-1;j++,i++){
            this.rules[i]=newStates[j];
        }




    }

    //Turing machine to binary string
    public BTM TMtoBTM(){
        
    }
    /**
     * print tapes
     */
    public void print(){
        
    }
    //returns new final state as last string in array and new production rules 
    private String[] singleFinal(String[] finalStates){

    }



    
}