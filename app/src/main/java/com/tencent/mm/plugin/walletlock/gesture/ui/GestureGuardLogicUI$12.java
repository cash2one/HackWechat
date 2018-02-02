package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.widget.Toast;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.plugin.walletlock.a.g;
import com.tencent.mm.plugin.walletlock.gesture.a.d;

class GestureGuardLogicUI$12 implements a {
    final /* synthetic */ GestureGuardLogicUI tgm;

    GestureGuardLogicUI$12(GestureGuardLogicUI gestureGuardLogicUI) {
        this.tgm = gestureGuardLogicUI;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        if (i2 == 0) {
            d.bNW();
            d.bNQ();
            d.bNS();
            Toast.makeText(this.tgm, this.tgm.getString(g.teN), 0).show();
        } else {
            Toast.makeText(this.tgm, this.tgm.getString(g.tey), 0).show();
        }
        GestureGuardLogicUI.b(this.tgm);
        GestureGuardLogicUI.c(this.tgm);
        this.tgm.finish();
        return 0;
    }
}
