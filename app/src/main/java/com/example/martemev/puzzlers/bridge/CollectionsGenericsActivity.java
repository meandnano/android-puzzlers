package com.example.martemev.puzzlers.bridge;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Mikhail Artemyev
 */
public class CollectionsGenericsActivity extends Activity{

    private abstract static class Bucket<T> {
        abstract void add(Collection<T> args);
        void addNotNull(Collection<T> args){
            for (T theArg : args) {
                if (theArg != null) {
                        add(Collections.singleton(theArg));
                }
            }
        }
    }

    private static class StringBucket extends Bucket<String> {

        private final List<String> list = new ArrayList<>();

        @Override
        void add(Collection<String> args) {
            list.addAll(args);
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
        bucket.addNotNull(Arrays.asList("Android", null, "Cat"));
        Log.d("Bucket", bucket.toString());
    }
}
