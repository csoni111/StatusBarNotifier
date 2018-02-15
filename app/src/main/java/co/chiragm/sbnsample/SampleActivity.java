package co.chiragm.sbnsample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import co.chiragm.sbn.StatusBarNotifier;

public class SampleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        // Build an instance of StatusBarNotifier
        final StatusBarNotifier statusBarNotifier = new StatusBarNotifier
                .Builder(this)
                .setAutoHide(true) // default true
                .setAutoHideDelayMillis(3000) // default 3000 ms (3 seconds)
                .build();

        // Set notification text and change colors
        statusBarNotifier.setText("Sample notification");
        statusBarNotifier.setBackgroundColor(ContextCompat.getColor(this,
                R.color.colorPrimaryDark));
        statusBarNotifier.getTextView().setTextColor(Color.WHITE);

        findViewById(R.id.click_me).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show StatusBarNotifier
                statusBarNotifier.show();
            }
        });
    }
}
