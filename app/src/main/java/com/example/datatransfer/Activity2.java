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

public class Activity2 extends AppCompatActivity {
    Button send_button_activity2;
    EditText send_text_activity2;
    TextView showMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        send_button_activity2 = findViewById(R.id.send_button_id_activity2);
        send_text_activity2 = findViewById(R.id.send_text_id_activity2);
        showMsg = findViewById(R.id.show_msg_activity2);

        // create the get Intent object
        Intent showMsg_intent_activity2 = getIntent();
        // receive the value by getStringExtra() method and
        // key must be same which is send by first activity
        String received_msg_from_activity1 = showMsg_intent_activity2.getStringExtra("message_key_activity1");
        // display the string into textView
        showMsg.setText(received_msg_from_activity1);

        // send data to activity 1
        send_button_activity2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // get the value which input by user in EditText and convert it to string
                String Activity2_Message = send_text_activity2.getText().toString();
                // Create the Intent object of this class Context() to Second_activity class
                Intent sendMsg_intent_activity2 = new Intent(Activity2.this,MainActivity.class);
                // now by putExtra method put the value in key, value pair key is
                // message_key by this key we will receive the value, and put the string
                sendMsg_intent_activity2.putExtra("message_key_activity2", Activity2_Message);
                startActivity(sendMsg_intent_activity2);
            }
        });

    }

}