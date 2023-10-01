package ru.second;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        Race race = context.getBean(Race.class);
        race.CompleteRace(10);
        context.close();
    }
}