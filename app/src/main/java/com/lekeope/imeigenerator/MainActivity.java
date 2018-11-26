package com.lekeope.imeigenerator;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText inputImei;
    TextView gen_field;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputImei = findViewById(R.id.input_imei);
        gen_field = findViewById(R.id.gen_field);
    }
    public void generate(View view) {
        int randomNumber;
        int min= 9999;
        int max= 100000;
        int lst_fig;
        Random fig;
        fig = new Random();
        lst_fig = fig.nextInt(10);
        int lastlst_fig= ((lst_fig*5)/10)-2;


        Random random;
        random = new Random();
        randomNumber = random.nextInt(max-min+1)+min;
        gen_field.setText(inputImei.getText().toString()+"" +Integer.toString(randomNumber)+""+lst_fig +lastlst_fig);
    }

    public void copy(View view) {
        TextView generated = (TextView) findViewById(R.id.gen_field);
        ClipboardManager clipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("label", generated.getText().toString());
        clipboard.setPrimaryClip(clip);

        Toast.makeText(getApplicationContext(), "IMEI Copied to ClipBoard", Toast.LENGTH_SHORT).show();
        Log.i("Info:", "IMEI copied");
    }
}

