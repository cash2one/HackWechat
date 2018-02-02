package com.tencent.mm.vending.app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.vending.e.b;

public abstract class PresenterActivity extends Activity implements b {
    private c gSQ = new c();

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gSQ.B(getIntent(), this);
    }

    protected void onResume() {
        super.onResume();
        this.gSQ.Hm(2);
    }

    protected void onPause() {
        this.gSQ.Hm(3);
        super.onPause();
    }

    protected void onDestroy() {
        this.gSQ.onDestroy();
        super.onDestroy();
    }
}
