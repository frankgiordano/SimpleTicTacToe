package tictactoe;

import java.util.Scanner;

/**
 * The game of Tic-Tac-Toe.
 * The game GRID state is represented by a String of length of 9 characters.
 * Example variable "gird" is XOO__OX_X which represents:
 * ---------
 * | X O O |
 * | _ _ O |
 * | X _ X |
 * ---------
 * Game input is driven by player coordinates. The gird input is represented as:
 * ---------------
 * | 1,1 1,2 1,3 |
 * | 2,1 2,2 2,3 |
 * | 3,1 3,2 3,3 |
 * ---------------
 * Player X is first and then player O and then takes turns...
 * Game ends when a player is a winner or there is a draw.
 * author: frank giordano
 */
public class SimpleTicTacToe {

    private static final String PLAYER_X_INPUT_MSG = "Enter the coordinates for X: ";
    private static final String PLAYER_O_INPUT_MSG = "Enter the coordinates for O: ";

    /**
     * Prints an empty grid at the beginning of the game. Creates a game loop where
     * the program asks the user to enter the cell coordinates, analyzes the move for
     * correctness and shows a grid with the changes if everything is okay. Ends the
     * game when someone wins or there is a draw.
     */
    public static void main(String[] args) {

        System.out.println("Tic Tac Toe\n");
        System.out.println("Player X is first...\n");

        // Start with an empty game gird...
        String gird = "_________";
        displayGrid(gird);

        // player X is first...
        boolean toggle = true;

        // play until a player has won or there is a draw...
        while ("Game not finished".equals(gameState(gird))) {
            String[] coordinates = getCoordinates(gird, toggle);
            if (toggle) {  // player X turn...
                gird = fillGridForXPlayer(gird, coordinates);
                toggle = false;
            } else {  // player O turn...
                gird = fillGridForOPlayer(gird, coordinates);
                toggle = true;
            }
            displayGrid(gird);
        }

        System.out.println(gameState(gird));
    }

    /**
     * Ask player to enter valid coordinates. Return two valid values.
     */
    private static String[] getCoordinates(String gird, boolean toggle) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(toggle ? PLAYER_X_INPUT_MSG : PLAYER_O_INPUT_MSG);
        String[] coordinates = scanner.nextLine().split(" ");
        while (isNotValidCoordinates(coordinates) || isCellOccupied(gird, coordinates)) {
            System.out.print(toggle ? PLAYER_X_INPUT_MSG : PLAYER_O_INPUT_MSG);
            coordinates = scanner.nextLine().split(" ");
        }
        return coordinates;
    }

    /**
     * If a cell in the gird is already occupied return true otherwise false.
     */
    private static boolean isCellOccupied(String gird, String[] inputs) {
        char[] chars = gird.toCharArray();
        boolean isFilled = false;
        if ("1".equals(inputs[0]) && "1".equals(inputs[1])) {
            if (chars[0] == 'X' || chars[0] == 'O')
                isFilled = true;
        } else if ("1".equals(inputs[0]) && "2".equals(inputs[1])) {
            if (chars[1] == 'X' || chars[1] == 'O')
                isFilled = true;
        } else if ("1".equals(inputs[0]) && "3".equals(inputs[1])) {
            if (chars[2] == 'X' || chars[2] == 'O')
                isFilled = true;
        } else if ("2".equals(inputs[0]) && "1".equals(inputs[1])) {
            if (chars[3] == 'X' || chars[3] == 'O')
                isFilled = true;
        } else if ("2".equals(inputs[0]) && "2".equals(inputs[1])) {
            if (chars[4] == 'X' || chars[4] == 'O')
                isFilled = true;
        } else if ("2".equals(inputs[0]) && "3".equals(inputs[1])) {
            if (chars[5] == 'X' || chars[5] == 'O')
                isFilled = true;
        } else if ("3".equals(inputs[0]) && "1".equals(inputs[1])) {
            if (chars[6] == 'X' || chars[6] == 'O')
                isFilled = true;
        } else if ("3".equals(inputs[0]) && "2".equals(inputs[1])) {
            if (chars[7] == 'X' || chars[7] == 'O')
                isFilled = true;
        } else if ("3".equals(inputs[0]) && "3".equals(inputs[1])) {
            if (chars[8] == 'X' || chars[8] == 'O')
                isFilled = true;
        }

        if (isFilled) {
            System.out.println("This cell is occupied! Choose another one!");
        }

        return isFilled;
    }

    /**
     * Are coordinates values valid.
     */
    private static boolean isNotValidCoordinates(String[] inputs) {
        if (inputs.length < 2 || inputs.length > 2) {
            System.out.println("Please enter two coordinates!");
            return true;
        }
        int input1, input2;
        try {
            input1 = Integer.parseInt(inputs[0]);
            input2 = Integer.parseInt(inputs[1]);
        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            return true;
        }

        if (input1 <= 0 || input1 > 3 || input2 <= 0 || input2 > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return true;
        }

        return false;
    }

    /**
     * Populate player's X coordinates within the game gird.
     */
    private static String fillGridForXPlayer(String gird, String[] inputs) {
        char[] chars = gird.toCharArray();
        if ("1".equals(inputs[0]) && "1".equals(inputs[1]))
            chars[0] = 'X';
        if ("1".equals(inputs[0]) && "2".equals(inputs[1]))
            chars[1] = 'X';
        if ("1".equals(inputs[0]) && "3".equals(inputs[1]))
            chars[2] = 'X';
        if ("2".equals(inputs[0]) && "1".equals(inputs[1]))
            chars[3] = 'X';
        if ("2".equals(inputs[0]) && "2".equals(inputs[1]))
            chars[4] = 'X';
        if ("2".equals(inputs[0]) && "3".equals(inputs[1]))
            chars[5] = 'X';
        if ("3".equals(inputs[0]) && "1".equals(inputs[1]))
            chars[6] = 'X';
        if ("3".equals(inputs[0]) && "2".equals(inputs[1]))
            chars[7] = 'X';
        if ("3".equals(inputs[0]) && "3".equals(inputs[1]))
            chars[8] = 'X';

        return String.valueOf(chars);
    }

    /**
     * Populate player's O coordinates within the game gird.
     */
    private static String fillGridForOPlayer(String gird, String[] inputs) {
        char[] chars = gird.toCharArray();
        if ("1".equals(inputs[0]) && "1".equals(inputs[1]))
            chars[0] = 'O';
        if ("1".equals(inputs[0]) && "2".equals(inputs[1]))
            chars[1] = 'O';
        if ("1".equals(inputs[0]) && "3".equals(inputs[1]))
            chars[2] = 'O';
        if ("2".equals(inputs[0]) && "1".equals(inputs[1]))
            chars[3] = 'O';
        if ("2".equals(inputs[0]) && "2".equals(inputs[1]))
            chars[4] = 'O';
        if ("2".equals(inputs[0]) && "3".equals(inputs[1]))
            chars[5] = 'O';
        if ("3".equals(inputs[0]) && "1".equals(inputs[1]))
            chars[6] = 'O';
        if ("3".equals(inputs[0]) && "2".equals(inputs[1]))
            chars[7] = 'O';
        if ("3".equals(inputs[0]) && "3".equals(inputs[1]))
            chars[8] = 'O';

        return String.valueOf(chars);
    }

    /**
     * Analyze the game state and return game status. Possible statuses:
     * - "Game not finished" when neither side has three in a row but the grid still has empty cells.
     * - "Draw" when no side has a three in a row and the grid has no empty cells.
     * - "X wins" when the grid has three X’s in a row.
     * - "O wins" when the grid has three O’s in a row.
     * - "Impossible" when the grid has three X’s in a row as well as three O’s in a row, or there are
     * a lot more X's than O's or vice versa (the difference should be 1 or 0; if the difference is 2 or more,
     * then the game state is impossible).
     */
    private static String gameState(String input) {
        int numOfX = 0, numOfO = 0, emptyCells = 0;
        boolean isXWinPosition = false, isOWinPosition = false;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'X') numOfX++;
            if (input.charAt(i) == 'O') numOfO++;
            if (input.charAt(i) == '_') emptyCells++;
        }

        if (input.charAt(0) == 'X' && input.charAt(1) == 'X' && input.charAt(2) == 'X')
            isXWinPosition = true;
        if (input.charAt(3) == 'X' && input.charAt(4) == 'X' && input.charAt(5) == 'X')
            isXWinPosition = true;
        if (input.charAt(6) == 'X' && input.charAt(7) == 'X' && input.charAt(8) == 'X')
            isXWinPosition = true;

        if (input.charAt(0) == 'O' && input.charAt(1) == 'O' && input.charAt(2) == 'O')
            isOWinPosition = true;
        if (input.charAt(3) == 'O' && input.charAt(4) == 'O' && input.charAt(5) == 'O')
            isOWinPosition = true;
        if (input.charAt(6) == 'O' && input.charAt(7) == 'O' && input.charAt(8) == 'O')
            isOWinPosition = true;

        if (input.charAt(2) == 'X' && input.charAt(5) == 'X' && input.charAt(8) == 'X')
            isXWinPosition = true;
        if (input.charAt(1) == 'X' && input.charAt(4) == 'X' && input.charAt(7) == 'X')
            isXWinPosition = true;
        if (input.charAt(0) == 'X' && input.charAt(3) == 'X' && input.charAt(6) == 'X')
            isXWinPosition = true;

        if (input.charAt(2) == 'O' && input.charAt(5) == 'O' && input.charAt(8) == 'O')
            isOWinPosition = true;
        if (input.charAt(1) == 'O' && input.charAt(4) == 'O' && input.charAt(7) == 'O')
            isOWinPosition = true;
        if (input.charAt(0) == 'O' && input.charAt(3) == 'O' && input.charAt(6) == 'O')
            isOWinPosition = true;

        if (input.charAt(0) == 'X' && input.charAt(4) == 'X' && input.charAt(8) == 'X')
            isXWinPosition = true;

        if (input.charAt(0) == 'O' && input.charAt(4) == 'O' && input.charAt(8) == 'O')
            isOWinPosition = true;

        if (input.charAt(2) == 'X' && input.charAt(4) == 'X' && input.charAt(6) == 'X')
            isXWinPosition = true;

        if (input.charAt(2) == 'O' && input.charAt(4) == 'O' && input.charAt(6) == 'O')
            isOWinPosition = true;

        // determine game state after checking all grid cells done above...
        if (isXWinPosition && isOWinPosition)
            return "Impossible";
        else if (numOfX == 3 && isXWinPosition)
            return "X wins";
        else if (numOfO == 3 && isOWinPosition)
            return "O wins";
        else if (Math.abs(numOfX - numOfO) >= 2)
            return "Impossible";
        else if (numOfX >= numOfO && isXWinPosition)
            return "X wins";
        else if (numOfO >= numOfX && isOWinPosition)
            return "O wins";
        else if (emptyCells == 0)
            return "Draw";

        return "Game not finished";
    }

    /**
     * Print current game gird.
     */
    public static void displayGrid(String input) {
        System.out.println("---------");
        System.out.println("| " + input.charAt(0) + " " + input.charAt(1) + " " + input.charAt(2) + " |");
        System.out.println("| " + input.charAt(3) + " " + input.charAt(4) + " " + input.charAt(5) + " |");
        System.out.println("| " + input.charAt(6) + " " + input.charAt(7) + " " + input.charAt(8) + " |");
        System.out.println("---------");
    }

}

