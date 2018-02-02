package com.tencent.mm.plugin.search.ui;

import com.tencent.mm.plugin.fts.d.i;

class i$a implements Runnable {
    private String fDj;
    final /* synthetic */ i qcO;
    private i qcP;

    i$a(i iVar, i iVar2, String str) {
        this.qcO = iVar;
        this.fDj = str;
        this.qcP = iVar2;
    }

    public final void run() {
        if (!i.a(this.qcO) && ((i) i.b(this.qcO).get(i.b(this.qcO).size() - 1)).getType() == this.qcP.getType()) {
            i.c(this.qcO);
        }
        int i = 0;
        for (i qe : i.b(this.qcO)) {
            i = qe.qe(i);
        }
        this.qcO.vP(i);
        this.qcO.notifyDataSetChanged();
        this.qcO.G(i, i.d(this.qcO));
        if (i.d(this.qcO)) {
            i.e(this.qcO).hKz = System.currentTimeMillis();
        }
    }
}
