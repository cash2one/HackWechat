package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.z.ar;

class LoginUI$20 implements OnClickListener {
    final /* synthetic */ k flZ;
    final /* synthetic */ LoginUI xPJ;

    LoginUI$20(LoginUI loginUI, k kVar) {
        this.xPJ = loginUI;
        this.flZ = kVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.oH("R400_100_login");
        Intent intent = new Intent();
        intent.putExtra("regsetinfo_binduin", LoginUI.k(this.xPJ).hNv);
        intent.putExtra("regsetinfo_pwd", LoginUI.k(this.xPJ).xPo);
        intent.putExtra("regsetinfo_ismobile", 0);
        intent.putExtra("regsetinfo_ticket", LoginUI.n(this.xPJ));
        intent.putExtra("regsetinfo_NextControl", ((v) this.flZ).Oc());
        intent.setClass(this.xPJ, RegSetInfoUI.class);
        this.xPJ.mController.xIM.startActivity(intent);
        b.oI(ar.CB() + "," + this.xPJ.getClass().getName() + ",R400_100_login," + ar.fH("R400_100_login") + ",2");
    }
}
