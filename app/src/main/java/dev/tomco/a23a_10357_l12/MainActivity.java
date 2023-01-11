package dev.tomco.a23a_10357_l12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public class MainActivity extends AppCompatActivity {

    private MaterialButton main_BTN_start;
    private MaterialButton main_BTN_end;
    private LinearProgressIndicator main_PRG_download;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViews();
        initViews();
    }

    private void initViews() {
        main_BTN_start.setOnClickListener(v -> start());
        main_BTN_end.setOnClickListener(v -> stop());
    }

    private void findViews() {
        main_PRG_download = findViewById(R.id.main_PRG_download);
        main_BTN_start = findViewById(R.id.main_BTN_start);
        main_BTN_end = findViewById(R.id.main_BTN_end);
    }


    private void start() {
        main_PRG_download.setMax(100);
        main_PRG_download.setProgress(0);
        Intent intent = new Intent(this, ServiceSteps.class);
        intent.setAction(ServiceSteps.ACTION_START);
        startService(intent);
    }

    private void stop() {
        Intent intent = new Intent(this, ServiceSteps.class);
        intent.setAction(ServiceSteps.ACTION_STOP);
        startService(intent);
    }
}