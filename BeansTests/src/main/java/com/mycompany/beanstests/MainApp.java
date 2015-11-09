/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beanstests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author george
 */
public class MainApp {

    private static final String LINE = "-------------------------------";

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/mycompany/beanstests/Beans.xml");

        HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
        System.out.println(LINE);
        objA.setMessage("I'm object A");
        objA.getMessage();
        objA.getName();
        objA.getLast();
        objA.setLast("Changed last");
        System.out.println(LINE);
        HelloWorld objB = (HelloWorld) context.getBean("helloWorld");
        objB.getMessage();
        objB.getName();
        objB.getLast();
        System.out.println(LINE);
        HelloWorld protoA = (HelloWorld) context.getBean("helloWorldPrototype");
        protoA.getMessage();
        protoA.getName();
        protoA.getLast();
        System.out.println(LINE);
        HelloWorld templateA = (HelloWorld) context.getBean("helloTemplate");
        templateA.getMessage();
        templateA.getName();
        templateA.getLast();

    }

}
