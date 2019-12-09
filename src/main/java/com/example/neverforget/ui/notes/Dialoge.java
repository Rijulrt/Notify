package com.example.neverforget.ui.notes;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.example.neverforget.R;

import java.util.List;
import java.util.Stack;

public class Dialoge extends DialogFragment {
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        List<NotePad>  listOfNotes = new Stack<>();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.dialouge_new_note, null))
                // Add action buttons
                .setPositiveButton(R.string.create, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        LinearLayout linearLayout = findViewById(R.id.singleNote);
                        linearLayout.removeAllViews();
                        View noteChunk = getLayoutInflater().inflate(R.layout.chunk_notes,
                                linearLayout, false);
                        TextView textView = noteChunk.findViewById(R.id.subjectLine);
                        Button button = noteChunk.findViewById(R.id.deleteButton);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        return builder.create();
    }
}
