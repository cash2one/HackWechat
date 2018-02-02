package com.tencent.mm.ui.account;

import android.content.Intent;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.sdk.platformtools.x;

class LoginUI$19 implements Runnable {
    final /* synthetic */ k flZ;
    final /* synthetic */ LoginUI xPJ;

    LoginUI$19(LoginUI loginUI, k kVar) {
        this.xPJ = loginUI;
        this.flZ = kVar;
    }

    public final void run() {
        x.d("MicroMsg.LoginUI", "onSceneEnd, in runnable");
        Intent at = a.ifs.at(this.xPJ);
        at.addFlags(67108864);
        at.putExtra("kstyle_show_bind_mobile_afterauth", ((v) this.flZ).Sc());
        at.putExtra("kstyle_bind_wording", ((v) this.flZ).Sd());
        at.putExtra("kstyle_bind_recommend_show", ((v) this.flZ).Sf());
        this.xPJ.startActivity(at);
        this.xPJ.finish();
    }
}
