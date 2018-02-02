package com.tencent.mm.plugin.bottle.ui;

import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.af;

class ThrowBottleUI$8 extends af {
    final /* synthetic */ ThrowBottleUI kEz;

    ThrowBottleUI$8(ThrowBottleUI throwBottleUI) {
        this.kEz = throwBottleUI;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        ThrowBottleUI.f(this.kEz).setBackgroundDrawable(a.b(ThrowBottleUI.h(this.kEz), R.g.bFg));
        ThrowBottleUI.f(this.kEz).setEnabled(true);
    }
}
