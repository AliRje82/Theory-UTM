import java.util.Arrays;

/**
 * Universal Turing machine
 */
public class UTM {
    private String[] inputs;
    private String[] state;
    private String[] descriptions;

    public UTM() {
        this.inputs = null;
        this.state = new String[1];
        this.descriptions = null;
    }

    // Run a binary turing machine
    public void run(BTM turing, String[] in) {
        this.descriptions = turing.getRules();
        this.inputs = turing.convert(in);
        InputTape inputs = new InputTape(this.inputs);
        this.state[0] = "1";
        int head = 0;
        while (true) {
            String input = inputs.get(head);
            int index = findRule(input, this.state[0]);
            if (index == (-1)) {
                break;
            }
            String[] description = this.descriptions[index].split("0");
            this.state[0] = description[4];
            head = inputs.replace(head, description[2]);
            if (description[3].equals("1")) {
                head--;
            } else {
                head++;
            }
        }
        if (state[0].equals("11")) {
            System.out.println("Enter final state. Language accepted");
        } else {
            System.out.println("No transition rule found for the given input and state. HAULT!!!!");
        }
        this.inputs = inputs.getInput();
        this.print();
    }

    // print tapes
    public void print() {
        System.out.println("The description tape : " + Arrays.toString(this.descriptions) + "\n"
                + "The inputs tape : " + Arrays.toString(this.inputs) + "\n"
                + "The state tape " + Arrays.toString(this.state));
    }

    public void setInput(String[] input) {
        this.inputs = input;
    }

    /**
     * find specefic rules
     */
    public int findRule(String input, String state) {
        for (int i = 0; i < descriptions.length; i++) {
            String[] description = this.descriptions[i].split("0");
            if (state.equals(description[0]) && input.equals(description[1])) {
                return i;
            }
        }
        return (-1);
    }

}