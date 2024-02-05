Design patterns are reusable solutions to common problems that occur in software design. They represent best practices and provide a way to create software that is flexible, maintainable, and scalable. In Java, you can implement various design patterns. Here are some commonly used design patterns along with simple examples in Java:

1. **Singleton Pattern:**
   Ensures that a class has only one instance and provides a global point of access to it.

   ```java
   public class Singleton {
       private static Singleton instance;

       private Singleton() {}

       public static Singleton getInstance() {
           if (instance == null) {
               instance = new Singleton();
           }
           return instance;
       }
   }
   ```

2. **Factory Method Pattern:**
   Defines an interface for creating an object, but leaves the choice of its type to the subclasses.

   ```java
   public interface Product {
       void create();
   }

   public class ConcreteProduct implements Product {
       @Override
       public void create() {
           System.out.println("Creating ConcreteProduct");
       }
   }

   public interface Creator {
       Product factoryMethod();
   }

   public class ConcreteCreator implements Creator {
       @Override
       public Product factoryMethod() {
           return new ConcreteProduct();
       }
   }
   ```

3. **Observer Pattern:**
   Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

   ```java
   import java.util.ArrayList;
   import java.util.List;

   public interface Observer {
       void update(String message);
   }

   public class ConcreteObserver implements Observer {
       private String name;

       public ConcreteObserver(String name) {
           this.name = name;
       }

       @Override
       public void update(String message) {
           System.out.println(name + " received message: " + message);
       }
   }

   public class Subject {
       private List<Observer> observers = new ArrayList<>();

       public void addObserver(Observer observer) {
           observers.add(observer);
       }

       public void notifyObservers(String message) {
           for (Observer observer : observers) {
               observer.update(message);
           }
       }
   }
   ```

4. **Strategy Pattern:**
   Defines a family of algorithms, encapsulates each algorithm, and makes them interchangeable. Strategy lets the algorithm vary independently from the clients that use it.

   ```java
   public interface PaymentStrategy {
       void pay(int amount);
   }

   public class CreditCardPayment implements PaymentStrategy {
       private String cardNumber;

       public CreditCardPayment(String cardNumber) {
           this.cardNumber = cardNumber;
       }

       @Override
       public void pay(int amount) {
           System.out.println("Paid " + amount + " using credit card " + cardNumber);
       }
   }

   public class CashPayment implements PaymentStrategy {
       @Override
       public void pay(int amount) {
           System.out.println("Paid " + amount + " in cash");
       }
   }

   public class ShoppingCart {
       private PaymentStrategy paymentStrategy;

       public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
           this.paymentStrategy = paymentStrategy;
       }

       public void checkout(int amount) {
           paymentStrategy.pay(amount);
       }
   }
   ```

These are just a few examples, and there are many more design patterns that can be applied depending on the specific requirements of your software. Understanding and applying design patterns can lead to more maintainable and extensible code.