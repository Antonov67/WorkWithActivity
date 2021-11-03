package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //метод для получения новых данных, замена метода startActivityForResult
    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent intent = result.getData();
                        TextView textView = findViewById(R.id.textView5);
                        textView.setText(intent.getStringExtra("newData"));
                    }
                }
            });

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
    //новый метод забрать данный из второй Активити
    public void getDataNewMetod(View view) {
        mStartForResult.launch(new Intent(this, MainActivity4.class));
    }
}