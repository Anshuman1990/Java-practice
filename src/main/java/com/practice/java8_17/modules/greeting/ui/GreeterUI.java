package modules.ui;

import modules.service.birthday.BirthdayGreeterService;

public class GreeterUI {
    public static void main(String[] args) {
        System.out.println(new BirthdayGreeterService().greet("Sarah"));
    }
}

