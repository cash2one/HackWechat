package com.tencent.mm.plugin.wallet.pay;

import android.os.Parcelable;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet.pay.a.e.b;
import com.tencent.mm.plugin.wallet.pay.a.e.c;
import com.tencent.mm.plugin.wallet.pay.a.e.d;
import com.tencent.mm.plugin.wallet.pay.a.e.e;
import com.tencent.mm.plugin.wallet.pay.a.e.f;
import com.tencent.mm.plugin.wallet.pay.b.a;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class b$15 extends a {
    final /* synthetic */ b sEl;

    b$15(b bVar, WalletBaseUI walletBaseUI, g gVar) {
        this.sEl = bVar;
        super(bVar, walletBaseUI, gVar);
    }

    public final /* synthetic */ CharSequence um(int i) {
        return this.zHU.getString(i.uWO);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (super.d(i, i2, str, kVar)) {
            return true;
        }
        if (!(kVar instanceof f) || i != 0 || i2 != 0) {
            return false;
        }
        f fVar = (f) kVar;
        if (fVar.sFA) {
            b.o(this.sEl).putParcelable("key_orders", fVar.sEs);
        }
        Parcelable parcelable = fVar.oWt;
        if (parcelable != null) {
            b.p(this.sEl).putParcelable("key_realname_guide_helper", parcelable);
        }
        this.sEl.a(this.zHU, 0, b.q(this.sEl));
        return true;
    }

    public final boolean k(Object... objArr) {
        k kVar;
        p pVar = (p) objArr[0];
        Orders orders = (Orders) b.r(this.sEl).getParcelable("key_orders");
        if (pVar == null || orders == null) {
            x.e("MicroMsg.CgiManager", "empty verify or orders");
            kVar = null;
        } else {
            PayInfo payInfo = pVar.pCn;
            String str = "";
            if (payInfo != null) {
                x.i("MicroMsg.CgiManager", "get reqKey from payInfo");
                str = payInfo.fuH;
            }
            if (bh.ov(str)) {
                x.i("MicroMsg.CgiManager", "get reqKey from orders");
                str = orders.fuH;
            }
            if (bh.ov(str)) {
                x.i("MicroMsg.CgiManager", "empty reqKey!");
                kVar = new f(pVar, orders);
            } else {
                if (payInfo != null) {
                    x.d("MicroMsg.CgiManager", "reqKey: %s, %s", new Object[]{payInfo.fuH, orders.fuH});
                }
                x.i("MicroMsg.CgiManager", "verifyreg reqKey: %s", new Object[]{str});
                x.i("MicroMsg.CgiManager", "verifyreg go new split cgi");
                kVar = str.startsWith("sns_aa_") ? new com.tencent.mm.plugin.wallet.pay.a.e.a(pVar, orders) : str.startsWith("sns_tf_") ? new e(pVar, orders) : str.startsWith("sns_ff_") ? new b(pVar, orders) : str.startsWith("ts_") ? new c(pVar, orders) : str.startsWith("sns_") ? new d(pVar, orders) : new f(pVar, orders);
            }
        }
        if (kVar != null) {
            this.zHV.a(kVar, true, 1);
        }
        return true;
    }
}
