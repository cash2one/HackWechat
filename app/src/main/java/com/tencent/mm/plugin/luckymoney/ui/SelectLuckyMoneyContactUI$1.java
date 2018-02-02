package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.o.a;

class SelectLuckyMoneyContactUI$1 implements a {
    final /* synthetic */ Intent kvq;
    final /* synthetic */ SelectLuckyMoneyContactUI okK;

    SelectLuckyMoneyContactUI$1(SelectLuckyMoneyContactUI selectLuckyMoneyContactUI, Intent intent) {
        this.okK = selectLuckyMoneyContactUI;
        this.kvq = intent;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            this.okK.setResult(-1, this.kvq);
            this.okK.finish();
        }
    }
}
