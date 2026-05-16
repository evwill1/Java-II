package module5.solve;

import java.util.*;

public class StoreAdventure {
    private static Map<String, GodricsMedievalStore> stores = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int coin = 1000;
    private static List<String> cart = new ArrayList<>();

    public static void main(String[] args) {

        // Stores
        GodricsMedievalStore weapons = new GodricsMedievalStore("Weapons");
        GodricsMedievalStore armoury = new GodricsMedievalStore("Armoury");
        GodricsMedievalStore potions = new GodricsMedievalStore("Potions");

        // items & prices
        weapons.addItem("Katana", 20.0);
        weapons.addItem("Bow", 40.0);
        weapons.addItem("30 Arrows", 4000.0);
        weapons.addItem("Daedric Long Sword", 80.0);
        armoury.addItem("Light Armour Set", 25.0);
        armoury.addItem("Heavy Armour Set", 75.0);
        potions.addItem("Healing", 30.0);
        potions.addItem("Poison Immunity", 15.0);

        // Add departments to map
        stores.put("Weapons", weapons);
        stores.put("Armoury", armoury);
        stores.put("Potions", potions);
        String currentStore = "Weapons";
        System.out.println("Welcome to Godric's Medieval Store!");
        System.out.println("Your starting coin: " + coin + " gold");
        
        // Loop that displays current store and items
        while (true) {
            GodricsMedievalStore store = stores.get(currentStore);
            System.out.println("\nYou are in the " + store.getName() + " Catagory.");
            System.out.println("Items for sale:");
            
            // Displays list of times
            for (Map.Entry<String, Double> entry : store.getItems().entrySet()) {
                System.out.println("- " + entry.getKey() + " " + entry.getValue()  + " gold");
            }

            // Display coin and cart text for options
            System.out.println("Current coin: " + coin + " gold");
            System.out.println("Cart: " + cart);
            System.out.println("What would you like to do? (move/buy/exit)");
            String action = scanner.nextLine();

            // Moving stores
            if (action.equalsIgnoreCase("move")) {
                System.out.println("Where would you like to go? (Weapons/Armoury/Potions)");
                String next = scanner.nextLine();

                if (stores.containsKey(next)) {
                    currentStore = next;

                } else {
                    System.out.println("That store doesn't exist.");
                }

            // Buy item
            } else if (action.equalsIgnoreCase("buy")) {
                System.out.println("What would you like to buy?");
                String item = scanner.nextLine();

                // Select item
                if (store.getItems().containsKey(item)) {
                    Double price = store.getItems().get(item);

                    // Check price of item is less than current coin
                    if (coin >= price) {
                        coin -= price;
                        cart.add(item);
                        store.removeItem(item);
                        System.out.println("You bought the " + item + " for " + price + " gold");
                    
                    // not enough coin
                    } else {
                        System.out.println("Not enough coin!");
                    }

                // Invalid item
                } else {
                    System.out.println("Item not found in this Store.");
                }
            // Exit option
            } else if (action.equalsIgnoreCase("exit")) {
                System.out.println("\nThanks for shopping! Here's what you bought:");

                // list of bought items
                for (String s : cart) {
                    System.out.println("- " + s);
                }

                // Remaining coin
                System.out.println("Remaining coin: " + coin + " gold");
                break;
            // Did not move/buy/exit
            } else {
                System.out.println("Invalid action.");
            }

        }

    }

}
