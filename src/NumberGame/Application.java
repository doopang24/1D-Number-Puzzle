package NumberGame;

public class Application {
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

        int[] exchangeNumbers = application.getNumbersToSwap();
    }
}
