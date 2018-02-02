package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.appusage.j.b;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class a$14 implements a {
    final /* synthetic */ a jPj;

    a$14(a aVar) {
        this.jPj = aVar;
    }

    public final void a(String str, l lVar) {
        try {
            if (lVar.obj != null && (lVar.obj instanceof Long)) {
                ArrayList abd;
                long j = a.h(this.jPj).get();
                x.d("MicroMsg.AppBrandLauncherRecentsList", "onPagingDataBack ticket %d, mInitFetchTicket %d, mPagingFetchTicket %d", new Object[]{(Long) lVar.obj, Long.valueOf(j), Long.valueOf(a.i(this.jPj).get())});
                if (lVar.obj.equals(Long.valueOf(j))) {
                    abd = f.Zm().iKb.abd();
                } else {
                    abd = f.Zm().iKb.e(a.j(this.jPj).get(), 30);
                }
                if (!bh.cA(abd)) {
                    a.j(this.jPj).set(((i) abd.get(abd.size() - 1)).gLl);
                }
                abd = a.k(this.jPj).k(abd);
                if (lVar.obj.equals(Long.valueOf(j))) {
                    this.jPj.runOnUiThread(new 1(this, a.l(this.jPj) ? f.Zn().jF(b.iJT) : null, abd));
                } else if (lVar.obj.equals(Long.valueOf(r4))) {
                    this.jPj.runOnUiThread(new 2(this, abd));
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandLauncherRecentsList", "onPagingDataBack e %s", new Object[]{e});
        }
    }
}
