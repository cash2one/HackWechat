package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.os.Bundle;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.p.a;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.x;

public abstract class b extends a {
    public Activity activity;
    protected float kCe = 0.0f;
    protected d nTp;
    protected float nlE = 0.0f;
    protected int type = 0;

    public abstract d aWu();

    public abstract int getLayoutId();

    public b(Activity activity) {
        this.activity = activity;
    }

    public void onCreate(Bundle bundle) {
        this.activity.requestWindowFeature(1);
        this.activity.setContentView(getLayoutId());
        this.type = this.activity.getIntent().getIntExtra("map_view_type", 0);
        x.i("MicroMsg.MMBaseMapUI", "init oncreate type %d", new Object[]{Integer.valueOf(this.type)});
        ((FrameLayout) findViewById(R.h.cuV)).addView(d.cY(this.activity));
        this.nTp = aWu();
        this.nTp.setMapViewOnTouchListener(new 1(this));
    }

    public final View findViewById(int i) {
        return this.activity.findViewById(i);
    }

    public final String getString(int i) {
        return this.activity.getString(i);
    }

    public final void onBackPressed() {
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void aWv() {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        x.d("MicroMsg.MMBaseMapUI", "dispatchKeyEvent");
        this.activity.finish();
        return true;
    }

    public final boolean aWt() {
        return false;
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }

    protected final void aWs() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = this.activity.getCurrentFocus();
            if (currentFocus != null) {
                IBinder windowToken = currentFocus.getWindowToken();
                if (windowToken != null) {
                    inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                }
            }
        }
    }

    public final void showVKB() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = this.activity.getCurrentFocus();
            if (currentFocus != null && currentFocus.getWindowToken() != null) {
                inputMethodManager.toggleSoftInput(0, 2);
            }
        }
    }
}
