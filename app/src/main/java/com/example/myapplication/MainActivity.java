package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.Toast;
import android.widget.TextView;;
import android.view.View;
import android.widget.RadioButton;
import android.content.Context;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    String yourname = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void display_result(View view) {

        EditText name = (EditText) findViewById(R.id.editText);
        yourname = name.getText().toString();

        EditText answer = (EditText) findViewById(R.id.answer);
        String answer1 = answer.getText().toString();
        int finalValue = Integer.parseInt(answer1);

        CheckBox Ankara = (CheckBox) findViewById(R.id.ankara);
        boolean ankara1 = Ankara.isChecked();

        CheckBox hongkong = (CheckBox) findViewById(R.id.hong);
        boolean hongkong1 = hongkong.isChecked();

        CheckBox seven = (CheckBox) findViewById(R.id.seven);
        boolean seven1 = seven.isChecked();

        RadioButton yes = (RadioButton) findViewById(R.id.yes);
        boolean yes1 = yes.isChecked();

        CheckBox tahran = (CheckBox) findViewById(R.id.tahran);
        boolean tahran1 = tahran.isChecked();

        CheckBox paris = (CheckBox) findViewById(R.id.paris);
        boolean paris1 = paris.isChecked();

        CheckBox five = (CheckBox) findViewById(R.id.five);
        boolean five1 = five.isChecked();

        CheckBox london = (CheckBox) findViewById(R.id.london);
        boolean london1 = london.isChecked();

        CheckBox six = (CheckBox) findViewById(R.id.six);
        boolean six1 = six.isChecked();

        CheckBox lasvegas = (CheckBox) findViewById(R.id.la);
        boolean lasvegas1 = lasvegas.isChecked();

        score = calculatescore(ankara1,six1, hongkong1, seven1, yes1,tahran1,
        london1,paris1,lasvegas1, five1, score,finalValue);
        String themessage = createmessage(score);
        yourscore(themessage);

        String messege = createtoast(score);

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast displayscore = Toast.makeText(context, messege, duration);
        displayscore.show();


        score = 0;

    }

    public int calculatescore(boolean ankara1, boolean six1, boolean hongkong1, boolean seven1, boolean yes1,boolean tahran1,
                              boolean london1, boolean paris1, boolean lasvegas1, boolean five1, int score1,int finalValue) {
        if (ankara1 && !paris1 && !tahran1) {
            score1 = score1 + 1;
        }
        if (finalValue == 15) {
            score1 = score1 + 1;
        }
        if (hongkong1 && !lasvegas1 && !london1) {
            score1 = score1 + 1;
        }
        if (seven1 && !six1 && !five1) {
            score1 = score1 + 1;
        }
        if (yes1) {
            score1 = score1 + 1;
        }

        return score1;
    }

    public void yourscore(String message) {
        TextView done = (TextView) findViewById(R.id.score);
        done.setText(message);
    }

    private String createmessage(int score) {
        String scoremessage = "name:" + yourname;
        scoremessage += "\nYour Score is:" + score;
        return scoremessage;
    }

    private String createtoast(int score) {
        String message = "";
            message = "you got" + score + "/5";
        return message;
    }

}
