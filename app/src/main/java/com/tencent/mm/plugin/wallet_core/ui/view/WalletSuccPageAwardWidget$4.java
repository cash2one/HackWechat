package com.tencent.mm.plugin.wallet_core.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class WalletSuccPageAwardWidget$4 implements OnClickListener {
    final /* synthetic */ WalletSuccPageAwardWidget sYo;

    WalletSuccPageAwardWidget$4(WalletSuccPageAwardWidget walletSuccPageAwardWidget) {
        this.sYo = walletSuccPageAwardWidget;
    }

    public final void onClick(View view) {
        int i = 2;
        if (WalletSuccPageAwardWidget.a(this.sYo) != null && WalletSuccPageAwardWidget.a(this.sYo).wbv != null) {
            WalletSuccPageAwardWidget.a(this.sYo, WalletSuccPageAwardWidget.a(this.sYo).wbv);
            x.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, type: %s", new Object[]{Integer.valueOf(WalletSuccPageAwardWidget.h(this.sYo).Avd)});
            if (WalletSuccPageAwardWidget.h(this.sYo).Avd == 1) {
                x.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", new Object[]{Integer.valueOf(WalletSuccPageAwardWidget.h(this.sYo).Avd), WalletSuccPageAwardWidget.h(this.sYo).url});
                e.l(WalletSuccPageAwardWidget.i(this.sYo), WalletSuccPageAwardWidget.h(this.sYo).url, false);
                WalletSuccPageAwardWidget.j(this.sYo);
                WalletSuccPageAwardWidget.k(this.sYo);
            } else if (WalletSuccPageAwardWidget.h(this.sYo).Avd == 2) {
                d.a.a.e eVar = WalletSuccPageAwardWidget.h(this.sYo).Ave;
                if (eVar != null) {
                    x.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, jump tiny app, userName: %s, path: %s, version: %s", new Object[]{eVar.wDr, eVar.wDs, Integer.valueOf(eVar.wDt)});
                    b qpVar = new qp();
                    qpVar.fIi.userName = eVar.wDr;
                    qpVar.fIi.fIk = bh.az(eVar.wDs, "");
                    qpVar.fIi.scene = 1060;
                    qpVar.fIi.fnp = WalletSuccPageAwardWidget.l(this.sYo);
                    qpVar.fIi.fIl = 0;
                    if (eVar.wDt > 0) {
                        qpVar.fIi.fIm = eVar.wDt;
                    }
                    qpVar.fIi.context = WalletSuccPageAwardWidget.i(this.sYo);
                    a.xef.m(qpVar);
                    WalletSuccPageAwardWidget.j(this.sYo);
                }
                WalletSuccPageAwardWidget.k(this.sYo);
            } else if (WalletSuccPageAwardWidget.h(this.sYo).Avd == 3) {
                x.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do get lottery");
                WalletSuccPageAwardWidget.m(this.sYo);
                WalletSuccPageAwardWidget.k(this.sYo);
            } else if (WalletSuccPageAwardWidget.h(this.sYo).Avd == 5) {
                x.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do nothing");
            } else if (WalletSuccPageAwardWidget.h(this.sYo).Avd == 6) {
                x.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, show layer");
                WalletSuccPageAwardWidget.bNf();
                WalletSuccPageAwardWidget.k(this.sYo);
            } else if (WalletSuccPageAwardWidget.h(this.sYo).Avd == 7) {
                x.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, draw lottery");
                WalletSuccPageAwardWidget.a(this.sYo, 3, true);
                WalletSuccPageAwardWidget.k(this.sYo);
            } else if (WalletSuccPageAwardWidget.h(this.sYo).Avd == 8) {
                WalletSuccPageAwardWidget.m(this.sYo);
                x.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", new Object[]{Integer.valueOf(WalletSuccPageAwardWidget.h(this.sYo).Avd), WalletSuccPageAwardWidget.h(this.sYo).url});
                WalletSuccPageAwardWidget.k(this.sYo);
            } else if (WalletSuccPageAwardWidget.h(this.sYo).Avd == 9) {
                WalletSuccPageAwardWidget.m(this.sYo);
                WalletSuccPageAwardWidget.k(this.sYo);
            }
            g gVar = g.pQN;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(2);
            if (!WalletSuccPageAwardWidget.n(this.sYo)) {
                i = 1;
            }
            objArr[1] = Integer.valueOf(i);
            gVar.h(15225, objArr);
        }
    }
}
