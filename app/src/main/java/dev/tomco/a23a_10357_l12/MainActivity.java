package dev.tomco.a23a_10357_l12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView main_LBL_title;
    private MaterialButton main_BTN_start;
    private MaterialButton main_BTN_change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViews();
        initViews();
    }

    private void initViews() {
        main_BTN_start.setOnClickListener(v -> doSomething());
        main_BTN_change.setOnClickListener(v -> {
            String text = main_LBL_title.getText().toString();
            main_LBL_title.setText(text.equals("Hello World!") ? "Goodbye World!" : "Hello World!");
        });
    }

    private void findViews() {
        main_LBL_title = findViewById(R.id.main_LBL_title);
        main_BTN_start = findViewById(R.id.main_BTN_start);
        main_BTN_change = findViewById(R.id.main_BTN_change);
    }

    private void doSomething() {
        int x = 9;
        Log.d("Started", "doSomething");
        for (int i = 0; i < 10; i++) {
            int y = 0;
            Log.d("in loop", "doSomething: "+i);
            for (int j = 0; j < 300_000_000; j++) {
                if (j % 2 == 0) {
                    y += Math.pow(i,3) + Math.sin(x*2.4);
                } else {
                    y -= Math.pow(i,3) - Math.sin(x*2.4);
                }
            }
        }
    }
}