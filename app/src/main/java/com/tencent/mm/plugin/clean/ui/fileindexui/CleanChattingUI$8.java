package com.tencent.mm.plugin.clean.ui.fileindexui;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;

class CleanChattingUI$8 implements Runnable {
    final /* synthetic */ long lgH;
    final /* synthetic */ CleanChattingUI lgN;

    CleanChattingUI$8(CleanChattingUI cleanChattingUI, long j) {
        this.lgN = cleanChattingUI;
        this.lgH = j;
    }

    public final void run() {
        CleanChattingUI.g(this.lgN).dismiss();
        h.b(this.lgN, this.lgN.getString(R.l.dTC, new Object[]{bh.bx(this.lgH)}), "", true);
        CleanChattingUI.e(this.lgN).setText(this.lgN.getString(R.l.dDH, new Object[]{" "}));
    }
}
