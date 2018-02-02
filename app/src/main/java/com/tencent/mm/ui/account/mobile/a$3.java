package com.tencent.mm.ui.account.mobile;

import android.content.Intent;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.ui.MMActivity;

class a$3 implements Runnable {
    final /* synthetic */ MMActivity fgW;
    final /* synthetic */ a xTL;

    a$3(a aVar, MMActivity mMActivity) {
        this.xTL = aVar;
        this.fgW = mMActivity;
    }

    public final void run() {
        Intent at = a.ifs.at(this.fgW);
        at.addFlags(67108864);
        this.fgW.startActivity(at);
        this.fgW.finish();
    }
}
