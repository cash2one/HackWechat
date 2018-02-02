package com.tencent.mm.ui.account;

import android.content.Intent;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.sdk.platformtools.x;

class LoginIndepPass$6 implements Runnable {
    final /* synthetic */ LoginIndepPass xPi;

    LoginIndepPass$6(LoginIndepPass loginIndepPass) {
        this.xPi = loginIndepPass;
    }

    public final void run() {
        x.d("MicroMsg.LoginIndepPass", "onSceneEnd, in runnable");
        Intent at = a.ifs.at(this.xPi);
        at.addFlags(67108864);
        this.xPi.startActivity(at);
        this.xPi.finish();
    }
}
