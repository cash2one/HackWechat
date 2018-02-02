package com.tencent.mm.plugin.voip.ui;

import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;

class e$4 implements OnClickListener {
    final /* synthetic */ e srL;

    e$4(e eVar) {
        this.srL = eVar;
    }

    public final void onClick(View view) {
        boolean z;
        e eVar = this.srL;
        if (e.j(this.srL)) {
            z = false;
        } else {
            z = true;
        }
        e.b(eVar, z);
        eVar = this.srL;
        if (e.j(this.srL)) {
            z = false;
        } else {
            z = true;
        }
        Point c = e.c(eVar, z);
        e.k(this.srL).dT(c.x, c.y);
        g.pQN.h(11079, new Object[]{Integer.valueOf(3)});
    }
}
