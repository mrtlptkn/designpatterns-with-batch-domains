package com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.templateMethod;


public class templateMethodMain {

    public static void main(String[] args) {

        Beverage tea = new Tea();
        Beverage coffee = new Coffee();

        System.out.println("=== Çay Hazırlama ===");
        tea.prepareRecipe();

        System.out.println();

        System.out.println("=== Kahve Hazırlama ===");
        coffee.prepareRecipe();
    }
}