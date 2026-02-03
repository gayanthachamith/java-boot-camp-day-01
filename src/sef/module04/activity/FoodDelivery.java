package sef.module04.activity;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FoodDelivery {


        public static void main(String[] args) {

//             Restaurant
            Restaurant restaurant = new Restaurant("BITES");
            restaurant.addMenuItem(new MenuItem("Burger", 3.50));
            restaurant.addMenuItem(new MenuItem("Pizza", 6.00));
            restaurant.addMenuItem(new MenuItem("Coca- Cola", 1.30));
            restaurant.addMenuItem(new MenuItem("Pepsi", 1.30));

            restaurant.printMenu();

//              creates order
            Customer customer = new Customer("Gayantha");
            Order order = customer.createOrder(restaurant);

//            Add / remove items
            MenuItem burger = restaurant.findMenuItemByName("Burger");
            MenuItem pizza = restaurant.findMenuItemByName("Pizza");
            MenuItem cola = restaurant.findMenuItemByName("Coca- Cola");
            MenuItem pepsi = restaurant.findMenuItemByName("Pepsi");

            order.addItem(burger);
            order.addItem(burger);
            order.addItem(pizza);
            order.addItem(cola);
            order.addItem(pepsi);

            order.removeItemByName("Coca- Cola"); // remove one item

            order.printSummary();

//             Confirm order
            order.confirm();
            order.printSummary();

//          delivery logic lives here
            Delivery delivery = new Delivery(order);
            delivery.printStatus();

            delivery.markOnTheWay();
            delivery.printStatus();

            delivery.markDelivered();
            delivery.printStatus();
        }
    }


    class Restaurant {
        private final String name;
        private final List<MenuItem> menu;

        public Restaurant(String name) {
            this.name = name;
            this.menu = new ArrayList<>();
            System.out.println("[Restaurant] Created: " + name);
        }

        public void addMenuItem(MenuItem item) {
            menu.add(item);
            System.out.println("[Restaurant] Added to menu: " + item.getName());
        }

        public MenuItem findMenuItemByName(String itemName) {
            for (MenuItem item : menu) {
                if (item.getName().equalsIgnoreCase(itemName)) {
                    return item;
                }
            }
            System.out.println("[Restaurant] Item not found: " + itemName);
            return null;
        }

        public void printMenu() {
            System.out.println("\n--- MENU (" + name + ") ---");
            for (MenuItem item : menu) {
                System.out.println("- " + item.getName() + " : €" + item.getPrice());
            }
            System.out.println();
        }

        public String getName() {
            return name;
        }
    }

    class MenuItem {
        private final String name;
        private final double price;

        public MenuItem(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() { return name; }
        public double getPrice() { return price; }
    }

    class Customer {
        private final String name;
        private final List<Order> orders;

        public Customer(String name) {
            this.name = name;
            this.orders = new ArrayList<>();
            System.out.println("[Customer] Created: " + name);
        }

        public Order createOrder(Restaurant restaurant) {
            Order order = new Order(this, restaurant);
            orders.add(order);
            System.out.println("[Customer] " + name + " created an order at " + restaurant.getName());
            return order;
        }

        public String getName() {
            return name;
        }
    }

    class Order {
        public static final String STATUS_CREATED = "CREATED";
        public static final String STATUS_CONFIRMED = "CONFIRMED";

        private final Customer customer;
        private final Restaurant restaurant;
        private final List<MenuItem> items;
        private String status;

        public Order(Customer customer, Restaurant restaurant) {
            this.customer = customer;
            this.restaurant = restaurant;
            this.items = new ArrayList<>();
            this.status = STATUS_CREATED;
            System.out.println("[Order] New order status = " + status);
        }

        public void addItem(MenuItem item) {
            if (!canEdit()) {
                System.out.println("[Order] Cannot add item. Order is already confirmed.");
                return;
            }
            if (item == null) {
                System.out.println("[Order] Cannot add null item.");
                return;
            }
            items.add(item);
            System.out.println("[Order] Added: " + item.getName());
        }

        public void removeItemByName(String itemName) {
            if (!canEdit()) {
                System.out.println("[Order] Cannot remove item. Order is already confirmed.");
                return;
            }

            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getName().equalsIgnoreCase(itemName)) {
                    System.out.println("[Order] Removed: " + items.get(i).getName());
                    items.remove(i);
                    return;
                }
            }

            System.out.println("[Order] Item not found in order: " + itemName);
        }

        public void confirm() {
            if (!STATUS_CREATED.equals(status)) {
                System.out.println("[Order] Cannot confirm. Current status = " + status);
                return;
            }
            if (items.isEmpty()) {
                System.out.println("[Order] Cannot confirm an empty order.");
                return;
            }
            status = STATUS_CONFIRMED;
            System.out.println("[Order] Order confirmed!");
        }

        public void printSummary() {
            System.out.println("\n--- ORDER SUMMARY ---");
            System.out.println("Customer   : " + customer.getName());
            System.out.println("Restaurant : " + restaurant.getName());
            System.out.println("Status     : " + status);

            if (items.isEmpty()) {
                System.out.println("Items: (none)");
            } else {
                System.out.println("Items:");
                for (MenuItem item : items) {
                    System.out.println(" - " + item.getName() + " (€" + item.getPrice() + ")");
                }
            }

            System.out.println("Total: €" + calculateTotal());
            System.out.println();
        }

        private boolean canEdit() {
            return STATUS_CREATED.equals(status);
        }

        private double calculateTotal() {
            double total = 0.0;
            for (MenuItem item : items) {
                total += item.getPrice();
            }
            return total;
        }

        // Delivery should read order info, but NOT control delivery behavior
        public String getStatus() { return status; }
    }

    class Delivery {
        public static final String STATUS_CREATED = "CREATED";
        public static final String STATUS_ON_THE_WAY = "ON_THE_WAY";
        public static final String STATUS_DELIVERED = "DELIVERED";

        private final Order order;
        private String status;

        public Delivery(Order order) {
            this.order = order;
            this.status = STATUS_CREATED;
            System.out.println("[Delivery] Created. Delivery status = " + status);
            
        }

        public void markOnTheWay() {
            if (!STATUS_CREATED.equals(status)) {
                System.out.println("[Delivery] Cannot mark ON_THE_WAY. Current status = " + status);
                return;
            }
            status = STATUS_ON_THE_WAY;
            System.out.println("[Delivery] Status changed to ON_THE_WAY");
        }

        public void markDelivered() {
            if (!STATUS_ON_THE_WAY.equals(status)) {
                System.out.println("[Delivery] Cannot mark DELIVERED. Current status = " + status);
                return;
            }
            status = STATUS_DELIVERED;
            System.out.println("[Delivery] Status changed to DELIVERED");
        }

        public void printStatus() {
            System.out.println("[Delivery] Current status: " + status);
        }
    }
