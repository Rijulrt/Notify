package com.example.neverforget.ui.reminder;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.neverforget.R;

public class ReminderFragment extends Fragment {

    private ReminderViewModel reminderViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        reminderViewModel =
                ViewModelProviders.of(this).get(ReminderViewModel.class);
        View root = inflater.inflate(R.layout.fragment_reminder, container, false);
        final Button addReminder = root.findViewById(R.id.addReminder);
        final TextView editText = root.findViewById(R.id.add_reminder);
        LinearLayout linearLayout = root.findViewById(R.id.reminderLayout);
        CheckedTextView textView = new CheckedTextView(getContext());
        addReminder.setOnClickListener(unused -> textView.setText(editText.getText()));
        linearLayout.addView(textView);
        //textView.setOnClickListener(unused -> textView.setCheckMarkDrawable());
        if (!textView.isChecked()) {

            textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
        reminderViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                editText.setText(s);
            }
        });
        return root;
    }
}