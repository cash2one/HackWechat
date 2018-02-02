package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.ipcall.a.e.d;

class g$7 implements OnClickListener {
    final /* synthetic */ g nKt;

    g$7(g gVar) {
        this.nKt = gVar;
    }

    public final void onClick(View view) {
        this.nKt.dismiss();
        d.a(1, -1, g.h(this.nKt), g.b(this.nKt, g.h(this.nKt)), 1, -1, 1, g.e(this.nKt), g.f(this.nKt));
    }
}
