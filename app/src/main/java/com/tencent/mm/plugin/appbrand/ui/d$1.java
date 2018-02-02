package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.c;

class d$1 implements OnClickListener {
    final /* synthetic */ d jLi;

    d$1(d dVar) {
        this.jLi = dVar;
    }

    public final void onClick(View view) {
        c.a(d.a(this.jLi).mAppId, c.c.iqj);
        d.a(this.jLi).finish();
    }
}
