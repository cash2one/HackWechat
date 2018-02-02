package com.tencent.mm.plugin.webview.fts.topstory.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.f;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;

class e$2 implements b {
    final /* synthetic */ e tnX;

    e$2(e eVar) {
        this.tnX = eVar;
    }

    public final void o(String str, String str2, String str3) {
        String b;
        for (String b2 : e.a(this.tnX)) {
            e.a(this.tnX, b2);
        }
        e.a(this.tnX).clear();
        if (!bh.ov(e.b(this.tnX))) {
            b2 = e.b(this.tnX);
            e.b(this.tnX, null);
            e.a(this.tnX, b2);
        }
        e.b(this.tnX, str3);
        o.TV().a(e.a(this.tnX, e.b(this.tnX), str2), false);
        if (e.bPw().get() == 9223372036854775806L) {
            e.bPw().set(0);
            g.Dj().CU().a(a.xxE, Long.valueOf(e.bPw().get()));
            new e.a(this.tnX, Long.MAX_VALUE).run();
        } else if (!e.bPv().get()) {
            e.post(new e.a(this.tnX, e.bPw().get()), "FtsRecommendVideoPreloadMgr.DeleteUnusedTask");
        }
        long incrementAndGet = e.bPw().incrementAndGet();
        x.i("MicroMsg.WebSearch.TopStoryVideoPreloadMgr", "startHttpStream mediaId: %s\n path: %s \n url:%s \n Thread.currentThread().getId(): %d index: %d", new Object[]{str, str2, str3, Long.valueOf(Thread.currentThread().getId()), Long.valueOf(incrementAndGet)});
        b2 = b.NZ(e.b(this.tnX));
        if (!bh.ov(b2)) {
            this.tnX.NR(b2);
        }
    }

    public final void ng(String str) {
        o.TV().b(str, null);
    }

    public final void h(String str, int i, int i2) {
        o.TV();
        f.f(str, i, i2);
    }

    public final boolean isVideoDataAvailable(String str, int i, int i2) {
        return o.TV().isVideoDataAvailable(str, i, i2);
    }

    public final void a(b.a aVar) {
        e.a(this.tnX, aVar);
    }
}
