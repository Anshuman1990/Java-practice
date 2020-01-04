package com.designPattern.Behavioral.iterator;

public class NotificationIterator implements Iterator {
   private Notification[] notifications;

    private int pos = 0;

    NotificationIterator(Notification[] notifications) {
        this.notifications = notifications;
    }


    @Override
    public boolean hasNext() {
        return (this.pos >= this.notifications.length || this.notifications[this.pos] == null);
    }

    @Override
    public Object next() {
        Notification notification = this.notifications[this.pos];
        this.pos++;
        return notification;
    }
}
