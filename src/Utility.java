import java.util.Scanner;

public class Utility {

    public static String spaceout(String orignal, int length){
        String res = orignal;
        while (res.length() < length){
            res = res + " ";
        }
        return res;
    }

    public static boolean chance(int numerator, int denominator){
        double randNum = Math.random();
        double rate = (double) numerator/denominator;
        if (randNum <= rate){
            return true;
        }
        return false;
    }

    public static int tryInput(String input, int max){ // Learnt From W3Schools https://www.w3schools.com/java/java_try_catch.asp
        int num = 0;
        Scanner scan = new Scanner(System.in);
        try {
            num = Integer.parseInt(input);
            if (num > max){
                System.out.println( Color.RED + "Please Enter A Valid Input! " + Color.RESET);
                num = tryInput(scan.nextLine(), max);
            }
        } catch (Exception e){
            System.out.println( Color.RED + "Please Enter A Valid Input! " + Color.RESET);
            num = tryInput(scan.nextLine(), max);
        }
        return num;
    }

    public static String moveTryInput(String input){ // Learnt From W3Schools https://www.w3schools.com/java/java_try_catch.asp
        Scanner scan = new Scanner(System.in);
        String movement = input.toLowerCase(); //lowercase
        try {
            if (!(movement.equals("w")||movement.equals("a")||movement.equals("s")||movement.equals("d"))){
                System.out.println( Color.RED + "Please Enter A Valid Input! " + Color.RESET);
                moveTryInput(scan.nextLine());
            }
        } catch (Exception e){
            System.out.println( Color.RED + "Please Enter A Valid Input! " + Color.RESET);
            moveTryInput(scan.nextLine());
        }
        return movement;
    }

    public static String plural(String input, int number){
        if (!(1 == Math.abs(number))){
            return input + "s";
        }
        return input;
    }

    public static String color(String input, String color){
        return (color + input + Color.RESET);
    }

    public static String healthBar(double health, double maxHP){
        String color = Color.GREEN_BACKGROUND;
        double ratio = health/maxHP;
        if (ratio <= .50){
            color = Color.YELLOW_BACKGROUND;
        }
        if (ratio <= .02 && ratio != 0){  //BRUTE FORCE 1%
            return color + " " + Color.RED_BACKGROUND + "                                                  " + Color.RESET;
        }
        int bars = (int) (ratio/.02);
        String hpBar = color;

        for (int i = 0; i < bars; i++){
            hpBar += " ";
            if (i > 50){
                hpBar += Color.CYAN_BACKGROUND;
            }
        }
        hpBar += Color.RED_BACKGROUND;
        for (int i = bars; i < 50; i++){
            hpBar += " ";
        }


        return hpBar + Color.RESET;
    }
}
