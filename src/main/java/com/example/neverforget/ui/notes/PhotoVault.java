package com.example.neverforget.ui.notes;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.neverforget.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PhotoVault extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_vault);

        FloatingActionButton addPic = findViewById(R.id.addPicture);
        LinearLayout llpic = findViewById(R.id.picHolder);
        ImageView pic = (ImageView) findViewById(R.id.pic);

        addPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                        "content://media/internal/images/media"));
                startActivity(intent);
            }
        });
    }
}