import java.util.ArrayList;
import java.util.Scanner;

public class Character {


    private String name;
    private String description = "Blah Blah";
    private ArrayList<String[]> allSkills = new ArrayList<String[]>();
    private Scanner scan = new Scanner(System.in);
    private int maxHealth;
    private int maxHPUp = 0;
    private int health;
    private int attack;
    private int atkUp = 0;
    private int defense;
    private int defUp = 0;
    public boolean alive = true;
    private int critChance;
    private int dodgeChance;

    public Character(String name, int health, int attack, int defense){
        this.name = name;
        this.attack = attack;
        maxHealth = health;
        this.defense = defense;
        this.health = maxHealth;
        critChance = 1;
        dodgeChance = 1;
    }


    public Character(){
        name = "empty";
        alive = false;
    }

    public void statChange(int hp, int atk, int def, int maxHP){
        this.health += hp;
        this.attack += atk;
        atkUp += atk;
        this.defense += def;
        defUp += def;
        this.maxHealth += maxHP;
        maxHPUp += maxHP;
        if (!alive){
            health = 0;
        }
    }

    public void heal(){
        health = maxHealth;
        alive = true;
    }

    public void takeDMG(int dmg){
        int damageTaken = dmg - defense;
        boolean dodge = false;
        String dmgColor = Color.WHITE_BOLD_BRIGHT;
        if (Utility.chance(critChance,20)){ //Crit
            damageTaken = (int)(dmg * 1.5 - (defense * .5));
            dmgColor = Color.YELLOW_BOLD_BRIGHT;
            System.out.print(Utility.color("CRITICAL HIT! ",dmgColor));
        } else if (Utility.chance(dodgeChance,20)){
            damageTaken = 0;
            System.out.print(Utility.color("DODGED! ",dmgColor));
            dodge = true;
        }
        if (damageTaken < 0 && !dodge){
            damageTaken = 1;
        }
        health = health - damageTaken;
        System.out.print (Utility.color(name,Color.CYAN_BOLD_BRIGHT) + " takes " + Utility.color(damageTaken + " Damage! ",dmgColor));
        System.out.println( "and has " + health + "/" + maxHealth + " health left");
        if (health <= 0){
            health = 0;
            if (!name.equals("Hydra Head") && !alive) {
                System.out.println(name + " fainted!\n");
            }
            alive = false;
        }
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void addSkills(String[] skill){
        allSkills.add(skill);
        //System.out.println(name + " Learnt The Skill: " + skill[0] + "!");
    }
    public int getHP(){return health;}
    public int getMaxHealth(){return maxHealth;}
    public int getATK(){return attack;}
    public int getDEF(){return defense;}
    public String getName(){return name;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public ArrayList<String[]> getAllSkills() {
        return allSkills;
    }

    public void setDodgeChance(int dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    public void setCritChance(int critChance) {
        this.critChance = critChance;
    }

    public void setHealth(int health) {this.health = health;}

    public String info() {
        if (name.equals("Hydra Head") || alive && !(name.equals("empty"))) {
            String hp =  health + "/" + maxHealth + "\uD83D\uDC9AHP  ";
            String atk = attack + "⚔\uFE0FATK  ";
            String def = defense + "\uD83D\uDEE1\uFE0FDEF  ";
            String status = Color.CYAN_BOLD_BRIGHT + Utility.spaceout(name, 14) + Color.CYAN_BOLD + " " + Utility.spaceout(hp, 13) + Utility.spaceout(atk,7) + Utility.spaceout(def,10);

            return status + Color.RESET;
        } else if (!(name.equals("empty"))){
            String hp =  health + "/" + maxHealth + "\uD83D\uDC9AHP  ";
            String atk = attack + "⚔\uFE0FATK  ";
            String def = defense + "\uD83D\uDEE1\uFE0FDEF  ";
            String status = Utility.spaceout(name, 14) + " " + Utility.spaceout(hp, 13) + Utility.spaceout(atk,7) + Utility.spaceout(def,10);

            return Color.RED_BRIGHT + status + Color.RESET;
        }
        return "";
    }


}
