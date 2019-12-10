package com.example.neverforget.ui.notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.neverforget.R;

public class SetPass extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setpass);



        EditText passwordInput;
        Button set;

        passwordInput = (EditText) findViewById(R.id.setpassw);
        set = (Button) findViewById(R.id.addPass);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String password = passwordInput.getText().toString();
                Intent intent = new Intent(SetPass.this, NotesActivity.class);
                intent.putExtra("password", password);
                startActivity(intent);
            }
        });


    }

}

