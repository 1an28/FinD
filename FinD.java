import java.util.Scanner;

class FinD {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]) {
        
        String choice;
        System.out.println("Welcome to FinD World! :)");

        Character Player = new Character(scanner);

        while (true) {
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
        }
        scanner.close();
        System.out.println("Bye! :)");
    }

    static void Battle(Character p1, Character p2) {
        setFirstTurn(p1, p2);
        System.out.println("Your " + ((1 == p1.getTurn()) ? "1st" : "2nd"));

        //Set number
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
        //main battle
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
    }
    static void setFirstTurn(Character p1, Character p2) {
        int Turn = (int)(Math.random() * 2);
        p1.setTurn(Turn);
        p2.setTurn(1 - Turn);
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
    Character(Scanner scanner) {
        //set name
        while (true) {
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

    Character(String Name, int Hp, int Mp) {
        this.name = Name;
        this.hp = Hp;
        this.mp = Mp;
    }

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

}
