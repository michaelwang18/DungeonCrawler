import java.util.Scanner;

public class Battle {

    Character player;
    Character enemy;
    Scanner scan;
    boolean enemyAttack = false;
    boolean enemyBlock = false;


    public Battle(Character player, Character enemy){
        scan = new Scanner(System.in);
        this.player = player;
        this.enemy = enemy;

    }

    public boolean start(){
        System.out.println("You are confronted by a" + enemy.getName() + "!");


        while (player.alive && enemy.alive){

            System.out.println(player.info());
            System.out.println(enemy.info());
            System.out.println("What would you like to do? \n\n1) Attack\n2) Guard");
            int action = Utility.tryInput(scan.nextLine(),2);
            enemyChoice();
            if (action == 1 && enemyAttack){
                enemy.takeDMG(player.getATK());
                System.out.println("You hit the " + enemy.getName() + "!");
                player.takeDMG(enemy.getATK());
                System.out.println("It hits you back!");
            }
            if (action == 1 && enemyBlock){
                enemy.takeDMG(player.getATK()/2);
                System.out.println("You hit the " + enemy.getName() + " but it guarded!");
            }
            if (action == 2 && enemyAttack){
                player.takeDMG(enemy.getATK()/2);
                System.out.println("You hit the " + enemy.getName() + " but it guarded!");
            }
            if (action == 2 && enemyBlock){
                System.out.println("You stare each other in the eye,\nAwkwardly");
            }


        }


        if (player.alive){
            System.out.println("You win the encounter");
            return true;
        } else if (!enemy.alive){
            System.out.println("unfortunate end to your journey");
            return false;
        }
        return true;
    }

    private void enemyChoice(){
        if ((double)enemy.getHP()/enemy.getMaxHealth() > .5){
            if (Utility.chance(3,4)){
                enemyAttack = true;
                enemyBlock = false;
            } else {
                enemyAttack = false;
                enemyBlock = true;
            }
        } else {
            if (Utility.chance(3,4)){
                enemyAttack = false;
                enemyBlock = true;
            } else {
                enemyAttack = true;
                enemyBlock = false;
            }
        }
    }


}
