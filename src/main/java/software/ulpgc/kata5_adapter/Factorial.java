package software.ulpgc.kata5_adapter;

public class Factorial {
    public void handle(Input input, Output output) {
        try {
            String param = input.getParameter(":number");
            int number = Integer.parseInt(param);

            if (number < 0 || number > 20) {
                output.setStatus(400);
                output.setBody("Number out of bounds");
                return;
            }

            int result = factorial(number);
            output.setStatus(200);
            output.setBody(String.valueOf(result));
        } catch (NumberFormatException e) {
            output.setStatus(400);
            output.setBody("Invalid number");
        }
    }

    private int factorial(int number) {
        int result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
