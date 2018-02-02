package com.tencent.mm.plugin.bottle.ui;

import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.af;

class ThrowBottleAnimUI$4 extends af {
    final /* synthetic */ ThrowBottleAnimUI kDV;

    ThrowBottleAnimUI$4(ThrowBottleAnimUI throwBottleAnimUI) {
        this.kDV = throwBottleAnimUI;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (ThrowBottleAnimUI.i(this.kDV) == null && ThrowBottleAnimUI.a(this.kDV) != null) {
            ThrowBottleAnimUI.a(this.kDV, (SprayLayout) ThrowBottleAnimUI.a(this.kDV).findViewById(R.h.bOz));
        }
        if (ThrowBottleAnimUI.i(this.kDV) != null) {
            ThrowBottleAnimUI.i(this.kDV).stop();
        }
        if (ThrowBottleAnimUI.m(this.kDV) != null) {
            ThrowBottleAnimUI.m(this.kDV).arW();
        }
    }
}
