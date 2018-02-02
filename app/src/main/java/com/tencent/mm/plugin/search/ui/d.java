package com.tencent.mm.plugin.search.ui;

import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c.e;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.q;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

public final class d extends b implements k {
    private af jzN = new af();
    private h mLO;
    private String mLS;
    private a mMa;
    private q qcf;

    public d(c cVar, String str) {
        super(cVar);
        this.mLS = str;
        if (s.eV(str)) {
            ar.Hg();
            this.qcf = c.Fh().hD(str);
        }
    }

    protected final b qf(int i) {
        b cVar = new com.tencent.mm.plugin.search.ui.a.c(i);
        cVar.iVU = (j) this.mLO.mMc.get(i);
        cVar.mMb = this.mLO.mMb;
        cVar.mPx = -14;
        cVar.qcf = this.qcf;
        cVar.mPy = i;
        cVar.pageType = 6;
        if (cVar.position == getCount() - 1) {
            cVar.mPw = true;
        }
        return cVar;
    }

    protected final void bpU() {
        clearCache();
        if (this.mMa != null) {
            ((m) g.k(m.class)).cancelSearchTask(this.mMa);
        }
        com.tencent.mm.plugin.fts.a.a.g gVar = new com.tencent.mm.plugin.fts.a.a.g();
        gVar.fDj = this.fDj;
        gVar.mLS = this.mLS;
        gVar.mLY = e.mMC;
        gVar.mLZ = this;
        gVar.handler = this.jzN;
        gVar.mLR = 3;
        this.mMa = ((m) g.k(m.class)).search(3, gVar);
        x.i("MicroMSsg.FTS.FTSChattingConvAdapter", "do search %s", this.fDj);
    }

    public final void b(h hVar) {
        switch (hVar.bjW) {
            case -3:
            case -2:
            case -1:
                vP(0);
                notifyDataSetChanged();
                G(getCount(), true);
                return;
            case 0:
                this.mLO = hVar;
                vP(hVar.mMc.size());
                notifyDataSetChanged();
                G(getCount(), true);
                return;
            default:
                return;
        }
    }

    public final void finish() {
        super.finish();
        if (this.mMa != null) {
            ((m) g.k(m.class)).cancelSearchTask(this.mMa);
        }
    }

    protected final boolean a(View view, b bVar, boolean z) {
        return false;
    }
}
