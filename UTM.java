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
        this.state = null;
        this.descriptions = null;
    }

    // public UTM(String[] inputs , String[] state , String[] descriptions){
    // this.inputs = inputs;
    // this.state = state;
    // this.descriptions = descriptions;
    // }

    // Run a binary turing machine
    public void run(BTM turing) {
        this.descriptions = Arrays.copyOf(turing.getRules(), turing.getRules().length);
        this.inputs = turing.convert(this.inputs);
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
            this.state[0] = description[2];
            head = inputs.replace(head, description[3]);
            if (description[4].equals("1")) {
                head--;
                if (head < 0) {
                    head = inputs.replace(head, "1");
                }
            } else {
                head++;
                if (head > inputs.getSize() - 1) {
                    head = inputs.replace(head, "1");
                }
            }
        }
        if (state[0].equals("11")) {
            System.out.println("Enter final state. Language accepted");
        } else {
            System.out.println("No transition rule found for the given input and state. HAULT!!!!");
        }

    }

    // print tapes
    public void print() {
        System.out.println("The description tape : " + Arrays.toString(this.descriptions) + "\n"
                + "The inputs tape : " + Arrays.toString(this.inputs) + "\n"
                + "The state tape " + Arrays.toString(this.state));
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