package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class WalletLqtBasePresenterUI extends WalletBaseUI {
    private c gSQ = new c();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gSQ.B(getIntent(), this);
        this.zJc = true;
    }

    public void onResume() {
        super.onResume();
        this.gSQ.Hm(2);
    }

    public void onPause() {
        super.onPause();
        this.gSQ.Hm(3);
    }

    public void onDestroy() {
        super.onDestroy();
        this.gSQ.onDestroy();
    }

    public final <T extends b<? extends a>> T q(Class<? extends b<? extends a>> cls) {
        return this.gSQ.a(this, cls);
    }

    public final <T extends a> T t(Class<? extends a> cls) {
        return this.gSQ.b(this, cls);
    }

    public boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected int getLayoutId() {
        return 0;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
