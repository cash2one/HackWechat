package com.tencent.mm.plugin.voip_cs.b.a;

import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;

class b$5 implements OnClickListener {
    final /* synthetic */ b sxB;

    b$5(b bVar) {
        this.sxB = bVar;
    }

    public final void onClick(View view) {
        b.a(this.sxB, !b.h(this.sxB));
        Point b = b.b(this.sxB, b.h(this.sxB));
        b.i(this.sxB).dT(b.x, b.y);
    }
}
