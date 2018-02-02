package com.tencent.mm.plugin.offline.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.28.1;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

class WalletOfflineCoinPurseUI$28$1$1 implements Runnable {
    final /* synthetic */ Bitmap jsN;
    final /* synthetic */ String oZc;
    final /* synthetic */ 1 oZd;

    WalletOfflineCoinPurseUI$28$1$1(1 1, String str, Bitmap bitmap) {
        this.oZd = 1;
        this.oZc = str;
        this.jsN = bitmap;
    }

    public final void run() {
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[]{this.oZc, this.oZd.oYZ});
        if (WalletOfflineCoinPurseUI.J(this.oZd.oZb.oYH).containsKey(this.oZc)) {
            int intValue = ((Integer) WalletOfflineCoinPurseUI.J(this.oZd.oZb.oYH).get(this.oZc)).intValue();
            if (this.oZd.oZa.getItem(intValue) != null) {
                this.oZd.oZa.getItem(intValue).setIcon(new BitmapDrawable(d.a(this.jsN, this.oZd.oZb.oYH.getResources().getDimensionPixelOffset(a.d.ucs), this.oZd.oZb.oYH.getResources().getDimensionPixelOffset(a.d.ucs), true, false)));
                this.oZd.oZb.nal.cyK();
            }
        }
    }
}
