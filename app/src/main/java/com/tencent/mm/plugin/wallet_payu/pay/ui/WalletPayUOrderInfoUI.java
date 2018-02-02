package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.b.a;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI;
import com.tencent.mm.plugin.wallet_payu.a.d;
import com.tencent.mm.plugin.wallet_payu.pay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.q;
import java.util.ArrayList;

public class WalletPayUOrderInfoUI extends WalletOrderInfoOldUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ji(1554);
    }

    protected final void bMG() {
        l(new a());
    }

    protected final void No(String str) {
        l(new c(str, 1));
    }

    public void onDestroy() {
        jj(1554);
        super.onDestroy();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a) {
            return true;
        }
        if (kVar instanceof c) {
            c cVar = (c) kVar;
            if (cVar.pPl.sNW == null || cVar.pPl.sNW.size() <= 0) {
                x.w("MicroMsg.WalletPayUOrderInfoUI", "hy: no commodity. show alert");
                h.a(this, i.uVe, i.dGO, new 1(this));
            } else {
                Commodity commodity = (Commodity) cVar.pPl.sNW.get(0);
                x.d("MicroMsg.WalletPayUOrderInfoUI", "Coomdity:" + commodity);
                d.bNt().tcu = null;
                if (commodity != null) {
                    this.sTV = new ArrayList();
                    this.sTV.add(commodity);
                    g.Dk();
                    com.tencent.mm.l.a WO = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WO(commodity.paA);
                    if (WO == null || ((int) WO.gJd) == 0) {
                        ak.a.hfL.a(commodity.paA, "", this.sUI);
                    } else {
                        K(WO);
                    }
                    this.sUB.notifyDataSetChanged();
                    bMH();
                }
            }
        }
        return super.d(i, i2, str, kVar);
    }

    public final void done() {
        bMu();
        Bundle bundle = new Bundle();
        bundle.putInt("intent_pay_end_errcode", this.vf.getInt("intent_pay_end_errcode"));
        bundle.putString("intent_pay_app_url", this.vf.getString("intent_pay_app_url"));
        bundle.putBoolean("intent_pay_end", this.vf.getBoolean("intent_pay_end"));
        x.i("MicroMsg.WalletPayUOrderInfoUI", "pay done...feedbackData errCode:" + this.vf.getInt("intent_pay_end_errcode"));
        for (String str : this.sTU) {
            String str2;
            if (!bh.ov(str2)) {
                x.d("MicroMsg.WalletPayUOrderInfoUI", "hy: doing netscene subscribe...appName: %s", new Object[]{str2});
                b(new com.tencent.mm.wallet_core.c.i(str2), false);
            }
        }
        com.tencent.mm.wallet_core.a.j(this, bundle);
        if (this.sEs != null && !bh.ov(this.sEs.lOX)) {
            str2 = this.sEs.sNW.size() > 0 ? ((Commodity) this.sEs.sNW.get(0)).fuI : "";
            str2 = String.format("%sreqkey=%s&transid=%s", new Object[]{this.sEs.lOX, this.sEs.fuH, str2});
            x.d("MicroMsg.WalletPayUOrderInfoUI", "url = " + str2);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            intent.putExtra("showShare", false);
            intent.putExtra("geta8key_username", q.FS());
            com.tencent.mm.bm.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }
}
