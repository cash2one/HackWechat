package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.g;

class e$10 implements OnClickListener {
    final /* synthetic */ e srL;

    e$10(e eVar) {
        this.srL = eVar;
    }

    public final void onClick(View view) {
        int i;
        boolean z = false;
        g.pQN.h(11079, new Object[]{Integer.valueOf(4)});
        if (!(e.j(this.srL) || this.srL.spN.get() == null)) {
            e.n(this.srL).getVisibility();
        }
        if (e.n(this.srL).getVisibility() == 0) {
            i = 4;
        } else {
            boolean z2 = false;
        }
        int i2 = i == 0 ? 0 : 8;
        e.n(this.srL).setVisibility(i2);
        e.r(this.srL).setVisibility(i2);
        e.s(this.srL).setVisibility(i2);
        e.b(this.srL).setVisibility(i2);
        e.a(this.srL).setVisibility(i2);
        e eVar = this.srL;
        if (i2 == 0) {
            z = true;
        }
        e.d(eVar, z);
        if (r.iee) {
            e.u(this.srL).setVisibility(i2);
            e.v(this.srL).setVisibility(i2);
            e.w(this.srL).setVisibility(i2);
            e.x(this.srL).setVisibility(i2);
            e.y(this.srL).setVisibility(i2);
            e.z(this.srL).setVisibility(i2);
        }
        if (i == 0) {
            e.o(this.srL);
        }
    }
}
