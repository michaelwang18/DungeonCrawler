import java.util.Scanner;

public class Game {
    private Boolean alive;
    private Character player;
    private Scanner scan;
    private int floorLevel;
    private int gridSize;
    private Room[][] floor;
    private Character playerChar;
    private int playerY;
    private int playerX;
    private boolean floorEscaped;
    private Item[] items = {Entity.potion(),Entity.orbOfVision(),Entity.key()};

    public Item[] getItems() {
        return items;
    }

    public Character getPlayerChar() {
        return playerChar;
    }

    public Game() {
        scan = new Scanner(System.in);
        gridSize = 4;
        floorLevel = 0;
        alive = true;
        playerChar = Entity.knight(1);


        while (alive) { //LOOPING FLOORS
            createFloor();
            floorLevel++;
            floorEscaped = false;
            System.out.println(Color.WHITE_BOLD_BRIGHT + "WELCOME TO FLOOR " + floorLevel + "!\n\n" +Color.RESET);
            System.out.println("---------------------------------------------------------------------------");

            while (!floorEscaped && alive) { //LOOPING ACTION IN THE FLOOR

                viewMap();
                System.out.println("\nITEMS] ");
                for (Item item: items){
                    if (item.getCount() > 0){
                        System.out.print(item.getName() + " " + Color.YELLOW_BOLD_BRIGHT + item.getCount() + "x" + Color.RESET);
                    }
                }
                // PLAYER TURN/ACTION
                System.out.println("\nWhat would you like to do? \n(W,A,S,D) Move to different room\n1) Use an item\n2) " + floor[playerY][playerX].getRoomAction());
                System.out.println();
                String resp = scan.nextLine();
                System.out.println("\n\n\n\n");
                if (resp.toLowerCase().equals("w")||resp.toLowerCase().equals("a")||resp.toLowerCase().equals("s")||resp.toLowerCase().equals("d")){
                   playerMovement(resp.toLowerCase());
                } else {
                    int action = Utility.tryInput(resp, 2);
                    switch (action) {
                        case 1:
                            viewItems();
                            System.out.println("what would you like to use?");
                            break;
                        case 2:
                            floor[playerY][playerX].roomEvent();
                            break;
                    }
                }




            }


        }
    }

    private void createFloor() {
        String[] possibleRooms = {"empty", "empty", "empty", "fight", "trade", "rest", "fight", "empty"};

        String playerLocation = ((int) (Math.random() * gridSize)) + "," + ((int) (Math.random() * gridSize));
        playerY = Integer.parseInt(playerLocation.substring(0, 1));
        playerX = Integer.parseInt(playerLocation.substring(2));
        System.out.println("You are at " + (playerY + 1) + "," + (playerX + 1));

        floor = new Room[gridSize][gridSize]; // 3 rows, 4 columns
        for (int i = 0; i < gridSize; i++) { // row
            for (int j = 0; j < gridSize; j++) { // column
                if (floor[i][j] == null) {
                    floor[i][j] = new Room(possibleRooms[(int) (Math.random() * 8)], this);  //COLORING
                }
            }
        }


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

            floor[playerY][playerX] = new Room("empty",this);
            floor[playerY][playerX].playerEnter();

    }

    private void viewMap(){
        for (int i = 0; i < gridSize; i++) { // row
            for (int j = 0; j < gridSize; j++) { // column
                //floor[i][j].see();
                System.out.print(floor[i][j].display() + " ");
            }
            System.out.println("");
        }
    }

    private void viewItems(){
        Boolean hasItem = false;
        Item[] haveList = new Item[3];
        int have = 0;
        for (Item item: items){
            if (item.getCount() > 0){
                System.out.println((have+1) + ")" + item.getName() + Color.YELLOW_BOLD_BRIGHT + item.getCount() + "x\n" + Color.WHITE_BOLD + item.getDescription() + Color.RESET );
                hasItem = true;
                haveList[have] = item;
            }
        }
        if (!hasItem){
            System.out.println("You have no items currently,\npoor...");
        } else {
            System.out.println("What item would do you like to use?");
            Item using = haveList[Utility.tryInput((scan.nextLine()),haveList.length-1) - 1];
            if (using.getName().equals("Key")){
                System.out.println(".. what you gonna do with it? eat it?");
            }
            //System.out.println("you used a " +  haveList[Utility.tryInput(scan.nextLine(),haveList.length-1)] + " and have " + haveList[Utility.tryInput(scan.nextLine(),haveList.length-1)].getCount() + "Left");
        }
    }

    private void playerMovement(String resp){
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

}//END








