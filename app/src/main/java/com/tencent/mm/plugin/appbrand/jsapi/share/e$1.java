package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;

class e$1 implements a {
    final /* synthetic */ String fgU;
    final /* synthetic */ MMActivity fgW;
    final /* synthetic */ String gBF;
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ e jqU;

    e$1(e eVar, MMActivity mMActivity, String str, String str2, j jVar, int i) {
        this.jqU = eVar;
        this.fgW = mMActivity;
        this.fgU = str;
        this.gBF = str2;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i != 0) {
            return;
        }
        if (i2 == -1) {
            h.bu(this.fgW, this.fgW.getResources().getString(q.j.dGG));
            e.b(this.fgU, this.gBF, "", 1, i2);
            x.i("MicroMsg.JsApiShareTimeline", "result is success");
            this.iZy.E(this.gOK, this.jqU.e("success", null));
            return;
        }
        x.i("MicroMsg.JsApiShareTimeline", "result is cancel");
        this.iZy.E(this.gOK, this.jqU.e("cancel", null));
        e.b(this.fgU, this.gBF, "", 3, i2);
    }
}
