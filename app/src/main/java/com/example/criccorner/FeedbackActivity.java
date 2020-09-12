package com.example.criccorner;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.firebase.client.Firebase;

public class FeedbackActivity extends AppCompatActivity {
    EditText namedata, emaildata, messagedata;
    Button button;
    Firebase firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        getSupportActionBar().setTitle("Feedback");

        namedata = findViewById(R.id.Enter_your_name);
        emaildata = findViewById(R.id.Enter_your_Email);
        messagedata = findViewById(R.id.FeedbackBody);
        button = findViewById(R.id.button);


        Firebase.setAndroidContext(this);

        String UniqueID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);


        firebase = new Firebase("https://criccorner-bd7d2.firebaseio.com/feedback/users" + UniqueID);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String name = namedata.getText().toString();
                final String email = emaildata.getText().toString();
                final String message = messagedata.getText().toString();

                Firebase child_name = firebase.child("Name");
                child_name.setValue(name);

                if (name.isEmpty()) {
                    namedata.setError("This is a required field");
                    button.setEnabled(false);
                } else {
                    namedata.setError(null);
                    button.setEnabled(false);
                }

                Firebase child_email = firebase.child("Email");
                child_email.setValue(email);

                if (email.isEmpty()) {
                    emaildata.setError("This is a required field");
                    button.setEnabled(false);
                } else {
                    emaildata.setError(null);
                    button.setEnabled(false);
                }

                Firebase child_message = firebase.child("Message");
                child_message.setValue(message);

                if (message.isEmpty()) {
                    messagedata.setError("This is a required field");
                    button.setEnabled(false);
                } else {
                    messagedata.setError(null);
                    button.setEnabled(true);
                }

              Toast.makeText(getApplicationContext(), "Thank you for your Feedback", Toast.LENGTH_SHORT).show();

                namedata.getText().clear();
                emaildata.getText().clear();
                messagedata.getText().clear();


            }
        });

    }
}