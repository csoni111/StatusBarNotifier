package co.chiragm.sbn;

import android.app.Activity;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class StatusBarNotifier {
    private long autoHideDelayMillis = 3000;
    private boolean autoHide = true;
    private boolean isVisible = false;

    private Activity activity;
    private View sbn;

    private Runnable autoHideRunnable;

    private StatusBarNotifier(Activity activity) {
        this.activity = activity;
    }

    public static class Builder {
        private StatusBarNotifier sbn;

        public Builder(@NonNull Activity activity) {
            this.sbn = new StatusBarNotifier(activity);
        }

        public Builder setAutoHide(boolean autoHide) {
            sbn.autoHide = autoHide;
            return this;
        }

        public Builder setAutoHideDelayMillis(long autoHideDelayMillis) {
            sbn.autoHideDelayMillis = autoHideDelayMillis;
            return this;
        }

        public StatusBarNotifier build() {
            sbn.init();
            return sbn;
        }
    }

    private void init() {
        setFullScreen();
        addSBNView();
        autoHideRunnable = new Runnable() {
            @Override
            public void run() {
                hide();
            }
        };
    }

    private void setFullScreen() {
        getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    private void addSBNView() {
        ViewGroup root = (ViewGroup) ((ViewGroup) activity
                .findViewById(android.R.id.content)).getChildAt(0);
        sbn = View.inflate(activity, R.layout.status_bar_notifier, root);
    }

    private View getDecorView() {
        return activity.getWindow().getDecorView();
    }

    public void show() {
        getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        isVisible = true;
        if (autoHide) {
            new Handler().postDelayed(autoHideRunnable, autoHideDelayMillis);
        }
    }

    public void hide() {
        setFullScreen();
        isVisible = false;
    }

    public void setBackgroundColor(int color) {
        sbn.findViewById(R.id.proxy_status_bar).setBackgroundColor(color);
    }

    public void setText(String text) {
        getTextView().setText(text);
    }

    public TextView getTextView() {
        return ((TextView) sbn.findViewById(R.id.sbn_text));
    }

    public boolean isVisible() {
        return this.isVisible;
    }

}
