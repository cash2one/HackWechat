package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.a;

class WalletPwdConfirmUI$1 implements OnClickListener {
    final /* synthetic */ WalletPwdConfirmUI sVm;

    WalletPwdConfirmUI$1(WalletPwdConfirmUI walletPwdConfirmUI) {
        this.sVm = walletPwdConfirmUI;
    }

    public final void onClick(View view) {
        String string = this.sVm.vf.getString("key_new_pwd1");
        String cCk = this.sVm.sBG.cCk();
        String string2 = this.sVm.vf.getString("kreq_token");
        String string3 = this.sVm.vf.getString("key_verify_code");
        x.d("Micromsg.WalletPwdConfirmUI", "mPayInfo " + WalletPwdConfirmUI.a(this.sVm) + " vertifyCode: " + string3);
        if (string == null || !string.equals(cCk)) {
            a.m(this.sVm, -1002);
            return;
        }
        p pVar = new p();
        pVar.sPj = this.sVm.sBG.getText();
        pVar.pCn = WalletPwdConfirmUI.a(this.sVm);
        pVar.token = string2;
        pVar.sPk = string3;
        pVar.sPl = this.sVm.vf.getBoolean("key_is_bind_bankcard", true);
        if (a.ag(this.sVm).bMX()) {
            pVar.flag = "4";
        } else {
            pVar.flag = "1";
        }
        FavorPayInfo favorPayInfo = (FavorPayInfo) this.sVm.vf.getParcelable("key_favor_pay_info");
        if (favorPayInfo != null) {
            pVar.sKD = favorPayInfo.sMW;
            pVar.sKE = favorPayInfo.sMT;
        }
        this.sVm.cCd().k(new Object[]{pVar});
    }
}
