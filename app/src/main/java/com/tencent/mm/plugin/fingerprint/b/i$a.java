package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.a;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;

public class i$a implements c {
    final /* synthetic */ i mzz;

    public i$a(i iVar) {
        this.mzz = iVar;
    }

    public final void aH(int i, int i2) {
        if (this.mzz.mza) {
            x.e("MicroMsg.OpenFingerPrintAuthEventListener", "hy: event already end. ignore");
            return;
        }
        String string;
        switch (i) {
            case 0:
                x.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_SUCCESS");
                i iVar = this.mzz;
                x.i("MicroMsg.OpenFingerPrintAuthEventListener", "onSuccess()");
                iVar.mza = true;
                a.aJS();
                a.aJT();
                ((l) g.h(l.class)).a(iVar.mzw, i2);
                if (iVar.mza) {
                    iVar.mzw = null;
                }
                x.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onSuccess()");
                i.aKz();
                return;
            case MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN /*2000*/:
                x.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify timeout");
                return;
            case 2001:
                this.mzz.fm(false);
                x.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_TIMEOUT");
                return;
            case 2002:
                x.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_NO_MATCH");
                this.mzz.mza = false;
                i.aKz();
                this.mzz.fm(true);
                this.mzz.R(1, "");
                return;
            case TXLiveConstants.PLAY_EVT_PLAY_BEGIN /*2004*/:
            case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
            case TXLiveConstants.PLAY_EVT_PLAY_LOADING /*2007*/:
            case 10308:
                x.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", Integer.valueOf(i));
                this.mzz.mza = true;
                string = ac.getContext().getString(i.uOn);
                if (i == 10308) {
                    string = ac.getContext().getString(i.uOo);
                } else if (i == TXLiveConstants.PLAY_EVT_PLAY_LOADING) {
                    s.sPp.mzJ = true;
                }
                i.aKz();
                this.mzz.R(2, string);
                return;
            case TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION /*2009*/:
                x.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", Integer.valueOf(i));
                if (this.mzz.mzw != null) {
                    com.tencent.mm.plugin.soter.c.a.yb(this.mzz.mzw.fCw.fCz);
                }
                this.mzz.mza = true;
                string = ac.getContext().getString(i.uOn);
                i.aKz();
                this.mzz.R(i, string);
                return;
            default:
                return;
        }
    }
}
