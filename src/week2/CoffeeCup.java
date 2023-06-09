package week2;
/*
EXAMPLE ABSTRACT COFFEE CUP CLASS

This is an example of a class that could be used to represent a coffee cup.
It is not a complete class, but it should give you an idea of how to structure your classes.
 */
public class CoffeeCup {
    public double amountOfCoffee; // in ml. Should this really be public?...
    public double strengthOfCoffee ; // % espresso , 0 is water , 100 is pure espresso
    public CoffeeCup() { // constructor of the class − see next slide amountOfCoffee = 0.0; // cup is empty to start with strengthOfCoffee = 0.0;
    }
    public double getAmountOfCoffee() { return 0; // accessors − return class variables return amountOfCoffee ;
    }
    public double getStrengthOfCoffee () {
        return strengthOfCoffee ; }
    // other methods
    public double getEffectiveCaffeine () {  return 0;// implementation
    }
    public void addToCup(CoffeeCup coffee) { }
    public CoffeeCup combineInNewCupWith(CoffeeCup coffee) { return new CoffeeCup();}
    public void addEspressoToCup(int amountOfShots) {}
    public void addWaterToCup(double amountOfWater) { }
    public void addMilkToCup(double amountOfMilk) {}
}