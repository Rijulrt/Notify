package com.example.neverforget.ui.notes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.neverforget.R;

public class FauxDialogue extends Activity {

    String subject, email;
    EditText subjectInput, emailInput;
    Button add;

    protected void onCreate(Bundle savedInstanceSate) {
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.dialouge_new_note);

        subjectInput = findViewById(R.id.setpassw);
        emailInput = findViewById(R.id.Email);

        add = findViewById(R.id.addButton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subject = subjectInput.getText().toString();
                if (subject.equals("qwerty")) {
                    Intent intent = new Intent(FauxDialogue.this, PhotoVault.class);
                    startActivity(intent);
                } else {
                    subject = "\t \t" + subject;
                    Intent intent = new Intent(FauxDialogue.this, NotePad.class);
                    intent.putExtra("subject", subject);
                    intent.putExtra("email", email);
                    startActivity(intent);
                }
            }
        });
    }


}
