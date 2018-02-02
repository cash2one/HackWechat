package com.tencent.mm.plugin.radar.ui;

import android.view.View;
import android.view.View.OnClickListener;
import b.c.b.e;

final class a$b implements OnClickListener {
    final /* synthetic */ a pxP;
    final /* synthetic */ int pxQ;

    a$b(a aVar, int i) {
        this.pxP = aVar;
        this.pxQ = i;
    }

    public final void onClick(View view) {
        RadarSpecialGridView$a radarSpecialGridView$a = this.pxP.pxN.pyz;
        if (radarSpecialGridView$a != null) {
            int i = this.pxQ;
            e.h(view, "v");
            radarSpecialGridView$a.g(i, view);
        }
    }
}
