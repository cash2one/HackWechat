package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.R;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;

class i$1 implements c {
    final /* synthetic */ i nYD;

    i$1(i iVar) {
        this.nYD = iVar;
    }

    public final void a(n nVar) {
        nVar.a(1, this.nYD.getString(R.l.dGF), 0);
        if (this.nYD.type == 1) {
            nVar.a(3, this.nYD.getString(R.l.eAd), 0);
        } else if (this.nYD.type == 2 && this.nYD.activity.getIntent().getBooleanExtra("kFavCanDel", true)) {
            nVar.a(5, this.nYD.getString(R.l.eeY), 0);
            nVar.a(4, this.nYD.getString(R.l.dEw), 0);
        }
        b dhVar = new dh();
        dhVar.frQ.fqm = this.nYD.fqm;
        a.xef.m(dhVar);
        if (dhVar.frR.frp || g.m(ac.getContext(), 4)) {
            nVar.a(6, this.nYD.getString(R.l.dZe), 0);
        }
    }
}
