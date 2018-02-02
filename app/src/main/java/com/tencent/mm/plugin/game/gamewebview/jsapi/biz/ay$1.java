package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.ui.MMActivity.a;

class ay$1 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ d mWr;
    final /* synthetic */ ay mXl;

    ay$1(ay ayVar, d dVar, int i) {
        this.mXl = ayVar;
        this.mWr = dVar;
        this.gOK = i;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i != 2) {
            return;
        }
        if (i2 == -1) {
            d dVar = this.mWr;
            int i3 = this.gOK;
            ay ayVar = this.mXl;
            dVar.E(i3, com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("share_timeline:ok", null));
            return;
        }
        dVar = this.mWr;
        i3 = this.gOK;
        ayVar = this.mXl;
        dVar.E(i3, com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("share_timeline:cancel", null));
    }
}
