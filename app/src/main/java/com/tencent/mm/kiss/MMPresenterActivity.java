package com.tencent.mm.kiss;

import android.os.Bundle;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.app.c;

public abstract class MMPresenterActivity extends MMActivity {
    private c gSQ = new c();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gSQ.B(getIntent(), this);
    }

    protected void onResume() {
        super.onResume();
        this.gSQ.Hm(2);
    }

    protected void onPause() {
        super.onPause();
        this.gSQ.Hm(3);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.gSQ.onDestroy();
    }
}
