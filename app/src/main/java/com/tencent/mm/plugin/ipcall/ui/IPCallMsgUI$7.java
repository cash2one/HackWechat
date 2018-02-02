package com.tencent.mm.plugin.ipcall.ui;

import android.os.Looper;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.af;

class IPCallMsgUI$7 implements a {
    final /* synthetic */ IPCallMsgUI nKK;

    IPCallMsgUI$7(IPCallMsgUI iPCallMsgUI) {
        this.nKK = iPCallMsgUI;
    }

    public final void a(String str, l lVar) {
        new af(Looper.getMainLooper()).post(new 1(this));
    }
}
