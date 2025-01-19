package software.ulpgc.kata5_adapter;

public class Fibonacci {
    public void handle(Input input, Output output) {
        try {
            String param = input.getParameter(":number");
            int number = Integer.parseInt(param);

            if (number < 0 || number > 20) {
                output.setStatus(400);
                output.setBody("Number out of bounds");
                return;
            }

            int result = fibonacci(number);
            output.setStatus(200);
            output.setBody(String.valueOf(result));
        } catch (NumberFormatException e) {
            output.setStatus(400);
            output.setBody("Invalid number");
        }
    }

    private int fibonacci(int number) {
        if (number <= 1) {
            return number;
        }
        int a = 0, b = 1, c = 1;
        for (int i = 2; i <= number; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
