package NumberGame;

import java.util.*;

public class Application {

    public int[] exchange(int[] puzzle, int[] exchangeNumbers) {
        int x = exchangeNumbers[0];
        int y = exchangeNumbers[1];
        for(int i=0; i<puzzle.length; i++) {
            if(puzzle[i] == x) {
                puzzle[i] = y;
            } else if(puzzle[i] == y) {
                puzzle[i] = x;
            }
        }
        return puzzle;
    }

    public int[] validateInput(String input) {
        int[] exchangeNumbers = new int[2];
        try {
            String[] exchangeInput = input.split(",");
            for(int i=0; i<exchangeNumbers.length; i++) {
                exchangeNumbers[i] = Integer.parseInt(exchangeInput[i]);
            }
            for(int exchangeNumber : exchangeNumbers) {
                if(exchangeNumber < 1 || exchangeNumber > 8) {
                    System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
                    getNumbersToSwap();
                }
            }
            return exchangeNumbers;
        } catch (Exception e) {
            System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
            getNumbersToSwap();
        }
        return null;
    }

    public int[] getNumbersToSwap() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("교환할 두 숫자를 입력>");
        String input = scanner.next();
        int[] exchangeNumbers = validateInput(input);
        return exchangeNumbers;
    }

    public void printPuzzle(int[] puzzle) {
        System.out.print(Arrays.toString(puzzle));
    }

    public int[] shuffle(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int target = (int) (Math.random() * numbers.length);
            int tmp = numbers[0];
            numbers[0] = numbers[target];
            numbers[target] = tmp;
        }
        return numbers;
    }

    public static void main(String[] args) {
        Application application = new Application();

        System.out.println("간단 숫자 퍼즐");
        int turn = 1;
        System.out.println("Turn " + turn);
        int[] numbers = new int[8];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        int[] puzzle = application.shuffle(numbers);
        application.printPuzzle(puzzle);

    public static void main(String[] args) {
        Application application = new Application();

        int[] puzzle = application.start();
        int turn = 1;
        boolean ascendingOrder = false;

        while (!ascendingOrder) {
            application.printStatus(puzzle, turn);
            int[] tmp = puzzle;
            Arrays.sort(tmp);
            ascendingOrder = Arrays.equals(puzzle, tmp);
        }
        int[] exchangeNumbers = application.getNumbersToSwap();
    }
}
