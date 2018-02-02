package com.tencent.mm.plugin.webview.fts.a;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.webview.fts.a.c.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class b implements c {
    Map<a, a> gKa = new HashMap();
    Map<a, CountDownLatch> tng = new ConcurrentHashMap();
    private k tnh = new 1(this);
    private k tni = new 2(this);

    public final a NY(String str) {
        a eVar = new e(str, Integer.MAX_VALUE);
        CountDownLatch countDownLatch = (CountDownLatch) this.tng.get(eVar);
        if (countDownLatch != null) {
            x.i("FTSMatchContact", "have a running task ,wait for result, query %s,maxMatch %d", new Object[]{str, Integer.valueOf(Integer.MAX_VALUE)});
        } else if (a(eVar, this.tnh)) {
            x.i("FTSMatchContact", "not have a running task ,start new task, query %s,maxMatch %d", new Object[]{str, Integer.valueOf(Integer.MAX_VALUE)});
            countDownLatch = new CountDownLatch(1);
            this.tng.put(eVar, countDownLatch);
        } else {
            x.i("FTSMatchContact", "start new task fail, query %s,maxMatch %d", new Object[]{str, Integer.valueOf(Integer.MAX_VALUE)});
        }
        if (countDownLatch != null) {
            try {
                countDownLatch.await(2000, TimeUnit.MILLISECONDS);
            } catch (Throwable e) {
                x.printErrStackTrace("FTSMatchContact", e, "", new Object[0]);
            }
        }
        this.tng.remove(eVar);
        return eVar;
    }

    public final void a(a aVar, a aVar2) {
        this.gKa.put(aVar, aVar2);
        a(aVar, this.tni);
    }

    private static boolean a(a aVar, k kVar) {
        if (bh.ov(aVar.fDj)) {
            return false;
        }
        int[] iArr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
        int[] iArr2 = new int[]{1, 5};
        g gVar = new g();
        gVar.fDj = aVar.fDj;
        gVar.mLU = iArr;
        gVar.mLV = iArr2;
        gVar.mLW = aVar.tnf;
        gVar.mLY = com.tencent.mm.plugin.fts.a.c.b.mMz;
        gVar.mLX = new HashSet();
        gVar.mLZ = kVar;
        gVar.scene = 1;
        ((m) com.tencent.mm.kernel.g.k(m.class)).search(2, gVar).mLn = aVar;
        return true;
    }
}
