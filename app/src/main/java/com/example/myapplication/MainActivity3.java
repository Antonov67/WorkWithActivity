package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

    }

    public void recieveData(View view) {
        EditText editText = findViewById(R.id.editText);
        Intent intent = new Intent();
        intent.putExtra("recieveData", editText.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
    }
}