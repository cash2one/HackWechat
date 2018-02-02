package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.m.b.a;

class q$15 implements a {
    final /* synthetic */ q yLH;
    final /* synthetic */ aw yLS;

    q$15(q qVar, aw awVar) {
        this.yLH = qVar;
        this.yLS = awVar;
    }

    public final void b(WxaAttributes wxaAttributes) {
        int i = 0;
        if (wxaAttributes != null) {
            int i2;
            q.b(this.yLH, wxaAttributes.field_appId);
            if ((wxaAttributes.field_appOpt & 1) > 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            View view = this.yLS.yOZ;
            if (i2 == 0) {
                i = 8;
            }
            view.setVisibility(i);
        }
    }
}
