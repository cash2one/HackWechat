package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.widget.Toast;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.plugin.walletlock.a$g;

class GestureGuardLogicUI$23 implements a {
    final /* synthetic */ GestureGuardLogicUI tgm;

    GestureGuardLogicUI$23(GestureGuardLogicUI gestureGuardLogicUI) {
        this.tgm = gestureGuardLogicUI;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        GestureGuardLogicUI.b(this.tgm);
        GestureGuardLogicUI.d(this.tgm);
        if (i2 == 0) {
            Toast.makeText(this.tgm, this.tgm.getString(a$g.teO), 0).show();
            GestureGuardLogicUI.a(this.tgm, -1, 0, "open gesture ok");
        } else {
            Toast.makeText(this.tgm, this.tgm.getString(a$g.tey), 0).show();
            GestureGuardLogicUI.a(this.tgm, -1, -1, "open gesture failed");
        }
        return 0;
    }
}
