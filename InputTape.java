import java.util.Arrays;

public class InputTape {
    // Make input infinite
    private String[] inputTape;
    private int size;

    public InputTape(String[] input) {
        inputTape = input;
        size = input.length;
    }

    // returns new head
    public int replace(int i, String replace) {
        if (i >= this.size || i < 0) {
            String[] tape = new String[size * 3];
            int j;
            for (j = 0; j < size; j++) {
                tape[j] = "1";
                tape[j + size] = inputTape[j];
                tape[j + size * 2] = "1";
            }
            this.size = 3 * size;
            inputTape = tape;
            i += j;
        }
        inputTape[i] = replace;
        return i;
    }

    public String get(int i) {
        if (i >= size || i < 0)
            return "1";
        return inputTape[i];
    }

    public int getSize() {
        return this.size;
    }

    public String[] getInput() {
        return inputTape;
    }

    public void print() {
        System.out.println("The input tape with size of " + this.size + " : "
                + Arrays.toString(this.inputTape));
    }
}
