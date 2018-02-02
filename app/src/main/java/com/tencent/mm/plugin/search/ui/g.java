package com.tencent.mm.plugin.search.ui;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.widget.AbsListView;
import com.tencent.mm.bc.a;
import com.tencent.mm.bc.e;
import com.tencent.mm.plugin.fts.d.c;
import com.tencent.mm.plugin.fts.d.h;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;

public final class g extends b implements b {
    private int mPx;
    private boolean nXt;
    private af qbw = new af(Looper.getMainLooper());
    private boolean qcl;
    private i qcr;
    private a qcs;
    private boolean qct;
    private af qcu = new 1(this, Looper.getMainLooper());
    private boolean qcv;

    public g(c cVar, int i, int i2) {
        super(cVar);
        this.mPx = i;
        Context context = getContext();
        int i3 = -1;
        switch (i) {
            case -15:
                i3 = 4224;
                break;
            case -13:
                i3 = 4208;
                break;
            case -7:
                i3 = 4192;
                break;
            case -5:
                i3 = 4144;
                break;
            case -4:
                i3 = 4112;
                break;
            case -3:
                i3 = 4128;
                break;
            case -2:
                i3 = 4160;
                break;
            case -1:
                i3 = 4176;
                break;
        }
        x.i("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | uiLogicType=%d", Integer.valueOf(i3), Integer.valueOf(i3));
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(i3));
        this.qcr = (i) h.a(hashSet, context, this, i2).get(0);
        this.qcs = new a();
    }

    protected final com.tencent.mm.plugin.fts.d.a.b qf(int i) {
        com.tencent.mm.plugin.fts.d.a.b qf = this.qcr.qf(i);
        if (qf != null) {
            qf.mPy = i;
            qf.pageType = 2;
        }
        return qf;
    }

    protected final void bpU() {
        this.nXt = true;
        this.qcl = false;
        this.qcs.reset();
        this.qcr.a(this.fDj, this.qbw, new HashSet());
    }

    protected final void clearCache() {
        super.clearCache();
        this.qcr.aaS();
        this.qcr.aNm();
        this.qcu.removeMessages(1);
    }

    protected final boolean a(View view, com.tencent.mm.plugin.fts.d.a.b bVar, boolean z) {
        this.qcr.a(view, bVar, z);
        if (bVar.mPF) {
            x.d("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", Integer.valueOf(bVar.mPx), Integer.valueOf(bVar.mOz), Integer.valueOf(bVar.mPy), Integer.valueOf(bVar.mPz), bVar.mPA, Long.valueOf(bVar.mPB));
            if (!this.qcl) {
                e.b(this.fDj, true, aNp(), bVar.mPx);
                this.qcl = true;
            }
            e.a(bVar, this.qcs);
        } else if (bVar instanceof com.tencent.mm.plugin.search.ui.a.g) {
            this.qcv = true;
            e.a(bVar, this.qcs);
        }
        return false;
    }

    public final void finish() {
        if (!this.qcl) {
            this.qcl = true;
            if (!this.qcv) {
                e.b(this.fDj, false, aNp(), this.mPx);
            }
        }
        this.qcs.reset();
        super.finish();
    }

    public final void a(i iVar, String str) {
        if (str.equals(this.fDj)) {
            this.nXt = false;
        }
        vP(iVar.qe(0));
        notifyDataSetChanged();
        G(getCount(), true);
        this.qcs.hKz = System.currentTimeMillis();
        a aVar = this.qcs;
        for (i.a aVar2 : ((c) iVar).mOA) {
            aVar.hKA = aVar2.mOV.size() + aVar.hKA;
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.qct = true;
            com.tencent.mm.plugin.search.a.c.bpQ().aNr();
            n.qQy.pause();
            x.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is false");
            return;
        }
        this.qct = false;
        if (!com.tencent.mm.plugin.search.a.c.bpQ().aNs()) {
            this.qcu.removeMessages(1);
            this.qcu.sendEmptyMessageDelayed(1, 200);
        }
    }

    protected final int aNp() {
        return this.qcr.aNp();
    }
}
