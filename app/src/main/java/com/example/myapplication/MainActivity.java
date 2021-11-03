package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void simpleOpenTwo(View view) {
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        startActivity(intent);

    }

    public void openActivityWithDataTransfer(View view) {
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        EditText editText = findViewById(R.id.editText1);
        String text =  editText.getText().toString();
        intent.putExtra("dataText", text);
        startActivity(intent);
    }

    public void getData(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity3.class);
        startActivityForResult(intent,1);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            TextView textView = findViewById(R.id.textView2);
            textView.setText(data.getStringExtra("recieveData"));
        }
        else
            Toast.makeText(getApplicationContext(),"Нет-нет",Toast.LENGTH_LONG).show();

    }
}