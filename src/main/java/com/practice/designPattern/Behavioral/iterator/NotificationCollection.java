package com.practice.designPattern.Behavioral.iterator;

public class NotificationCollection implements Collection {
    private static final int MAX_ITEMS = 10;
    private int numberOfItems = 0;
    private Notification[] notifications;

    NotificationCollection() {
        this.notifications = new Notification[MAX_ITEMS];

        // Let us add some dummy notifications
        addItem("Notification 1");
        addItem("Notification 2");
        addItem("Notification 3");
    }


    public void addItem(String str) {
        Notification notification = new Notification(str);
        if (numberOfItems >= MAX_ITEMS)
            System.err.println("Full");
        else {
            this.notifications[numberOfItems] = notification;
            this.numberOfItems++;
        }
    }

    @Override
    public Iterator createIterator() {
        return new NotificationIterator(this.notifications);
    }
}
