package com.tencent.mm.ui.account.bind;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.friend.i.a;

class BindMobileUI$7 implements a {
    final /* synthetic */ String kik;
    final /* synthetic */ BindMobileUI xTx;

    BindMobileUI$7(BindMobileUI bindMobileUI, String str) {
        this.xTx = bindMobileUI;
        this.kik = str;
    }

    public final void Eh(int i) {
        boolean z = true;
        if (i == 1) {
            if (BindMobileUI.h(this.xTx)) {
                Context context = this.xTx;
                boolean z2 = !BindMobileUI.i(this.xTx).isChecked();
                if (BindMobileUI.j(this.xTx).isChecked()) {
                    z = false;
                }
                BindMobileStatusUI.c(context, z2, z);
                BindMobileUI.k(this.xTx);
                return;
            }
            Intent intent = new Intent(this.xTx, BindMobileStatusUI.class);
            intent.putExtra("kstyle_bind_wording", BindMobileUI.l(this.xTx));
            intent.putExtra("kstyle_bind_recommend_show", BindMobileUI.m(this.xTx));
            intent.putExtra("Kfind_friend_by_mobile_flag", BindMobileUI.i(this.xTx).isChecked());
            intent.putExtra("Krecom_friends_by_mobile_flag", BindMobileUI.j(this.xTx).isChecked());
            MMWizardActivity.A(this.xTx, intent);
        } else if (i == 2) {
            BindMobileUI.d(this.xTx, this.kik);
        }
    }
}
