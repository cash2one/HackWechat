package com.tencent.mm.plugin.setting.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.hs;
import com.tencent.mm.g.a.se;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.CountDownLatch;

class a$a implements e, Runnable {
    CountDownLatch lPT;
    k qgA;
    final /* synthetic */ a qgt;
    h qgz;
    long start;

    a$a(a aVar, h hVar, CountDownLatch countDownLatch) {
        this.qgt = aVar;
        this.qgz = hVar;
        this.lPT = countDownLatch;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            x.e("MicroMsg.UnfamiliarContactEngine", "[onSceneEnd] errType:%s errCode:%s errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            this.lPT.countDown();
        } else if (kVar.getType() == JsApiSetAudioState.CTRL_INDEX) {
            this.qgA = kVar;
            com.tencent.mm.sdk.f.e.post(this, "load_unfamiliar_contact");
        }
    }

    public final void run() {
        b seVar = new se();
        seVar.fJQ.fJS = this.qgA;
        a.xef.m(seVar);
        int i = seVar.fJR.state;
        Object obj = seVar.fJR.fJT;
        String str = "MicroMsg.UnfamiliarContactEngine";
        String str2 = "[callback] state:%s,tagList is null?%s,tagList size:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Boolean.valueOf(obj == null);
        objArr[2] = Integer.valueOf(obj == null ? 0 : obj.size());
        x.i(str, str2, objArr);
        if (i != 1) {
            if (obj != null) {
                this.qgt.qgq.addAll(obj);
            }
            x.i("MicroMsg.UnfamiliarContactEngine", "[AsyncGetSnsTagInfo] %sms", new Object[]{Long.valueOf(System.currentTimeMillis() - this.start)});
            this.lPT.countDown();
            return;
        }
        if (this.qgz != null) {
            ag.y(new 1(this));
        }
        this.qgt.gQF.g(new 2(this), 30000);
    }

    static void bqr() {
        b hsVar = new hs();
        hsVar.fya.fuL = 3;
        a.xef.m(hsVar);
    }
}
