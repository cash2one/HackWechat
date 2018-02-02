package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;

class g$3 implements OnClickListener {
    final /* synthetic */ g nKt;

    g$3(g gVar) {
        this.nKt = gVar;
    }

    public final void onClick(View view) {
        if (view == g.b(this.nKt)) {
            g.a(this.nKt, 1);
        } else if (view == g.c(this.nKt)) {
            g.a(this.nKt, 2);
        } else if (view == g.d(this.nKt)) {
            g.a(this.nKt, 3);
        }
    }
}
