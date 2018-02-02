package com.tencent.mm.plugin.wallet_core.ui;

import android.widget.TextView;
import com.tencent.mm.g.a.am;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;

class WalletOrderInfoOldUI$3 extends c<am> {
    final /* synthetic */ WalletOrderInfoOldUI sUK;

    WalletOrderInfoOldUI$3(WalletOrderInfoOldUI walletOrderInfoOldUI) {
        this.sUK = walletOrderInfoOldUI;
        this.xen = am.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        am amVar = (am) bVar;
        if (amVar instanceof am) {
            this.sUK.sUC = amVar.foz.foB;
            this.sUK.foC = amVar.foz.foC;
            this.sUK.foD = amVar.foz.foD;
            this.sUK.foE = amVar.foz.foE;
            if (this.sUK.foE && !bh.ov(this.sUK.sRB)) {
                for (int i = 0; i < this.sUK.sTV.size(); i++) {
                    Commodity commodity = (Commodity) this.sUK.sTV.get(i);
                    int i2 = -1;
                    for (int i3 = 0; i3 < commodity.sOs.size(); i3++) {
                        Promotions promotions = (Promotions) commodity.sOs.get(i3);
                        if (promotions.type == Orders.sOj && !bh.ov(promotions.url) && promotions.url.equals(this.sUK.sRB)) {
                            i2 = i3;
                        }
                    }
                    if (i2 >= 0) {
                        commodity.sOs.remove(i2);
                    }
                }
            }
            this.sUK.sUB.notifyDataSetChanged();
            if (!bh.ov(this.sUK.sRB)) {
                TextView textView = (TextView) this.sUK.sUD.get(this.sUK.sRB);
                if (textView != null) {
                    textView.setClickable(this.sUK.foC);
                    textView.setEnabled(this.sUK.foC);
                    textView.setOnClickListener(null);
                    if (this.sUK.foD) {
                        textView.setVisibility(8);
                    }
                }
            }
            amVar.foA.fnI = true;
        }
        return false;
    }
}
