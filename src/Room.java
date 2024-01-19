public class Room {

    private Game game;
    private String emoji;
    private String type;
    private boolean playerAT;
    private Boolean seen;
    private Boolean used;
    private Boolean entered;
    private String roomAction;








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
        roomEvent();
        seen = true;
        entered = true;
        playerAT = true;


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
        System.out.println("ARg its i the room " + type);

            if (type.equals("key")){
                if (!used) {
                    System.out.println("You got a key!");
                    System.out.println("Perhaps you should find the exit.");
                } else {
                    System.out.println("You got a key!");
                    System.out.println("(In your bag since you took it from the room already, idiot.)");
                }
            }

        if (type.equals("rest")){
            if (!used) {
                System.out.println("You feel rejuvenated");
                System.out.println("However it doesn't feel safe to sleep here anymore");
                //DO the funny here
            } else {
                System.out.println("You feel as if you are being watched.");
                System.out.println("Perhaps it's better to get a move on it");
            }
        }

        if (type.equals("exit")){
            if (!used) {
                if (game.getKey()){
                    game.escapeFloor();
                }
                System.out.println("You feel rejuvenated");
                System.out.println("However it doesn't feel safe to sleep here anymore");
                //DO the funny here
            } else {
                System.out.println("You feel as if you are being watched.");
                System.out.println("Perhaps it's better to get a move on it");
            }
        }







    }




    private void setEmoji(){
        if (this.type.equals("empty")){
            emoji = "⬜";
        }
        if (this.type.equals("trade")){
            emoji = "\uD83D\uDCB0";
        }
        if (this.type.equals("gamble")){
            emoji = "\uD83C\uDFB2";
        }
        if (this.type.equals("fight")){
            emoji = "⚔\uFE0F";
        }
        if (this.type.equals("rest")){
            emoji = "\uD83D\uDC9A";
            roomAction = "3) Take a rest at the room";
        }
        if (this.type.equals("boss")){
            emoji = "\uD83D\uDE08";
        }
        if (this.type.equals("key")){
            emoji = "\uD83D\uDDDD\uFE0F";
            roomAction = "3) Pick up the key";
        }
        if (this.type.equals("exit")){
            emoji = "\uD83D\uDD12";
        }




    }
}
