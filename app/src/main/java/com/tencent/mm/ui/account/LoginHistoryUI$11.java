package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.c.b;

class LoginHistoryUI$11 implements OnClickListener {
    final /* synthetic */ k flZ;
    final /* synthetic */ LoginHistoryUI xPa;

    LoginHistoryUI$11(LoginHistoryUI loginHistoryUI, k kVar) {
        this.xPa = loginHistoryUI;
        this.flZ = kVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.oH("R400_100_login");
        Intent intent = new Intent();
        intent.putExtra("regsetinfo_binduin", this.xPa.xOA.hNv);
        intent.putExtra("regsetinfo_pwd", this.xPa.xOA.xPo);
        intent.putExtra("regsetinfo_ismobile", 0);
        intent.putExtra("regsetinfo_NextControl", ((v) this.flZ).Oc());
        intent.setClass(this.xPa, RegSetInfoUI.class);
        this.xPa.mController.xIM.startActivity(intent);
    }
}
