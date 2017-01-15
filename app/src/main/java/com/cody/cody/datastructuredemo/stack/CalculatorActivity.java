package com.cody.cody.datastructuredemo.stack;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cody.cody.datastructuredemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalculatorActivity extends AppCompatActivity {

    @BindView(R.id.result)
    TextView mResult;
    @BindView(R.id.clear)
    Button mClear;
    @BindView(R.id.neg)
    Button mNeg;
    @BindView(R.id.percent)
    Button mPercent;
    @BindView(R.id.divide)
    Button mDivide;
    @BindView(R.id.num_7)
    Button mNum7;
    @BindView(R.id.num_8)
    Button mNum8;
    @BindView(R.id.num_9)
    Button mNum9;
    @BindView(R.id.multiply)
    Button mMultiply;
    @BindView(R.id.num_4)
    Button mNum4;
    @BindView(R.id.num_5)
    Button mNum5;
    @BindView(R.id.num_6)
    Button mNum6;
    @BindView(R.id.subtract)
    Button mSubtract;
    @BindView(R.id.num_1)
    Button mNum1;
    @BindView(R.id.num_2)
    Button mNum2;
    @BindView(R.id.num_3)
    Button mNum3;
    @BindView(R.id.plus)
    Button mPlus;
    @BindView(R.id.num_0)
    Button mNum0;
    @BindView(R.id.dot)
    Button mDot;
    @BindView(R.id.equal)
    Button mEqual;



    private boolean isOperator(char obj) {
        boolean isOp = false;
        if (obj == '+' || obj == '-' || obj == '*' || obj == '/') {
            isOp = true;
        }

        return isOp;
    }


    private boolean isAppendValid(String exp) {
        if (exp.equals("")) {
            return true;
        }
        int expLen = exp.length();
        for (int i = expLen - 1; i >= 0; i--) {
            char ch = exp.charAt(i);
            if (isOperator(ch)) {
                return true;
            } else if (ch == '.') {
                return false;
            }
        }
    return true;
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.clear, R.id.neg, R.id.percent, R.id.divide, R.id.num_7, R.id.num_8, R.id.num_9, R.id.multiply, R.id.num_4, R.id.num_5, R.id.num_6, R.id.subtract, R.id.num_1, R.id.num_2, R.id.num_3, R.id.plus, R.id.num_0, R.id.dot, R.id.equal, R.id.activity_calculator})


    public void onClick(View view) {
        Button btn = (Button) view;

        switch (view.getId()) {
            case R.id.num_0:
                operate(btn);
                break;
            case R.id.num_1:
                operate(btn);
                break;
            case R.id.num_2:
                operate(btn);
                break;
            case R.id.num_3:
                operate(btn);
                break;
            case R.id.num_4:
                operate(btn);
                break;
            case R.id.num_5:
                operate(btn);
                break;
            case R.id.num_6:
                operate(btn);
                break;
            case R.id.num_7:
                operate(btn);
                break;
            case R.id.num_8:
                operate(btn);
                break;
            case R.id.num_9:
                operate(btn);
                break;
            case R.id.dot:
                operate(btn);
                break;

            case R.id.equal:
                operate(btn);
                break;
            case R.id.plus:
                operate(btn);
                break;
            case R.id.subtract:
                operate(btn);
                break;
            case R.id.multiply:
                operate(btn);
                break;
            case R.id.divide:
                operate(btn);
                break;
            case R.id.clear:
                mResult.setText("");
                break;
            case R.id.neg:
                break;
            case R.id.percent:
                break;
        }
    }


    public void operate(Button bn){
        String bnText = bn.getText().toString();

        String oldExpression = mResult.getText().toString();

        char inputCh = bnText.charAt(bnText.length()-1);
        if (isOperator(inputCh)) {
            if (oldExpression.equals(""))
                return;

            char lastCh = oldExpression.charAt(oldExpression.length()-1);
            if (isOperator(lastCh))
                return;
        }

        if (inputCh == '.' && !isAppendValid(oldExpression)) {
            return;
        }

        String newExpression = null;
        if (bnText.equals("=")) {
            double result = ReversePolishNotation.evalExp(oldExpression);
            newExpression = Double.toString(result);
        }
        else {
            newExpression = oldExpression.concat(bnText);
        }

        mResult.setText(newExpression);
    }



}
