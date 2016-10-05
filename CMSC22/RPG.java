import java.util.*;

public class RPG {

    public static int lev = 1;

    public static int kills = 0;

    public static RPGCharacter hero;

    private Random rand = new Random();

    private static Random rand1 = new Random();

    public RPG() {
        this.rand = new Random();
        this.rand1 = new Random();
    }

    // generate a random monster name..
    public String getRandomMonsterName() {
        String[] adjectives = {"The Deadly", "Evil", "The Blood Thirsty", "Dark"};
        String[] monsters = {"Woman", "Figure", "Witch", "Keeper"};
        List<String> adjs = Arrays.asList(adjectives);
        List<String> mons = Arrays.asList(monsters);

        return adjs.get(randInt(0, adjs.size() - 1)) + " " + mons.get(randInt(0, mons.size() - 1));
    }

    // inclusive random integer
    public int randInt(int min, int max) {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static int rand1Int(int min, int max) {
        int randomNum = rand1.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    // coin toss
    public boolean coinToss(int accuracy) {
        return randInt(0, accuracy) >= 1 ? true : false;
    }

    public static boolean coinToss1(int accuracy) {
        return rand1Int(0, accuracy) >= 1 ? true : false;
    }

    // pause the game for awhile for dramatic effect!
    public static void sleep(int x) {
        try {
            Thread.sleep(x);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    // duel two characters, one as attacker, one as defender
    // returns true if someone is killed
    public boolean duel(RPGCharacter attacker, RPGCharacter defender, RPGCharacter attackerSkill) {
        int damage = attackerSkill.attack();
        System.out.println("--> " + attacker.getName() + " ATTACK " + defender.getName());
        sleep(2000);

        if (coinToss(attacker.accuracy())) {
            int remHp = defender.damageTaken(damage);
            System.out.println("");
            System.out.println("--> DAMAGE: " + damage);
            System.out.println("");
            if (remHp <= 0) {
                System.out.println("");
                System.out.printf("--> %s killed %s!\n", attacker.getName(), defender.getName());
                System.out.println("");
                sleep(1500);
                return true;
            }
        } else {
            System.out.println("");
            System.out.println("--> MISSED!");
            System.out.println("");
        }
        return false;
    }

    public static void fight() {
        int baseAtk = 10;
        int maxAtk = 20;
        RPG rpg = new RPG();
        String monsterName = rpg.getRandomMonsterName();
        int hpMin = 60;
        int hpMax = 70;
        int atkMin = baseAtk;
        int atkMax = maxAtk;

        int monsterHP = rpg.randInt(hpMin, hpMax);
        
        RPGCharacter monster = new Monster(monsterName, monsterHP);
        RPGCharacter monsterNew;

        // System.out.println("HERO LEVEL: " + lev);
        System.out.printf("%s\n%s\n", hero, monster);
        System.out.println("");

        // fight! for version 1, hero will always attack first.
        int count = 0;
        // int nothing = 0;

        RPGCharacter heroNew;
        while (true) {

            if (coinToss1(2)) {
                atkMin += 0;
                atkMax += 0;
            }else {
                atkMin += 10;
                atkMax += 20;
            }

            int power = rpg.rand1Int(atkMin, atkMax);

            monsterNew = new Monster(power);

            atkMin = baseAtk;
            atkMax = maxAtk;

            Scanner scan = new Scanner(System.in);
            // System.out.println("== round " + ++count);
            System.out.println("");
            System.out.println("Use skill number: ");
            int skill = scan.nextInt();
            heroNew = new Archer(skill, lev);
            // hero's turn
            System.out.println("");
            boolean heroVsMonster = rpg.duel(hero, monster, heroNew);

            if (heroVsMonster) {
                if (lev == 100) {
                    lev = 100;
                }else {
                    lev += 2;
                }
                kills++;
                hpMin += 10;
                hpMax += 10;
                baseAtk += 15;
                maxAtk += 15;

                Scanner scanned = new Scanner(System.in);
                System.out.println("Proceed to Next Monster? (y/n)");
                String proceed = scanned.next();

                if (proceed.equals("y") || proceed.equals("Y")) {
                    char c = '\n';
                    int length = 25;
                    char[] chars = new char[length];
                    Arrays.fill(chars, c);
                    System.out.print(String.valueOf(chars));
                    
                    System.out.println("Ready....");
                    System.out.println("");
                    sleep(1500);
                    RPGCharacter myHero = new Archer(lev);
                    fight();
                }else {
                    System.out.println("Monsters Killed: " + kills);
                    break;
                }
            }

            // monster's turn
            boolean monsterVsHero = rpg.duel(monster, hero, monsterNew);

            if (monsterVsHero) {
                System.out.println("YOU LOOSE!!!");
                System.out.println("Monsters Killed: " + kills);
                break;
            }

            System.out.println("");
            System.out.printf("%s\n%s\n", hero, monster);
            System.out.println("");
        }
    }


    public static void game() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter character name: ");
        String charName = sc.next();

        hero = new Archer(charName, lev); // TODO take parameters as input via STDIN

        char c = '\n';
        int length = 25;
        char[] chars = new char[length];
        Arrays.fill(chars, c);
        System.out.print(String.valueOf(chars));

        sleep(1500);

        System.out.println("====== GAME START =====");
        System.out.println("");

        fight();
    }


    // game...
    public static void main(String[] args) {
        game();
    }
}