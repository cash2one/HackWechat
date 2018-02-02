package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.util.Pair;
import android.view.View;
import com.tencent.mm.ad.h;
import com.tencent.mm.ae.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.5;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.z.bs.a;
import com.tencent.mm.z.s;
import java.util.Map;

class LuckyMoneyF2FQRCodeUI$1 implements a {
    final /* synthetic */ LuckyMoneyF2FQRCodeUI oar;

    LuckyMoneyF2FQRCodeUI$1(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        this.oar = luckyMoneyF2FQRCodeUI;
    }

    public final void a(d.a aVar) {
        Map y = bi.y(n.a(aVar.hmq.vGZ), "sysmsg");
        if (y != null) {
            String str = (String) y.get(".sysmsg.sendId");
            final String str2 = (String) y.get(".sysmsg.username");
            final String str3 = (String) y.get(".sysmsg.amount");
            final String str4 = (String) y.get(".sysmsg.receiveId");
            if (bh.getInt((String) y.get(".sysmsg.islucky"), 0) > 0) {
                LuckyMoneyF2FQRCodeUI.a(this.oar, str2);
            }
            if (!bh.G(new String[]{str, str2, str3})) {
                this.oar.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ LuckyMoneyF2FQRCodeUI$1 oau;

                    public final void run() {
                        if (!LuckyMoneyF2FQRCodeUI.a(this.oau.oar).contains(str4)) {
                            LuckyMoneyF2FQRCodeUI.a(this.oau.oar).add(0, str4);
                            if (!s.gE(str2)) {
                                h hVar = new h();
                                hVar.username = str2;
                                com.tencent.mm.ad.n.JQ().a(hVar);
                            }
                            LuckyMoneyF2FQRCodeUI.b(this.oau.oar).put(str4, str2);
                            ShuffleView c = LuckyMoneyF2FQRCodeUI.c(this.oau.oar);
                            if (c.oaK.size() > 0) {
                                if (c.oaP.isStarted()) {
                                    c.oaP.end();
                                }
                                if (c.oaO.isStarted()) {
                                    c.oaO.end();
                                }
                                if (c.oaU != null) {
                                    c.oaS = c.oaU;
                                    c.oaK.remove(c.oaS);
                                    if (c.oaM != null) {
                                        c.oaM.start();
                                    }
                                    c.rZ(c.oaV);
                                    if (c.oaY > 0) {
                                        c.oaV = c.aWY();
                                        c.oaU = (View) c.oaK.get(c.oaV);
                                    } else {
                                        c.oaU = null;
                                        c.oaV = 0;
                                    }
                                } else {
                                    c.rX(c.aWY());
                                    c.oaS = c.oaU;
                                    c.oaP.addListener(new 5(c));
                                }
                            }
                            LuckyMoneyF2FQRCodeUI.d(this.oau.oar).remove(LuckyMoneyF2FQRCodeUI.c(this.oau.oar).oaS);
                            LuckyMoneyF2FQRCodeUI.e(this.oau.oar).J(0, 60000);
                            LuckyMoneyF2FQRCodeUI.f(this.oau.oar).add(new Pair(str2, Integer.valueOf(bh.getInt(str3, 0))));
                        }
                    }
                });
            }
        }
    }
}
