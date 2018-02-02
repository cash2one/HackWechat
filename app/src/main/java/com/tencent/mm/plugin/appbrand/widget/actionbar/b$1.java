package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnClickListener;

class b$1 implements OnClickListener {
    final /* synthetic */ b jVS;

    b$1(b bVar) {
        this.jVS = bVar;
    }

    public final void onClick(View view) {
        if (b.a(this.jVS) != null) {
            b.a(this.jVS).onClick(b.b(this.jVS));
        } else if (b.c(this.jVS) != null) {
            b.c(this.jVS).onClick(b.b(this.jVS));
        }
    }
}
