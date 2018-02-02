package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.view.View.OnClickListener;

class a$2 implements OnClickListener {
    final /* synthetic */ t Rd;
    final /* synthetic */ a kgb;
    final /* synthetic */ int kgc;

    a$2(a aVar, t tVar, int i) {
        this.kgb = aVar;
        this.Rd = tVar;
        this.kgc = i;
    }

    public final void onClick(View view) {
        if (a.b(this.kgb) != null) {
            b b = a.b(this.kgb);
            View view2 = this.Rd.VU;
            int i = this.kgc;
            long j = this.Rd.VW;
            b.mv(i);
        }
    }
}
