package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.f;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.m.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.sdk.platformtools.x;

class q$3 implements OnClickListener {
    final /* synthetic */ String tIq;
    final /* synthetic */ String yJT;
    final /* synthetic */ q yLH;
    final /* synthetic */ String yLO;
    final /* synthetic */ int yLP;
    final /* synthetic */ int yLQ;
    final /* synthetic */ String yLR;

    q$3(q qVar, String str, String str2, int i, int i2, String str3, String str4) {
        this.yLH = qVar;
        this.yLO = str;
        this.yJT = str2;
        this.yLP = i;
        this.yLQ = i2;
        this.yLR = str3;
        this.tIq = str4;
    }

    public final void onClick(View view) {
        ar arVar = (ar) view.getTag();
        x.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[]{this.yLO});
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.fnp = arVar.fEJ.field_msgSvrId + ":" + arVar.userName + ":" + q.c(this.yLH).crz() + ":" + this.yJT;
        if (((a) g.h(a.class)).fV(arVar.userName)) {
            appBrandStatObject.scene = HardCoderJNI.FUNC_CANCEL_UNIFY_CPU_IO_THREAD_CORE;
            ((c) g.h(c.class)).a(q.c(this.yLH).getContext(), this.yLO, null, this.yLP, this.yLQ, this.yLR, appBrandStatObject);
        } else {
            appBrandStatObject.scene = 1043;
            d jS = f.jS(arVar.userName);
            ((c) g.h(c.class)).a(q.c(this.yLH).getContext(), this.yLO, null, this.yLP, this.yLQ, this.yLR, appBrandStatObject, jS == null ? null : jS.field_appId);
        }
        q.B(9, q.a(this.yLH), q.b(this.yLH));
        com.tencent.mm.plugin.report.service.g.pQN.h(11608, new Object[]{q.b(this.yLH), this.tIq, Integer.valueOf(2)});
    }
}
