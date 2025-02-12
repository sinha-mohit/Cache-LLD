package com.ms;

import com.ms.controller.Controller;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.initialiseCache(5, "LRU");
        System.out.println(controller.getKey("1"));
        controller.putKey("2", "abc");
        System.out.println(controller.getKey("2"));

    }
}