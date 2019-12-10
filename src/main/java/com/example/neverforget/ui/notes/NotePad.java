package com.example.neverforget.ui.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.neverforget.R;

public class NotePad extends AppCompatActivity {
    TextView subjectLine;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_note);
        subjectLine = findViewById(R.id.makeSubject);
        Button done = findViewById(R.id.doneWithNotes);
        EditText notes = findViewById(R.id.actualNotes);
        String subjectString = getIntent().getStringExtra("subject");
        subjectLine.setText(subjectString);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotesActivity.notePadList.add(NotePad.this);
                startActivity(new Intent(NotePad.this, NotesActivity.class));
            }
        });
    }


}
