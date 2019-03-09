package com.fturk.ch1.CreatingNestedClasses;

import javax.swing.*;

public class OuterClassExample {

    private String greeting = "hi";

    int x = 5;

    int width=2;

    //just like any inner class , inner interface can be private.Can only be referred to within outer class.
    private interface InnerInterface{
    }

    private class MemberInnerClass implements InnerInterface {
        int x = 10;

        // private static int y=5;  --> inner classes cannot have static declarations.

        void printThreeTimesHi() {
            //Member inner class use enclosing class member.Like greeting variable
            for (int i = 0; i < 3; i++) {
                System.out.println(greeting);
            }
        }


        public class ThirdInnerClass {
            int x = 15;

            void printAllX() {
                System.out.println(x);
                System.out.println(this.x);
                System.out.println(MemberInnerClass.this.x);
                System.out.println(OuterClassExample.this.x);
            }

        }
    }

    public void callMemberInnerClass() {
        MemberInnerClass memberInnerClass = new MemberInnerClass();
        memberInnerClass.printThreeTimesHi();
    }

    public void localInnerClassMethod(){
          int length = 5; // or final int length= 5;
        // private static int y=5;  --> local inner classes cannot have static declarations.
         //length =2; local inner class, needs to be final or effectively final.Any change occurs in the length variable, this can not be effectively final.
         class LocalInnerClass{
             public void multiply(){
                 System.out.println(" local inner class :" +(length* width));
             }
         }

         LocalInnerClass localInnerClass=new LocalInnerClass();
         localInnerClass.multiply();
    }

    abstract class DoSomething{
        abstract void print();
    }

    // anonymous inner class special form of local inner class,
    // only difference is no name class.So, anonymous inner class only extends or implements one class or interface.
    // of course, anonymous inner class dont have static method or variable.
    public  void anonymousInnerClassMethod(){
        int length = 5;
        //length=2; is not effectively final.Same as local inner class
        DoSomething doSomething=new DoSomething() {
            @Override
            void print() {
                System.out.println(width *length);
            }
        };
    }

    public static void main(String[] args) {
        OuterClassExample outerClassExample = new OuterClassExample();
        outerClassExample.callMemberInnerClass();
        //Not initialize inner class just like cannot reach static to this
        // MemberInnerClass memberInnerClass=new MemberInnerClass();
        //CreatingNestedClasses.OuterClassExample.this' c cannot be referenced from a static context
        outerClassExample.new MemberInnerClass().printThreeTimesHi(); // Another way to access printThreeTimes.
        outerClassExample.new MemberInnerClass().new ThirdInnerClass().printAllX();

        OuterClassExample.MemberInnerClass memberInnerClass = outerClassExample.new MemberInnerClass();
        OuterClassExample.MemberInnerClass.ThirdInnerClass thirdInnerClass = memberInnerClass.new ThirdInnerClass();
        thirdInnerClass.printAllX(); // Another way call printALLX

        //call localInnerClassMethod.
        outerClassExample.localInnerClassMethod();
    }
}
