package machine;
import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int beans;
        
    public CoffeeMachine(int water, int milk, int beans) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;        
    }
            
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Write how many ml of water the coffee machine has: ");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int beans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int amount = scanner.nextInt();
        
        CoffeeMachine machine = new CoffeeMachine(water, milk, beans);
        CoffeCup cup = new CoffeCup();

        int availableCups = cup.cupsAmount(machine.water, machine.milk, machine.beans); 
        if (amount == availableCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (amount > availableCups) {
            System.out.printf("No, I can make only %d cup(s) of coffee", availableCups);
        } else if (amount < availableCups) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", availableCups - amount);
        }
        
    }
}

class CoffeCup {
    private int water = 200;
    private int milk = 50;
    private int beans = 15;
    
    public int cupsAmount(int water, int milk, int beans) {
        int amount = 0;
        int byWater = water / this.water;
        int byMilk = milk / this.milk;
        int byBeans = beans / this.beans;
        amount = Math.min(byWater, Math.min(byMilk, byBeans));
        return amount;
    }    
}
