package com.example.martemev.puzzlers.broadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.martemev.puzzlers.R;

import java.util.Arrays;

/**
 * @author Mikhail Artemyev
 */
public class ReceiverActivity extends Activity{

    private EditText editText;
    private TextView textViewReceived;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // extract received array
            String[] data = intent.getStringArrayExtra(BroadcastingService.EXTRA_DATA);
            final String received = Arrays.toString(data);

            // Print received array
            textViewReceived.setText("Received array: " + received);
            Log.d("Received", received);

            // Modify last element to the content of EditText
            data[data.length - 1] = editText.getText().toString();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        // register local broadcast receiver
        LocalBroadcastManager
                .getInstance(this)
                .registerReceiver(receiver, new IntentFilter(BroadcastingService.ACTION));

        textViewReceived = (TextView) findViewById(R.id.textView_received);
        editText = (EditText) findViewById(R.id.edit);

        // when button click - request a service to send a broadcasting intent
        findViewById(R.id.button_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(ReceiverActivity.this, BroadcastingService.class));
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopService(new Intent(this, BroadcastingService.class));
    }
}
