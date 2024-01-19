import java.util.Scanner;

public class Game {
    private Boolean alive;
    private Character player;
    private Scanner scan;
    private int floorLevel;
    private int gridSize;
    private Room[][] floor;
    private int playerY;
    private int playerX;
    private boolean floorEscaped;
    private boolean hasKey;



    public Game() {
        gridSize = 3;
        floorLevel = 0;
        alive = true;
        createFloor();

        //DISPLAYS THE MAP
        while (alive) {
            createFloor();
            floorLevel++;
            floorEscaped = false;
            System.out.println(Color.WHITE_BOLD_BRIGHT + "WELCOME TO FLOOR" + floorLevel + "!\n\n" +Color.RESET);
            while (!floorEscaped) {

                viewmap();
                // PLAYER TURN/ACTION
                System.out.println("What would you like to do? \n1)Move to different room\n2)Use an item");
                int action = Utility.tryInput(scan.nextLine(), 3);
                switch (action) {
                    case 1:
                        playerMovement();
                        break;
                    case 2:
                        //View Items
                        break;
                    case 3:
                        floor[playerY][playerX].roomEvent();
                        break;


                }

            }


        }
    }

    private void createFloor() {
        scan = new Scanner(System.in);
        String[] possibleRooms = {"empty", "empty", "empty", "fight", "trade", "rest", "fight", "gamble"};

        String playerLocation = ((int) (Math.random() * gridSize)) + "," + ((int) (Math.random() * gridSize));
        playerY = Integer.parseInt(playerLocation.substring(0, 1));
        playerX = Integer.parseInt(playerLocation.substring(2));
        System.out.println("You are at " + (playerY + 1) + "," + (playerX + 1));

        Room[][] floor = new Room[gridSize][gridSize]; // 3 rows, 4 columns
        for (int i = 0; i < gridSize; i++) { // row
            for (int j = 0; j < gridSize; j++) { // column
                if (floor[i][j] == null) {
                    floor[i][j] = new Room(possibleRooms[(int) (Math.random() * 8)], this);  //COLORING
                }
                System.out.print(floor[i][j].display() + "  ");
            }
            System.out.println("");
        }


        while (true) {
            //create boss
            int bossX = playerY;
            int bossY = playerX;
            while (bossY == playerX || bossX == playerY) {
                bossY = (int) (Math.random() * gridSize);
                bossX = (int) (Math.random() * gridSize);
            }
            int keyX = playerY;
            int keyY = playerX;
            while (keyY == playerX || keyX == playerY || keyX == bossX && keyY == bossY) {
                keyX = (int) (Math.random() * gridSize);
                keyY = (int) (Math.random() * gridSize);
            }
            int exitX = playerY;
            int exitY = playerX;
            while (exitX == playerY || exitY == playerX || exitX == bossX && exitX == bossY || exitX == keyX && exitY == keyY) {
                exitX = (int) (Math.random() * gridSize);
                exitY = (int) (Math.random() * gridSize);
            }
            floor[bossX][bossY] = new Room("boss",this);
            floor[keyX][keyY] = new Room("key",this);
            floor[exitX][exitY] = new Room("exit",this);
        }

    }

    private void viewmap(){
        for (int i = 0; i < gridSize; i++) { // row
            for (int j = 0; j < gridSize; j++) { // column
                //floor[i][j].see();
                System.out.print(floor[i][j].display() + " ");
            }
            System.out.println("");
        }
    }

    private void playerMovement(){
        System.out.println("\nEnter Move");
        String resp = scan.nextLine().toLowerCase();
        floor[playerY][playerX].playerLeave();
        if (resp.equals("w")) {
            if (!((playerY - 1) < 0)) {
                playerY--;
            } else {
                System.out.println(Color.RED + "Out of Bound bruh" + Color.RESET);
            }
        }
        if (resp.equals("a")) {
            if (!((playerX - 1) < 0)) {
                playerX--;
            } else {
                System.out.println(Color.RED + "Out of Bound bruh" + Color.RESET);
            }
        }
        if (resp.equals("s")) {
            if (!((playerY + 1) >= gridSize)) {
                playerY++;
            } else {
                System.out.println(Color.RED + "Out of Bound bruh" + Color.RESET);
            }
        }
        if (resp.equals("d")) {
            if (!((playerX + 1) >= gridSize)) {
                playerX++;
            } else {
                System.out.println(Color.RED + "Out of Bound bruh" + Color.RESET);
            }
        }
        if (!resp.equals("w") && !resp.equals("a") && !resp.equals("s") && !resp.equals("d")) {
            System.out.println(Color.RED + "INVALID INPUT" + Color.RESET);
        }
        floor[playerY][playerX].playerEnter();
    }

    public void escapeFloor(){
        floorEscaped = true;
    }

    public void setKey(boolean hasKey) {
        this.hasKey = hasKey;
    }

    public boolean getKey() {
       return hasKey;
    }
}//END








