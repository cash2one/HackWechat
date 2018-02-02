package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.a.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceRankInfoUI$12 implements b<j> {
    final /* synthetic */ ExdeviceRankInfoUI lXj;

    ExdeviceRankInfoUI$12(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        this.lXj = exdeviceRankInfoUI;
    }

    public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
        j jVar = (j) kVar;
        x.i("MicroMsg.Sport.ExdeviceRankInfoUI", "onNetSceneEndCallback, errType(%s), errCode(%s), errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.lXj.isFinishing() || ExdeviceRankInfoUI.d(this.lXj)) {
            x.i("MicroMsg.Sport.ExdeviceRankInfoUI", "ExdeviceRankInfoUI has been destroyed.");
            return;
        }
        this.lXj.runOnUiThread(new Runnable(this) {
            final /* synthetic */ ExdeviceRankInfoUI$12 lXk;

            {
                this.lXk = r1;
            }

            public final void run() {
                if (ExdeviceRankInfoUI.e(this.lXk.lXj) != null && ExdeviceRankInfoUI.e(this.lXk.lXj).isShowing()) {
                    ExdeviceRankInfoUI.e(this.lXk.lXj).dismiss();
                    ExdeviceRankInfoUI.f(this.lXk.lXj);
                    x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "dismiss tips dialog.");
                }
            }
        });
        if (i == 0 && i2 == 0) {
            ExdeviceRankInfoUI.a(this.lXj, jVar.lOX);
            ExdeviceRankInfoUI.b(this.lXj, jVar.lOY);
            this.lXj.lPu = jVar.lPu;
            this.lXj.lPt = jVar.lPt;
            ExdeviceRankInfoUI.a(this.lXj, jVar.lPh);
            ExdeviceRankInfoUI.g(this.lXj);
            this.lXj.runOnUiThread(new Runnable(this) {
                final /* synthetic */ ExdeviceRankInfoUI$12 lXk;

                {
                    this.lXk = r1;
                }

                public final void run() {
                    ExdeviceRankInfoUI.h(this.lXk.lXj);
                    if (!bh.ov(ExdeviceRankInfoUI.i(this.lXk.lXj))) {
                        this.lXk.lXj.addIconOptionMenu(0, R.g.bDI, new 1(this));
                    }
                    if (ExdeviceRankInfoUI.k(this.lXk.lXj) != null) {
                        ExdeviceRankInfoUI.k(this.lXk.lXj).zq(ExdeviceRankInfoUI.l(this.lXk.lXj));
                    }
                }
            });
        } else if (ExdeviceRankInfoUI.a(this.lXj) == null || ExdeviceRankInfoUI.a(this.lXj).size() == 0) {
            this.lXj.runOnUiThread(new 2(this));
        }
    }
}
