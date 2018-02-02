package com.tencent.mm.sandbox.updater;

import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class AppUpdaterUI$1 implements g {
    final /* synthetic */ AppUpdaterUI xcq;

    AppUpdaterUI$1(AppUpdaterUI appUpdaterUI) {
        this.xcq = appUpdaterUI;
    }

    public final void cj(int i, int i2) {
        int i3 = (int) (i <= 0 ? 0 : (((long) i2) * 100) / ((long) i));
        if (i3 == 100) {
            AppUpdaterUI.a(this.xcq).setText(this.xcq.getString(R.l.eRZ));
        } else {
            AppUpdaterUI.a(this.xcq).setText(this.xcq.getString(R.l.eRX) + i3 + "%");
        }
    }

    public final void cem() {
        x.e("MicroMsg.AppUpdaterUI", "no sdcard.");
        if (AppUpdaterUI.b(this.xcq) != null) {
            AppUpdaterUI.b(this.xcq).dismiss();
        }
        if (!this.xcq.isFinishing()) {
            AppUpdaterUI.c(this.xcq);
        }
    }

    public final void cen() {
        if (AppUpdaterUI.b(this.xcq) != null) {
            AppUpdaterUI.b(this.xcq).dismiss();
        }
        if (!this.xcq.isFinishing()) {
            AppUpdaterUI.d(this.xcq);
        }
    }

    public final void bxc() {
        if (!this.xcq.isFinishing()) {
            AppUpdaterUI.a(this.xcq).setText(R.l.eRX);
            AppUpdaterUI.a(this.xcq).setEnabled(false);
        }
    }

    public final void KY(String str) {
        if (AppUpdaterUI.b(this.xcq) != null) {
            AppUpdaterUI.b(this.xcq).dismiss();
        }
        if (!this.xcq.isFinishing()) {
            x.d("MicroMsg.AppUpdaterUI", str);
            if (str != null) {
                AppUpdaterUI.a(this.xcq, str);
                AppUpdaterUI.a(this.xcq).setEnabled(false);
            }
        }
    }

    public final void a(c cVar) {
        if (!this.xcq.isFinishing()) {
            if (cVar instanceof c) {
                g.pQN.a(405, 67, 1, true);
                x.e("MicroMsg.AppUpdaterUI", "download package from cdn error. switch to webserver");
                if (AppUpdaterUI.b(this.xcq) != null) {
                    AppUpdaterUI.b(this.xcq).setMessage(this.xcq.getString(R.l.ejr, new Object[]{AppUpdaterUI.e(this.xcq).desc, this.xcq.getString(R.l.eRU), bh.bx((long) AppUpdaterUI.e(this.xcq).size)}));
                }
                if (AppUpdaterUI.e(this.xcq).xdz) {
                    g.pQN.a(405, 68, 1, true);
                    AppUpdaterUI.a(this.xcq, cVar);
                    return;
                }
                return;
            }
            g.pQN.a(405, 69, 1, true);
            h.a(this.xcq, R.l.eRV, R.l.dGO, new 1(this), new 2(this));
        }
    }
}
