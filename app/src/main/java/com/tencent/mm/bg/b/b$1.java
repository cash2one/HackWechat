package com.tencent.mm.bg.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.Set;

class b$1 implements Runnable {
    final /* synthetic */ Set hZi;
    final /* synthetic */ String hZj;
    final /* synthetic */ String hZk;
    final /* synthetic */ b hZl;

    public b$1(b bVar, Set set, String str, String str2) {
        this.hZl = bVar;
        this.hZi = set;
        this.hZj = str;
        this.hZk = str2;
    }

    public final void run() {
        LinkedList linkedList = new LinkedList();
        for (String UA : this.hZi) {
            linkedList.add(new bdo().UA(UA));
            x.d("MicroMsg.NewVoiceInputReportManager", "mVoiceIdSet Id = %s", UA);
        }
        bdo UA2 = new bdo().UA(this.hZj);
        bdo UA3 = new bdo().UA(this.hZk);
        g.CG().a((int) JsApiOpenWeRunSetting.CTRL_INDEX, this.hZl);
        g.CG().a(new a(linkedList.size(), linkedList, UA2, UA3), 0);
    }
}
