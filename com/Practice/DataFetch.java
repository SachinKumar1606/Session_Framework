package com.Practice;

import java.util.ArrayList;
import java.util.Iterator;

public class DataFetch {
    public void setup(){
        PAssDataAsClass obj0 = new PAssDataAsClass("Sachin", 22, "QA");
        PAssDataAsClass obj1 = new PAssDataAsClass("Rohit", 20, "QA");
        PAssDataAsClass obj2 = new PAssDataAsClass("Sakshi", 21, "QA");
        PAssDataAsClass obj3 = new PAssDataAsClass("Puneet", 26, "QA");
        PAssDataAsClass obj4 = new PAssDataAsClass("Pankaj", 22, "QA");
        ArrayList<PAssDataAsClass> li = new ArrayList<>();
        li.add(obj0);
        li.add(obj1);
        li.add(obj2);
        li.add(obj3);
        li.add(obj4);
//        System.out.println(li.get(1));
        Iterator<PAssDataAsClass> it =  li.iterator();
        while(it.hasNext()){
            PAssDataAsClass i = it.next();
            System.out.print(i.name+"\t");
            System.out.print(i.age+"\t");
            System.out.println(i.dept);
        }
    }


    public static void main(String[] args) {

        DataFetch obj = new DataFetch();
        obj.setup();

    }
}
