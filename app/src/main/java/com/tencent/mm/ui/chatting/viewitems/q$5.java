package com.tencent.mm.ui.chatting.viewitems;

import android.text.TextUtils;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.m.b$a;
import com.tencent.mm.sdk.platformtools.ag;

class q$5 implements b$a {
    final /* synthetic */ q yLH;
    final /* synthetic */ String yLO;
    final /* synthetic */ aw yLS;

    q$5(q qVar, aw awVar, String str) {
        this.yLH = qVar;
        this.yLS = awVar;
        this.yLO = str;
    }

    public final void b(WxaAttributes wxaAttributes) {
        if (wxaAttributes != null) {
            final String str = wxaAttributes.field_brandIconURL;
            final String str2 = wxaAttributes.field_nickname;
            ag.y(new Runnable(this) {
                final /* synthetic */ q$5 yLU;

                public final void run() {
                    o.PA().a(str, this.yLU.yLS.yPB, q.f(this.yLU.yLH));
                    this.yLU.yLS.yPC.setText(TextUtils.isEmpty(str2) ? this.yLU.yLO : str2);
                }
            });
        }
    }
}
