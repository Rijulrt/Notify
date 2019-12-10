package com.example.neverforget.ui.notes;

import android.content.Intent;
import android.os.Bundle;

import com.example.neverforget.MainActivity;
import com.example.neverforget.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NotesActivity extends AppCompatActivity {

    LinearLayout llnotes;
    public static List<NotePad> notePadList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        FloatingActionButton addNotesButton = findViewById(R.id.addNotesButton);
        llnotes = findViewById(R.id.noteList);
        TextView noNote = findViewById(R.id.noNoteText);
        noNote.setVisibility(View.VISIBLE);
        if (notePadList != null) {
            noNote = findViewById(R.id.noNoteText);
            noNote.setVisibility(View.GONE);
            for (NotePad a : notePadList) {
                View noteChunk = getLayoutInflater().inflate(R.layout.chunk_notes,
                        llnotes, false);
                TextView subject = noteChunk.findViewById(R.id.subjectLine);
                Button delete = noteChunk.findViewById(R.id.deleteButton);
                subject.setText(a.subjectLine.getText());
                llnotes.addView(noteChunk);
                if (delete != null) {
                    delete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            llnotes.removeView(noteChunk);
                            notePadList.remove(a);
                        }
                    });
                }
            }
            addNotesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(NotesActivity.this, FauxDialogue.class));
                }
            });

        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_delete_all:
                llnotes.removeAllViews();
                notePadList.clear();
                TextView noNote = findViewById(R.id.noNoteText);
                noNote.setVisibility(View.VISIBLE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
