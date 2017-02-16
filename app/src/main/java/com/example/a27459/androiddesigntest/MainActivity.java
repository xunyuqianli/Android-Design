package com.example.a27459.androiddesigntest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.toappBar)
    Button toAppBar;
    @BindView(R.id.toAll)
    Button tooall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toAppBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"dianji",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,AppBarLayoutActivity.class);
                startActivity(intent);
            }
        });

        tooall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"dianji",Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent1);
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toappBar:
                Toast.makeText(this,"dianji",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,AppBarLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.toAll:
                Toast.makeText(this,"dianji",Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(this, Main2Activity.class);
                startActivity(intent1);
                break;
            default:
                break;


        }
    }
}
