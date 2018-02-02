package com.tencent.mm.plugin.wallet.pwd.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mm.aq.p$a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.IconPreference;

class WalletSecuritySettingUI$5 implements p$a {
    final /* synthetic */ WalletSecuritySettingUI sHN;
    final /* synthetic */ IconPreference sHO;

    WalletSecuritySettingUI$5(WalletSecuritySettingUI walletSecuritySettingUI, IconPreference iconPreference) {
        this.sHN = walletSecuritySettingUI;
        this.sHO = iconPreference;
    }

    public final void h(String str, Bitmap bitmap) {
        x.i("MicroMsg.WalletSecuritySettingUI", "alvinluo icon url: %s", new Object[]{str});
        this.sHO.drawable = new BitmapDrawable(this.sHN.mController.xIM.getResources(), bitmap);
    }
}
