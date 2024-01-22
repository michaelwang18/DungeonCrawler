public class Entity {
    //fuck you michael - past michael
    private Entity(){}


    public static Character goblin(double scaling){ // 1.1 would be 10% scaling, 2.7 would be 170% scaling
        int health = (int) Math.round(100 * scaling); //Hp
        int attack = (int) Math.round(20 * scaling + 20);
        int defense = (int) Math.round(15 * scaling);
        Character enemy = new Character("Goblin", health, attack, defense);
        return enemy;
    }

    public static Character orge(double scaling){ // 1.1 would be 10% scaling, 2.7 would be 170% scaling
        int health = (int) Math.round(350 * scaling); //Hp
        int attack = (int) Math.round(35 * scaling + 15);
        int defense = (int) Math.round(5 * scaling);
        Character enemy = new Character("Orge", health, attack, defense);
        return enemy;
    }

    public static Character golem(double scaling){ // 1.1 would be 10% scaling, 2.7 would be 170% scaling
        int health = (int) Math.round(200 * scaling + 50); //Hp
        int attack = (int) Math.round(50 * scaling + 15);
        int defense = (int) Math.round(30 * scaling);
        Character enemy = new Character("Golem", health, attack, defense);
        return enemy;
    }


    public static Character skeleton(double scaling){ // 1.1 would be 10% scaling, 2.7 would be 170% scaling
        int health = (int) Math.round(120 * scaling); //Hp
        int attack = (int) Math.round(35 * scaling + 25);
        int defense = (int) Math.round(5 * scaling);
        Character enemy = new Character("Skeleton", health, attack, defense);
        return enemy;
    }

    public static Character dragon(double scaling){ // 1.1 would be 10% scaling, 2.7 would be 170% scaling
        int health = (int) Math.round(200 * scaling + 100); //Hp
        int attack = (int) Math.round(25 * scaling + 20);
        int defense = (int) Math.round(30 * scaling + 10);
        Character enemy = new Character("Dragon", health, attack, defense);
        return enemy;
    }

    public static Character darkKnight(double scaling){ // 1.1 would be 10% scaling, 2.7 would be 170% scaling
        int health = (int) Math.round(275 * scaling + 50); //Hp
        int attack = (int) Math.round(35 * scaling );
        int defense = (int) Math.round(45 * scaling);
        Character enemy = new Character("Dark Knight", health, attack, defense);
        return enemy;
    }

    public static Character sans(double scaling){ // 1.1 would be 10% scaling, 2.7 would be 170% scaling
        int health = (int) Math.round(0 * scaling + 1); //Hp
        int attack = (int) Math.round(35 * scaling + 10);
        int defense = (int) Math.round(0 * scaling + 0);
        Character enemy = new Character("Sans", health, attack, defense);
        enemy.setDodgeChance(20);
        return enemy;
    }


    public static Character goblinKing(double scaling){ // 1.1 would be 10% scaling, 2.7 would be 170% scaling
        int health = (int) Math.round(200* scaling + 50); //Hp
        int attack = (int) Math.round(20 * scaling + 15);
        int defense = (int) Math.round(15 * scaling + 10);
        Character enemy = new Character("Goblin King", health, attack, defense);
        return enemy;
    }

    public static Character hydraHead(double scaling){ // 1.1 would be 10% scaling, 2.7 would be 170% scaling
        int health = (int) Math.round(200 * scaling + 150); //Hp
        int attack = (int) Math.round(25 * scaling + 20);
        int defense = (int) Math.round(20 * scaling + 5);
        Character enemy = new Character("Hydra Head", health, attack, defense);

        return enemy;
    }

    public static Character knight(double scaling){ // 1.1 would be 10% scaling, 2.7 would be 170% scaling
        int health = (int) Math.round(250* scaling + 50); //Hp
        int attack = (int) Math.round(20 * scaling + 15);
        int defense = (int) Math.round(15 * scaling + 10);
        Character enemy = new Character("Knight", health, attack, defense);
        return enemy;
    }





    public static Character[] allEnemies(double scale){
        Character[] enemyList = new Character[10];
        enemyList[0] = goblin(scale);
        enemyList[1] = goblin(scale - .05);
        enemyList[2] = goblin(scale - .05);
        enemyList[3] = skeleton(scale - .05);
        enemyList[4] = skeleton(scale - .05);
        enemyList[5] = skeleton(scale - .05);
        enemyList[6] = goblin(scale);
        enemyList[7] = goblin(scale);
        enemyList[8] = orge(scale - .05);
        enemyList[9] = orge(scale - .05);
        enemyList[10] = orge(scale);
        enemyList[11] = golem(scale - .05);
        enemyList[12] = golem(scale - .05);
        enemyList[13] = golem(scale);
        enemyList[14] = orge(scale);
        enemyList[15] = skeleton(scale);
        enemyList[16] = dragon(scale);
        enemyList[17] = dragon(scale);
        enemyList[18] = skeleton(scale + .05);
        enemyList[19] = skeleton(scale + .05);
        enemyList[20] = skeleton(scale - .05);
        enemyList[21] = golem(scale - .05);
        enemyList[22] = goblin(scale - .05);
        enemyList[23] = goblin(scale - .05);
        enemyList[24] = goblin(scale + .05);
        enemyList[25] = goblin(scale + .05);
        enemyList[26] = skeleton(scale + .05);
        enemyList[27] = skeleton(scale);
        return enemyList;
    }

    public static Character[] storyEnemy(double scale){
        Character[] enemyList = new Character[32];
        enemyList[0] = goblin(scale);
        enemyList[1] = goblin(scale);
        enemyList[2] = goblin(scale + .05);
        enemyList[3] = goblin(scale + .05);
        enemyList[4] = skeleton(scale - .05);
        enemyList[5] = skeleton(scale + .05);
        enemyList[6] = skeleton(scale);
        enemyList[7] = skeleton(scale);
        enemyList[8] = orge(scale + .05);
        enemyList[9] = orge(scale - .05);
        enemyList[10] = dragon(scale);
        return enemyList;
    }

    public static Item potion(){
        Item item = new Item("Potion","Heals for one third of your health", 0);
        return item;
    }
    public static Item orbOfVision(){
        Item item = new Item("Potion","Grants vision of all of the rooms", 0);
        return item;
    }
    public static Item key(){
        Item item = new Item("Key","Opens the door to the next entrance", 0);
        return item;
    }





    //GOOD PEOPLE PROLLY JUST HERE TO SEPERATE LINE CUZ YOU MESSY---------------------------------------------------------------------------------





    //BARBARIAN










}
