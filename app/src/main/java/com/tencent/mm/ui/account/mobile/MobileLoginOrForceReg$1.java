package com.tencent.mm.ui.account.mobile;

import android.graphics.Bitmap;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class MobileLoginOrForceReg$1 extends af {
    final /* synthetic */ MobileLoginOrForceReg xUx;

    MobileLoginOrForceReg$1(MobileLoginOrForceReg mobileLoginOrForceReg) {
        this.xUx = mobileLoginOrForceReg;
    }

    public final void handleMessage(Message message) {
        if (message.obj != null) {
            MobileLoginOrForceReg.a(this.xUx).setImageBitmap((Bitmap) message.obj);
        }
    }
}
