package com.tencent.mm.plugin.search.ui;

import android.view.View;
import com.tencent.mm.bc.e;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.plugin.search.ui.c.g;
import com.tencent.mm.sdk.platformtools.af;
import java.util.HashSet;

public final class f extends b implements b {
    private af jzN = new af();
    private boolean qcl;
    private g qco;

    public f(c cVar, String str, String str2, String str3, int i, int i2) {
        super(cVar);
        this.qco = new g(cVar.getContext(), this, i);
        this.qco.mLT = str2;
        this.qco.talker = str;
        this.qco.mLS = str3;
        this.qco.showType = i2;
    }

    protected final com.tencent.mm.plugin.fts.d.a.b qf(int i) {
        com.tencent.mm.plugin.fts.d.a.b qf = this.qco.qf(i);
        if (qf != null) {
            qf.pageType = 5;
        }
        return qf;
    }

    protected final void bpU() {
        this.qcl = false;
        this.qco.a(this.fDj, this.jzN, new HashSet());
    }

    protected final boolean a(View view, com.tencent.mm.plugin.fts.d.a.b bVar, boolean z) {
        boolean a = this.qco.a(view, bVar, z);
        if (bVar.mPF && !this.qcl) {
            this.qcl = true;
            e.b(this.fDj, true, this.qco.aNo(), -2);
        }
        if (a) {
            clearCache();
            vP(this.qco.qe(0));
            notifyDataSetChanged();
            G(getCount(), true);
        }
        return a;
    }

    public final void a(i iVar, String str) {
        vP(iVar.qe(0));
        notifyDataSetChanged();
        G(getCount(), true);
    }

    public final void finish() {
        super.finish();
        if (!this.qcl) {
            this.qcl = true;
            e.b(this.fDj, false, this.qco.aNo(), -2);
        }
    }

    protected final int aNp() {
        return this.qco.aNo();
    }
}
