package com.tencent.mm.plugin.gallery.model;

import com.tencent.mm.plugin.gallery.model.g.a;
import com.tencent.mm.plugin.gallery.model.g.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;

public final class l {
    private int jmN = 3;
    HashSet<a> mRu = new HashSet();
    public HashSet<b> mRv = new HashSet();
    g mRw;
    public int mRx = 1;

    public final void qo(int i) {
        this.mRx = i;
        aOg();
    }

    private void aOg() {
        x.i("MicroMsg.MediaQueryService", "initQueryType: %d", new Object[]{Integer.valueOf(this.mRx)});
        switch (this.mRx) {
            case 1:
                this.mRw = new i();
                return;
            case 2:
                this.mRw = new n();
                return;
            case 3:
                this.mRw = new h();
                return;
            default:
                this.mRw = new i();
                return;
        }
    }

    public final void qp(int i) {
        x.i("MicroMsg.MediaQueryService", "setQuerySource, %d, %s", new Object[]{Integer.valueOf(i), bh.cgy()});
        this.jmN = i;
    }

    public final int aOh() {
        x.i("MicroMsg.MediaQueryService", "getQuerySource, %d, %s", new Object[]{Integer.valueOf(this.jmN), bh.cgy()});
        return this.jmN;
    }

    public final int aOi() {
        x.i("MicroMsg.MediaQueryService", "getQueryType, %d, %s", new Object[]{Integer.valueOf(this.mRx), bh.cgy()});
        return this.mRx;
    }

    public final void a(a aVar) {
        this.mRu.add(aVar);
    }

    public final void b(a aVar) {
        this.mRu.remove(aVar);
    }

    public final void aOj() {
        if (this.mRw == null) {
            x.f("MicroMsg.MediaQueryService", "media query not init, init again");
            aOg();
        }
        c.aNF().x(new 1(this));
    }

    public final void d(String str, int i, long j) {
        if (this.mRw == null) {
            x.f("MicroMsg.MediaQueryService", "media query not init, init again");
            aOg();
        }
        c.aNF().aNS().removeCallbacksAndMessages(null);
        this.mRw.aNZ();
        e aNF = c.aNF();
        aNF.aNS().post(new 2(this, str, i, j));
    }
}
