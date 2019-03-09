package com.fturk.ch1;

import java.util.Objects;

/*
Examine Object superClass method.
coding equals , hashCode and toString
 */
public class ObjectClassExample{
    private String objectName;

    public ObjectClassExample(String objectName) {
        this.objectName = objectName;
    }


    /*
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.

     * --> It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
            * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
            * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
            * </pre></blockquote>
            *
            * @return  a string representation of the object.

    Apache Commons Lang (http://commons.apache.org/proper/
            commons-lang/) provides some methods that you might wish were in core Java.


            */
    @Override
    public String toString() {
        return "I am ObjectClassExample{" +
                "objectName='" + objectName + '\'' +
                '}';
    }


    /*
     equals() method.

      * Note that it is generally necessary to override the {@code hashCode}
      * method whenever this method is overridden, so as to maintain the
      * general contract for the {@code hashCode} method, which states
      * that equal objects must have equal hash codes.
      *
      * @param   obj   the reference object with which to compare.
      * @return  {@code true} if this object is the same as the obj
      *          argument; {@code false} otherwise.
      * @see     #hashCode()
      * @see     java.util.HashMap
      *
      *
      * Java provide  a number of rules in the contract for the equals method.The equals() method implements an equivalence relation on non‐null object references:
        1) It is reflexive: For any non‐null reference value x, x.equals(x) should return true.
        2) It is symmetric: For any non‐null reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.
        3) It is transitive: For any non‐null reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.
        4) It is consistent: For any non‐null reference values x and y, multiple invocations of x.equals(y) consistently return true or consistently return false, provided no
           information used in equals comparisons on the objects is modified.
        5) For any non‐null reference value x, x.equals(null) should return false.
      */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  //reflexive, symmetric and transitive.
        if (o == null || getClass() != o.getClass()) return false;  //any non-null reference value
        ObjectClassExample that = (ObjectClassExample) o;
        return Objects.equals(objectName, that.objectName);
    }

    /*
    There is actually nothing wrong with this method. It is a perfectly good method.
    However, it does not override equals() from Object.class
     */

    public boolean equals(ObjectClassExample obj) {
        if (obj == null) return false;
        return this.objectName.equals(obj.objectName);
    }

    /* Examine String.class equals method

         public boolean equals(Object anObject) {
        if (this == anObject) {  --> first reflexive control
            return true;
        }
        if (anObject instanceof String) {  --> for symmetric and transitive control
            String anotherString = (String)anObject;  --> casting ok
            int n = value.length;
            if (n == anotherString.value.length) {  -->
                char v1[] = value;
                char v2[] = anotherString.value;
                int i = 0;
                while (n-- != 0) {
                    if (v1[i] != v2[i])
                        return false;
                    i++;
                }
                return true;
            }
        }
        return false;
    }


     */


    /**
     * Returns a hash code value for the object. This method is
     * supported for the benefit of hash tables such as those provided by
     * {@link java.util.HashMap}.
     * <p>
     * The general contract of {@code hashCode} is:
     * <ul>
     * <li>Whenever it is invoked on the same object more than once during
     *     an execution of a Java application, the {@code hashCode} method
     *     must consistently return the same integer, provided no information
     *     used in {@code equals} comparisons on the object is modified.
     *     This integer need not remain consistent from one execution of an
     *     application to another execution of the same application.
     * <li>If two objects are equal according to the {@code equals(Object)}
     *     method, then calling the {@code hashCode} method on each of
     *     the two objects must produce the same integer result.
     * <li>It is <em>not</em> required that if two objects are unequal
     *     according to the {@link java.lang.Object#equals(java.lang.Object)}
     *     method, then calling the {@code hashCode} method on each of the
     *     two objects must produce distinct integer results.  However, the
     *     programmer should be aware that producing distinct integer results
     *     for unequal objects may improve the performance of hash tables.
     * </ul>
     * <p>
     * As much as is reasonably practical, the hashCode method defined by
     * class {@code Object} does return distinct integers for distinct
     * objects. (This is typically implemented by converting the internal
     * address of the object into an integer, but this implementation
     * technique is not required by the
     * Java&trade; programming language.)
     *
     * @return  a hash code value for this object.
     * @see     java.lang.Object#equals(java.lang.Object)
     * @see     java.lang.System#identityHashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(objectName);
    }

    /*
    public int hashCode() { return 8; } --> is legal , all object return same hashCode but it is not appropriate, slow  and inefficient for collection.
    */




    public static void main(String[] args) {
        Object object =new Object();
        /*
        equals() method.
         */
        System.out.println("Two diffirent instance same object check via equals method :"+object.equals(new Object()));
        System.out.println("Two diffirent instance same object check via == :"+ (object == new Object()));

        String a = new String("test");
        String b = new String("test");
        System.out.println("String equals method check :"+a.equals(b)); // true
        System.out.println("String == check :" + (a == b));

        //String class override equals()method.

        StringBuilder a1= new StringBuilder("test");
        StringBuilder a2= new StringBuilder("test");
        System.out.println("StringBuilder equals method chech :"+ a1.equals(a2));
        System.out.println("StringBuilder == check :" + (a1 == a2));

        //StringBuilder class doesn't override equals method.

        /*
        toString() method.
        */

        System.out.println(object);  //java.lang.Object@1b6d3586
        System.out.println(object.toString());

        ObjectClassExample objectClassExample=new ObjectClassExample("ClassA");
        System.out.println(objectClassExample);

        /*
        hashCode method.

        if x.equals(y) return true, x.hashCode == y.hashCode return true.

        if x.equals(y) return false, x.hashCode == y.hashCode return true or false;

        if x.hashCode != y.hashCode return true, x.equals(y) return false;

        if x.hashCode == y.hashCode return true, x.equals(y) return true or false;

        It is common not to include boolean and char variables in the hash code.


        1)Within the same program, the result of hashCode() must not change. This means that
          you shouldn’t include variables that change in figuring out the hash code.
        2)equals() returns true when called with two objects, calling hashCode() on each of
          those objects must return the same result. This means hashCode() can use a subset of
          the variables that equals() uses.
        3)If equals() returns false when called with two objects, calling hashCode() on each of
          those objects does not have to return a different result.
         */

        Integer integer = new Integer(1);
        Integer integerAnother = new Integer(1);

        System.out.println( integer == integerAnother ); // return false
        System.out.println( integer.equals(integerAnother) ); // return true
        System.out.println( "integer hashCode: "+ (integer.hashCode()) + " integerAnother hashCode: "+ (integerAnother.hashCode()) +
                " if two object check equals return true  also checking hashcode equality return true :"+ (integer.hashCode() == integerAnother.hashCode()) );
    }
}
