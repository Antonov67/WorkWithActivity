package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    public void recieveDataNewMetod(View view) {
        EditText editText = findViewById(R.id.editText4);
        Intent intent = new Intent();
        intent.putExtra("newData", editText.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
    }
}