import java.util.Scanner;

class FinD {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]) {
        cls();
        String choice;
        System.out.println("Welcome to FinD World! :)");

        Character PlayerA = new Character();

        System.out.println("please type playerA's name.");
        PlayerA.setName(scanner.next());
        cls();

        Character PlayerB = new Character();
        System.out.println("please type playerB's name.");
        PlayerB.setName(scanner.next());
        cls();
        
        while (true) {
            /*
            System.out.println("please choose [1](Combat) or [0](Exit).");
            choice = scanner.next();
            if ("0".equals(choice)) {
                break;
            } else if ("1".equals(choice)) {
                Character Slime = new Character("Slime", 10, 1);
                System.out.println("name = " + Slime.getName());

                Battle(Player, Slime);

            } else {
                System.out.println("please input 1 or 0.");
            }
            */
            Battle(PlayerA, PlayerB);
            break;
        }
        scanner.close();
        System.out.println("Bye! :)");
    }

    static void Battle(Character p1, Character p2) {
        Character[] list = new Character[2];

        //Set number
        System.out.println("Please set " + p1.getName() + " number.");
        p1.setNum(scanner.nextInt());
        cls();
        System.out.println("Please set " + p2.getName() + " number.");
        p2.setNum(scanner.nextInt());
        cls();

        //set 1st.
        setFirstTurn(p1, p2);
        list[p1.getTurn()] = p1;
        list[p2.getTurn()] = p2;        
        //System.out.println(list[1].getName() + " is 1st.");
        
        /*
        while (true) {
            System.out.println("Set your first number. [1] - [" + p1.getHp() +"]");
            p1.setNum(scanner.nextInt());
            if (1 <= p1.getNum() && p1.getNum() <= p1.getHp()) {
                System.out.println("Your number is " + p1.getNum());
                break;
            } else {
                System.out.println("Please type number. [1] - [" + p1.getHp() +"]");
            }
        }
        
        //Set enemy (bot)
        p2.setNum((int)(Math.random() * p2.hp) + 1);
        */
        //main battle
        int turnCount = 0;
        while (true) {
            turnCount++;
            boolean gameSet = oneTurn(list, turnCount);
            if (gameSet) {
                break;
            }
        }

        System.out.println(list[turnCount % 2].getName() + " WIN!!!");
        
        /*
        int turnCount = 0;
        int oppNum = 0;
        while (true) {
            turnCount++;
            System.out.println(((turnCount % 2 == p1.getTurn()) ? p1.getName() : p2.getName()) + "Turn");

            while (true) {
                System.out.println("Predict your opponent's numbers.");
                oppNum = scanner.nextInt();
                if (1 <= oppNum && oppNum <= p2.getHp()) {
                    break;
                } else {
                    System.out.println("Please type number. [1] - [" + p2.getHp() +"]");
                }    
            }
            if (oppNum == p2.getNum()) {
                System.out.println("you win!");
                break;
            }
        }
        */

    }
    static void setFirstTurn(Character p1, Character p2) {
        int Turn = (int)(Math.random() * 2);
        p1.setTurn(Turn);
        p2.setTurn(1 - Turn);
    }
    static void cls() {
        System.out.printf("\033[2J");
    }
    static boolean oneTurn(Character[] p, int Turn) {
        Character[] Players = new Character[2];
        int guess = -1;
        boolean game = false;

        //Players[0] is Player. Players[1] is opponent.
        Players[0] = p[Turn % 2];
        Players[1] = p[1 - Turn % 2];

        System.out.println(Players[0].getName() + " Turn.");
        System.out.println("guess opponent number.");
        guess = scanner.nextInt();

        cls();

        if (guess == Players[1].getNum()) {
            game = true;
        } else if (guess > Players[1].getNum()) {
            System.out.println("more smaller.");
        } else if (guess < Players[1].getNum()) {
            System.out.println("more larger.");
        }

        return game;
    }
}

class Character {
    //name
    String name;
    //drop item
    String drop;
    //character's number
    int num;
    //hit point
    int hp;
    //move point
    int mp;
    //turn
    int turn;
    /*
    Character(Scanner scanner) {

        //set name
        while (true) {
            cls();
            System.out.println("Please type your name.");
            setName(scanner.next());

            String choice;
            while (true) {
                System.out.println("Is your name " + getName() + " ?");
                System.out.println("1[Yes] or 0[No].");
                choice = scanner.next();
                if ("0".equals(choice) || "1".equals(choice)) {
                    break;
                } else {
                    System.out.println("please input 1 or 0.");
                }
            }
            if ("1".equals(choice)) {
                System.out.println("Registered your name.");
                break;
            }
        }

        //set hp
        setHp(100);

        //set mp
        setMp(5);
        

    }

    */

    void setName(String newName) {
        this.name = newName;
    }
    String getName() {
        return this.name;
    }

    void setHp(int newHp) {
        this.hp = newHp;
    }
    int getHp() {
        return this.hp;
    }

    void setMp(int newMp) {
        this.mp = newMp;
    }
    int getMp() {
        return this.mp;
    }

    void setNum(int newNum) {
        this.num = newNum;
    }
    int getNum() {
        return this.num;
    }

    void setTurn(int newTurn) {
        this.turn = newTurn;
    }
    int getTurn() {
        return this.turn;
    }

    static void cls() {
        System.out.printf("\033[2J");
    }
}
