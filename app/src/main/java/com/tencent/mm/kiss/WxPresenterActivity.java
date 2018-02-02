package com.tencent.mm.kiss;

import android.os.Bundle;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.e.a;

public abstract class WxPresenterActivity extends MMActivity {
    protected c gSQ = new c();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gSQ.B(getIntent(), this);
    }

    public void onResume() {
        super.onResume();
        this.gSQ.Hm(2);
    }

    public void onPause() {
        this.gSQ.Hm(3);
        super.onPause();
    }

    public void onDestroy() {
        this.gSQ.onDestroy();
        super.onDestroy();
    }

    public void keep(a aVar) {
        this.gSQ.keep(aVar);
    }

    public final <T extends b<? extends com.tencent.mm.vending.app.a>> T q(Class<? extends b<? extends com.tencent.mm.vending.app.a>> cls) {
        return this.gSQ.a(this, cls);
    }

    public final com.tencent.mm.vending.app.a DW() {
        return this.gSQ.DW();
    }
}
