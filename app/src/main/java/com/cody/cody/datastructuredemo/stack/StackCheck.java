package com.cody.cody.datastructuredemo.stack;

import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Stack;

/**
 * Created by Cody on 2017/1/11.
 */

public class StackCheck {
    private TextView mTextView;
    private Stack<String> mStack=new Stack<>();
    private final DecimalFormat mFormat=new DecimalFormat("#########.#########");


    private void push(char object){
        final int size=mStack.size();
        if('c'==object) {
            mStack.clear();
        }
    }



}
