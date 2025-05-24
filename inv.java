import java.util.Scanner;

public void main() {
    final int MAX_ITEMS = 100;
    int[] productIds = new int[MAX_ITEMS];
    String[] productNames = new String[MAX_ITEMS];
    int[] quantities = new int[MAX_ITEMS];
    double[] prices = new double[MAX_ITEMS];
    int itemCount = 0;

    Scanner scanner = new Scanner(System.in);
    boolean running = true;

    while (running) {
        System.out.println("Inventory Management System");
        System.out.println("1. Add Product");
        System.out.println("2. View All Products");
        System.out.println("3. Search Product");
        System.out.println("4. Update Quantity");
        System.out.println("5. Remove Product");
        System.out.println("6. Exit");
        System.out.print("Select option: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1: // Add Product
                if (itemCount < MAX_ITEMS) {
                    System.out.print("Enter Product ID: ");
                    productIds[itemCount] = scanner.nextInt();

                    System.out.print("Enter Product Name: ");
                    productNames[itemCount] = scanner.next();

                    System.out.print("Enter Quantity: ");
                    quantities[itemCount] = scanner.nextInt();

                    System.out.print("Enter Price: ");
                    prices[itemCount] = scanner.nextDouble();

                    itemCount++;
                    System.out.println(" Product added successfully!");
                } else {
                    System.out.println(" Inventory is full!");
                }
                break;

            case 2: // View All Products
                if (itemCount == 0) {
                    System.out.println("Inventory is empty!");
                } else {
                    System.out.println(" Product List:");
                    for (int i = 0; i < itemCount; i++) {
                        System.out.printf("ID: %d | Name: %s | Qty: %d | Price: $%.2f%n",
                                productIds[i], productNames[i], quantities[i], prices[i]);
                    }
                }
                break;

            case 3: // Search Product
                System.out.println("Search by: 1. ID  2. Name");
                int searchType = scanner.nextInt();

                if (searchType == 1){
                    System.out.print("Enter Product ID: ");
                    int searchId = scanner.nextInt();
                    boolean found = false;

                    int i = 0;
                    do {
                        if (i < itemCount && productIds[i] == searchId) {
                            System.out.printf(" Found - Name: %s | Qty: %d | Price: $%.2f%n",
                                    productNames[i], quantities[i], prices[i]);
                            found = true;
                        }
                        i++;
                    } while (!found && i < itemCount);

                    if (!found) {
                        System.out.println(" Product not found!");
                    }

                } else if (searchType == 2) {
                    System.out.print("Enter Product Name: ");
                    String searchName = scanner.next();
                    boolean nameFound = false;

                    for (int i = 0; i < itemCount; i++) {
                        if (productNames[i].equalsIgnoreCase(searchName)) {
                            System.out.printf("🔍 Found - ID: %d | Qty: %d | Price: $%.2f%n",
                                    productIds[i], quantities[i], prices[i]);
                            nameFound = true;
                        }
                    }

                    if (!nameFound) {
                        System.out.println("Product not found!");
                    }
                } else {
                    System.out.println("Invalid search option!");
                }
                break;

            case 4: // Update Quantity
                System.out.print("Enter Product ID to update quantity: ");
                int updateId = scanner.nextInt();
                boolean updated = false;

                for (int i = 0; i < itemCount; i++) {
                    if (productIds[i] == updateId) {
                        System.out.print("Enter new quantity: ");
                        quantities[i] = scanner.nextInt();
                        System.out.println("Enter new price: ");
                        prices[i]=scanner.nextDouble();
                        System.out.println("Quantity updated!");
                        updated = true;
                        break;
                    }
                }

                if (!updated) {
                    System.out.println(" Product not found!");
                }
                break;

            case 5: // Remove Product
                System.out.print("Enter Product ID to remove: ");
                int removeId = scanner.nextInt();
                int removeIndex = -1;

                for (int i = 0; i < itemCount; i++) {
                    if (productIds[i] == removeId) {
                        removeIndex = i;
                        break;
                    }
                }

                if (removeIndex != -1) {
                    // Shift left
                    for (int i = removeIndex; i < itemCount - 1; i++) {
                        productIds[i] = productIds[i + 1];
                        productNames[i] = productNames[i + 1];
                        quantities[i] = quantities[i + 1];
                        prices[i] = prices[i + 1];
                    }
                    itemCount--;
                    System.out.println("Product removed!");
                } else {
                    System.out.println("Product not found!");
                }
                break;

            case 6: // Exit
                running = false;
                System.out.println("Exiting Inventory System. Goodbye!");
                break;

            default:
                System.out.println(" Invalid option. Please choose from 1-6.");
        }
    }

    scanner.close();
}