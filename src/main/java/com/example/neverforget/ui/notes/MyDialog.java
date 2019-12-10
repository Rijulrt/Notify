package com.example.neverforget.ui.notes;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

import com.example.neverforget.R;

import java.util.List;
import java.util.Stack;

public class MyDialog extends DialogFragment {

    String subject;
    EditText subjectInput;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialouge_new_note, null);
        subjectInput = (EditText) view.findViewById(R.id.subject);
        builder.setView(inflater.inflate(R.layout.dialouge_new_note, null))
                .setPositiveButton(R.string.create, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        subject = subjectInput.getText().toString();
                        Intent intent = new Intent(getContext(), NotePad.class);
                        intent.putExtra("subject", subject);
                        startActivity(intent);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        return builder.create();
    }



    /*
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialouge_new_note, null))
                // Add action buttons
                .setPositiveButton(R.string.create, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        View view = inflater.inflate(R.layout.dialouge_new_note, null);
                        EditText editText = view.findViewById(R.id.subject);
                        Intent intent = new Intent(getContext(), NotePad.class);
                        intent.putExtra("subject", editText.getText());
                        startActivity(intent);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        return builder.create();
    }

     */
}
