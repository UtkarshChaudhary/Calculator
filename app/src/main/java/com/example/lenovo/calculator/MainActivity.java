package com.example.lenovo.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   Button one,two,three,four,five,six,seven,eight,nine,zero,clear,multiply,divide,equal,plus,minus;
    TextView firstText,secondText;
    String str1="",str2="7";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plus = (Button) findViewById(R.id. plus);
        minus = (Button) findViewById(R.id. minus);
        divide = (Button) findViewById(R.id. divide);
        multiply = (Button) findViewById(R.id. multiply);
        equal = (Button) findViewById(R.id. equal);
        clear = (Button) findViewById(R.id. clear);

        one = (Button) findViewById(R.id. one);
        two = (Button) findViewById(R.id. two);
        three = (Button) findViewById(R.id. three);
        four = (Button) findViewById(R.id. four);
        five = (Button) findViewById(R.id. five);
        six = (Button) findViewById(R.id. six);
        seven = (Button) findViewById(R.id. seven);
        eight = (Button) findViewById(R.id. eight);
        nine = (Button) findViewById(R.id. nine);
        zero = (Button) findViewById(R.id. zero);

        plus.setOnClickListener( this);
        minus.setOnClickListener(this);
        divide.setOnClickListener(this);
        multiply.setOnClickListener(this);
        equal.setOnClickListener(this);
        clear.setOnClickListener(this);

        one.setOnClickListener( this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener( this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);

        firstText=(TextView) findViewById(R.id.text1);
        secondText=(TextView) findViewById(R.id.text2);

           }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.one){
            str1+=1;
         firstText.setText(str1);

        }
        if(v.getId()==R.id.two){
            str1+=2;
            firstText.setText(str1);

        }
        if(v.getId()==R.id.three){
            str1+=3;
            firstText.setText(str1);

        }
        if(v.getId()==R.id.four){
            str1+=4;
            firstText.setText(str1);

        }
        if(v.getId()==R.id.five){
            str1+=5;
            firstText.setText(str1);

        }
        if(v.getId()==R.id.six){
            str1+=6;
            firstText.setText(str1);

        }
        if(v.getId()==R.id.seven){
            str1+=7;
            firstText.setText(str1);

        }
        if(v.getId()==R.id.eight){
            str1+=8;
            firstText.setText(str1);

        }
        if(v.getId()==R.id.nine){
            str1+=9;
            firstText.setText(str1);

        }
        if(v.getId()==R.id.zero){
            str1+=0;
            firstText.setText(str1);

        }
        if(v.getId()==R.id.plus) {
            str1+='+';
            firstText.setText(str1);
        }
        if(v.getId()==R.id.minus) {
            str1+='-';
            firstText.setText(str1);
        }
        if(v.getId()==R.id.multiply){
            str1+='X';
            firstText.setText(str1);
        }
        if(v.getId()==R.id.divide){
            str1+='/';
            firstText.setText(str1);

        }
        if(v.getId()==R.id.clear){
            if(str1.isEmpty()){
               if(str2.isEmpty()){

               }else{
                   str2=str2.substring(0,str2.length()-1);
                   secondText.setText(str2);
               }
            }else {
                str1 = str1.substring(0, str1.length() - 1);
            }
            firstText.setText(str1);
        }
        if(v.getId()==R.id.equal){
            equalFunctionIsClicked();
        }

    }

    private void equalFunctionIsClicked() {
        int n1=0;
        if((str2.isEmpty())||(str1.charAt(0)!='+'&& str1.charAt(0)!='-'&&str1.charAt(0)!='/'&&str1.charAt(0)!='X')){
            n1=0;
        }else{
            n1=Integer.parseInt(str2);
        }
        Log.i("n1 value at starting",""+n1);
        int n2=0;
        String temp="";
        Log.i("BEFORE FOR LOOP ","STRING 1 LENGTH:"+str1.length());
        for(int i=0;i<str1.length();i++){
            Log.i("FOR LOOP","i value "+i );
            if(str1.charAt(i)=='+') {
                if (i == 0) {
                    temp = "";
                    i++;
                    while ((i < str1.length())&&(str1.charAt(i) != '+')&&( str1.charAt(i) != '-' )&&(str1.charAt(i) != '/')&&(str1.charAt(i) != 'X') ){
                        temp += str1.charAt(i++);
                        Log.i("i==1 while loop","temp value "+temp+"i value "+i);

                }
                n2 = Integer.parseInt(temp);
                    Log.i("n2 value i==1"," "+n2);
                n1 += n2;
                i-=1;
                temp="";
            }else{
                if(temp.equals("")) {
                    i++;
                    while ((i < str1.length())&&(str1.charAt(i) != '+')&&(str1.charAt(i) != '-')&&(str1.charAt(i) != '/')&&(str1.charAt(i) != 'X')){
                        temp += str1.charAt(i++);
                    }
                    n2 = Integer.parseInt(temp);
                    n1 += n2;
                    i-=1;
                    temp="";

                }else{
                    n2 = Integer.parseInt(temp);
                    n1 += n2;
                    temp="";
                    i++;
                    while ((i < str1.length())&&(str1.charAt(i) != '+' )&&( str1.charAt(i) != '-')&&( str1.charAt(i) != '/')&&(str1.charAt(i) != 'X') ){
                        temp += str1.charAt(i++);
                        Log.i("inside while loop","i value"+i+" tempValue: "+temp);
                }
                n2 = Integer.parseInt(temp);
                n1 += n2;
                i-=1;
                temp="";
                }
                }

            }else if(str1.charAt(i)=='X'){
                if (i == 0) {
                    temp = "";
                    i++;
                    while ((i < str1.length())&&(str1.charAt(i) != '+' )&&( str1.charAt(i) != '-')&&( str1.charAt(i) != '/')&&(str1.charAt(i) != 'X') ){
                        temp += str1.charAt(i++);
                        Log.i("i==1 while loop","temp value "+temp+"i value "+i);

                    }
                    n2 = Integer.parseInt(temp);
                    Log.i("n2 value i==1"," "+n2);
                    n1 *= n2;
                    i-=1;
                    temp="";
                }else{
                    if(temp.equals("")) {
                        i++;
                        while ((i < str1.length())&&(str1.charAt(i) != '+' )&&( str1.charAt(i) != '-')&&( str1.charAt(i) != '/')&&(str1.charAt(i) != 'X')){
                            temp += str1.charAt(i++);
                        }
                        n2 = Integer.parseInt(temp);
                        n1 *= n2;
                        i-=1;
                        temp="";
                    }else{
                         n2 = Integer.parseInt(temp);
                        n1 += n2;
                        temp="";
                        i++;
                        while ((i < str1.length())&&(str1.charAt(i) != '+' )&&( str1.charAt(i) != '-')&&( str1.charAt(i) != '/')&&(str1.charAt(i) != 'X') ){
                            temp += str1.charAt(i++);
                            Log.i("inside while loop","i value"+i+" tempValue: "+temp);
                        }
                        n2 = Integer.parseInt(temp);
                        n1 *= n2;
                        i-=1;
                        temp="";
                    }
                }

                }else if(str1.charAt(i)=='/'){
                if (i == 0) {
                    temp = "";
                    i++;
                    while ((i < str1.length())&&(str1.charAt(i) != '+' )&&( str1.charAt(i) != '-')&&( str1.charAt(i) != '/')&&(str1.charAt(i) != 'X')){
                        temp += str1.charAt(i++);
                        Log.i("i==1 while loop","temp value "+temp+"i value "+i);

                    }
                    n2 = Integer.parseInt(temp);
                    Log.i("n2 value i==1"," "+n2);
                    n1 /= n2;
                    i-=1;
                    temp="";
                }else{
                    if(temp.equals("")) {
                        i++;
                        while ((i < str1.length())&&(str1.charAt(i) != '+' )&&( str1.charAt(i) != '-')&&( str1.charAt(i) != '/')&&(str1.charAt(i) != 'X')){
                            temp += str1.charAt(i++);
                        }
                        n2 = Integer.parseInt(temp);
                        n1 /= n2;
                        i-=1;
                        temp="";
                    }else{
                        n2 = Integer.parseInt(temp);
                        n1 += n2;
                        temp="";
                        i++;
                        while ((i < str1.length())&&(str1.charAt(i) != '+' )&&( str1.charAt(i) != '-')&&( str1.charAt(i) != '/')&&(str1.charAt(i) != 'X') ){
                            temp += str1.charAt(i++);
                            Log.i("inside while loop","i value"+i+" tempValue: "+temp);
                        }
                        n2 = Integer.parseInt(temp);
                        n1 /= n2;
                        i-=1;
                        temp="";
                    }
                }
                }else if(str1.charAt(i)=='-'){
                if (i == 0) {
                    temp = "";
                    i++;
                    while ((i < str1.length())&&(str1.charAt(i) != '+' )&&( str1.charAt(i) != '-')&&( str1.charAt(i) != '/')&&(str1.charAt(i) != 'X') ){
                        temp += str1.charAt(i++);
                        Log.i("i==1 while loop","temp value "+temp+"i value "+i);

                    }
                    n2 = Integer.parseInt(temp);
                    Log.i("n2 value i==1"," "+n2);
                    n1 -= n2;
                    i-=1;
                    temp="";
                }else{
                    if(temp.equals("")) {
                        i++;
                        while ((i < str1.length())&&(str1.charAt(i) != '+' )&&( str1.charAt(i) != '-')&&( str1.charAt(i) != '/')&&(str1.charAt(i) != 'X')){
                            temp += str1.charAt(i++);
                        }
                        n2 = Integer.parseInt(temp);
                        n1 -= n2;
                        i-=1;
                        temp="";
                    }else{
                          n2 = Integer.parseInt(temp);
                        n1 += n2;
                        temp="";
                        i++;
                        while ((i < str1.length())&&(str1.charAt(i) != '+' )&&( str1.charAt(i) != '-')&&( str1.charAt(i) != '/')&&(str1.charAt(i) != 'X')){
                            temp += str1.charAt(i++);
                            Log.i("inside while loop","i value"+i+" tempValue: "+temp);
                        }
                        n2 = Integer.parseInt(temp);
                        n1 -= n2;
                        i-=1;
                        temp="";
                    }
                }
                }else{
                temp+=str1.charAt(i);
            }
        }
        str2="";
        str2+=n1;
        secondText.setText(str2);
        str1="";
        firstText.setText(str1);
    }
}
  /*


    }
    EditText t = (EditText) findViewById(R.id.edit);
    int res=0;
    public void onClick(View v) {
        int n1, n2;
        if(res==0) {

            String s = t.getText().toString();
            n1 = Integer.parseInt(s);
        }else{
            n1=res;
        }

        if (v.getId() == R.id.plus) {
            // EditText t = (EditText) findViewById(R.id.edit);

            String s = t.getText().toString();
            n2=Integer.parseInt(s);
            t.setText(null);

            //  res=n1+n2;


        }else  if(v.getId()==R.id.minus)
        {// EditText t = (EditText) findViewById(R.id.edit);

            String s = t.getText().toString();
            n2=Integer.parseInt(s);
            res=n1-n2;
            t.setText(null);
            t.setText(res+"");

        }else  if(v.getId()==R.id.div)
        { //EditText t = (EditText) findViewById(R.id.edit);
            t.setText(null);
            String s = t.getText().toString();
            n2=Integer.parseInt(s);
            res=n1/n2;
            t.setText(res+"");

        }else  if(v.getId()==R.id.mul)
        { EditText t = (EditText) findViewById(R.id.edit);
            t.setText(null);
            String s = t.getText().toString();
            n2=Integer.parseInt(s);
            res=n1*n2;
            t.setText(res+"");

        }else  if(v.getId()==R.id.C)
        { //EditText t = (EditText) findViewById(R.id.edit);
            t.setText(null);
            String s = t.getText().toString();
            n2=Integer.parseInt(s);
            res=0;
            t.setText("");

        }
        else  if(v.getId()==R.id.eq)
        {  //EditText t = (EditText) findViewById(R.id.edit);
            t.setText(res+"");

        }

*/