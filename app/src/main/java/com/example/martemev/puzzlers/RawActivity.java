package com.example.martemev.puzzlers;

import android.app.Activity;
import android.os.Bundle;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author Mikhail Artemyev
 */
public class RawActivity extends Activity {

    private static class Collapser<T> {

        public String collapse(Collection<String> strings) {
            StringBuilder collapse = new StringBuilder();
            for (String theString : strings) {
                collapse.append(theString);
            }
            return collapse.toString();
        }

        public int collapse(List<Integer> integers) {
            int result = 0;
            for (Integer theInt : integers) {
                result += theInt;
            }
            return result;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<String> strings = Arrays.asList("Android", "Boris", "Cat");

        // working example
        System.out.println(new Collapser<Void>().collapse(strings));

        // falling example
        System.out.println(new Collapser().collapse(strings));
    }
}
