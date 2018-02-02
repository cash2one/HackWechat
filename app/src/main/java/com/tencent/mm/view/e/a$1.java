package com.tencent.mm.view.e;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;

class a$1 extends af {
    final /* synthetic */ a zGr;

    a$1(a aVar) {
        this.zGr = aVar;
    }

    public final void handleMessage(Message message) {
        boolean z = true;
        switch (message.what) {
            case TXLiveConstants.PUSH_WARNING_RECONNECT /*1102*/:
                this.zGr.cAK();
                a.a(this.zGr);
                if (a.b(this.zGr) != null && a.c(this.zGr) != null) {
                    int i = a.d(this.zGr).zGF;
                    if (i < 0 || i > a.d(this.zGr).aas(a.b(this.zGr)).cAJ()) {
                        i = a.d(this.zGr).aas(a.b(this.zGr)).cAJ() - 1;
                    }
                    a.a(this.zGr, i + a.d(this.zGr).aas(a.b(this.zGr)).kaM);
                    a.c(this.zGr).ah(a.e(this.zGr));
                    a.f(this.zGr);
                    return;
                }
                return;
            case TXLiveConstants.PUSH_WARNING_HW_ACCELERATION_FAIL /*1103*/:
                x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "update selection");
                a aVar = this.zGr;
                int i2 = message.arg1;
                if (message.arg2 != 1) {
                    z = false;
                }
                a.a(aVar, i2, z, false);
                return;
            default:
                return;
        }
    }
}
