package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.c;

class g$2 implements OnClickListener {
    final /* synthetic */ g jMY;

    g$2(g gVar) {
        this.jMY = gVar;
    }

    public final void onClick(View view) {
        c.a(g.b(this.jMY).mAppId, c.c.iqj);
        g.b(this.jMY).finish();
    }
}
