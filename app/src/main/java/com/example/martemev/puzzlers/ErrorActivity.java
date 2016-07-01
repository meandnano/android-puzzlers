package com.example.martemev.puzzlers;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;

/**
 * @author Mikhail Artemyev
 */
public class ErrorActivity extends Activity implements View.OnClickListener {

    private EditText errorEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);

        errorEditText = (EditText) findViewById(R.id.textView_error);

        findViewById(R.id.button_error).setOnClickListener(this);
        findViewById(R.id.button_error_drawable).setOnClickListener(this);
        findViewById(R.id.button_clear_error).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_error:
                errorEditText.setError(getString(R.string.error_text));
                break;
            case R.id.button_error_drawable:
                errorEditText.setError(getString(R.string.error_text), getIcon());
                break;
            case R.id.button_clear_error:
                errorEditText.setError(null);
                break;
        }
    }

    @NonNull
    private Drawable getIcon() {
        Drawable icon = ContextCompat.getDrawable(this, R.drawable.warning);
        icon.setBounds(0, 0, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
        return icon;
    }
}
