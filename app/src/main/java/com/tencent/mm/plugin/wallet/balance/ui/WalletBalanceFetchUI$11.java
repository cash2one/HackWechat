package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.10;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.ui.widget.g;
import java.util.List;

class WalletBalanceFetchUI$11 implements OnClickListener {
    final /* synthetic */ WalletBalanceFetchUI szH;

    WalletBalanceFetchUI$11(WalletBalanceFetchUI walletBalanceFetchUI) {
        this.szH = walletBalanceFetchUI;
    }

    public final void onClick(View view) {
        int i;
        WalletBalanceFetchUI.b(this.szH);
        p.bJN();
        List bLZ = p.bJO().bLZ();
        p.bJN();
        b bVar = p.bJO().sQd;
        String str = "";
        String str2 = "";
        if (bVar != null) {
            str2 = bVar.sKM;
            CharSequence charSequence = bVar.sKL;
            CharSequence charSequence2 = str2;
        } else {
            Object obj = str;
            Object obj2 = str2;
        }
        WalletBalanceFetchUI walletBalanceFetchUI = this.szH;
        Context context = this.szH.mController.xIM;
        Bankcard c = WalletBalanceFetchUI.c(this.szH);
        p$d 1 = new 1(this, bLZ);
        g gVar = new g(context, g.ztq, true);
        gVar.rKC = new 10(walletBalanceFetchUI, bLZ, context);
        gVar.rKD = 1;
        gVar.ztx = true;
        View inflate = LayoutInflater.from(context).inflate(a$g.uEp, null);
        if (!bh.ov(charSequence)) {
            ((TextView) inflate.findViewById(f.ufE)).setText(charSequence);
        }
        if (!bh.ov(charSequence2)) {
            ((TextView) inflate.findViewById(f.ufD)).setText(charSequence2);
        }
        gVar.dO(inflate);
        int size = bLZ.size();
        if (c != null) {
            int i2 = 0;
            i = size;
            while (i2 < bLZ.size()) {
                size = ((Bankcard) bLZ.get(i2)).field_bindSerial.equals(c.field_bindSerial) ? i2 : i;
                i2++;
                i = size;
            }
        } else {
            i = size;
        }
        gVar.ztz = i;
        gVar.bUk();
    }
}
