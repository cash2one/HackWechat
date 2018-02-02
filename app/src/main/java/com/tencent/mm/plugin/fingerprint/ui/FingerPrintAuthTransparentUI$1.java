package com.tencent.mm.plugin.fingerprint.ui;

import com.tencent.mm.plugin.soter.c.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;

class FingerPrintAuthTransparentUI$1 implements c {
    final /* synthetic */ FingerPrintAuthTransparentUI mzX;

    FingerPrintAuthTransparentUI$1(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        this.mzX = fingerPrintAuthTransparentUI;
    }

    public final void aH(int i, int i2) {
        String string;
        switch (i) {
            case 0:
                x.i("MicroMsg.FingerPrintAuthTransparentUI", "identify success");
                FingerPrintAuthTransparentUI.a(this.mzX, i2);
                FingerPrintAuthTransparentUI.a(this.mzX);
                return;
            case 2001:
                x.i("MicroMsg.FingerPrintAuthTransparentUI", "identify timeout");
                return;
            case 2002:
                x.i("MicroMsg.FingerPrintAuthTransparentUI", "identify FingerPrintConst.RESULT_NO_MATCH");
                FingerPrintAuthTransparentUI.b(this.mzX);
                FingerPrintAuthTransparentUI.a(this.mzX, true);
                return;
            case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
            case TXLiveConstants.PLAY_EVT_PLAY_LOADING /*2007*/:
            case 10308:
                x.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", new Object[]{Integer.valueOf(i)});
                string = ac.getContext().getString(i.uOn);
                if (i == 10308) {
                    string = ac.getContext().getString(i.uOo);
                    a.c(6, -1000223, -1, "too many trial");
                } else {
                    a.c(1000, -1000223, i, "fingerprint error");
                }
                FingerPrintAuthTransparentUI.a(this.mzX, string);
                return;
            case TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION /*2009*/:
                x.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", new Object[]{Integer.valueOf(i)});
                string = ac.getContext().getString(i.uOn);
                a.c(1000, -1000223, i, "fingerprint error");
                a.yb(2);
                FingerPrintAuthTransparentUI.a(this.mzX, string);
                return;
            default:
                return;
        }
    }
}
