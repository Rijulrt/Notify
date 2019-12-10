package com.example.neverforget.ui.notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.neverforget.R;

public class FauxDialogue extends AppCompatActivity {

    String subject;
    EditText subjectInput;
    Button add;

    protected void onCreate(Bundle savedInstanceSate) {
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.dialouge_new_note);

        subjectInput = (EditText) findViewById(R.id.subject);

        add = (Button) findViewById(R.id.addButton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subject = subjectInput.getText().toString();
                Intent intent = new Intent(FauxDialogue.this, NotePad.class);
                intent.putExtra("subject", subject);
                startActivity(intent);
            }
        });
    }


}
