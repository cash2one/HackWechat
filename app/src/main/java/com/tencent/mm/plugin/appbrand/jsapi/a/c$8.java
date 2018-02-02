package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;

class c$8 implements a {
    final /* synthetic */ c jgI;
    final /* synthetic */ MMActivity jgN;

    c$8(c cVar, MMActivity mMActivity) {
        this.jgI = cVar;
        this.jgN = mMActivity;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == 100) {
            this.jgI.jgF = 1;
            if (i2 == -1) {
                this.jgI.jgG = 1;
                x.i("MicroMsg.JsApiGetPhoneNumber", "mmOnActivityResult RESULT_OK");
                g.pQN.h(14249, new Object[]{this.jgI.jgr.mAppId, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.jgI.jgF), Integer.valueOf(this.jgI.jgG), Integer.valueOf(this.jgI.jgE)});
                h.bu(this.jgN.mController.xIM, this.jgN.getResources().getString(j.izb));
                this.jgI.afH();
            } else {
                this.jgI.jgG = 0;
                this.jgI.jgr.E(this.jgI.jcN, this.jgI.e("fail:user cancel", null));
                x.e("MicroMsg.JsApiGetPhoneNumber", "mmOnActivityResult RESULT_CANCEL OR RESULT_FIRST_USER");
                g.pQN.h(14249, new Object[]{this.jgI.jgr.mAppId, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.jgI.jgF), Integer.valueOf(this.jgI.jgG), Integer.valueOf(this.jgI.jgE)});
            }
            this.jgN.jwN = null;
        }
    }
}
