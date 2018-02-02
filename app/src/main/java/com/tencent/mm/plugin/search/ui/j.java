package com.tencent.mm.plugin.search.ui;

import android.view.View;
import com.tencent.mm.bc.e;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.plugin.search.ui.c.m;
import com.tencent.mm.sdk.platformtools.af;
import java.util.HashSet;

public final class j extends b implements b {
    private af jzN = new af();
    private boolean qcl;
    private m qdm;

    public j(c cVar, String str, int i) {
        super(cVar);
        this.qdm = new m(cVar.getContext(), this, i);
        this.qdm.mLT = str;
    }

    protected final com.tencent.mm.plugin.fts.d.a.b qf(int i) {
        com.tencent.mm.plugin.fts.d.a.b qf = this.qdm.qf(i);
        if (qf != null) {
            qf.pageType = 3;
        }
        return qf;
    }

    protected final void bpU() {
        this.qcl = false;
        this.qdm.a(this.fDj, this.jzN, new HashSet());
    }

    protected final boolean a(View view, com.tencent.mm.plugin.fts.d.a.b bVar, boolean z) {
        boolean a = this.qdm.a(view, bVar, z);
        if (bVar.mPF && !this.qcl) {
            this.qcl = true;
            e.b(this.fDj, true, this.qdm.aNo(), -2);
        }
        if (a) {
            clearCache();
            vP(this.qdm.qe(0));
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
            e.b(this.fDj, false, this.qdm.aNo(), -2);
        }
    }

    protected final int aNp() {
        return this.qdm.aNo();
    }
}
