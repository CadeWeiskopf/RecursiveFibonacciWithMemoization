
import java.util.HashMap;
import java.util.Scanner;

class RecursiveFibonacci {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean validInput;
        do {
            validInput = true;
            System.out.println("enter a number from range [0, 46]");
            System.out.print("=> ");
            input = scanner.nextLine();
            if (!input.matches("[\\d]+") || Integer.parseInt(input) < 0 || Integer.parseInt(input) > 46) {
                validInput = false;
            }
        } while (!validInput);
        scanner.close();

        int tdf = topDownFibonacci(Integer.parseInt(input), new HashMap<Integer, Integer>());
        System.out.println(tdf);
    }

    static int topDownFibonacci(int n, HashMap<Integer, Integer> map) {
        if (n < 2) {
            return n;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int fibN = topDownFibonacci(n - 1, map) + topDownFibonacci(n - 2, map);
        map.put(n, fibN);
        return fibN;
    }
}