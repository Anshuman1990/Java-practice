package com.practice.java8_17.language.streams;


import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class Main {
    public static void main(String[] args) {

//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 85, 78);
//
//        List listCombination = (list
//                .stream()
//                .flatMap(integer -> list.stream().filter(integer1 -> !integer.equals(integer1)).map(integer1 -> integer + "-" + integer1))
//                .collect(Collectors.toList()))
//                .stream()
//                .filter(data -> Integer.parseInt(data.split("-")[0]) + Integer.parseInt(data.split("-")[1]) == 10)
//                .collect(Collectors.toList());
//
//        System.out.println(listCombination);
//
//        Main.peek(list);
//
//        // Create ArrayList containing names
//        ArrayList<String> lists = new ArrayList<String>();
//        lists.add("Aman");
//        lists.add("Zufaq");
//        lists.add("Suraj");
//
//        // create a stream with ArrayList
//        Stream<ArrayList<String>> value
//                = Stream.of(lists);
//
//        // print values
//        System.out.println("Values of Stream:");
//        value.forEach(System.out::println);
//        //reduce
//        Main.reduce(list);
//        Main.map();
//        Main.collectors();
        Main.takeWhile();
        Main.dropWhile();
        List<Integer> list = List.of(1, 2, 3, 4);
        for(Integer i : list) {
            System.out.println(i);
        }
        System.out.println("**********************************************************");
        Set<Integer> set = Set.of(1, 2, 3, 4);
        for(Integer i : set) {
            System.out.println(i);
        }

        // unsupported exceptions the of method creates and immutable list of data
//        System.out.println("********************************");
//        Set set1 = Set.of(1, 2, 3, 4);
//        set1.remove(0);
//        System.out.println(set1);

//        System.out.println("********************************");
//        List list1 = List.of(1, 2, 3, 4);
//        list1.add(5);
//        System.out.println(list1);

    }


    public static void peek(List<Integer> list) {
        log.info("--------------------------------------PEEK---------------------------------------------");
//        System.out.println("--------------------------------------PEEK---------------------------------------------");
        log.info("list Data:- ", list);
//        System.out.println(list);
        Consumer<Integer> consumer = integer -> System.out.println(integer * 10);

        List<Integer> result = list.stream().peek(consumer).collect(Collectors.toList());
        System.out.println(result);
        List<String> resultString = Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> log.info("Filtered value:", e))
                .map(String::toUpperCase)
                .peek(e -> log.info("Mapped value:", e))
                .collect(Collectors.toList());
        System.out.println(resultString);
        System.out.println("--------------------------------------PEEK---------------------------------------------");
    }

    public static void reduce(List<Integer> list) {
        System.out.println("--------------------------------------REDUCE---------------------------------------------");
        System.out.println(list);
        Optional<Integer> val = list.stream()
//                .filter(x -> x % 2 == 0)
                .reduce((x, y) -> {
                    System.out.println("x= " + x);
                    System.out.println("y=" + y);
                    return x + y;
                });
        System.out.println("Result:- " + val.get());
        System.out.println("--------------------------------------REDUCE---------------------------------------------");
    }

    public static void map() {
        System.out.println("--------------------------------------MAP---------------------------------------------");
        List<RoomView> roomViewList = new ArrayList<>();
        RoomView roomView11 = new RoomView(1, 101, "D");
        RoomView roomView12 = new RoomView(1, 102, "D");
        RoomView roomView13 = new RoomView(1, 103, "D");
        RoomView roomView14 = new RoomView(1, 104, "D");
        RoomView roomView15 = new RoomView(1, 105, "D");

        RoomView roomView21 = new RoomView(2, 201, "D");
        RoomView roomView22 = new RoomView(2, 202, "D");
        RoomView roomView23 = new RoomView(2, 203, "D");
        RoomView roomView24 = new RoomView(2, 204, "D");
        RoomView roomView25 = new RoomView(2, 205, "D");

        roomViewList.add(roomView11);
        roomViewList.add(roomView12);
        roomViewList.add(roomView13);
        roomViewList.add(roomView14);
        roomViewList.add(roomView15);
        roomViewList.add(roomView21);
        roomViewList.add(roomView22);
        roomViewList.add(roomView23);
        roomViewList.add(roomView24);
        roomViewList.add(roomView25);
        System.out.println(roomViewList);
        List<Room> roomList = roomViewList.stream().map(RoomView::getFloorNumber).distinct().collect(Collectors.toList())
                .stream().map(integer -> {
                    Room room = new Room();
                    room.setFloorNumber(integer);
                    List<RoomDetails> roomDetailsList = roomViewList.stream().filter(roomView -> Objects.equals(roomView.getFloorNumber(), integer)).map(roomView -> {
                        RoomDetails roomDetails = new RoomDetails();
                        roomDetails.setRoomNumber(roomView.getRoomNumber());
                        roomDetails.setRoomTypeName(roomView.getRoomTypeName());
                        return roomDetails;
                    }).collect(Collectors.toList());
                    room.setRoomDetails(roomDetailsList);
                    return room;
                }).collect(Collectors.toList());
        System.out.println(roomList);

        System.out.println("--------------------------------------MAP---------------------------------------------");
    }

    public static void collectors() {
        String str = "qweqweeqrtyw";
        Stream<String> stream = Stream.of(str.split(""));
        Map result = stream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);

        Map output = Stream.of(str.split("")).collect(Collectors.groupingBy(Function.identity()));
        System.out.println(output);


    }

    public static void takeWhile() {
        List<Employee> empList = List.of(
                new Employee("David", LocalDate.of(1995, 7, 1)),
                new Employee("Jonathan", LocalDate.of(1994, 5, 14)),
                new Employee("John", LocalDate.of(1992, 1, 10)),
                new Employee("Emily", LocalDate.of(1991, 12, 3)),
                new Employee("Sarah", LocalDate.of(1989, 11, 23)),
                new Employee("Sophia", LocalDate.of(1984, 8, 15)),
                new Employee("Tim", LocalDate.of(1982, 3, 25)),
                new Employee("Mary", LocalDate.of(1979, 2, 28)),
                new Employee("Ava", LocalDate.of(1975, 4, 20)),
                new Employee("Lily", LocalDate.of(1971, 2, 5))
        );

        Stream<Employee> empStreamOrdered = empList.stream();    // Line 1

        Stream<Employee> employeeBornAfter1986 = empStreamOrdered.takeWhile(employee -> employee.getDob().isAfter(LocalDate.of(1986, 1, 1)));

        System.out.println("************Employee Name************");
        employeeBornAfter1986.forEach(emp -> {
            System.out.println(emp.getName());
        });

    }

    public static void dropWhile() {
        List<Employee> empList = List.of(new Employee("David", LocalDate.of(1995, 7, 1)),
                new Employee("Jonathan", LocalDate.of(1994, 5, 14)),
                new Employee("John", LocalDate.of(1992, 1, 10)),
                new Employee("Emily", LocalDate.of(1991, 12, 3)),
                new Employee("Sarah", LocalDate.of(1989, 11, 23)),
                new Employee("Sophia", LocalDate.of(1984, 8, 15)),
                new Employee("Tim", LocalDate.of(1982, 3, 25)),
                new Employee("Mary", LocalDate.of(1979, 2, 28)),
                new Employee("Ava", LocalDate.of(1975, 4, 20)),
                new Employee("Lily", LocalDate.of(1971, 2, 5))
        );

        Stream<Employee> empStreamOrdered = empList.stream();    // Line 1

        Stream<Employee> employeeBornBefore1986 = empStreamOrdered.dropWhile(employee -> employee.getDob().isAfter(LocalDate.of(1986, 1, 1)));

        System.out.println("************Employee Name************");
        employeeBornBefore1986.forEach(emp -> {
            System.out.println(emp.getName());
        });

    }
}


class Room {
    private Integer floorNumber;
    private List<RoomDetails> roomDetails;

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<RoomDetails> getRoomDetails() {
        return roomDetails;
    }

    public void setRoomDetails(List<RoomDetails> roomDetails) {
        this.roomDetails = roomDetails;
    }

    @Override
    public String toString() {
        return "Room{" +
                "floorNumber=" + floorNumber +
                ", roomDetails=" + roomDetails +
                '}';
    }
}

class RoomDetails {
    private Integer roomNumber;
    private String roomTypeName;

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    @Override
    public String toString() {
        return "RoomDetails{" +
                "roomNumber=" + roomNumber +
                ", roomTypeName='" + roomTypeName + '\'' +
                '}';
    }
}

class RoomView {

    public RoomView(Integer floorNumber, Integer roomNumber, String roomType) {
        this.floorNumber = floorNumber;
        this.roomNumber = roomNumber;
        this.roomTypeName = roomType;
    }

    private Integer floorNumber;
    private Integer roomNumber;
    private String roomTypeName;

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    @Override
    public String toString() {
        return "RoomView{" +
                "floorNumber=" + floorNumber +
                ", roomNumber=" + roomNumber +
                ", roomTypeName='" + roomTypeName + '\'' +
                '}';
    }
}

class Employee {
    private String name;
    private LocalDate dob;

    public Employee(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
