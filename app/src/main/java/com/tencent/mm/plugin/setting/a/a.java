package com.tencent.mm.plugin.setting.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public final class a {
    public final ag gQF;
    Object mLock = new Object();
    public Runnable mRunnable;
    public long mYz;
    public boolean qgj;
    public boolean qgk;
    public boolean qgl;
    final CountDownLatch qgm;
    HashSet<String> qgn = new HashSet();
    HashSet<String> qgo = new HashSet();
    HashSet<String> qgp = new HashSet();
    HashSet<String> qgq = new HashSet();
    public a qgr;
    public h qgs;

    static /* synthetic */ void a(a aVar, LinkedList linkedList) {
        if (aVar.qgk) {
            aVar.qgr = new a(aVar, aVar.qgs, aVar.qgm);
            e eVar = aVar.qgr;
            eVar.start = System.currentTimeMillis();
            ar.CG().a(JsApiSetAudioState.CTRL_INDEX, eVar);
            a.bqr();
        }
        if (aVar.qgj) {
            HashSet hashSet = new HashSet();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                hashSet.add((String) it.next());
            }
            long currentTimeMillis = System.currentTimeMillis() - 15552000000L;
            x.i("MicroMsg.UnfamiliarContactEngine", "[getHalfYearNotChatInfo] timestamp:%s size:%s", new Object[]{Long.valueOf(currentTimeMillis), Integer.valueOf(hashSet.size())});
            long currentTimeMillis2 = System.currentTimeMillis();
            g gVar = new g();
            gVar.mLR = 9;
            gVar.fDj = String.valueOf(currentTimeMillis);
            gVar.mLZ = new 3(aVar, hashSet, currentTimeMillis, currentTimeMillis2);
            gVar.handler = aVar.gQF.cfF();
            ((m) com.tencent.mm.kernel.g.k(m.class)).search(2, gVar);
        }
        if (aVar.qgl) {
            aVar.f(linkedList, 0);
        }
        Runnable 2 = new 2(aVar);
        aVar.mRunnable = 2;
        com.tencent.mm.sdk.f.e.post(2, "MicroMsg.UnfamiliarContactEngineAwait");
    }

    public a(boolean z, boolean z2, boolean z3, h hVar) {
        this.qgj = z;
        this.qgk = z2;
        this.qgl = z3;
        x.i("MicroMsg.UnfamiliarContactEngine", "[UnfamiliarContactEngine] count:%s [%s:%s:%s]", new Object[]{Integer.valueOf((this.qgl ? 1 : 0) + ((this.qgj ? 1 : 0) + (this.qgk ? 1 : 0))), Boolean.valueOf(this.qgk), Boolean.valueOf(this.qgj), Boolean.valueOf(this.qgl)});
        this.qgm = new CountDownLatch(r0);
        this.gQF = new ag("UnfamiliarContactEngine");
        this.qgs = hVar;
    }

    final void f(LinkedList<String> linkedList, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        int size = i + 10 < linkedList.size() ? i + 10 : linkedList.size();
        List subList = linkedList.subList(i, size);
        g gVar = new g();
        gVar.mLR = 8;
        gVar.fDj = bh.d(subList, ",");
        gVar.mLZ = new 4(this, size, subList, linkedList, currentTimeMillis);
        gVar.handler = this.gQF.cfF();
        ((m) com.tencent.mm.kernel.g.k(m.class)).search(2, gVar);
    }
}
