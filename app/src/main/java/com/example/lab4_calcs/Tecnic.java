package com.example.lab4_calcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Tecnic extends AppCompatActivity {

    private static final int OPERATION_KIND_NONE = 0;
    private static final int OPERATION_KIND_PLUS = 1;
    private static final int OPERATION_KIND_MINUS = 2;
    private static final int OPERATION_KIND_DELETE = 3;
    private static final int OPERATION_KIND_MULTI = 4;

    private static final int OPERATION_KIND_SIN = 5;
    private static final int OPERATION_KIND_COS = 6;
    private static final int OPERATION_KIND_SQRT = 7;
    private static final int OPERATION_KIND_POW = 8;
    private static final int OPERATION_KIND_e = 9;
    private static final int OPERATION_KIND_log10 = 10;
    private static final int OPERATION_KIND_log2 = 11;
    private static final int OPERATION_KIND_ln = 12;
    private static final int OPERATION_KIND_POW3 = 13;


    private double result = 0;
    private double firstVal = 0;
    private double secondVal = 0;
    private int operationKind = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tecnic);
        clearResults();

        Button button = (Button) findViewById(R.id.button_clear);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                clearResults();
            }

        });

        button = (Button) findViewById(R.id.button_equals);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applyEquals();
            }
        });
    }


    private void clearResults(){
        result = 0;
        firstVal = 0;
        secondVal = 0;
        operationKind = OPERATION_KIND_NONE;
        TextView view = (TextView) findViewById(R.id.result);
        view.setText(getText(R.string.text_result));

    }

    private void applyEquals(){
        if (operationKind == OPERATION_KIND_NONE)
            return;
        TextView view = (TextView) findViewById(R.id.result);
        String strBuff = (String) view.getText();

        if (operationKind <= 4) {
            try {
                secondVal = Double.valueOf(strBuff);
            } catch (NumberFormatException e) {
                secondVal = 0;
            }

            switch (operationKind) {
                case OPERATION_KIND_PLUS:
                    result = firstVal + secondVal;
                    break;
                case OPERATION_KIND_MINUS:
                    result = firstVal - secondVal;
                    break;
                case OPERATION_KIND_DELETE:
                    result = firstVal / secondVal;
                    break;
                case OPERATION_KIND_MULTI:
                    result = firstVal * secondVal;
                    break;
                default:
                    break;
            }
        }
        else
            switch (operationKind) {
                case OPERATION_KIND_SIN:
                    result = Math.sin(firstVal);
                    break;
                case OPERATION_KIND_COS:
                    result = Math.cos(firstVal);
                    break;
                case OPERATION_KIND_SQRT:
                    result = Math.sqrt(firstVal);
                    break;
                case OPERATION_KIND_POW:
                    result = firstVal * firstVal;
                    break;
                case OPERATION_KIND_e:
                    result=Math.exp(firstVal);
                    break;
                case OPERATION_KIND_log10:
                    result=Math.log10(firstVal);

                    break;
                case OPERATION_KIND_log2:
                    result=Math.log(firstVal) / Math.log(2);

                    break;
                case OPERATION_KIND_ln:
                    result=Math.log(firstVal);

                    break;
                case OPERATION_KIND_POW3:
                    result = firstVal * firstVal* firstVal;

                    break;
                default:
                    break;
            }

        firstVal = result;
        if (result==0)
        {view.setText("0");}
        else
        {
            String res=String.valueOf (result);
            if (!res.endsWith(".0"))
            {view.setText(res);}
            else
                view.setText(res.substring(0, res.length() - 2));


        }

    }

    public void OnClickOperation(View view) {
        int bid = view.getId();
        switch (bid){
            case R.id.button_plus:
                operationKind = OPERATION_KIND_PLUS;
                break;
            case R.id.button_minus:
                operationKind = OPERATION_KIND_MINUS;
                break;
            case R.id.button_del:
                operationKind = OPERATION_KIND_DELETE;
                break;
            case R.id.button_multi:
                operationKind = OPERATION_KIND_MULTI;
                break;
            case R.id.button_sin:
                operationKind = OPERATION_KIND_SIN;

                break;
            case R.id.button_cos:
                operationKind = OPERATION_KIND_COS;

                break;
            case R.id.button_sqrt:
                operationKind = OPERATION_KIND_SQRT;

                break;
            case R.id.button_pow2:
                operationKind = OPERATION_KIND_POW;

                break;

            case R.id.button_e:
                operationKind = OPERATION_KIND_e;
                break;
            case R.id.button_log10:
                operationKind = OPERATION_KIND_log10;

                break;
            case R.id.button_log2:
                operationKind = OPERATION_KIND_log2;

                break;
            case R.id.button_ln:
                operationKind = OPERATION_KIND_ln;

                break;
            case R.id.button_pow3:
                operationKind = OPERATION_KIND_POW3;

                break;
            default:
                return;
        }
        TextView v = (TextView) findViewById(R.id.result);
        String strBuff = (String) v.getText();
        try {
            firstVal = Double.valueOf(strBuff);
        }
        catch (NumberFormatException e)
        {
            firstVal = 0;
        }
        if (operationKind <= 4)
            v.setText(getText(R.string.text_result));
        else
            applyEquals();

    }

    public void OnClick(View view) {
        TextView v = (TextView) findViewById(R.id.result);
        String strBuff = (String) v.getText();
        if (strBuff.equalsIgnoreCase((String) getText(R.string.text_result)))
            strBuff = "";
        int bid = view.getId();
        switch (bid){
            case R.id.button_0:
                strBuff += "0";
                break;
            case R.id.button_1:
                strBuff += "1";
                break;
            case R.id.button_2:
                strBuff += "2";
                break;
            case R.id.button_3:
                strBuff +="3";
                break;
            case R.id.button_4:
                strBuff += "4";
                break;
            case R.id.button_5:
                strBuff += "5";
                break;
            case R.id.button_6:
                strBuff += "6";
                break;
            case R.id.button_7:
                strBuff += "7";
                break;
            case R.id.button_8:
                strBuff += "8";
                break;
            case R.id.button_9:
                strBuff += "9";
                break;
            case R.id.button_point:
                strBuff += ".";
                break;
            default:
                return;
        }
        v.setText(strBuff);
    }



    public void OnClickMenu(View view) {
        Intent intent = new Intent(Tecnic.this, Menu.class);

        startActivity(intent);

    }
}