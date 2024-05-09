import java.util.Arrays;
import java.util.Scanner;

public class Userinterface {
    Scanner input = new Scanner(System.in);
    Adventure adventure = new Adventure();

    public void printStartingMenu(){
        System.out.println();
        System.out.println("******************************");
        System.out.println("Welcome to the adventure game!");
        System.out.println("Please press a key to continue");
        System.out.println("------------------------------");
        System.out.println("1. Start game");
        System.out.println("2. Quit");
        System.out.println("------------------------------");
        System.out.println("******************************");
    }

    public void startingMenu(){
        printStartingMenu();
        String userChoice = input.nextLine();
        while(!userChoice.equals("2")){
            if(userChoice.equals("1")){
                startingGame();
                break;
            } else {
                System.out.println("Invalid input");
            }
            userChoice = input.nextLine();
        }
    }

    public void startingGame(){
        String userChoice = "";
        System.out.println(adventure.getPlayer().getRoomNameAndDescription());
        while (!userChoice.equals("q")){
            userChoice = input.nextLine().toLowerCase();
            String[] parts = userChoice.split(" ", 2);
            if(parts[0].equals("take") || parts[0].equals("t")){
                userChoice = "take";
            }
            if(parts[0].equals("drop") || parts[0].equals("d")){
                userChoice = "drop";
            }
            if(parts[0].equals("eat")){
                userChoice = "eat";
            }
            if(parts[0].equals("equip")){
                userChoice = "equip";
            }
            switch (userChoice){
                case "n", "go north", "north":
                    System.out.println("Going north...");
                    System.out.println(adventure.getPlayer().goNorth());
                    break;
                case "s", "go south", "south":
                    System.out.println("Going south...");
                    System.out.println(adventure.getPlayer().goSouth());
                    break;
                case "e", "go east", "east":
                    System.out.println("Going east...");
                    System.out.println(adventure.getPlayer().goEast());
                    break;
                case "w", "go west", "west":
                    System.out.println("Going west...");
                    System.out.println(adventure.getPlayer().goWest());
                    break;
                case "inventory", "inv", "i":
                    System.out.print("Your inventory: ");
                    System.out.println(adventure.getPlayer().showInventory());
                    break;
                case "take", "t":
                    if(parts.length == 2) {
                        adventure.getPlayer().takeItem(parts[1]);
                    }
                    break;
                case "drop", "d":
                    if(parts.length == 2){
                        adventure.getPlayer().dropItem(parts[1]);
                    }
                    break;
                case "eat":
                    if(parts.length == 2){
                        adventure.getPlayer().eat(parts[1]);
                    }
                    break;
                case "health":
                    System.out.println(adventure.getPlayer().getHealth());
                    break;
                case "equip":
                    if(parts.length == 2){
                        adventure.getPlayer().equipWeapon(parts[1]);
                    }
                    break;
                case "attack":

                    break;
                case "h", "help":
                    help();
                    break;
                case "l", "look":
                    look();
                    break;
                case "exit", "close", "q", "quit":
                    userChoice = "q";
                    break;
                default:
                    System.out.println("Invalid input. Press help for getting info");
                    break;
            }
        }
    }

    public void help(){
        System.out.println("Here are your options:");
        System.out.println("look/l for getting room description");
        System.out.println("exit/close/quit/q for quitting the game");
        System.out.println("go north/north/n, go south/south/s, go east/east/e, go west/west/w for directions");
    }

    public void look(){
        System.out.println("Here is the room description again: ");
        System.out.println(adventure.getPlayer().getRoomNameAndDescription());
    }
}
