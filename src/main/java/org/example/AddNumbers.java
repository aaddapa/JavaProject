package org.example;

public class AddNumbers {

    public int add(int a, int b){
        System.out.println("Inside ADD method");
        return a-b;
    }
    public static void main(String[] args) {
        AddNumbers addNum=new AddNumbers();
        int a=3,b=5;
        addNum.add(a,b);

    }
}