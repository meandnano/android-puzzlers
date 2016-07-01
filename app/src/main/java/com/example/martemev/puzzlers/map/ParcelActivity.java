package com.example.martemev.puzzlers.map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.martemev.puzzlers.R;

import java.util.TreeMap;

/**
 * @author Mikhail Artemyev
 */
public class ParcelActivity extends Activity implements View.OnClickListener {

    public static final String MAP = "arg_map";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hash_map);

        findViewById(R.id.button_send).setOnClickListener(this);

        // Working case
        TreeMap<String, String> sortedMap = MapWrapper.getMapExtra(getIntent(), MAP);

        // Falling case
        // TreeMap<String, String> sortedMap =
        //        (TreeMap<String, String>) getIntent().getSerializableExtra(MAP);

        if (sortedMap != null) {
            Log.d("Extracted map", sortedMap.toString());
        }
    }

    @Override
    public void onClick(View v) {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("A", "Android");
        map.put("B", "Boris");
        map.put("C", "Cat");

        Intent intent = new Intent(this, ParcelActivity.class);

        // Working case
        MapWrapper.putMapExtra(intent, MAP, map);

        // Falling case
        // intent.putExtra(MAP, map);

        Log.d("Extracted map", map.toString());

        startActivity(intent);
    }
}
