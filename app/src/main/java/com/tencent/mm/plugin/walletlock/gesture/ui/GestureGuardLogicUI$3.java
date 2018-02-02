package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.widget.Toast;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.plugin.walletlock.a.g;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import java.util.List;

class GestureGuardLogicUI$3 implements a {
    final /* synthetic */ GestureGuardLogicUI tgm;
    final /* synthetic */ List tgo;

    GestureGuardLogicUI$3(GestureGuardLogicUI gestureGuardLogicUI, List list) {
        this.tgm = gestureGuardLogicUI;
        this.tgo = list;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        if (i2 == 0) {
            GestureGuardLogicUI.i(this.tgm);
            GestureGuardLogicUI.j(this.tgm);
            d.bNW();
            d.bNQ();
            d.bNS();
            GestureGuardLogicUI.a(this.tgm, this.tgo);
            GestureGuardLogicUI.a(this.tgm, 1);
            GestureGuardLogicUI.h(this.tgm);
        } else if (i2 == -3) {
            GestureGuardLogicUI.k(this.tgm);
            GestureGuardLogicUI.a(this.tgm, 2);
            GestureGuardLogicUI.h(this.tgm);
        } else {
            Toast.makeText(this.tgm, this.tgm.getString(g.tez), 0).show();
        }
        return 0;
    }
}
