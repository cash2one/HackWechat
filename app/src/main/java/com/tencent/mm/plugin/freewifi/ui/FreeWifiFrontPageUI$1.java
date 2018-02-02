package com.tencent.mm.plugin.freewifi.ui;

import android.os.Message;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.8;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.c;
import com.tencent.mm.sdk.platformtools.af;

class FreeWifiFrontPageUI$1 extends af {
    final /* synthetic */ FreeWifiFrontPageUI mHw;

    FreeWifiFrontPageUI$1(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        this.mHw = freeWifiFrontPageUI;
    }

    public final void handleMessage(Message message) {
        c cVar = (c) message.obj;
        switch (8.mHx[cVar.mHv.ordinal()]) {
            case 1:
                this.mHw.aMD();
                return;
            case 2:
                this.mHw.aME();
                return;
            case 3:
                this.mHw.br(cVar.data);
                return;
            case 4:
                this.mHw.bs(cVar.data);
                return;
            default:
                return;
        }
    }
}
