package com.tencent.mm.plugin.masssend.ui;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.5.1;

class MassSendMsgUI$5$1$2 implements Runnable {
    final /* synthetic */ 1 onV;

    MassSendMsgUI$5$1$2(1 1) {
        this.onV = 1;
    }

    public final void run() {
        Toast.makeText(this.onV.onU.onR, this.onV.onU.onR.getString(R.l.eSY), 0).show();
        if (MassSendMsgUI.e(this.onV.onU.onR) != null) {
            MassSendMsgUI.e(this.onV.onU.onR).dismiss();
            MassSendMsgUI.f(this.onV.onU.onR);
        }
    }
}
