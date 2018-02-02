package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.os.SystemClock;
import android.widget.Toast;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.plugin.walletlock.a.g;
import com.tencent.mm.plugin.walletlock.gesture.a.d;

class GestureGuardLogicUI$24 implements a {
    final /* synthetic */ GestureGuardLogicUI tgm;

    GestureGuardLogicUI$24(GestureGuardLogicUI gestureGuardLogicUI) {
        this.tgm = gestureGuardLogicUI;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        if (i2 == 0) {
            d.fh(SystemClock.elapsedRealtime());
            Toast.makeText(this.tgm, this.tgm.getString(g.teP), 0).show();
            GestureGuardLogicUI.e(this.tgm);
        } else {
            Toast.makeText(this.tgm, this.tgm.getString(g.tey), 0).show();
        }
        GestureGuardLogicUI.b(this.tgm);
        GestureGuardLogicUI.d(this.tgm);
        return 0;
    }
}
