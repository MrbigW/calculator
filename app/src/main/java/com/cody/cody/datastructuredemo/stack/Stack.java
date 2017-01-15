package com.cody.cody.datastructuredemo.stack;

/**
 * Created by Cody on 2017/1/11.
 */


public class Stack<T> {

    private int maxSize;
    private Object[] stackArray;
    private int top;

    public Stack(int size) {
        this.maxSize = size;
        stackArray = new Object[size];
        top = -1;
    }

    public long size(){
        return maxSize;
    }

    public void push(T j) {
        if(isFull()) {
            try {
                throw new Exception("StackOverFlow!!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            top++;
            stackArray[top] = j;
        }



    }

    public Object pop() {
        if(isEmpty()) {
            try {
                throw new Exception("no element in the stack");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            int old_top=top;
            top--;
            return stackArray[old_top];
        }

            return null;

    }


    public Object pick(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return (top==-1);
    }

    public boolean isFull(){
        return (maxSize-1==top);
    }


}
