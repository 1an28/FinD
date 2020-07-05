import java.util.Scanner;

class FinD {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        System.out.println("Welcome to FinD World! :)");
        while (true) {
            System.out.println("please choose [1](Combat) or [0](Exit).");
            choice = scanner.next();
            if ("0".equals(choice)) {
                break;
            } else if ("1".equals(choice)) {
                System.out.println("There's no one here.");
            } else {
                System.out.println("please input 1 or 0.");
            }
        }
        scanner.close();
        System.out.println("Bye! :)");
    }
}