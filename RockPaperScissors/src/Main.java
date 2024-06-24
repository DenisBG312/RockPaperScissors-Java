import jdk.dynalink.beans.StaticClass;

import javax.naming.Name;
import java.lang.constant.Constable;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int playerPoints = 0;
        int cpuPoints = 0;

        String[] moves = new String[]{"Rock", "Paper", "Scissors"};

        Random random = new Random();

        System.out.println("Welcome to the Rock, Paper, Scissors game!");
        System.out.println("Do you wish to play?: y/n");
        
        String command = scanner.nextLine();
        if (command.equals("y")) {
            System.out.println("The first with 5 points wins the game! Good Luck!");
            while (true) {
                
                if (playerPoints == 5 || cpuPoints == 5) {
                    CheckAndPrintTheWinner(playerPoints, cpuPoints);    
                    break;
                }
                
                int cpuRandomIndex = random.nextInt(0, 3);
                String cpuMove = moves[cpuRandomIndex];
                System.out.println("Choose a move: Rock Paper Scissors");
                String playerMove = scanner.nextLine();
                
                System.out.println("The CPU chose: " + cpuMove);
                System.out.println("You chose: " + playerMove);

                // Player Rock Move
                if (playerMove.equals("Rock")) {
                    if (cpuMove.equals("Rock")) {
                        System.out.println("Equal!");
                    } else if (cpuMove.equals("Paper")) {
                        System.out.println("CPU wins!");
                        cpuPoints++;
                    } else if (cpuMove.equals("Scissors")) {
                        System.out.println("You win!");
                        playerPoints++;
                    }
                }

                // Player Paper Move
                if (playerMove.equals("Paper")) {
                    if (cpuMove.equals("Rock")) {
                        System.out.println("You win!");
                        playerPoints++;
                    } else if (cpuMove.equals("Paper")) {
                        System.out.println("Equal!");
                    } else if (cpuMove.equals("Scissors")) {
                        System.out.println("CPU wins!");
                        cpuPoints++;
                    }
                }

                // Player Rock Move
                if (playerMove.equals("Scissors")) {
                    if (cpuMove.equals("Rock")) {
                        System.out.println("CPU wins!");
                        cpuPoints++;
                    } else if (cpuMove.equals("Paper")) {
                        System.out.println("You win!");
                        playerPoints++;
                    } else if (cpuMove.equals("Scissors")) {
                        System.out.println("Equal!");
                    }
                }
                
                PrintResult(playerPoints, playerMove, cpuPoints, cpuMove);
            }
        }
    }

    private static void CheckAndPrintTheWinner(int playerPoints, int cpuPoints) {
        if (playerPoints == 5) {
            System.out.println("Congrats! You are the winner.");
        }
        else if (cpuPoints == 5) {
            System.out.println("Sorry, the CPU is the winner.");
        }
    }

    private static void PrintResult(int playerPoints, String playerMove, int cpuPoints, String cpuMove) {
        if (playerMove.equals("Rock") && cpuMove.equals("Paper")) {
            System.out.println("CPU now has: " + cpuPoints);
        }
        else if (playerMove.equals("Rock") && cpuMove.equals("Scissors")) {
            System.out.println("You now have: " + playerPoints);
        }
        else if (playerMove.equals("Paper") && cpuMove.equals("Rock")) {
            System.out.println("You now have: " + playerPoints);
        }
        else if (playerMove.equals("Paper") && cpuMove.equals("Scissors")) {
            System.out.println("CPU now has: " + cpuPoints);
        }
        else if (playerMove.equals("Scissors") && cpuMove.equals("Rock")) {
            System.out.println("CPU now has " + cpuPoints);
        }
        else if (playerMove.equals("Scissors") && cpuMove.equals("Paper")) {
            System.out.println("You now have: " + playerPoints);
        }

        /* Will use that also for equal matches */
        PrintAlwaysFinalResult(playerPoints, cpuPoints);
    }

    private static void PrintAlwaysFinalResult(int playerPoints, int cpuPoints) {
        System.out.println("You have " + playerPoints + " points" + " and CPU has " + cpuPoints);
    }
}
