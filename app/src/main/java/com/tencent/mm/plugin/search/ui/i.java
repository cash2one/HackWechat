package com.tencent.mm.plugin.search.ui;

import android.os.Looper;
import android.view.View;
import android.widget.AbsListView;
import com.tencent.mm.bc.f;
import com.tencent.mm.g.a.pf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.map.e;
import com.tencent.mm.plugin.fts.d.h;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import com.tencent.mm.z.q;
import com.tencent.wcdb.FileUtils;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.R$styleable;

public final class i extends b implements b {
    int qbL = 1;
    private af qbw = new af(Looper.getMainLooper());
    private List<com.tencent.mm.plugin.fts.d.i> qcD;
    private f qcE = new f();
    private b qcF = null;
    private long qcG;
    private long qcH;
    private long qcI;
    private long qcJ;
    private af qcK = new 1(this, Looper.getMainLooper());
    private int qcL = -1;
    boolean qcM;
    private boolean qcN;
    private boolean qcl;
    private boolean qct;
    boolean qcv;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public i(c cVar, int i, b bVar) {
        int i2 = 1;
        super(cVar);
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(16));
        hashSet.add(Integer.valueOf(32));
        hashSet.add(Integer.valueOf(48));
        hashSet.add(Integer.valueOf(64));
        hashSet.add(Integer.valueOf(80));
        hashSet.add(Integer.valueOf(FileUtils.S_IWUSR));
        hashSet.add(Integer.valueOf(96));
        hashSet.add(Integer.valueOf(MMGIFException.D_GIF_ERR_IMAGE_DEFECT));
        if (g.Dh().Cy()) {
            com.tencent.mm.sdk.b.b pfVar = new pf();
            a.xef.m(pfVar);
            c fn = com.tencent.mm.z.c.c.IF().fn("100193");
            if (fn.isValid()) {
                if ("1".equals(fn.chI().get("isOpenLocalSearch"))) {
                }
            }
        }
        i2 = 0;
        if (i2 != 0) {
            hashSet.add(Integer.valueOf(e.CTRL_INDEX));
        }
        if (com.tencent.mm.modelappbrand.a.IT()) {
            hashSet.add(Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX));
        }
        this.qcD = h.a(hashSet, getContext(), this, i);
        this.qcF = bVar;
    }

    protected final com.tencent.mm.plugin.fts.d.a.b qf(int i) {
        com.tencent.mm.plugin.fts.d.a.b bVar = null;
        for (com.tencent.mm.plugin.fts.d.i qf : this.qcD) {
            bVar = qf.qf(i);
            if (bVar != null) {
                break;
            }
        }
        com.tencent.mm.plugin.fts.d.a.b bVar2 = bVar;
        if (bVar2 != null) {
            int i2;
            LinkedList linkedList = new LinkedList();
            for (com.tencent.mm.plugin.fts.d.i qf2 : this.qcD) {
                linkedList.addAll(qf2.aNn());
            }
            for (int size = linkedList.size() - 1; size >= 0; size--) {
                if (i > ((Integer) linkedList.get(size)).intValue()) {
                    i2 = i - size;
                    break;
                }
            }
            i2 = i;
            bVar2.mPy = i2;
            bVar2.pageType = 1;
        }
        if (bVar2 == null) {
            x.e("MicroMsg.FTS.FTSMainAdapter", "Create Data Item Error: getCount-%d position-%d", new Object[]{Integer.valueOf(getCount()), Integer.valueOf(i)});
        }
        return bVar2;
    }

    protected final void bpU() {
        this.qcl = false;
        this.qcv = false;
        this.qcL = -1;
        this.qcM = false;
        this.qcE.reset();
        this.qbL = 1;
        this.qcG = 0;
        this.qcH = 0;
        this.qcI = 0;
        this.qcJ = 0;
        HashSet hashSet = new HashSet();
        hashSet.add("filehelper");
        boolean Gz = q.Gz();
        if (!Gz) {
            Gz = bh.getInt(com.tencent.mm.k.g.zY().getValue("BindQQSwitch"), 1) == 1;
        }
        if (!Gz) {
            x.i("MicroMsg.FTS.FTSMainAdapter", "summerqq BindQQSwitch off");
            hashSet.add("22");
            hashSet.add("23");
        }
        if (!com.tencent.mm.modelappbrand.a.IT()) {
            hashSet.add("61");
        }
        x.d("MicroMsg.FTS.FTSMainAdapter", "summerqq doSearch blockSet[%d]", new Object[]{Integer.valueOf(hashSet.size())});
        d(hashSet);
    }

    public final void finish() {
        if (!this.qcl) {
            this.qcl = true;
            if (!this.qcv) {
                com.tencent.mm.bc.e.a(this.fDj, false, aNp(), 0, this.qcE);
            }
        }
        if (!(this.qcv || this.qcN)) {
            com.tencent.mm.bc.g.d(this.fDj, this.qbL, 3, 3);
        }
        this.qcE.reset();
        super.finish();
    }

    protected final void clearCache() {
        super.clearCache();
        for (com.tencent.mm.plugin.fts.d.i iVar : this.qcD) {
            iVar.aNm();
            iVar.aaS();
        }
    }

    public final void stopSearch() {
        this.qcK.removeMessages(1);
        super.stopSearch();
    }

    protected final boolean a(View view, com.tencent.mm.plugin.fts.d.a.b bVar, boolean z) {
        for (com.tencent.mm.plugin.fts.d.i a : this.qcD) {
            z = a.a(view, bVar, z);
            if (z) {
                break;
            }
        }
        if (bVar.mPF) {
            this.qcN = true;
            x.d("MicroMsg.FTS.FTSMainAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", new Object[]{Integer.valueOf(bVar.mPx), Integer.valueOf(bVar.mOz), Integer.valueOf(bVar.mPy), Integer.valueOf(bVar.mPz), bVar.mPA, Long.valueOf(bVar.mPB)});
            if (!this.qcl) {
                com.tencent.mm.bc.e.a(this.fDj, true, aNp(), 0, this.qcE);
                this.qcl = true;
            }
            if (!bh.ov(this.fDj)) {
                com.tencent.mm.bc.g.d(this.fDj, this.qbL, 1, 3);
            }
            com.tencent.mm.bc.e.a(bVar, this.qcE);
            return true;
        }
        if (bVar instanceof com.tencent.mm.plugin.search.ui.a.g) {
            this.qcv = true;
            if (!bh.ov(this.fDj)) {
                com.tencent.mm.bc.g.d(this.fDj, this.qbL, 1, 3);
            }
            com.tencent.mm.bc.e.a(bVar, this.qcE);
        }
        return false;
    }

    public final void a(com.tencent.mm.plugin.fts.d.i iVar, String str) {
        com.tencent.mm.plugin.fts.d.c cVar = (com.tencent.mm.plugin.fts.d.c) iVar;
        if (str.equals(this.fDj)) {
            d(cVar.mLX);
        }
        if (cVar.aNo() > 0 && this.qcG == 0) {
            this.qcG = System.currentTimeMillis() - this.qbV;
            com.tencent.mm.bc.e.n(9, this.qcG);
            x.i("MicroMsg.FTS.FTSMainAdapter", "firstItemTime=%d", new Object[]{Long.valueOf(this.qcG)});
        }
        switch (cVar.getType()) {
            case 16:
                if (this.qcH == 0) {
                    this.qcH = System.currentTimeMillis() - this.qbV;
                    x.i("MicroMsg.FTS.FTSMainAdapter", "firstGetTopHitsTime=%d", new Object[]{Long.valueOf(this.qcH)});
                    com.tencent.mm.bc.e.n(0, this.qcH);
                    break;
                }
                break;
            case 32:
                if (this.qcI == 0) {
                    this.qcI = System.currentTimeMillis() - this.qbV;
                    x.i("MicroMsg.FTS.FTSMainAdapter", "firstGetContactTime=%d", new Object[]{Long.valueOf(this.qcI)});
                    com.tencent.mm.bc.e.n(3, this.qcI);
                    break;
                }
                break;
            case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (this.qcJ == 0) {
                    this.qcJ = System.currentTimeMillis() - this.qbV;
                    x.i("MicroMsg.FTS.FTSMainAdapter", "firstGetChatroomTime=%d", new Object[]{Long.valueOf(this.qcJ)});
                    com.tencent.mm.bc.e.n(6, this.qcJ);
                    break;
                }
                break;
        }
        f fVar = this.qcE;
        for (com.tencent.mm.plugin.fts.d.i.a aVar : cVar.mOA) {
            switch (aVar.hKY) {
                case -15:
                    fVar.hKO = aVar.mOV.size();
                    break;
                case -11:
                    fVar.hKP = aVar.mOV.size();
                    break;
                case -8:
                    fVar.hKG = aVar.mOV.size();
                    break;
                case -7:
                    fVar.hKJ = aVar.mOV.size();
                    break;
                case -6:
                    fVar.hKL = aVar.mOV.size();
                    break;
                case -5:
                    fVar.hKN = aVar.mOV.size();
                    break;
                case -4:
                    fVar.hKH = aVar.mOV.size();
                    break;
                case -3:
                    fVar.hKI = aVar.mOV.size();
                    break;
                case -2:
                    fVar.hKK = aVar.mOV.size();
                    break;
                case -1:
                    fVar.hKM = aVar.mOV.size();
                    break;
                default:
                    break;
            }
        }
        new a(this, iVar, str).run();
    }

    private void d(HashSet<String> hashSet) {
        this.qcL++;
        if (this.qcL < this.qcD.size()) {
            ((com.tencent.mm.plugin.fts.d.i) this.qcD.get(this.qcL)).a(this.fDj, this.qbw, hashSet);
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
        if (absListView.getLastVisiblePosition() == getCount() && this.qcM) {
            this.qbL = 2;
            if (this.qcF != null) {
                this.qcF.bqk();
            }
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.qct = true;
            h.aNx().aNr();
            n.qQy.pause();
            return;
        }
        this.qct = false;
        if (!h.aNx().aNs()) {
            this.qcK.removeMessages(1);
            this.qcK.sendEmptyMessageDelayed(1, 200);
        }
    }

    protected final int aNp() {
        int i = 0;
        for (com.tencent.mm.plugin.fts.d.i aNp : this.qcD) {
            i = aNp.aNp() + i;
        }
        return i;
    }
}
