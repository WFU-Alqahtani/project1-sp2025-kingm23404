import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Item[] setupStore() {
        Item[] store = new Item[5];
        store[0] = new Item("Cleats", 20.00);
        store[1] = new Item("Shin Guards", 5.00);
        store[2] = new Item("Jersey", 25.00);
        store[3] = new Item("Shorts", 15.00);
        store[4] = new Item("Socks", 10.00);
        return store;
    }

    public static ArrayList<Item> createCart(String[] args, Item[] store) {
        ArrayList<Item> cart = new ArrayList<>();

        for (String arg : args) {
            try {
                int index = Integer.parseInt(arg);
                if (index >= 0 && index < store.length) {
                    cart.add(store[index]);
                } else {
                    System.out.println("The store does not have an item of index " + index + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("\"" + arg + "\" is not a valid integer.");
            }
        }

        if (cart.isEmpty()) {
            System.out.println("No valid input to cart.");
        }

        return cart;
    }

    public static void printReceiptInOrder(ArrayList<Item> cart) {
        System.out.println("Receipt");
        System.out.println("==================");
        System.out.println("Item          Price");

        double subtotal = 0;
        for (Item item : cart) {
            System.out.printf("%-13s $%.2f%n", item.getItemName(), item.getItemPrice());
            subtotal += item.getItemPrice();
        }

        System.out.println("=========================");
        double salesTax = subtotal * 0.05;
        double total = subtotal + salesTax;
        System.out.printf("(a) Subtotal: $%.2f%n", subtotal);
        System.out.printf("(b) Sales Tax: 5%%%n");
        System.out.printf("(c) Total: $%.2f%n", total);
    }

    public static void emptyCartReverseOrder(ArrayList<Item> cart) {
        System.out.println("Removing all items from the cart in \"Last In First Out\" order...");
        while (!cart.isEmpty()) {
            Item item = cart.remove(cart.size() - 1); // Remove the last item
            System.out.println("Removing: " + item.getItemName());
        }
        System.out.println("Cart has been emptied.");
    }

    public static void main(String[] args) {
        Item[] store = setupStore();

        ArrayList<Item> cart = createCart(args, store);

        if (!cart.isEmpty()) {
            printReceiptInOrder(cart);
            emptyCartReverseOrder(cart);
        }
    }
}

