package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringList myList = new StringListImpl(2);

        myList.set(0, "Monday");
        myList.set(1, "Tuesday");
        myList.set(2, "Wednesday");
        myList.set(1, "Thursday");
        myList.set(14, "Frayday");
        myList.set(4, "Friday");
        myList.set(6, "Saturday");
        myList.set(66, "Sunday");
        myList.set(26, "Sunday");
        myList.set(8, "Wednesday");

        myList.remove(3);
        System.out.println(myList.indexOf("Sundayy"));
        System.out.println(myList.lastIndexOf("Wednesday"));
        System.out.println(myList.contains("Friday "));

        System.out.println(myList);
        myList.clear();
        System.out.println(myList);
        String[] copyList = myList.toArray();
        System.out.println(Arrays.toString(copyList));

        /*
        myList.add(0,"Monday");
        myList.add(1,"Tuesday");
        myList.add(2,"Wednesday");
        myList.add(3,"Thursday");
        myList.add(4,"Friday");
        myList.add(5,"Saturday");
        myList.add(6,"Sunday");
        myList.add(26,"Sunday");
        */
/*
        myList.add("Privet");
        myList.add("MIR");
        myList.add("VISA");
        myList.add("MasterCard");
        myList.add("OpenWay");
        myList.add(9,"I am");
        myList.add(52,"Turkey forever");
        */
/*
        myList.set(2,"Java one love");
        myList.set(25,"SkyPro");

        System.out.println(myList);
        System.out.println(myList.size());

        myList.remove(5);
        myList.remove(7);

        System.out.println(myList);
        System.out.println(myList.size());

        myList.remove("MasterCard");
       // myList.remove(" ");
       // myList.remove("UnionPay");
        System.out.println(myList);

        System.out.println(myList.contains("VISA"));
        System.out.println(myList.contains("Visa"));
        System.out.println(myList.contains(""));

        System.out.println(myList.indexOf("VISA"));
        System.out.println(myList.indexOf("OpenWay"));
        System.out.println(myList.indexOf("Privet"));
        myList.add("OpenWay");
        myList.add("OpenWay");
        System.out.println(myList);
        System.out.println(myList.indexOf("OpenWay"));
        System.out.println(myList.lastIndexOf("OpenWay"));
        System.out.println(myList.get(4));
     //   System.out.println(myList.get(14));

        StringList newList = new StringListImpl(8);
        newList.add("Hello, World!");
        newList.add("Privet");
        newList.add("Java one love");
        newList.add("VISA");
        newList.add("I am");
        newList.add("Turkey forever");
        newList.add("OpenWay");
        newList.add("OpenWay");
        newList.add("CardId");

        System.out.println(myList.equals(newList));
        System.out.println(myList);
        System.out.println(newList);

        StringList emptyList = new StringListImpl(28);
        System.out.println(emptyList.isEmpty());
        System.out.println(myList.isEmpty());

        System.out.println("newlist = " + newList);
        newList.clear();
        System.out.println(newList);
*/

    }
}