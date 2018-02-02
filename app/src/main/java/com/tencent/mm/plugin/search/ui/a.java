package com.tencent.mm.plugin.search.ui;

import android.os.Looper;
import android.view.View;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.sdk.platformtools.af;
import java.util.HashSet;

public final class a extends b implements b {
    private com.tencent.mm.plugin.search.ui.c.a qbu;
    protected boolean qbv;
    private af qbw = new af(Looper.getMainLooper());

    public a(c cVar) {
        super(cVar);
        this.qbu = new com.tencent.mm.plugin.search.ui.c.a(cVar.getContext(), this, 0);
    }

    protected final com.tencent.mm.plugin.fts.d.a.b qf(int i) {
        return this.qbu.qf(i);
    }

    protected final void bpU() {
        this.qbv = false;
        this.qbu.a(this.fDj, this.qbw, new HashSet());
    }

    protected final boolean a(View view, com.tencent.mm.plugin.fts.d.a.b bVar, boolean z) {
        return false;
    }

    public final void a(i iVar, String str) {
        int qe = this.qbu.qe(0);
        vP(qe);
        notifyDataSetChanged();
        G(qe, true);
    }

    protected final int aNp() {
        return this.qbu.aNo();
    }
}
