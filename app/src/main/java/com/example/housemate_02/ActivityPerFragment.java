package com.example.housemate_02;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.housemate_02.ui.main.ActivityPerFragment2;

public class ActivityPerFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_per_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, ActivityPerFragment2.newInstance())
                .commitNow();
        }
    }
}