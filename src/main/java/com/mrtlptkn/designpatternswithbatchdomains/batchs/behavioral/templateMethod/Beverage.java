package com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.templateMethod;

abstract class Beverage {

    // Template Method
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    private void boilWater() {
        System.out.println("Su kaynatılıyor...");
    }

    private void pourInCup() {
        System.out.println("Fincana dökülüyor...");
    }

    // Alt sınıflar implement edecek
    protected abstract void brew();

    protected abstract void addCondiments();
}


class Tea extends Beverage {

    @Override
    protected void brew() {
        System.out.println("Çay demleniyor...");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Limon ekleniyor...");
    }
}


class Coffee extends Beverage {

    @Override
    protected void brew() {
        System.out.println("Kahve filtreleniyor...");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Şeker ve süt ekleniyor...");
    }
}

