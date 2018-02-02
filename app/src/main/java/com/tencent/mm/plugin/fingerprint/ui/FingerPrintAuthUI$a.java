package com.tencent.mm.plugin.fingerprint.ui;

import com.tencent.mm.plugin.soter.c.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.ref.WeakReference;

public class FingerPrintAuthUI$a implements c {
    final /* synthetic */ FingerPrintAuthUI mAe;
    private WeakReference<FingerPrintAuthUI> mAh = null;

    public FingerPrintAuthUI$a(FingerPrintAuthUI fingerPrintAuthUI, FingerPrintAuthUI fingerPrintAuthUI2) {
        this.mAe = fingerPrintAuthUI;
        this.mAh = new WeakReference(fingerPrintAuthUI2);
    }

    private FingerPrintAuthUI aKJ() {
        if (this.mAh != null) {
            return (FingerPrintAuthUI) this.mAh.get();
        }
        return null;
    }

    public final void aH(int i, int i2) {
        String string;
        switch (i) {
            case 0:
                x.i("MicroMsg.FingerPrintAuthUI", "identify success");
                if (aKJ() != null) {
                    FingerPrintAuthUI.a(aKJ(), i2);
                    return;
                }
                return;
            case 2001:
                x.i("MicroMsg.FingerPrintAuthUI", "identify timeout");
                if (aKJ() != null) {
                    FingerPrintAuthUI.a(this.mAe, false);
                    return;
                }
                return;
            case 2002:
                x.i("MicroMsg.FingerPrintAuthUI", "identify FingerPrintConst.RESULT_NO_MATCH");
                if (aKJ() != null) {
                    FingerPrintAuthUI.a(aKJ());
                    FingerPrintAuthUI.a(this.mAe, true);
                    return;
                }
                return;
            case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
            case TXLiveConstants.PLAY_EVT_PLAY_LOADING /*2007*/:
            case 10308:
                x.i("MicroMsg.FingerPrintAuthUI", "hy: on error: %d", new Object[]{Integer.valueOf(i)});
                string = ac.getContext().getString(i.uOn);
                if (i == 10308) {
                    string = ac.getContext().getString(i.uOo);
                    a.c(6, -1000223, -1, "too many trial");
                } else {
                    a.c(1000, -1000223, i, "fingerprint error");
                }
                if (aKJ() != null) {
                    FingerPrintAuthUI.a(aKJ(), string, -1);
                    return;
                }
                return;
            case TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION /*2009*/:
                x.i("MicroMsg.FingerPrintAuthUI", "hy: on error: %d", new Object[]{Integer.valueOf(i)});
                string = ac.getContext().getString(i.uOn);
                a.c(1000, -1000223, i, "fingerprint error");
                a.yb(2);
                if (aKJ() != null) {
                    FingerPrintAuthUI.a(aKJ(), string, -1);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
