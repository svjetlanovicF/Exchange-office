package com.link.mjenjanica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import java.util.Objects;

public class MainActivity extends MotherActivity implements OnFragmentSendMessageListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onEuroClick(View view) {
        Intent intent = new Intent(MainActivity.this, CourseActivity.class);
        intent.putExtra("CONVERTER", 0);
        startActivity(intent);
    }

    public void onDolarClick(View view) {
        Intent intent = new Intent(MainActivity.this, CourseActivity.class);
        intent.putExtra("CONVERTER", 1);
        startActivity(intent);
    }

    public void onKruneClick(View view) {
        Intent intent = new Intent(MainActivity.this, CourseActivity.class);
        intent.putExtra("CONVERTER", 2);
        startActivity(intent);
    }

    public void onKuneKlick(View view) {
        Intent intent = new Intent(MainActivity.this, CourseActivity.class);
        intent.putExtra("CONVERTER", 3);
        startActivity(intent);
    }

    public void onFranakClick(View view) {
        Intent intent = new Intent(MainActivity.this, CourseActivity.class);
        intent.putExtra("CONVERTER", 4);
        startActivity(intent);
    }

    @Override
    public void onFragmentSendMessage(CharSequence charSequence) {
        showConverterToast(charSequence);
    }
}