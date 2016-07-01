package com.example.martemev.puzzlers.bridge;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mikhail Artemyev
 */
public class VarargGenericsActivity extends Activity{

    private abstract static class Bucket<T> {
        abstract void add(T... args);
        void addNotNull(T... args){
            for (T theArg : args) {
                if (theArg != null) {
                    add(theArg);
                }
            }
        }
    }

    private static class StringBucket extends Bucket<String> {

        private List<String> list = new ArrayList<>();

        @Override
        void add(String... args) {
            list.addAll(Arrays.asList(args));
        }

        @Override
        public String toString() {
            return list.toString();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bucket<String> bucket = new StringBucket();
        bucket.addNotNull("Android", null, "Cat");
        Log.d("Bucket", bucket.toString());
    }
}
