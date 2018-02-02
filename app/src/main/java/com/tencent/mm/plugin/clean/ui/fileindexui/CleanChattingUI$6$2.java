package com.tencent.mm.plugin.clean.ui.fileindexui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI.6;

class CleanChattingUI$6$2 implements Runnable {
    final /* synthetic */ 6 lgP;

    CleanChattingUI$6$2(6 6) {
        this.lgP = 6;
    }

    public final void run() {
        CleanChattingUI.a(this.lgP.lgN).notifyDataSetChanged();
        CleanChattingUI.e(this.lgP.lgN).setText(R.l.dTA);
    }
}
