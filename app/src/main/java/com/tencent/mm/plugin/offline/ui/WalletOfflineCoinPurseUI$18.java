package com.tencent.mm.plugin.offline.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;

class WalletOfflineCoinPurseUI$18 implements OnItemClickListener {
    final /* synthetic */ WalletOfflineCoinPurseUI oYH;
    final /* synthetic */ int oYX;

    WalletOfflineCoinPurseUI$18(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI, int i) {
        this.oYH = walletOfflineCoinPurseUI;
        this.oYX = i;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.oYH.dismissDialog(this.oYX);
        WalletOfflineCoinPurseUI.uq(i);
        if (this.oYX == 1) {
            String str = (String) WalletOfflineCoinPurseUI.C(this.oYH).get(i);
            if (!TextUtils.isEmpty(str) && !str.equals(WalletOfflineCoinPurseUI.D(this.oYH))) {
                WalletOfflineCoinPurseUI.a(this.oYH, str);
                a.GU(WalletOfflineCoinPurseUI.D(this.oYH));
                k.bgX();
                k.bgZ().oVl = WalletOfflineCoinPurseUI.D(this.oYH);
                this.oYH.bhx();
                WalletOfflineCoinPurseUI.E(this.oYH);
                WalletOfflineCoinPurseUI.F(this.oYH);
            }
        }
    }
}
