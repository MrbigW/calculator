package com.cody.cody.datastructuredemo;

import android.util.Log;

/**
 * Created by Cody on 2017/1/9.
 */

public class ListNode {
    private static final String TAG = "ListNode";
    private int data;
    private ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getNext() {
        return this.next;
    }

    public int length(ListNode headNode) {
        int length = 0;
        ListNode currentNode = headNode;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNext(); //如果没有下一个节点，当前节点就空了，表示该节点为最后一个节点
        }
        return length;

    }


    /**
     * @param headNode     首节点
     * @param nodeToInsert 需要插入的节点
     * @param position     需要插入的位置
     */
    public ListNode insert(ListNode headNode, ListNode nodeToInsert, int position) {
        if (headNode == null) {   //链表为空，直接插入
            return nodeToInsert;
        }

        int size = length(headNode);   //链表的长度

        if (position > size + 1 || position < 1) {  //如果插入位置大于链表长度+1或<1,则为无效插入
            Log.d(TAG, "插入位置无效,正确的位置范围1到size+1");
            return headNode;
        }

        if (position == 1) {        //在链表开头插入，将插入节点的指针指向head节点
            nodeToInsert.setNext(headNode);
            return nodeToInsert;
        } else {
            //在链表中间或结尾插入，需要知道插入节点的前一个节点和后一个节点
            ListNode preNode = headNode;   //假设首节点是前一个节点
            int count = 1;
            while (count < position - 1) {       //当count等于插入节点的位置时就找到了前一个节点
                preNode = preNode.getNext(); //从首节点遍历
                count++;
            }
            ListNode currentNode = preNode.getNext(); //找到后一个节点
            nodeToInsert.setNext(currentNode);      //将插入节点的指针指向后一个节点
            preNode.setNext(nodeToInsert);           //将前一个节点的指针指向插入节点
        }

        return headNode;
    }


    public ListNode delete(ListNode headNode, int position) {
        int size = length(headNode);
        if (position > size || position < 1) {
            Log.d(TAG, "节点位置无效");
        }

        if (position == 1) { //删除表头节点
            ListNode currentNode = headNode.getNext();
            headNode = null;
            return currentNode;
        } else {     //删除中间或链表结尾
            ListNode preNode = headNode;
            int count = 1;
            while (count < position) {
                preNode = preNode.getNext();
                count++;
            }
            ListNode currentNode = preNode.getNext();
            preNode.setNext(currentNode.getNext());
            currentNode = null;
        }

        return headNode;
    }



    public void deleteListNode(ListNode headNode){
        ListNode nextNode,iterator=headNode;
        while (iterator!=null){
            nextNode=iterator.getNext();
            iterator=null;    //java中垃圾回收器自动处理
            iterator=nextNode;
        }
    }


}
