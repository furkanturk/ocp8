package com.fturk.ch1;

abstract class Animal{
    public abstract void feed();
}

class HeavyAnimals{
 public void print(){
 }
}

class Hippo extends HeavyAnimals{
    public void printHippo(){
    }

    @Override
    public void print() {
        super.print();
    }
}

class Elephant extends HeavyAnimals {
    public void printElephant(){
    }

    @Override
    public void print() {
        super.print();
    }
}

interface Mother{
}

public class InstanceOf {

    public static void main(String[] args) {
        Hippo hippo=new Hippo();
        System.out.println(hippo instanceof HeavyAnimals);
        //System.out.println(hippo instanceof Elephant);  Compilation Error

        /*The compiler knows that there is no possible way for a Hippo
        //variable reference to be an Elephant, since Hippo doesn’t extend Elephant directly or
        //indirectly.
        //The compilation check only applies when instanceof is called on a class. When checking
        //whether an object is an instanceof an interface, Java waits until runtime to do the
        //check. The reason is that a subclass could implement that interface and the compiler
         * wouldn’t know it. There is no way for Hippo to be a subclass of Elephant.
         */

        HeavyAnimals hippo2=new Hippo();
        System.out.println(hippo2 instanceof Elephant);
        hippo2=null;
        System.out.println(hippo2 instanceof HeavyAnimals);
        /*If the literal null or a variable reference pointing
        *to null is used to check instanceof, the result is false. null is not an Object.
        */

        System.out.println(hippo2 instanceof Mother);
        /*
           It so happen that Hippo does not implement Mother.The compiler allows the statement because there could later be a class such as this;
           Class XYZ extends Hippo implements Mother{}
         */

    }

     /*
        The instanceof operator is commonly used to determined if an instance is a subclass of a particular object before appliying an explicit cast.

         --> This is not a good way to wrie code.
         */

     public void feedAnimal(HeavyAnimals heavyAnimals){
         if(heavyAnimals instanceof Hippo){
             ((Hippo) heavyAnimals).printHippo();
         }else if (heavyAnimals instanceof  Elephant){
             ((Elephant) heavyAnimals).printElephant();
         }else {
             throw new RuntimeException("Unsupported animal");
         }
     }

}
