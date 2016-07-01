package com.example.martemev.puzzlers.broadcast;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.util.Arrays;

/**
 * @author Mikhail Artemyev
 */
public class BroadcastingService extends Service {

    public static final String ACTION = "local-test";
    public static final String EXTRA_DATA = "array";

    private final String[] DATA = {"Android", "Boris", "Cat"};

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // send our local array
        Intent intentToSend = new Intent(ACTION);
        intentToSend.putExtra(EXTRA_DATA, DATA);
        LocalBroadcastManager
                .getInstance(this)
                .sendBroadcast(intentToSend);

        Log.d("Sending", Arrays.toString(DATA));

        return super.onStartCommand(intent, flags, startId);
    }
}
