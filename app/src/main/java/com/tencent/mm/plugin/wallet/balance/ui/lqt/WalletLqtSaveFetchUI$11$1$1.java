package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.11.1;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

class WalletLqtSaveFetchUI$11$1$1 implements Runnable {
    final /* synthetic */ Bitmap jsN;
    final /* synthetic */ String oZc;
    final /* synthetic */ 1 sBE;

    WalletLqtSaveFetchUI$11$1$1(1 1, String str, Bitmap bitmap) {
        this.sBE = 1;
        this.oZc = str;
        this.jsN = bitmap;
    }

    public final void run() {
        x.i("MicroMsg.WalletLqtSaveFetchUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[]{this.oZc, this.sBE.oYZ});
        if (WalletLqtSaveFetchUI.d(this.sBE.sBD.sBv).containsKey(this.oZc)) {
            int intValue = ((Integer) WalletLqtSaveFetchUI.d(this.sBE.sBD.sBv).get(this.oZc)).intValue();
            if (this.sBE.oZa.getItem(intValue) != null) {
                this.sBE.oZa.getItem(intValue).setIcon(new BitmapDrawable(d.a(this.jsN, this.sBE.sBD.sBv.getResources().getDimensionPixelOffset(a.d.ucs), this.sBE.sBD.sBv.getResources().getDimensionPixelOffset(a.d.ucs), true, false)));
                this.sBE.sBD.nal.cyK();
            }
        }
    }
}
