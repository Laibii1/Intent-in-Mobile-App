package com.example.datatransfer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // define the variable
    Button send_button;
    EditText send_text;
    TextView showMsg_activity1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send_button = findViewById(R.id.send_button_id_activity1);
        send_text = findViewById(R.id.send_text_id_activity1);
        showMsg_activity1 = findViewById(R.id.show_msg_activity1);


        // create the get Intent object
        Intent showMsg_intent_activity1 = getIntent();
        // receive the value by getStringExtra() method and
        // key must be same which is send by first activity
        String received_msg_from_activity2 = showMsg_intent_activity1.getStringExtra("message_key_activity2");
        // display the string into textView
        showMsg_activity1.setText(received_msg_from_activity2);


        // add the OnClickListener in sender button after clicked this button following Instruction will run
        send_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // get the value which input by user in EditText and convert it to string
                String message = send_text.getText().toString();
                // Create the Intent object of this class Context() to Second_activity class
                Intent sendMsg_intent_activity1 = new Intent(MainActivity.this,Activity2.class);
                // now by putExtra method put the value in key, value pair key is
                // message_key by this key we will receive the value, and put the string
                sendMsg_intent_activity1.putExtra("message_key_activity1", message);
                startActivity(sendMsg_intent_activity1);
            }
        });

    }

}
