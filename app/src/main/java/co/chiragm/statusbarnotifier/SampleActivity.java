package co.chiragm.statusbarnotifier;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        final StatusBarNotifier statusBarNotifier = new StatusBarNotifier
                .Builder(this)
                .build();

        statusBarNotifier.setText("Sample notification");

        findViewById(R.id.click_me).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (statusBarNotifier.isVisible()) {
                    statusBarNotifier.hide();
                } else {
                    statusBarNotifier.show();
                }
            }
        });
    }
}
