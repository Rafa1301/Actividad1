package com.example.rafao.tarea1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static TextView texto1;
    static double deg = 0;
    static double res = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup rg = (RadioGroup) findViewById(R.id.rg1);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                ImageView img = (ImageView) findViewById(R.id.imagenLogo);
                switch(checkedId){
                    case R.id.radio4:
                        img.setImageResource(R.drawable.d45);
                        MainActivity.deg = Math.PI/4;
                        break;
                    case R.id.radio5:
                        img.setImageResource(R.drawable.d90);
                        MainActivity.deg = Math.PI/2;
                        break;
                    case R.id.radio6:
                        img.setImageResource(R.drawable.d180);
                        MainActivity.deg = Math.PI;
                        break;
                }
            }
        });

    }

    public void genRes(View v){

        boolean checked = ((RadioButton) v).isChecked();
        switch(v.getId()){
            case R.id.radio1:
                MainActivity.res = Math.sin(MainActivity.deg);
            break;
            case R.id.radio2:
                MainActivity.res = Math.cos(MainActivity.deg);
            break;
            case R.id.radio3:
                MainActivity.res = Math.tan(MainActivity.deg);
            break;
        }

        MainActivity.texto1 = (TextView) findViewById(R.id.resultado);
        MainActivity.texto1.setText(""+MainActivity.res);

    }
}
