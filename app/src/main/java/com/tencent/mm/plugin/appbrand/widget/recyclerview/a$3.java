package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.view.View.OnLongClickListener;

class a$3 implements OnLongClickListener {
    final /* synthetic */ t Rd;
    final /* synthetic */ a kgb;
    final /* synthetic */ int kgc;

    a$3(a aVar, t tVar, int i) {
        this.kgb = aVar;
        this.Rd = tVar;
        this.kgc = i;
    }

    public final boolean onLongClick(View view) {
        if (a.c(this.kgb) == null) {
            return false;
        }
        c c = a.c(this.kgb);
        View view2 = this.Rd.VU;
        long j = this.Rd.VW;
        return c.aob();
    }
}
