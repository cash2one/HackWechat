package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.R;
import com.tencent.mm.k.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;

class ExdeviceRankInfoUI$19 implements c {
    final /* synthetic */ ExdeviceRankInfoUI lXj;

    ExdeviceRankInfoUI$19(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        this.lXj = exdeviceRankInfoUI;
    }

    public final void a(n nVar) {
        int i;
        if (x.getLogLevel() == 0) {
            i = 2;
        } else {
            i = g.zY().getInt("WeRunLaunchGroupRankWeAppSwitch", 0);
        }
        if (i == 2) {
            nVar.a(3, this.lXj.getString(R.l.edr), R.k.dwQ);
        }
        nVar.a(0, this.lXj.getString(R.l.edq), R.k.dwQ);
        nVar.a(1, this.lXj.getString(R.l.eds), R.k.dwF);
        nVar.a(2, this.lXj.getString(R.l.edp), R.k.dwv);
    }
}
