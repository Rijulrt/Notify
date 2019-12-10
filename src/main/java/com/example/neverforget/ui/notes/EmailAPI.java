
/*package com.example.neverforget.ui.notes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.neverforget.R;

import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;


public class EmailAPI extends AppCompatActivity {

    String ownerEmail, otherEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_api);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button button = findViewById(R.id.shareButton);
        TextView textView = findViewById(R.id.ownerEmail);
        EditText editText = findViewById(R.id.Email);
        otherEmail = editText.getText().toString();
        ownerEmail = getIntent().getStringExtra("email");
        textView.setText(ownerEmail);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Email email = EmailBuilder.startingBlank()
                        .from("Michel Baker", "m.baker@mbakery.com")
                        .to("mom", "jean.baker@hotmail.com")
                        .to("dad", "StevenOakly1963@hotmail.com")
                        .withSubject("My Bakery is finally open!")
                        .withPlainText("Mom, Dad. We did the opening ceremony of our bakery!!!")
                        .buildEmail();

                MailerBuilder
                        .withSMTPServer("server", 25, "username", "password")
                        .buildMailer()
                        .sendMail(email);


            }
        });
    }
}
*/

