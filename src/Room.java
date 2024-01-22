public class Room {

    private Game game;
    private String emoji;
    private String type;
    private boolean playerAT;
    private Boolean seen;
    private Boolean used = false;
    private Boolean entered;
    private String roomAction;

    public String getRoomAction() {
        return roomAction;
    }

    public Room (Game game){
        this.game = game;
        entered = false;
        seen = false;
        type = "empty";
        used = false;
        roomAction = "3) Stare into the Abyss";
        setEmoji();
    }


    public Room (String type, Game game){
        this.game = game;
        entered = false;
        seen = false;
        this.type= type;
        setEmoji();
    }
    public void playerEnter(){
        seen = true;
        entered = true;
        playerAT = true;
        if (type.equals("fight") && !used||type.equals("boss") && !used){
            System.out.println("Epic battle occured");
            Battle battle = new Battle(game.getPlayerChar(),Entity.goblin(1));
            battle.start();
            used = true;
        }
    }
    public void playerLeave(){
        playerAT = false;
    }




    public void see(){
        seen = true;
    }


    public String display(){
        if (!seen){
            return "\uD83D\uDD33";
        } else if (playerAT){
            return "🟨";
        } else {
            return emoji;
        }
    }


    public void roomEvent(){

            if (type.equals("key")){
                if (!used) {
                    System.out.println("You got a key!");
                    System.out.println("Perhaps you should find the exit.");
                    game.getItems()[2].gain();
                    used = true;
                } else {
                    System.out.println("You got a key!");
                    System.out.println("(In your bag since you took it from the room already, idiot.)");
                }
            }

        if (type.equals("rest")){
            if (!used) {
                System.out.println("You feel rejuvenated");
                System.out.println("However it doesn't feel safe to sleep here anymore");
                used = true;
                //DO the funny here
            } else {
                System.out.println("You feel as if you are being watched.");
                System.out.println("Perhaps it's better to get a move on it");
            }
        }

        if (type.equals("exit")){
       {
                if (game.getItems()[2].getCount() > 0){
                    game.escapeFloor();
                    game.getItems()[2].use();
                    System.out.println("You proceed to the next floor");
                    game.escapeFloor();
                    //DO the funny here
                } else {
                    System.out.println("The exit is locked shut.");
                    System.out.println("You would need a key to exit");
                }

            }
        }


        if (type.equals("empty")){
            System.out.println("It was rather soothing.");
        }







    }




    private void setEmoji(){
        if (this.type.equals("empty")){
            emoji = "⬜";
            roomAction = "Sit and stare into the darkness";
        }
        if (this.type.equals("trade")){
            emoji = "\uD83D\uDCB0";
            roomAction = "Approach the suspicious man";
        }
        if (this.type.equals("item")){
            emoji = "\uD83C\uDFB2";
            roomAction = "Open the chest";
        }
        if (this.type.equals("fight")){
            emoji = "⚔\uFE0F";
            roomAction = "inspect the corpse";
        }
        if (this.type.equals("rest")){
            emoji = "\uD83D\uDC9A";
            roomAction = "Take a rest at the room";
        }
        if (this.type.equals("boss")){
            emoji = "\uD83D\uDE08";
        }
        if (this.type.equals("key")){
            emoji = "\uD83D\uDDDD\uFE0F";
            roomAction = "Pick up the key";
        }
        if (this.type.equals("exit")){
            emoji = "\uD83D\uDD12";
            roomAction = "Attempt to leave";
        }




    }
}
