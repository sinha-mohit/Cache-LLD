package com.ms;

import com.ms.controller.Controller;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
//        controller.initialiseCache(5, "LRU");
//        System.out.println(controller.getKey("1"));
//        controller.putKey("2", "abc");
//        System.out.println(controller.getKey("2"));
//        controller.putKey("4", "abc");
//        controller.putKey("3", "abc");
//        controller.putKey("1", "abc");
//        controller.putKey("27", "abc");
//        controller.putKey("22", "abc");
//        System.out.println(controller.getKey("2"));
//        controller.resizeCache(2);
//        System.out.println(controller.getKey("22"));
//        System.out.println(controller.getKey("27"));
//        System.out.println(controller.getKey("1"));


        controller.initialiseCache(2, "LFU");
        controller.putKey("1", "1");
        controller.putKey("2", "2");
        System.out.println(controller.getKey("1"));
        controller.putKey("3", "3");
        System.out.println(controller.getKey("2"));
        System.out.println(controller.getKey("3"));
        controller.putKey("4", "4");
        System.out.println(controller.getKey("1"));
        System.out.println(controller.getKey("3"));
        System.out.println(controller.getKey("4"));



    }
}